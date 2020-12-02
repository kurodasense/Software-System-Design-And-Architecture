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
			
			//为每一个book元素添加一个author子元素，元素内容自定
			for(int i=0;i<books.getLength();i++) {
				Node book = books.item(i);
				Element author = document.createElement("author");
				author.setTextContent("马保国");
				book.appendChild(author);
				
				//为每一个book元素添加一个category属性子元素，元素内容自定，如：<book  category="computer">
				Element element = (Element)book;
				element.setAttribute("category", "computer");
				
			}
			//修改title元素的值，在文本内容的后面添加文本“（电子工业出版社）”。
			NodeList titles = document.getElementsByTagName("title");
			for(int i=0;i<titles.getLength();i++) {
				Node title = titles.item(i);
				String content = title.getTextContent();
				title.setTextContent(content+"（电子工业出版社）");
			}
			
			//删除原有的第三个<book>元素。
			Node thirdBook = books.item(2);
			thirdBook.getParentNode().removeChild(thirdBook);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
