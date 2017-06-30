import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String repalceBlank(String str){
    	String dest="";
    	if(str!=null){
    		Pattern p=Pattern.compile("\\s*|\t|\r|\n");
    		Matcher m=p.matcher(str);
    		dest=m.replaceAll("");
    	}
    	return dest;
    }
    public static void main(String [] args){
    	System.out.println("just doit\n");
    	String a="asdf";
    	System.out.println(StringUtils.repalceBlank(a));
    }
}
