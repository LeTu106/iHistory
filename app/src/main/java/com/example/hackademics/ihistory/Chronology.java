package com.example.hackademics.ihistory;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Nhan on 01/08/2015.
 */
public class Chronology extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronology);
        LinearLayout li=(LinearLayout)findViewById(R.id.Layout1);

        Resources res = getResources();
        String[] chro = res.getStringArray(R.array.chronology1);
        for(int m=0;m<chro.length;m++)  //hien cac button cac trieu dai
        {
            Button btn=new Button(this);
            btn.setText(chro[m]);
            btn.setLayoutParams(new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            final String n=chro[m];
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in=new Intent(Chronology.this,Wars.class);
                    in.putExtra("ten",n);
                    startActivity(in);
                }
            });
            li.addView(btn);
        }
    }
}
