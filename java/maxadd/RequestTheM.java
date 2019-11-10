package maxadd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.omg.CORBA.portable.InputStream;

public class RequestTheM {

	public static void main(String[] args) {

		for (int i = 1; i <= 50; i++) {

			try {
				test("4.16.3."+i,
						"http://api.maxjia.com/api/activity/weekly_report/shared/1243978_1446018158IQHQHCJZLE/"	
//						"http://api.maxjia.com/api/activity/weekly_report/shared/1747404_1447413291WUKGKIOFUE/"
			
						);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("finish" + i);
		}		
	}

	public static void test(String ip, String m_url) throws IOException {
		URL url = new URL(m_url);
		System.out.println(ip);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
		conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("User-Agent", "Android");
		conn.setRequestProperty("X-Forwarded-For", ip);
		conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
		conn.setRequestProperty("Cache-Control", "max-age=0");
		conn.setRequestProperty("Host", "api.maxjia.com");
		conn.connect(); // ???????
		conn.getInputStream();
	}
}
