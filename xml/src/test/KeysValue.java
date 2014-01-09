package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class KeysValue {
    public static void main(String[] args) {
 
        try {
            FileInputStream file = new FileInputStream(new File("d://MACYS/files/Keys.xml"));
                 
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
             
            DocumentBuilder builder =  builderFactory.newDocumentBuilder();
             
            Document xmlDocument = builder.parse(file);
 
            XPath xPath =  XPathFactory.newInstance().newXPath();
 
            System.out.println("*************************");
//            String expression = "/stocks/Keys";
//            System.out.println(expression);
//            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            String key = "//stocks/Keys/Key";
        	NodeList keyList = (NodeList) xPath.compile(key).evaluate(xmlDocument, XPathConstants.NODESET);
        	String value = "/stocks/Keys/value";
        	NodeList valueList = (NodeList) xPath.compile(value).evaluate(xmlDocument, XPathConstants.NODESET);
 	
            System.out.println("nodeList "+keyList +" "+keyList.getLength());
            for (int i = 0; i < keyList.getLength(); i++) {         	
                System.out.println(keyList.item(i).getFirstChild().getNodeValue()+ " "+valueList.item(i).getFirstChild().getNodeValue()); 
            }
 
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }       
    }
}
