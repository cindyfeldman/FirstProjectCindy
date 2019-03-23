package com.example.extstudent.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Queue;

public class QuizActivity extends AppCompatActivity {
private ArrayList<QuizQuestion> quizQuestionList = null;
QuizQuestion currentQuestion = null;
int currentQuestionNumber = 1;
private int currentScore = 0;
private int maxScore = 0;
TextView textViewQuestionTitle = null;
TextView textViewQuestion = null;
TextView textViewScore = null;
RadioGroup radioGroupQuestion = null;
RadioButton radioButtonA = null;
RadioButton radioButtonB = null;
RadioButton radioButtonC = null;
RadioButton radioButtonD = null;
Button buttonSubmit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.textViewQuestionTitle = findViewById(R.id.QuestionNumber);
        this.textViewQuestion = findViewById(R.id.Question);
        this.textViewScore = findViewById(R.id.Score);
        radioGroupQuestion = findViewById(R.id.RadioGroup);
        radioButtonA = findViewById(R.id.choiceA);
        radioButtonB = findViewById(R.id.choiceB);
        radioButtonC = findViewById(R.id.choiceD);
        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        this.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(validateAnswer()){
                if(currentQuestionNumber<=maxScore){
                    currentQuestion = quizQuestionList.get(currentQuestionNumber);
                    currentQuestionNumber++;
                }
                else{
                    Intent intent = new Intent(QuizActivity.this,com.example.extstudent.myapplication.ResultsActivity.class);
                   intent.putExtra("currentScore",currentScore);
                   intent.putExtra("MAX",maxScore);
                    startActivity(intent);
                }
            }

            }
        });
        this.initQuestions();
        this.setQuestionView(this.currentQuestion);
    }

private void initQuestions(){
        this.quizQuestionList = new ArrayList<QuizQuestion>();
        QuizQuestion uno = new QuizQuestion();
        QuizQuestion dos = new QuizQuestion();
        QuizQuestion three = new QuizQuestion();
        QuizQuestion four = new QuizQuestion();
        QuizQuestion five = new QuizQuestion();
      quizQuestionList.add(uno);
      uno.setQuestion("How many bones does a human have");
      uno.setChoiceA("10");
      uno.setChoiceB("1000");
      uno.setChoiceC("206");
      uno.setChoiceD("199");
      uno.setCorrectAnswer("206");
      quizQuestionList.add(dos);
      dos.setQuestion("How many continents are there in the world?");
      dos.setChoiceA("5");
      dos.setChoiceB("7");
      dos.setChoiceC("20");
      dos.setChoiceD("6");
      dos.setCorrectAnswer("7");
      quizQuestionList.add(three);
      three.setQuestion("How many time zones are there?");
      three.setChoiceA("24");
      three.setChoiceB("7");
      three.setChoiceC("4");
      three.setChoiceD("2");
      three.setCorrectAnswer("24");
      quizQuestionList.add(four);
      four.setQuestion("How much is Apple worth?");
      four.setChoiceA("1 billion");
      four.setChoiceB("50 billion" );
      four.setChoiceC("100 million");
      four.setChoiceD("1 trillion");
      four.setCorrectAnswer("1 trillion");
      quizQuestionList.add(five);
      five.setQuestion("What's the powerhouse of the cell?");
      five.setChoiceA("the nucleus");
      five.setChoiceB("the Mitochondria");
      five.setChoiceC("the chloroplast");
      five.setChoiceD("Ribosomes");
      five.setCorrectAnswer("the Mitochondria");

      this.currentQuestion = quizQuestionList.get(0);
    this.currentQuestionNumber = 1;
    this.maxScore = this.quizQuestionList.size();
    this.currentScore = 0;

}
private void setQuestionView(QuizQuestion quizQuestion) {

    if(quizQuestion == null) {
        Log.d("[DEBUG]", "quizQuestion is null in setQuestionView.");
        return;
    }

    // Clear the radio button checks just encase it was been set previously.
    radioGroupQuestion.clearCheck();

textViewQuestionTitle.setText(currentQuestionNumber);
textViewQuestion.setText(quizQuestion.getQuestion());
radioButtonA.setText(quizQuestion.getChoiceA());
radioButtonB.setText(quizQuestion.getChoiceB());
radioButtonC.setText(quizQuestion.getChoiceC());
radioButtonD.setText(quizQuestion.getChoiceD());
textViewScore.setText("Score: "+ currentScore);

}


    private boolean validateAnswer(){

        int selectedButtonID = this.radioGroupQuestion.getCheckedRadioButtonId();
        if(selectedButtonID != -1){
            String answerSelectedStr = ((RadioButton)findViewById(selectedButtonID)).getText().toString();
            if (currentQuestion.isCorrectAnswer(answerSelectedStr)) {
                // Answer is correct.
                Log.d("ANSWER: ", "Correct");
                currentScore++;
        }
        else{
                Log.d("Answer: ", "incorrect");

            }
            return true;}
       else{
            Toast.makeText(getApplicationContext(), "Please Select An Answer",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
