package test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Jiexi2 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("src/Book.xml");
			NodeList books = document.getElementsByTagName("book");
			System.out.println(books.getLength());
			
			//Ϊÿһ��bookԪ�����һ��author��Ԫ�أ�Ԫ�������Զ�
			for(int i=0;i<books.getLength();i++) {
				Node book = books.item(i);
				Element author = document.createElement("author");
				author.setTextContent("����");
				book.appendChild(author);
				
				//Ϊÿһ��bookԪ�����һ��category������Ԫ�أ�Ԫ�������Զ����磺<book  category="computer">
				Element element = (Element)book;
				element.setAttribute("category", "computer");
				
			}
			//�޸�titleԪ�ص�ֵ�����ı����ݵĺ�������ı��������ӹ�ҵ�����磩����
			NodeList titles = document.getElementsByTagName("title");
			for(int i=0;i<titles.getLength();i++) {
				Node title = titles.item(i);
				String content = title.getTextContent();
				title.setTextContent(content+"�����ӹ�ҵ�����磩");
			}
			
			//ɾ��ԭ�еĵ�����<book>Ԫ�ء�
			Node thirdBook = books.item(2);
			thirdBook.getParentNode().removeChild(thirdBook);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
