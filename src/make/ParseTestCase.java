package make;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

/**
 * <code></code>
 * 
 */
public class ParseTestCase {

	public String title;
	public List<String> testCaseList;
	
	public ParseTestCase() {
		
		testCaseList = new ArrayList<String>();
		
		try {
			
			Path filePath = Paths.get("download/index.html"); // 相対パス
	        URL fileUrl = filePath.toUri().toURL(); // URL に変換
	        Source source = new Source(fileUrl);
	        
			Element temp = source.getFirstElement(HTMLElementName.TITLE);
			Pattern p = Pattern.compile("[A-Z]\\d{3}");
			Matcher m = p.matcher(temp.toString());
			if (m.find()) {
				title = m.group();
			}
			
			List<Element> titleList = source.getAllElements(HTMLElementName.CODE);
			for (Element e : titleList) {
				testCaseList.add(e.getContent().toString());
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
