/**
 * @author 冯晓闯 E-mail:lanxinxichen@126.com
 * @version 创建时间：2016年4月1日 上午10:58:23
 * 类说明:
 */
package com.fengxiaochuang.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.CoreConnectionPNames;

public class ProxyCheck {

    public ProxyCheck() {
    }

//	public static Boolean checkProxy(HttpHost proxyHost) {
//		Boolean isCheck = false;
//		URLConnection con = null;
//		URL url = null;
//		Proxy proxy = null;
//		BufferedReader br = null;
//		StringBuffer str = new StringBuffer();
//		// 检测代理访问其他网站能不能用
//		String validationUrl = "http://proxyjudge.us/azenv.php";
//		try {
//			url = new URL(validationUrl);
//			proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost.getHostName(), proxyHost.getPort()));
//			con = url.openConnection(proxy);
//			con.setConnectTimeout(3000);
//			con.setReadTimeout(3000);
//			con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//			con.setRequestProperty("Content-Type", "text/xml");
//			con.setRequestProperty("ContentType", "text/xml;charset=utf-8");
//			con.connect();
//			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//
//			con.getInputStream().close();
//			isCheck = true;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return isCheck;
//	}

    public static Boolean checkProxy(HttpHost proxy) {
        Boolean isCheck = false;
        try {
            HttpClient client = new DefaultHttpClient();
            String checkUrl = PropertiesUtil.getString("checkproxy.url");
            if (checkUrl.isEmpty()) {
                checkUrl = "http://www.baidu.com";
            }
            HttpGet get = new HttpGet(checkUrl);
            client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 3000);
            HttpResponse response = client.execute(get);
            HttpEntity enti = response.getEntity();
            if (response != null) {
                isCheck = true;
            }
        } catch (Exception e) {
        }
        return isCheck;
    }
}
