package com.example.navneetnandan.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int userTotalScore;
    public int userTurnScore;
    public int computerTotalScore;
    public int computerRoundScore;
    private ImageView mDiceView;
    private Button mHold, mReset, mRoll;
    private TextView mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDiceView=(ImageView)findViewById(R.id.image);
        mHold=(Button)findViewById(R.id.hold);
        mRoll=(Button)findViewById(R.id.roll);
        mReset=(Button)findViewById(R.id.reset);
        mScore=(TextView) findViewById(R.id.status);
        mRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                int nextDiceValue=random.nextInt(6);
                switch (nextDiceValue){
                    case 0:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                        userTurnScore=0;
                        mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" your turn score: "+ userTurnScore);
                        computerTurn();
                        break;

                    case 1:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                        userTurnScore +=2;
                        mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" your turn score: "+ userTurnScore);
                        break;

                    case 2:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                        userTurnScore +=3;
                        mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" your turn score: "+ userTurnScore);
                        break;

                    case 3:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                        userTurnScore +=4;
                        mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" your turn score: "+ userTurnScore);
                        break;

                    case 4:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                        userTurnScore +=5;
                        mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" your turn score: "+ userTurnScore);
                        break;

                    case 5:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                        userTurnScore +=6;
                        mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" your turn score: "+ userTurnScore);
                        break;
                }
            }
        });
        mHold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTotalScore+=userTurnScore;
                userTurnScore=0;
                mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" your turn score: "+ userTurnScore);
                computerTurn();
            }
        });
        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTurnScore=0;
                userTotalScore=0;
                computerTotalScore=0;
                computerRoundScore=0;
                mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" your turn score: "+ userTurnScore);
            }
        });
    }

    void computerTurn(){
        mHold.setEnabled(false);
        mRoll.setEnabled(false);
        Random random=new Random();
        for (int i=0; i<20;i++){
            int nextDiceValue=random.nextInt(6);
            boolean isOne=false;
            Log.e("random", nextDiceValue+"");
            switch (nextDiceValue){
                case 0:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                    computerRoundScore=0;
                    mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" computer turn score: "+ computerRoundScore);
                    isOne=true;
                    break;

                case 1:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                    computerRoundScore +=2;
                    mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" computer turn score: "+ computerRoundScore);
                    break;

                case 2:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                    computerRoundScore +=3;
                    mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" computer turn score: "+ computerRoundScore);
                    break;

                case 3:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                    computerRoundScore +=4;
                    mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" computer turn score: "+ computerRoundScore);
                    break;

                case 4:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                    computerRoundScore +=5;
                    mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" computer turn score: "+ computerRoundScore);
                    break;

                case 5:mDiceView.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                    computerRoundScore +=6;
                    mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" computer turn score: "+ computerRoundScore);
                    break;
            }
            if(isOne){
                break;
            }
        }
        computerTotalScore +=computerRoundScore;
        mScore.setText("Your score: "+userTotalScore+" computer score: "+computerTotalScore+" computer turn score: "+ computerRoundScore);
        mRoll.setEnabled(true);
        mHold.setEnabled(true);
    }
}
