package com.example.hackademics.ihistory.helper;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageHelper extends AssetsHelper {

	public ImageHelper(Context context) {
		super(context);
	}

	public Bitmap loadImage(String imagePath, int width, int height) {
		try {
			InputStream inputStream = openFileStream(imagePath);
			Bitmap image = BitmapFactory.decodeStream(inputStream);
			Bitmap scaleImage = Bitmap.createScaledBitmap(image, width, height,
					true);
			inputStream.close();
			return scaleImage;
		} catch (IOException e) {
			return null;
		}
	}

}
