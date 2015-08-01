package com.example.hackademics.ihistory.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.content.Context;

import com.example.hackademics.ihistory.model.War;

public class XmlDataHelper extends ContextHelper {

	public XmlDataHelper(Context context) {
		super(context);
	}

	public List<War> getWarsByTopic(String topicName) {
		List<War> wars = new ArrayList<War>();
		String path = "Xml/DataForTopic/" + topicName + ".xml";
		NodeList NLdsTopic = XuLyXMLHelper.Doc_danh_sach(context, "war", path,
				true);
		for (int i = 0; i < NLdsTopic.getLength(); i++) {
            Element w = (Element) NLdsTopic.item(i);
            String name = w.getAttribute("name");
            String link=w.getAttribute("link");
            String warName=w.getTextContent();
            War war = new War(name,link,warName);
			wars.add(war);
		}
		return wars;
	}

	public HashMap<String,String> getTopicNames() {
        HashMap<String,String>  dsTopic = new HashMap<String,String>();
		String path = "Xml/Topic/ListTopic.xml";
		NodeList NLdsTopic = XuLyXMLHelper.Doc_danh_sach(context, "topic",
				path, true);
		for (int i = 0; i < NLdsTopic.getLength(); i++) {
			Element war = (Element) NLdsTopic.item(i);
            dsTopic.put(war.getAttribute("name"),war.getTextContent());

		}
		return dsTopic;
	}

}
