package com.example.hackademics.ihistory.helper;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;


public class AssetsHelper extends ContextHelper {

	public AssetsHelper(Context context) {
		super(context);
	}

	public InputStream openFileStream(String filePath) throws IOException {
		try {
			return context.getAssets().open(filePath + ".jpg");
		} catch (IOException e) {
			return context.getAssets().open(filePath + ".png");
		}
	}

}
