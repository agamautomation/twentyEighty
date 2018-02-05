package com.twentyeighty.utilities;

import java.io.File;
import java.io.FileOutputStream;

import java.util.Hashtable;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWriter {
	
	public Result makeXML(String[][] data, String actionName)
	{
		//JustLogger.logInfo("Make omniture Data XML Started");
		Result result = new Result();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			
			result.setObject("Error @ParseConfigurationException @makeXML : "
					+ e.getMessage());
			e.printStackTrace();
			return result;
		} catch (Exception e) {
			
			result.setObject("Error @Exception @makeXML : " + e.getMessage());
			e.printStackTrace();
			return result;
		}
		Document document = docBuilder.newDocument();
		Element Sections = document.createElement("Sections");
		document.appendChild(Sections);
		Element Section = document.createElement("Section");
		Section.setAttribute("actionName", actionName);
		Section.setAttribute("numberOfEventsTriggered",
		getNumberOfEventsTriggered(data));
		Section.setAttribute("tagList", getData(data));
		Sections.appendChild(Section);
		System.out.println("writing omniture Data XML Started");
		return storeXML(document);
	}
	

	public Result storeXML(Document document) {
		Result result = new Result();
		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			Random random = new Random();
			int randomdigit = random.nextInt(1000);
			DOMSource source = new DOMSource(document);
			setXMLFileName("GATestData\\" + "file"
					+ randomdigit + ".xml");
			System.out.println(getXMLFileName());
			StreamResult streamResult = new StreamResult(new FileOutputStream(
					getXMLFileName()));
			// StreamResult streamResult = new StreamResult(System.out);
			transformer.transform(source, streamResult);
			System.out.println("File " + this.getXMLFileName() + " saved!");
		} catch (Exception e) {
			result.setObject("Error @storeXML : " + e.getMessage());
			return result;
		}
		result.setResult(true);
		return result;
	}

	private String getNumberOfEventsTriggered(String[][] data) {
		return this.numberOfEvents;
	}
	public void setNumberOfEventsTriggered(String data){
		this.numberOfEvents = data;
	}
	private String numberOfEvents;
	@SuppressWarnings("unchecked")
	public Result generateXML(Object data, String actionName) {
		try
		{
		data = removeUnusedTags((Hashtable<String, String>) data);
		}
		catch(Exception e){e.printStackTrace();}
			String[][] strData = getStringFromHash((Hashtable<String, String>) data);
		return makeXML(strData, actionName);
	}
	public Result deleteXMLFile(String fileName) {
		Result result = new Result();
		{
			/*System.out.println("Deleting file: " + fileName);
			try {
				File file = new File(fileName);
				result.setResult(file.delete());
			} catch (Exception e) {
				//ExceptionWriter.LogException(e);
				result.setObject(e.getMessage());
			}*/
			
			
			String tempFileName = "GATestData";
			 
		        if ((new File(tempFileName)).isDirectory()) {
					File file = new File(tempFileName);
					String[] children = file.list();
					for (int i = 0; i < children.length; i++) {
						deleteDir(new File(file, children[i]));
					}
				}
		}
		return result;
	}
	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				deleteDir(new File(dir, children[i]));
			}
		}
		// The directory is now empty so delete it
		dir.delete();
	}
	public static String[][] getStringFromHash(Hashtable<String, String> data) {
		String[][] str = null;
		{
			Object[] keys = data.keySet().toArray();
			Object[] values = data.values().toArray();
			str = new String[keys.length][values.length];
			for (int i = 0; i < keys.length; i++) {
				str[0][i] = (String) keys[i];
				str[1][i] = (String) values[i];
			}
		}
		return str;
	}
	private Object removeUnusedTags(Hashtable<String, String> data) {
		{
			data.remove("Browser");
			data.remove("TagName");
			data.remove("Tag Name");
			data.remove("tag name");
			data.remove("tagname");
		}
		return data;
	}

	private String getData(String[][] data) {
		String tempData = "";
		for (int i = 0; i < data[0].length-1; i++)
			tempData += data[0][i] + "=" + data[1][i] + " ||";
		return tempData;
	}
	
	public String getXMLFileName() {
		return XMLFileName;
	}

	public void setXMLFileName(String xMLFileName) {
		XMLFileName = xMLFileName;
	}

	private String XMLFileName;
}
