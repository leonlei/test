package com.leon.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil
{
	private static Logger logger = Logger.getLogger(HttpUtil.class);
	
	/**
	 * 基于HttpClient 4.3的通用POST方法
	 * 提交json
	 * @param url
	 * @param body Json
	 * @return
	 */
	public static String postJson(String url, String body)
	{
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;

		String responseText = null;
		HttpPost method = new HttpPost(url);

		try
		{
			StringEntity stringEntity = new StringEntity(body.toString(), "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json");
			method.setEntity(stringEntity);

			response = client.execute(method);

			HttpEntity entity = response.getEntity();

			if (entity != null)
			{
				responseText = EntityUtils.toString(entity);
				logger.debug(responseText);
			}
		}
		catch (Exception e)
		{
			logger.error("send msg error.", e);
		}
		finally
		{
			if (null != response)
			{
				try
				{
					response.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			if (null != client)
			{
				try
				{
					client.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		return responseText;
	}

	/**
	 * 基于HttpClient 4.3的通用POST方法 提交表单
	 * 
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String post(String url, Map<String, String> paramsMap)
	{
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;

		String responseText = null;
		HttpPost method = new HttpPost(url);

		try
		{
			if (paramsMap != null)
			{
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> param : paramsMap.entrySet())
				{
					NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
					paramList.add(pair);
				}
				method.setEntity(new UrlEncodedFormEntity(paramList, "utf-8"));
			}

			response = client.execute(method);

			HttpEntity entity = response.getEntity();
			if (entity != null)
			{
				responseText = EntityUtils.toString(entity);
				logger.debug(responseText);
			}
		}
		catch (Exception e)
		{
			logger.error("send msg error.", e);
		}
		finally
		{
			if (null != response)
			{
				try
				{
					response.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			if (null != client)
			{
				try
				{
					client.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		return responseText;
	}
}
