package com.example.hackademics.ihistory.helper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.content.Context;

public class XuLyXMLHelper {
	public static Element Doc_Nut(Context context, String Chuoi_Path,
			String Duong_Dan, boolean typeAssert) {
		Element kq = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputStream is = null;
			if (typeAssert)
				is = context.getAssets().open(Duong_Dan);
			else {
				File file = new File(Duong_Dan);
				is = new BufferedInputStream(new FileInputStream(file));
			}

			InputSource inputSource = new InputSource(is);
			Document doc = dBuilder.parse(inputSource);

			doc.getDocumentElement().normalize();

			kq = (Element) doc.getElementsByTagName(Chuoi_Path).item(0);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public static NodeList Doc_danh_sach(Context context, String Chuoi_Path,
			String Duong_Dan, boolean typeAssert) {
		NodeList kq = null;
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			InputStream is = null;
			if (typeAssert)
				is = context.getAssets().open(Duong_Dan);
			else {
				File file = new File(Duong_Dan);
				is = new BufferedInputStream(new FileInputStream(file));
			}

			InputSource inputSource = new InputSource(is);
			Document doc = dBuilder.parse(inputSource);

			doc.getDocumentElement().normalize();
			kq = doc.getElementsByTagName(Chuoi_Path);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public static Element Tao_Goc(String Ten_the) {
		Element Kq;
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document Tai_lieu = documentBuilder.newDocument();
		Kq = Tai_lieu.createElement(Ten_the);
		Tai_lieu.appendChild(Kq);
		return Kq;
	}

	public static Element Tao_nut(String Ten_the, Element Nut_cha) {
		Element Kq;
		Document Tai_lieu = Nut_cha.getOwnerDocument();
		Kq = Tai_lieu.createElement(Ten_the);
		Nut_cha.appendChild(Kq);
		return Kq;
	}

	public static boolean Ghi_nut(Element Nut, String Duong_dan) {
		boolean kq = false;
		Document Tai_lieu = Nut.getOwnerDocument();
		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			File file = new File(Duong_dan);
			if (file != null) {
				Result output = new StreamResult(file);
				Source input = new DOMSource(Tai_lieu);
				transformer.transform(input, output);
				kq = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
}
