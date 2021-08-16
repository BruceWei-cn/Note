package com.ming.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.DefaultHttpRequestFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;

public class IpDemo {

	String url = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?resource_id=6006&format=json&query=";
	String ip = "112.65.48.150";

	@Test
	public void test01() throws MalformedURLException {

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			URIBuilder uriBuilder = new URIBuilder(url);

			uriBuilder.addParameter("resource_id", "6006")
					.addParameter("format", "json").addParameter("query", ip);
			URI build = uriBuilder.build();
			//Get method request
			HttpGet httpGet = new HttpGet(build);
			CloseableHttpResponse response = client.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				InputStream content = response.getEntity().getContent();

				System.out.println("entity = " + content);
			}

		} catch (Exception e) {

		}
	}


	@Test
	public void test02() {
		BufferedReader in = null;
		String result = "";
		try {
			String urlNameString = url + ip;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
				System.out.println("line = " + line);
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Test
	public void test03() {
		try {
			HttpResponse<String> response = Unirest.get(url + ip).asString();
			String body = response.getBody();
			System.out.println("body = " + body);
			JSONObject jsonObject = JSONObject.parseObject(body);
			JSONArray data = jsonObject.getJSONArray("data");
			System.out.println("data = " + data);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test04() {
		try {
			HttpResponse<String> response = Unirest.get(url + ip).asString();
			String body = response.getBody();
			org.json.JSONObject jsonObject = new org.json.JSONObject(body);
			String location = jsonObject.getJSONArray("data").getJSONObject(0).getString("location");
			System.out.println("location = " + location);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test05() {

	}

}
