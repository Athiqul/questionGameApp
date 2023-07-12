package com.example.questionanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private final String[] questions={
            "Elon Musk is an Software Engineer?",
            "Narendra Modi is a Bangladesh Prime Minister?",
            "Sheikh Hasina is a Awami League President?",
            "Joy Bangla is a slogan of Bangladesh BNP ?",
            "Messi Won Three world cup?",
            "We are humans not demons?",
            "Above It provides enterprise services?",
            "Boss is always right?",
            "Human is mortal?"

    };
    private final boolean [] answers={false,false,true,false,false,true,true,false,true};
    //Get elements
    Button yes;
    Button no;
    TextView ques;
    Button reset;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //index and scores
        final  AtomicInteger index= new AtomicInteger(0);
        final AtomicInteger scores = new AtomicInteger(0);
        ques=(TextView) findViewById(R.id.questions);
        ques.setText(questions[index.get()]);
        no=(Button)findViewById(R.id.No);
        yes=(Button) findViewById(R.id.yes);
        reset=(Button)findViewById(R.id.reset);
        //Yes listener

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check answers
                if(answers[index.get()])
                {
                    scores.incrementAndGet();
                }
                if(index.get()<=questions.length-2)
                {


                    ques.setText(questions[index.incrementAndGet()]);

                }

                else{
                    no.setVisibility(View.INVISIBLE);
                    yes.setVisibility(View.INVISIBLE);
                    reset.setVisibility(View.VISIBLE);
                    ques.setText("Game is over");
                    Toast.makeText(getApplication(),"Your game is over and your score is: " +scores.get() +" out of "+questions.length,Toast.LENGTH_SHORT).show();

                }



            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check answers
                if(!answers[index.get()])
                {
                    scores.incrementAndGet();
                }
                if(index.get()<=questions.length-2)
                {


                    ques.setText(questions[index.incrementAndGet()]);

                }
                else{
                    no.setVisibility(View.INVISIBLE);
                    yes.setVisibility(View.INVISIBLE);
                    ques.setText("Game is over");
                    reset.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplication(),"Your game is over and your score is: " +scores.get(),Toast.LENGTH_SHORT).show();

                }


            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scores.set(0);
                index.set(0);
                reset.setVisibility(View.INVISIBLE);
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                ques.setText(questions[index.get()]);
            }
        });
    }
}