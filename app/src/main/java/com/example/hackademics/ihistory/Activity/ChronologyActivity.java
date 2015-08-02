package com.example.hackademics.ihistory.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hackademics.ihistory.R;
import com.example.hackademics.ihistory.helper.XmlDataHelper;
import com.example.hackademics.ihistory.model.Topic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Nhan on 01/08/2015.
 */
public class ChronologyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronology);
        LinearLayout li=(LinearLayout)findViewById(R.id.Layout1);
        XmlDataHelper xmlHelper=new XmlDataHelper(getApplicationContext());
        List<Topic> chros = xmlHelper.getTopicNames();

        for(int i = 0; i < chros.size(); i++)  //hien cac button cac trieu dai
        {
            Topic chro = chros.get(i);
            Button btn=new Button(this);
            btn.setText(chro.getValue());
            btn.setBackgroundResource(R.drawable.btnmenu);
            btn.setTextColor(getResources().getColor(R.color.ye));
            btn.setLayoutParams(new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            final String name =chro.getName();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in=new Intent(ChronologyActivity.this,WarActivity.class);
                    in.putExtra("name",name);
                    startActivity(in);
                }
            });
            li.addView(btn);
        }
    }
}
