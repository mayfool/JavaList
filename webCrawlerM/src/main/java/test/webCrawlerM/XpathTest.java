package test.webCrawlerM;

import java.io.IOException;
import java.util.List;

import org.htmlcleaner.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.jsoup.*;
import org.jsoup.nodes.Document;

import junit.framework.Assert;
import us.codecraft.xsoup.Xsoup;
public class XpathTest {
	public static void main(String [] args) throws IOException, XPatherException{
	@SuppressWarnings("restriction")
	String html =  Jsoup.connect("http://www.cnblogs.com/zyw-205520/").get().html();
	XPathFactory xPathFactory = XPathFactory.newInstance();
	XPath xPath = xPathFactory.newXPath();
	
	String url = "http://zhidao.baidu.com/daily";
	String contents = Jsoup.connect(url).post().html();

	HtmlCleaner hc = new HtmlCleaner();
	TagNode tn = hc.clean(contents);
	String xpath = "//h2/a/@href";
	Object[] objects = tn.evaluateXPath(xpath);
	System.out.println(objects.length);
	
	
	
	
	String html2 = "<html><div><a href='https://github.com'>github.com</a></div>" +
            "<table><tr><td>a</td><td>b</td></tr></table></html>";

    Document document = Jsoup.parse(html2);

    String result = Xsoup.compile("//a/@href").evaluate(document).get();
    Assert.assertEquals("https://github.com", result);

    List<String> list = Xsoup.compile("//tr/td/text()").evaluate(document).list();
    Assert.assertEquals("a", list.get(0));
    Assert.assertEquals("b", list.get(1));
	}
}