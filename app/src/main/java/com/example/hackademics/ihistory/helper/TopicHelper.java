package com.example.hackademics.ihistory.helper;

import java.util.HashMap;
import java.util.List;

import android.content.Context;

import com.example.hackademics.ihistory.model.Topic;

public class TopicHelper extends AssetsHelper {

	public TopicHelper(Context context) {
		super(context);
	}
	public List<Topic> getTopicNames() {
		XmlDataHelper helper = new XmlDataHelper(context);
		return helper.getTopicNames();
	}

}
