package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Jiexi1 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("src/score.xml");
			NodeList names = doc.getElementsByTagName("name");
			
			for(int i = 0 ; i<names.getLength() ;i++) {
				Node name = names.item(i);
				NodeList childNodes = name.getChildNodes();
				
				for(int j=0;j<childNodes.getLength();j++) {
					if(childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						String element = childNodes.item(j).getNodeName();
						String value = childNodes.item(j).getFirstChild().getNodeValue();
						switch(element) {
						case "alias":
							System.out.println(value);
							System.out.println();
							break;
						case "math":
							System.out.println("math:"+value);
							break;
						case "english":
							System.out.println("English:"+value);
							break;
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
