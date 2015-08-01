package com.example.hackademics.ihistory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hackademics.ihistory.helper.XmlDataHelper;

import java.util.List;

/**
 * Created by Nhan on 01/08/2015.
 */
public class Wars extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronology);
        Intent in=getIntent();
        String file=in.getExtras().getString("name");
        XmlDataHelper x=new XmlDataHelper(getApplicationContext());
        List<String> wars=x.getWordsByTopic(file);
        LinearLayout li=(LinearLayout)findViewById(R.id.Layout1);
        for(int m=0;m<wars.size();m++)
        {
            Button btn=new Button(this);
            btn.setText(wars.get(m));
            btn.setLayoutParams(new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            li.addView(btn);
        }
    }
}
