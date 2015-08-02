package com.example.hackademics.ihistory.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hackademics.ihistory.R;
import com.example.hackademics.ihistory.helper.XmlDataHelper;
import com.example.hackademics.ihistory.model.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nhan on 02/08/2015.
 */
public class QuizActivity extends Activity {
    int score1=0;
    int score2=0;
    Question current_qs;
    List<Question> questionList;
    TextView ques;
    Button s1;
    Button s2;
    Button a1;
    Button a2;
    Button b1;
    Button b2;
    Button c1;
    Button c2;
    Button d1;
    Button d2;

    Random r;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** attaching layout xml **/
        setContentView(R.layout.quiz);

        ques = (TextView)findViewById(R.id.qs);
        s1 = (Button)findViewById(R.id.score1);
        s2 = (Button)findViewById(R.id.score2);
        a1=(Button)findViewById(R.id.a1);
        a2=(Button)findViewById(R.id.a2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        c1=(Button)findViewById(R.id.c1);
        c2=(Button)findViewById(R.id.c2);
        d1=(Button)findViewById(R.id.d1);
        d2=(Button)findViewById(R.id.d2);
        r = new Random();

        Intent in = getIntent();
        String name = in.getExtras().getString("name");
        XmlDataHelper xml = new XmlDataHelper(getApplicationContext());
        questionList = xml.getQuestionsByWar(name);


        random = r.nextInt(questionList.size());
        current_qs = questionList.get(random);
        questionList.remove(random);
        UpdateQuestion();

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAnswer("a", 1);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAnswer("b", 1);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAnswer("c", 1);
            }
        });

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAnswer("d", 1);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAnswer("a", 2);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAnswer("b", 2);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAnswer("c", 2);
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickAnswer("d", 2);
            }
        });

    }

    private void ClickAnswer(String namebtn, int player){
        if(namebtn.equals(current_qs.getAnswer())){
            if(player == 1)
                score1++;
            else
                score2++;
        }else{
            if(player == 1)
                score1--;
            else
                score2--;
        }

        random = r.nextInt(questionList.size());
        current_qs = questionList.get(random);

        Toast.makeText(getApplicationContext(), "Đáp án:" + current_qs.getAnswer(), Toast.LENGTH_LONG).show();
        s1.setText(Integer.toString(score1));
        s2.setText(Integer.toString(score2));
        questionList.remove(random);
        UpdateQuestion();
    }

    private void UpdateQuestion(){
        ques.setText(current_qs.getName());
        a1.setText(current_qs.getAnswers().get(0));
        a2.setText(current_qs.getAnswers().get(0));
        b1.setText(current_qs.getAnswers().get(1));
        b2.setText(current_qs.getAnswers().get(1));
        c1.setText(current_qs.getAnswers().get(2));
        c2.setText(current_qs.getAnswers().get(2));
        d1.setText(current_qs.getAnswers().get(3));
        d2.setText(current_qs.getAnswers().get(3));
    }

}
