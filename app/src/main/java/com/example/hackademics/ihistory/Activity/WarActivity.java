package com.example.hackademics.ihistory.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hackademics.ihistory.R;
import com.example.hackademics.ihistory.helper.XmlDataHelper;
import com.example.hackademics.ihistory.model.War;

import java.util.List;

/**
 * Created by Nhan on 01/08/2015.
 */

public class WarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronology);
        Intent in=getIntent();
        String file=in.getExtras().getString("name");
        XmlDataHelper x=new XmlDataHelper(getApplicationContext());
        List<War> wars=x.getWarsByTopic(file);
        LinearLayout li=(LinearLayout)findViewById(R.id.Layout1);
        for(int m=0;m<wars.size();m++)
        {
            Button btn=new Button(this);
            btn.setText(wars.get(m).getWar_name());
            btn.setLayoutParams(new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            final String name=wars.get(m).getName();
            final String link=wars.get(m).getLink();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in=new Intent(WarActivity.this,ChooseDialog.class);
                    in.putExtra("name",name);
                    in.putExtra("link",link);
                    startActivity(in);
                }
            });
            li.addView(btn);
        }
    }
}
