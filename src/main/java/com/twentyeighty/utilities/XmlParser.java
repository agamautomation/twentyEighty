package com.twentyeighty.utilities;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;




import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {/*
 
	public  static ArrayList<String > abc = null;
	
 public static Document convertToDocument(Object xmlContent) {
  DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder = null;
  Document document = null;
  try {
   builder = builderFactory.newDocumentBuilder();
   if (xmlContent instanceof String) {
    document = builder.parse((String) xmlContent);
   } else if (xmlContent instanceof File) {
    document = builder.parse((File) xmlContent);
   }
  } catch (ParserConfigurationException pce) {
   pce.printStackTrace();
  } catch (SAXException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
  document.getDocumentElement().normalize();
  
  return document;
 }
 
 
 public static ArrayList<String > getNodeWithXPath(String tag){
	 
	 abc = new ArrayList<String>();
	 
	 
  String xmlContent="File location";
  //File xmlContent = new File(xmlContent);
  //String xmlContent = "https://iwe.qa.pch.com/iwe/services/winner/getWinners?limit=5&businessUnitId=31";
  Document doc=convertToDocument(xmlContent);
  doc.getDocumentElement().normalize();
  
  //Get file url
  System.out.println(doc.getDocumentURI());

  //Get Root Node Name
  System.out.println("Root element :- " + doc.getDocumentElement().getNodeName());

  
  
  NodeList nList = doc.getElementsByTagName(tag);
  System.out.println(nList.getLength());
  
  for (int i = 0; i < nList.getLength(); i++) {
   Node nNode = nList.item(i);
   System.out.println("\nCurrent Element :" + nNode.getNodeName());
   Element e2=(Element)nNode;
   System.out.println("=====>>>"+e2.getElementsByTagName("loc").item(0).getAttributes().toString());
   
   System.out.println("=====>>>"+e2.getElementsByTagName("loc").item(0).getTextContent());
   
   Element element = (Element)nList.item(i);
  abc.add("Added "+element.getTextContent());
   
  // System.out.println(abc.add("Added "+element.getTextContent()));
   System.out.println(i+" --> "+element.getTextContent());
  }
return abc; 

  
  
  
  
 }
*/


 
 }
