package com.example.hackademics.ihistory.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hackademics.ihistory.R;
import com.example.hackademics.ihistory.helper.XmlDataHelper;
import com.example.hackademics.ihistory.model.War;

import java.util.List;

/**
 * Created by Nhan on 01/08/2015.
 */

public class WarActivity extends Activity {

    String name;
    String link;
    List<War> wars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronology);
        Intent in=getIntent();
        String file=in.getExtras().getString("name");
        XmlDataHelper x=new XmlDataHelper(getApplicationContext());
        wars=x.getWarsByTopic(file);
        LinearLayout li=(LinearLayout)findViewById(R.id.Layout1);
        for(int m=0;m<wars.size();m++)
        {
            Button btn=new Button(this);
            btn.setTag(m);
            btn.setText(wars.get(m).getWar_name());
            btn.setBackgroundResource(R.drawable.btnmenu);
            btn.setTextColor(getResources().getColor(R.color.ye));
            btn.setLayoutParams(new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Button bt=(Button)view;
                    int k=(int)bt.getTag();
                    /*Intent in=new Intent(WarActivity.this,ChooseDialog.class);
                    in.putExtra("name",name);
                    in.putExtra("link",link);
                    startActivity(in);*/

                    showDialog(k);
                }
            });
            li.addView(btn);
        }
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final int vt = id;
        //Toast.makeText(getApplicationContext(),vt+"",Toast.LENGTH_LONG).show();
        builder.setTitle("Lựa chọn:");
        builder.setMessage("bạn muốn xem clip hay chơi?");
        builder.setCancelable(false);
        builder.setPositiveButton("Xem clip", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent in = new Intent(WarActivity.this, ClipActivity.class);
                in.putExtra("link", wars.get(vt).getLink());
                startActivity(in);
            }
        });
        builder.setNegativeButton("Chơi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent in = new Intent(WarActivity.this, QuizActivity.class);
                in.putExtra("name", wars.get(vt).getName());
                startActivity(in);
            }
        });
        return builder.create();
    }
}
