package com.slht.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetResult {
	public String getStr(String geturl) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(geturl);
			 
			URLConnection conn = url.openConnection(); 
			BufferedReader is = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));

			String str;
			while ((str = is.readLine()) != null) {
				buffer.append(str);
				buffer.append("\n");

			}
			str = buffer.toString().replaceAll("<script(.|\n)+?</script>", "")
					.replaceAll("<(.|\n)+?>", "").replaceAll("&nbsp;", " ");
			String[] s = str.split("\n");
			buffer = new StringBuffer();
			for (int i = 0; i < s.length; i++) {
				if (s[i].trim().equals("")) {
					continue;
				} else {
					buffer.append(s[i]);
					buffer.append("\n");
				}
			}
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

}
