package com.example.quizylecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Receive score from intent
        int finalScore = getIntent().getIntExtra("FINAL_SCORE", 0);

        // Set up UI components
        TextView scoreTextView = findViewById(R.id.textView);
        Button restartButton = findViewById(R.id.button);

        // Display score
        String scoreMessage = "Your score: " + finalScore;
        scoreTextView.setText(scoreMessage);

        // Restart quiz logic
        restartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Prevent back to result screen
                    });
            }
}