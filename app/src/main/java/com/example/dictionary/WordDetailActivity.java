package com.example.dictionary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WordDetailActivity extends AppCompatActivity {

    private TextView textWord;
    private TextView textMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);

        textWord = findViewById(R.id.textWord);
        textMeaning = findViewById(R.id.textMeaning);

        // Get the selected word from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("word")) {
            Word word = intent.getParcelableExtra("word");
            displayWordDetails(word);
        }
    }

    private void displayWordDetails(Word word) {
        textWord.setText(word.getWord());
        textMeaning.setText(word.getMeaning());
    }
}
