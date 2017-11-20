package org.kairosdb.datastore.cassandra.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.annotations.VisibleForTesting;
import org.kairosdb.core.admin.CacheMetricsProvider;
import org.kairosdb.datastore.cassandra.cache.persistence.GeneralHashCacheStore;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import static com.google.common.hash.Hashing.murmur3_128;
import static net.openhft.hashing.LongHashFunction.xx;

public abstract class AbstractByteBufferCache {
    private static final int MURMUR_SEED = 0xDEADBEEF;
    private static final int XX_SEED = 0xCAFEBABE;

    protected final LoadingCache<BigInteger, Object> outerLayerCache;

    protected AbstractByteBufferCache(final GeneralHashCacheStore cacheStore, final CacheMetricsProvider cacheMetricsProvider,
                                final int maxSize, final int ttlInSeconds, final String cacheId) {
        this.outerLayerCache = Caffeine.newBuilder()
                .initialCapacity(maxSize / 3 + 1)
                .maximumSize(maxSize)
                .expireAfterWrite(ttlInSeconds, TimeUnit.SECONDS)
                .recordStats()
                .writer(cacheStore)
                .build(cacheStore);
        cacheMetricsProvider.registerCache(cacheId, this.outerLayerCache);
    }

    @VisibleForTesting
    BigInteger doubleHash(final ByteBuffer payload) {
        final long murmurHash = murmur3_128(MURMUR_SEED).hashBytes(payload.array()).asLong();
        final long xxHash = xx(XX_SEED).hashBytes(payload);
        final ByteBuffer doubleHash = ByteBuffer.allocate((Long.SIZE * 2) / 8)
                .putLong(murmurHash)
                .putLong(xxHash);
        doubleHash.flip();
        return new BigInteger(doubleHash.array());
    }
}