package com.example.extstudent.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuizQuestion extends AppCompatActivity {
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correctAnswer;
    QuizQuestion(){

    }
    protected void setQuestion(String question) {
        this.question = question;
    }
    protected void setChoiceA(String answer) {
this.choiceA = answer;
    }

    protected void setChoiceB(String answer) {
      this.choiceB = answer;
    }

    protected void setChoiceC(String answer) {
this.choiceC = answer;
    }

    protected void setChoiceD(String answer) {
        this.choiceD = answer;
    }

    protected void setCorrectAnswer(String correctAnswer) {
      this.correctAnswer = correctAnswer;
    }

    protected String getQuestion() {
       return this.question;
    }

    protected String getChoiceA() {
       return this.choiceA;
    }

    protected String getChoiceB() {
      return this.choiceB ;
    }

    protected String getChoiceC() {
      return this.choiceC;
    }

    protected String getChoiceD() {
       return this.choiceD;
    }
    protected boolean isCorrectAnswer(String answer){
        if(this.correctAnswer == null){
            return false;
        }
        else if(this.correctAnswer==answer){
            return true;

        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);


    }
}
