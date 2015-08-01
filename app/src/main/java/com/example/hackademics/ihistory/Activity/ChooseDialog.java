package com.example.hackademics.ihistory.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hackademics.ihistory.R;

/**
 * Created by Nhan on 01/08/2015.
 */
public class ChooseDialog extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        Intent in=getIntent();
        final String name=in.getExtras().getString("name");
        Log.d("error: ",name);
        final String link=in.getExtras().getString("link");
        Log.d("error: ",link);
        Button btnClip =(Button)findViewById(R.id.btnclip);
        btnClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChooseDialog.this,ClipActivity.class);

                intent.putExtra("link",link);
                startActivity(intent);
            }
        });
        Button btnChoi=(Button)findViewById(R.id.btnhoi);
    }
}
