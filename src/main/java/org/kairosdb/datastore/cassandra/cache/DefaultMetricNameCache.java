package org.kairosdb.datastore.cassandra.cache;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.kairosdb.core.admin.CacheMetricsProvider;
import org.kairosdb.datastore.cassandra.cache.persistence.GeneralHashCacheStore;

public class DefaultMetricNameCache extends AbstractStringCache {
    public static final String METRIC_NAME_CACHE = "metricNameCache";

    @Inject
    public DefaultMetricNameCache(@Named(METRIC_NAME_CACHE) final GeneralHashCacheStore cacheStore,
                                  final CacheMetricsProvider cacheMetricsProvider,
                                  final MetricNameCacheConfiguration config) {
        super(cacheStore, cacheMetricsProvider, config, METRIC_NAME_CACHE);
    }
}