package com.example.hackademics.ihistory.helper;

import java.util.HashMap;
import java.util.List;

import android.content.Context;

public class TopicHelper extends AssetsHelper {

	public TopicHelper(Context context) {
		super(context);
	}
	public HashMap<String,String> getTopicNames() {
		XmlDataHelper helper = new XmlDataHelper(context);
		return helper.getTopicNames();
	}

}
