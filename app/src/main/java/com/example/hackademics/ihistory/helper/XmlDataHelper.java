package com.example.hackademics.ihistory.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.content.Context;

import com.example.hackademics.ihistory.model.Question;
import com.example.hackademics.ihistory.model.Topic;
import com.example.hackademics.ihistory.model.War;

public class XmlDataHelper extends ContextHelper {

	public XmlDataHelper(Context context) {
		super(context);
	}

    public List<Question> getQuestionsByWar(String warName) {
        List<Question> questionList = new ArrayList<Question>();
        String path = "Xml/Questions/" + warName + ".xml";
        NodeList NLQuestion = XuLyXMLHelper.Doc_danh_sach(context, "question", path,
                true);
        for (int i = 0; i < NLQuestion.getLength(); i++) {
            Element equestion = (Element)NLQuestion.item(i);
            String name = equestion.getAttribute("name");
            String answer = equestion.getAttribute("answer");
            NodeList NLAnswer = equestion.getChildNodes();
            List<String> answers = new ArrayList<String>();
            for (int j = 0; j < NLAnswer.getLength(); j++) {
                if(NLAnswer.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element eanswer = (Element) NLAnswer.item(j);
                    answers.add(eanswer.getTextContent());
                }
            }
            Question question = new Question(name, answer, answers);
            questionList.add(question);
        }
        return questionList;
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

	public List<Topic> getTopicNames() {
        List<Topic> dsTopic = new ArrayList<>();
		String path = "Xml/Topic/ListTopic.xml";
		NodeList NLdsTopic = XuLyXMLHelper.Doc_danh_sach(context, "topic",
				path, true);
		for (int i = 0; i < NLdsTopic.getLength(); i++) {
			Element war = (Element) NLdsTopic.item(i);
            Topic topic = new Topic(war.getAttribute("name"),war.getTextContent());
            dsTopic.add(topic);
		}
		return dsTopic;
	}

}
