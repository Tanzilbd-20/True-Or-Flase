package com.example.trueorfalse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;


import com.example.trueorfalse.databinding.ActivityMainBinding;
import com.example.trueorfalse.model.Questions;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private int currentQuestionIndex = 0;
    private ActivityMainBinding binding;
    private final Questions[] questionBank = new Questions[]{
            new Questions(R.string.question1, false),
            new Questions(R.string.question2, false),
            new Questions(R.string.question3, true),
            new Questions(R.string.question4, false),
            new Questions(R.string.question5,true),
            new Questions(R.string.question6,true),
            new Questions(R.string.question7,false),
            new Questions(R.string.question8,true),
            new Questions(R.string.question9,true),
            new Questions(R.string.question10,false),
            new Questions(R.string.question11,false),
            new Questions(R.string.question12,true),
            new Questions(R.string.question13,false),
            new Questions(R.string.question14,true),
            new Questions(R.string.question15,false),
            new Questions(R.string.question16,true),
            new Questions(R.string.question17,true),
            new Questions(R.string.question18,true),
            new Questions(R.string.question19,false),
            new Questions(R.string.question20,false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.questionTextView.setText(questionBank[0].getQuestionResId());

        binding.nextButton.setOnClickListener(view -> {
            currentQuestionIndex++;
            if(currentQuestionIndex >questionBank.length-1){
                Snackbar.make(binding.logoImageView,R.string.last_question_text,Snackbar.LENGTH_SHORT).show();
                currentQuestionIndex = questionBank.length-1;
            }else{
                updateQuestion();
            }

        });

        binding.prevButton.setOnClickListener(view -> {
            currentQuestionIndex--;
            if(currentQuestionIndex <0){
                Snackbar.make(binding.logoImageView,R.string.first_question_text,Snackbar.LENGTH_SHORT).show();

                currentQuestionIndex = 0;
            }else{
                updateQuestion();
            }
        });

        binding.trueButton.setOnClickListener(view -> checkAnswer(true));

        binding.falseButton.setOnClickListener(view -> checkAnswer(false));
    }

    private void checkAnswer(boolean chosenAnswer) {
       boolean correctAnswerIs = questionBank[currentQuestionIndex].isTrue();
       int messageId ;
    if(correctAnswerIs == chosenAnswer){
        messageId = R.string.correct_answer;
    }else{
        messageId = R.string.wrong_answer;
    }
        Snackbar.make(binding.logoImageView, messageId, Snackbar.LENGTH_SHORT).show();

    }

    private void updateQuestion() {
        binding.questionTextView.setText(questionBank[currentQuestionIndex].getQuestionResId());
    }


}