package d0703;

interface Parseable{
	// 구문분석작업을 해야 합니다.

	public abstract void parse(String fileName); // abstract 메서드는 body가 필요없다.
	
}

class ParserManager{
	public static Parseable getParser(String type ){
		if(type.equals("XML")){
			return new XMLParser();
		} else{
			Parseable p = new HTMLParser();
			return p;
		}
	}
}
class XMLParser implements Parseable {
	public void parse(String fileName){
		System.out.println(fileName + "XML parsing completed...");
	}
}
class HTMLParser implements Parseable{
	public void parse(String fileName){
		System.out.println(fileName+"HTML parsing completed...");
	}
}
public class ParserTest {
	public static void main (String[] args){
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("document.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("document.html");
	}
}
