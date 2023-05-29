package com.example.dictionary;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class  YorubaActivity extends AppCompatActivity {

    private ListView listView;
    private WordAdapter wordAdapter;
    private List<Word> wordList;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoruba);

        listView = findViewById(R.id.listView);
        wordList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(this);

        // Populate the wordList from the database
        loadWordsFromDatabase();

        wordAdapter = new WordAdapter(this, wordList);
        listView.setAdapter(wordAdapter);

        // Handle item click on the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word selectedWord = wordList.get(position);

                // Start WordDetailActivity and pass the selected word
                Intent intent = new Intent(YorubaActivity.this, WordDetailActivity.class);
                intent.putExtra("word", selectedWord);
                startActivity(intent);
            }
        });

        // Manually insert words into the database
        insertWordsIntoDatabase();
    }

    private void loadWordsFromDatabase() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM words", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String word = cursor.getString(cursor.getColumnIndex("word"));
                @SuppressLint("Range") String meaning = cursor.getString(cursor.getColumnIndex("meaning"));

                wordList.add(new Word(word, meaning));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    private void insertWordsIntoDatabase() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        // Check if the words are already inserted
        Cursor cursor = db.rawQuery("SELECT * FROM words", null);
        if (cursor.getCount() > 0) {
            // Words are already inserted, no need to insert again
            cursor.close();
            db.close();
            return;
        }
        cursor.close();

        // Insert words into the database
        ContentValues values = new ContentValues();
        values.put("word", "Hello");
        values.put("meaning", "A greeting or expression of goodwill");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "beans");
        values.put("meaning", "ẹ̀wà, Mo fẹ́ jẹ ẹ̀wà, I want to eat beans");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "abandon");
        values.put("meaning", "fi silẹ, Mo fẹ́ fi silẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "ability");
        values.put("meaning", "agbara, Mo ni agbara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "able");
        values.put("meaning", "le, Mo le ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "about");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "above");
        values.put("meaning", "loke, Mo wa loke");
        db.insert("words", null, values);
        values.put("meaning", "nipa, Mo n sọ̀rọ̀ nipa");

        values.clear();
        values.put("word", "abroad");
        values.put("meaning", "okeere, Mo wa okeere");
        db.insert("words", null, values);
        db.close();

        values.clear();
        values.put("word", "World");
        StringBuilder sbMeanings = new StringBuilder();
        sbMeanings.append("The earth and all people and things on it");
        sbMeanings.append(" | ");
        sbMeanings.append("A planet in the solar system");
        sbMeanings.append(" | ");
        sbMeanings.append("The people and societies on Earth");

        values.put("meaning", sbMeanings.toString());
        db.insert("words", null, values);

    }
}
