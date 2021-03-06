package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    // TODO: Declare member variables here:
    TextView scoreTv, question_text_view;
    ProgressBar progress_bar;
    private int mIndex = 0;
    private int score = 0;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true)
    };

    // TODO: Declare constants here
    private final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / mQuestionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            score = savedInstanceState.getInt("ScoreKey");
            mIndex = savedInstanceState.getInt("IndexKey");
        }
        else{
            score = 0;
            mIndex = 0;
        }

        initializeViews();
        updateScoreTv();
    }

    private void initializeViews() {
        scoreTv = findViewById(R.id.score);
        question_text_view = findViewById(R.id.question_text_view);
        progress_bar = findViewById(R.id.progress_bar);
    }

    public void trueBtnListener(View view) {
        checkTrueAnswer();
        updateQuestion();
    }

    private void updateQuestion() {
        mIndex = ((mIndex + 1) % mQuestionBank.length);
        if (mIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over!");
            alert.setMessage("You Scored " + score + " points");
            alert.setCancelable(false);
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.show();
        }
        updateScoreTv();
        progress_bar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        question_text_view.setText(mQuestionBank[mIndex].getmQuestuinID());
    }

    private void checkTrueAnswer() {
        if (mQuestionBank[mIndex].ismTrueFalse()) {
            score++;
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateScoreTv() {
        scoreTv.setText("Score " + score + "/" + mQuestionBank.length);
    }

    public void falseBtnListener(View view) {
        checkFalseAnswer();
        updateQuestion();
        //comment
    }

    private void checkFalseAnswer() {
        if (mQuestionBank[mIndex].ismTrueFalse()) {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        } else {
            score++;
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey",score);
        outState.putInt("IndexKey",mIndex);
    }
}
