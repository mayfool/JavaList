package test.webCrawlerM;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Allin1Test {
	
	
	public static void main(String []args){
		
		String a="3";
		String b="5";
		System.out.println();
	Date date=new Date();
	System.out.println(date.getTime());
	System.out.println("12345678".substring(4));
	crawler c=new crawler();
	Document doc=c.htmlDownload("http://nurs.dxy.cn/article/520365");
	//System.out.println(doc.title());
	
	
	}
}
