package com.xmlstu;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class XMLcom {
	//输出xml下某个节点下某个元素指定的值
	@Test
	public void read() throws Exception{
		SAXReader reader =new SAXReader();
		Document document=reader.read("src/com/xmlstu/MyXml.xml");
		Element root=document.getRootElement();
		Element person=(Element) root.elements("人员").get(0);
		String value=person.element("姓名").getText();
		System.out.println(value);
	}
	
	@Test
	public void readAttru() throws Exception{
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/com/xmlstu/MyXml.xml");
		Element root=document.getRootElement();
		Element person=(Element) root.elements("人员").get(1);
		String value=person.element("姓名").attributeValue("name");
		System.out.println(value);
	}
	
	@Test
	public void addPer() throws Exception{
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/com/xmlstu/MyXml.xml");
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		Element root=document.getRootElement();
		Element person=(Element) root.elements("人员").get(1);
		person.addElement("地区").setText("武汉");
		//下面可以不乱吗，但是不能设置其它写入xml的字符编码格式（出UTF-8外的）
		//		XMLWriter write=new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/com/xmlstu/MyXml.xml"),"UTF-8"));
		//下面加入了pretty格式并设置了写入的编码，所以也不会乱码，且编码可以设置为其它的
		XMLWriter write=new XMLWriter(new FileOutputStream("src/com/xmlstu/MyXml.xml"),format);

		write.write(document);
		write.close();
	}

	@Test
	public void getPath() throws Exception{
		String filepath = "E:\\123456\\90\\";
		System.out.println(filepath.substring(filepath.length()-1));
	}
}
