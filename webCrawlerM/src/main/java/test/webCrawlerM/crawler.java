package test.webCrawlerM;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawler {
    redisOperation rO;
    
    public crawler(){
    	
    	rO=new redisOperation();
    	AddCoreUrl("http://www.dxy.cn/");
    	
    	
    }
	public  Document htmlDownload(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("fetching %s", url);
		return doc;

	}
	public static long getModifyDate(String frontURL) {
		URL u = null;
		HttpURLConnection http = null;
		try {
		u = new URL(frontURL);
		http = (HttpURLConnection) u.openConnection();
		http.setRequestMethod("HEAD");
		} catch (MalformedURLException e) {
		// DO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// DO Auto-generated catch block
		e.printStackTrace();
		}
		Date lastModify = new Date(http.getLastModified());
		//String a=lastModify.getTime()+"";
		//a=a.substring(4);
		//int m=Integer.parseInt(a);
		long m=lastModify.getTime();
		return m;
		/*Date anotherdate=new Date();
		//System.out.println(date.toLocaleString());
        int a=lastModify.compareTo(anotherdate);
        System.out.println(lastModify.toLocaleString());
        System.out.println(anotherdate.toLocaleString());
        System.out.println(a);
        */
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		//String date = sdf.format(lastModify);
		/*if(a<0){
			return true;//需要重新处理网页
			}
		return false;*/
		}
	
	public void AddCoreUrl(String url){
		storeCoreUrl(url);
	}
	
	public void storeCoreUrl(String url){
		rO.redisUrlSadd(url,"core");
		
	}

	public  void getAndStoreBaiduUrl(Document doc) {
        
		Elements links = doc.select("a[data-click]");
		for (Element link : links) {
			if (link.attr("target").equals("_blank")) {
				if (link.attr("href").contains("cache")) {
System.out.println("百度快照");
				} else {
					System.out.println(link.attr("href"));
					rO.redisUrlSadd(link.attr("href"),"core");
					// System.out.println(link.attr("title"));
				}
			}
		}
	}
	public  void getAndStoreNormalUrl(Document doc) {
        String title="";
      
		
		Elements links = doc.select("a[data-click]");
		for (Element link : links) {
			if (link.attr("target").equals("_blank")) {
				    
					System.out.println(link.attr("href"));
					rO.redisUrlSadd(link.attr("href"));
					// System.out.println(link.attr("title"));
				
			}
		}
	}
	
	
	
	public void AddFromBaseUrl(){//从基础url中不断添加要抓取的url
        String urlPop=rO.redisUrlSpop("url:core");
        Document now;
        long lnow=0;
      		long lastModify=0;
      		String slastModify="";
      		
        
		while(urlPop!=null){
			
		   
		      try{
	      			Date nowTime=new Date();
	      			
	      		    lnow=nowTime.getTime();
	      		    slastModify=rO.hget(urlPop, "lastModify");
	      		    
	      		}
	      		catch(Exception e){
	      			System.out.println("没有查找到最后修改时间");
	      			e.printStackTrace();
	      		}
	              lastModify=Long.parseLong(slastModify);
	      		if(lnow-lastModify<2000000){//33.33分钟内爬取过不再选择这个网页
	      		   urlPop=rO.redisUrlSpop("url:core");
	      		   continue;
	      		}
		    
	      	now=htmlDownload(urlPop);
	 		urlPop=rO.redisUrlSpop("url:core");//下载完成以后就可以 直接先更改要读取的url了
	 		                                       
		    getAndStoreNormalUrl(now);		    
		
		
			
		//Document 
		}
		
	}
	
	public void storeData(String url){
		
		
	}
	
	
	public void getInformation(String url){
		Document doc=htmlDownload(url);
		String title=doc.title();
		String word=doc.text();
	}

	public static void main(String[] args) {
		String url = "http://www.hc3i.cn/";
		//BaseUrl.addUrl(url);
		crawler c=new crawler();
		Document doc = c.htmlDownload(url);
		
		c.getAndStoreBaiduUrl(doc);

	}
}
    