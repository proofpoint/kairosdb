/**
This file is automatically generated.  Do not modify
*/
package org.kairosdb.datastore.h2.orm;

import java.util.Locale;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.Timestamp;
import org.xml.sax.ContentHandler;
import org.xml.sax.Attributes;
import genorm.runtime.*;


/**
	Counts the data points for a metric query.
*/
public class CountDataPointsForMetricQuery extends genorm.runtime.SQLQuery
	{
	private static final Logger s_logger = LoggerFactory.getLogger(CountDataPointsForMetricQuery.class.getName());
	
	public static final String QUERY_NAME = "count_data_points_for_metric";
	public static final String QUERY = "select count(0) as dp_count\n				from data_point dp\n				where\n				dp.\"metric_id\" = ?\n				and dp.\"timestamp\" >= ?\n				and dp.\"timestamp\" <= ?";
	private static final int ATTRIBUTE_COUNT = 1;
	private static Map<String, Integer> s_attributeIndex;
	private static String[] s_attributeNames = {
			"dpCount" };
			
	static
		{
		s_attributeIndex = new HashMap<String, Integer>();
		for (int I = 0; I < ATTRIBUTE_COUNT; I++)
			s_attributeIndex.put(s_attributeNames[I], I);
		}
	
	private boolean m_serializable;
	
	private String m_metricId;
	private java.sql.Timestamp m_startTime;
	private java.sql.Timestamp m_endTime;

	//Deprecated
	public CountDataPointsForMetricQuery()
		{
		super();
		}		
	//---------------------------------------------------------------------------
	public CountDataPointsForMetricQuery(String metricId, java.sql.Timestamp startTime, java.sql.Timestamp endTime)
		{
		super();
		m_metricId = metricId;
		m_startTime = startTime;
		m_endTime = endTime;
		}
		
	//---------------------------------------------------------------------------
	public String getQueryName() { return (QUERY_NAME); }
	
	//---------------------------------------------------------------------------
	public String getQuery() { return (QUERY); }
		
	//---------------------------------------------------------------------------
	public void setSerializable(boolean serializable)
		{
		m_serializable = serializable;
		}
	
	//---------------------------------------------------------------------------
	public String toString()
		{
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(" metricId=").append(String.valueOf(m_metricId));
		sb.append(" startTime=").append(String.valueOf(m_startTime));
		sb.append(" endTime=").append(String.valueOf(m_endTime));
		
		return (sb.toString());
		}
		
	

	//---------------------------------------------------------------------------
	public void serializeQuery(ContentHandler ch, String tagName)
			throws org.xml.sax.SAXException
		{
		boolean prevSerializeState = m_serializable;
		m_serializable = true;
		ResultSet rs = runQuery();
		
		while (rs.next())
			{
			CountDataPointsForMetricData rec = rs.getRecord();
			ch.startElement("", tagName, tagName, rec);
			ch.endElement("", tagName, tagName);
			}
			
		rs.close();
		m_serializable = prevSerializeState;
		}
	
	//---------------------------------------------------------------------------
	//Deprecated
	public ResultSet runQuery(String metricId, java.sql.Timestamp startTime, java.sql.Timestamp endTime)
		{
		java.sql.PreparedStatement genorm_statement = null;
		try
			{
			String genorm_query = QUERY;
			
			genorm_statement = org.kairosdb.datastore.h2.orm.GenOrmDataSource.prepareStatement(genorm_query);
			genorm_statement.setString(1, metricId);
			genorm_statement.setTimestamp(2, startTime);
			genorm_statement.setTimestamp(3, endTime);

			long genorm_queryTimeStart = 0L;
			if (s_logger.isInfo())
				{
				genorm_queryTimeStart = System.currentTimeMillis();
				}
				
			java.sql.ResultSet genorm_resultSet = genorm_statement.executeQuery();
			
			if (genorm_queryTimeStart != 0L)
				{
				long genorm_quryTime = System.currentTimeMillis() - genorm_queryTimeStart;
				s_logger.info(genorm_quryTime);
				}
			
			ResultSet genorm_ret = new SQLResultSet(genorm_resultSet, genorm_statement, genorm_query);
			
			return (genorm_ret);
			}
		catch (java.sql.SQLException sqle)
			{
			try
				{
				if (genorm_statement != null)
					genorm_statement.close();
				}
			catch (java.sql.SQLException sqle2) { }
				
			throw new GenOrmException(sqle);
			}
		}		
	//---------------------------------------------------------------------------
	public ResultSet runQuery()
		{
		java.sql.PreparedStatement genorm_statement = null;
		try
			{
			String genorm_query = QUERY;
			
			genorm_statement = org.kairosdb.datastore.h2.orm.GenOrmDataSource.prepareStatement(genorm_query);
			genorm_statement.setString(1, m_metricId);
			genorm_statement.setTimestamp(2, m_startTime);
			genorm_statement.setTimestamp(3, m_endTime);

			long genorm_queryTimeStart = 0L;
			if (s_logger.isInfo())
				{
				genorm_queryTimeStart = System.currentTimeMillis();
				}
				
			java.sql.ResultSet genorm_resultSet = genorm_statement.executeQuery();
			
			if (genorm_queryTimeStart != 0L)
				{
				long genorm_quryTime = System.currentTimeMillis() - genorm_queryTimeStart;
				s_logger.info(genorm_quryTime);
				}
			
			ResultSet genorm_ret = new SQLResultSet(genorm_resultSet, genorm_statement, genorm_query);
			
			return (genorm_ret);
			}
		catch (java.sql.SQLException sqle)
			{
			try
				{
				if (genorm_statement != null)
					genorm_statement.close();
				}
			catch (java.sql.SQLException sqle2) { }
				
			throw new GenOrmException(sqle);
			}
		}
		
	//===========================================================================
	//Plugin Classes and Methods
		
	//===========================================================================
	public interface ResultSet extends GenOrmQueryResultSet<CountDataPointsForMetricData>
		{
		public List<CountDataPointsForMetricData> getArrayList(int maxRows);
		public List<CountDataPointsForMetricData> getArrayList();
		public CountDataPointsForMetricData getRecord();
		public CountDataPointsForMetricData getOnlyRecord();
		}
		
	//===========================================================================
	private class SQLResultSet 
			implements ResultSet
		{
		private java.sql.ResultSet m_resultSet;
		private java.sql.Statement m_statement;
		private String m_query;
		private boolean m_onFirstResult;
		
		//------------------------------------------------------------------------
		//need to pass in the statement so it can be closed after the result set
		protected SQLResultSet(java.sql.ResultSet resultSet, java.sql.Statement statement, 
				String query)
			{
			m_resultSet = resultSet;
			m_statement = statement;
			m_query = query;
			m_onFirstResult = false;
			}
		
		//------------------------------------------------------------------------
		/**
			Closes any underlying java.sql.Result set and java.sql.Statement 
			that was used to create this results set.
		*/
		public void close()
			{
			try
				{
				m_resultSet.close();
				m_statement.close();
				}
			catch (java.sql.SQLException sqle)
				{
				throw new GenOrmException(sqle);
				}
			}
			
		//------------------------------------------------------------------------
		/**
			Returns the reults as an ArrayList of Record objects.
			The Result set is closed within this call
		*/
		public List<CountDataPointsForMetricData> getArrayList(int maxRows)
			{
			ArrayList<CountDataPointsForMetricData> results = new ArrayList<CountDataPointsForMetricData>();
			int count = 0;
			
			try
				{
				if (m_onFirstResult)
					{
					count ++;
					results.add(new CountDataPointsForMetricData(CountDataPointsForMetricQuery.this, m_resultSet));
					}
					
				while (m_resultSet.next() && (count < maxRows))
					{
					count ++;
					results.add(new CountDataPointsForMetricData(CountDataPointsForMetricQuery.this, m_resultSet));
					}
					
				if (m_resultSet.next())
					throw new GenOrmException("Bound of "+maxRows+" is too small for query ["+m_query+"]");
				}
			catch (java.sql.SQLException sqle)
				{
				throw new GenOrmException(sqle);
				}
				
			close();
			return (results);
			}
			
		//------------------------------------------------------------------------
		/**
			Returns the reults as an ArrayList of Record objects.
			The Result set is closed within this call
		*/
		public List<CountDataPointsForMetricData> getArrayList()
			{
			ArrayList<CountDataPointsForMetricData> results = new ArrayList<CountDataPointsForMetricData>();
			
			try
				{
				if (m_onFirstResult)
					results.add(new CountDataPointsForMetricData(CountDataPointsForMetricQuery.this, m_resultSet));
					
				while (m_resultSet.next())
					results.add(new CountDataPointsForMetricData(CountDataPointsForMetricQuery.this, m_resultSet));
				}
			catch (java.sql.SQLException sqle)
				{
				throw new GenOrmException(sqle);
				}
				
			close();
			return (results);
			}
			
		//------------------------------------------------------------------------
		/**
			Returns the underlying java.sql.ResultSet object
		*/
		public java.sql.ResultSet getResultSet()
			{
			return (m_resultSet);
			}
			
		//------------------------------------------------------------------------
		/**
			Returns the current record in the result set
		*/
		public CountDataPointsForMetricData getRecord()
			{
			CountDataPointsForMetricData ret = null;
			try
				{
				ret = new CountDataPointsForMetricData(CountDataPointsForMetricQuery.this, m_resultSet);
				}
			catch (java.sql.SQLException sqle)
				{
				throw new GenOrmException(sqle);
				}
				
			return (ret);
			}
			
		//------------------------------------------------------------------------
		/**
			This call expects only one record in the result set.  If multiple records
			are found an excpetion is thrown.
			The ResultSet object is automatically closed by this call.
		*/
		public CountDataPointsForMetricData getOnlyRecord()
			{
			CountDataPointsForMetricData ret = null;
			
			try
				{
				if (m_resultSet.next())
					ret = new CountDataPointsForMetricData(CountDataPointsForMetricQuery.this, m_resultSet);
					
				if (m_resultSet.next())
					throw new GenOrmException("Multiple rows returned in call from CountDataPointsForMetricQuery.ResultSet.getOnlyRecord");
				}
			catch (java.sql.SQLException sqle)
				{
				throw new GenOrmException(sqle);
				}
				
			close();
			return (ret);
			}
			
		//------------------------------------------------------------------------
		/**
			Returns true if there is another record in the result set.
		*/
		public boolean next()
			{
			boolean ret = false;
			m_onFirstResult = true;
			try
				{
				ret = m_resultSet.next();
				}
			catch (java.sql.SQLException sqle)
				{
				throw new GenOrmException(sqle);
				}
			
			return (ret);
			}
		}
		
	//===========================================================================
	public class Record implements GenOrmQueryRecord, Attributes
		{
		protected int m_dpCount;

		protected String[] m_attrValues;
		
		protected Record(java.sql.ResultSet rs)
				throws java.sql.SQLException
			{
			m_dpCount = (int)rs.getInt(1);

			if (m_serializable)
				{
				m_attrValues = new String[ATTRIBUTE_COUNT];
				
				m_attrValues[0] = CountDataPointsForMetricQuery.this.m_formatter.toString(s_attributeNames[0], m_dpCount);

				}
			}
			
		public int getDpCount() { return (m_dpCount); }
 
		
		//------------------------------------------------------------------------
		public String toString()
			{
			StringBuilder sb = new StringBuilder();
			sb.append(" dp_count=\"");
			sb.append(m_dpCount);
			sb.append("\"");

			return (sb.toString().trim());
			}
			
		//------------------------------------------------------------------------
		/*Attributes*/
		public int getIndex(String qName)
			{
			Integer index = s_attributeIndex.get(qName);
			if (index == null)
				return (-1);
			else
				return (index);
			}
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public int getIndex(String uri, String localName)
			{
			if (uri == null || uri.equals(""))
				return (getIndex(localName));
			else
				return (-1);
			}
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public int getLength() { return (ATTRIBUTE_COUNT); }
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getLocalName(int index)
			{
			if (index < 0 || index >= ATTRIBUTE_COUNT)
				return (null);
			else
				return (s_attributeNames[index]);
			}
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getQName(int index)
			{
			if (index < 0 || index >= ATTRIBUTE_COUNT)
				return (null);
			else
				return (s_attributeNames[index]);
			}
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getType(int index) { return ("CDATA"); }
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getType(String qName) { return ("CDATA"); }
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getType(String uri, String localName) { return ("CDATA"); }
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getURI(int index)
			{
			if (index < 0 || index >= ATTRIBUTE_COUNT)
				return (null);
			else
				return ("");
			}
			
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getValue(int index)
			{
			if (index < 0 || index >= ATTRIBUTE_COUNT)
				return (null);
			else
				return (m_attrValues[index]);
			}
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getValue(String qName)
			{
			return (getValue(getIndex(qName)));
			}
		
		//------------------------------------------------------------------------
		/*Attributes*/
		public String getValue(String uri, String localName)
			{
			return (getValue(getIndex(uri, localName)));
			}
			
		}
		
	}