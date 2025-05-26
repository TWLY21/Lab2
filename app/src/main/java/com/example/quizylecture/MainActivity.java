package com.example.quizylecture;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final Question[] questionBank = new Question[]{
            new Question("The sky is blue.", true),
            new Question("2 + 2 equals 5.", false),
            new Question("The earth is flat.", false),
            new Question("Fire is cold.", false),
            new Question("Water boils at 100°C.", true)
    };

    private int currentIndex = 0;
    private int score = 0; // 🆕 Track correct answers
    private User user;
    private TextView questionTextView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question_text_view);
        Button trueButton = findViewById(R.id.true_button);
        Button falseButton = findViewById(R.id.false_button);
        Button backButton = findViewById(R.id.Back_button);

        user = new User("Faris");

        updateQuestion();

        trueButton.setOnClickListener(v -> {
            checkAnswer(true);
            moveToNextQuestionOrFinish();
        });

        falseButton.setOnClickListener(v -> {
            checkAnswer(false);
            moveToNextQuestionOrFinish();
        });

        backButton.setOnClickListener(v -> backToPreviousQuestion());
    }

    private void updateQuestion() {
        questionTextView.setText(questionBank[currentIndex].getQuestionText());
    }

    private void moveToNextQuestionOrFinish() {
        if (currentIndex == questionBank.length - 1) {
            // ✅ Quiz completed
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("FINAL_SCORE", score);
            startActivity(intent);
            finish(); // 🚫 Prevent back navigation
        } else {
            currentIndex++;
            updateQuestion();
        }
    }

    private void backToPreviousQuestion() {
        currentIndex = (currentIndex - 1 + questionBank.length) % questionBank.length;
        updateQuestion();
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = questionBank[currentIndex].isAnswerTrue();
        if (userAnswer == correctAnswer) {
            score++; // 🆙 Increase score
        }
        String message = user.getUsername() + (userAnswer == correctAnswer ? ", Correct!" : ", Incorrect!");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                }
}