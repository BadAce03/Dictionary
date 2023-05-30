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

        values.clear();
        values.put("word", "abroad");
        values.put("meaning", "okeere, Mo wa okeere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Absence");
        values.put("meaning", "Àìbẹ́ẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Absolute");
        values.put("meaning", "Ọ̀tọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Absorb");
        values.put("meaning", "Gba e lo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Abuse");
        values.put("meaning", "Ìjẹ́wọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Academic");
        values.put("meaning", "Ẹkọ́ ọ̀wọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Accept");
        values.put("meaning", "Ṣe ẹ̀yẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "According");
        values.put("meaning", "Gẹ́gẹ́ bí");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Account");
        values.put("meaning", "Ìwé ìyádọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Across");
        values.put("meaning", "Kọja");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Act");
        values.put("meaning", "Ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Action");
        values.put("meaning", "Iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Activity");
        values.put("meaning", "Iṣẹ́-ṣiṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Actually");
        values.put("meaning", "Nitori bẹ́ẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Add");
        values.put("meaning", "Fi kun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Address");
        values.put("meaning", "Adirẹsi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Administration");
        values.put("meaning", "Ìṣakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Admit");
        values.put("meaning", "Gbà wọlé");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Adult");
        values.put("meaning", "Ọdọ agbára");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Affect");
        values.put("meaning", "Fọwọ́ kan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "After");
        values.put("meaning", "Lẹ́hìn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Again");
        values.put("meaning", "Lẹ́ẹ̀kansi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Against");
        values.put("meaning", "Lọ́dọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Age");
        values.put("meaning", "Ọjọ́ ọmọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Agency");
        values.put("meaning", "Ẹgbẹ́ ìṣakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Agent");
        values.put("meaning", "Aṣoju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Ago");
        values.put("meaning", "Ṣẹ̀yìn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Agree");
        values.put("meaning", "Ṣe àdéhùn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Agreement");
        values.put("meaning", "Ìdehùn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Ahead");
        values.put("meaning", "Siwaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Air");
        values.put("meaning", "Ẹ̀fumọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Allow");
        values.put("meaning", "Fọwọ́ si");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Almost");
        values.put("meaning", "Fẹ́ẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Alone");
        values.put("meaning", "Ní ẹyọ kan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Along");
        values.put("meaning", "Lẹ́ẹ̀keji");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Already");
        values.put("meaning", "Tẹ́lẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Also");
        values.put("meaning", "Bẹ́ẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Alternative");
        values.put("meaning", "Aṣayan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Although");
        values.put("meaning", "Bẹ́ẹ̀ ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Always");
        values.put("meaning", "Gbogbo igba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "American");
        values.put("meaning", "Amẹrika");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Among");
        values.put("meaning", "Ninu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Among");
        values.put("meaning", "Ninu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Amount");
        values.put("meaning", "Iye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Analysis");
        values.put("meaning", "Iwadi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "And");
        values.put("meaning", "Ati");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Animal");
        values.put("meaning", "Ẹranko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Another");
        values.put("meaning", "Miiran");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Answer");
        values.put("meaning", "Idahun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Any");
        values.put("meaning", "Ẹnikẹni");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Anyone");
        values.put("meaning", "Ẹnikẹni");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Anything");
        values.put("meaning", "Ohun gbogbo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Appear");
        values.put("meaning", "Fara han");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Apply");
        values.put("meaning", "Lo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Approach");
        values.put("meaning", "Ilana");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Among");
        values.put("meaning", "Ninu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Appropriate");
        values.put("meaning", "O yẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Approval");
        values.put("meaning", "Iwọ̀lẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Approve");
        values.put("meaning", "Fọwọ́ sí");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Approximately");
        values.put("meaning", "To ṣẹ̀yìn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Architect");
        values.put("meaning", "Onilọ́pọ̀ ilé");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Area");
        values.put("meaning", "Agbegbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Argue");
        values.put("meaning", "Jà");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Arm");
        values.put("meaning", "Ọwọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Around");
        values.put("meaning", "Yika");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Arrive");
        values.put("meaning", "Wole");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Art");
        values.put("meaning", "Ohun-iwe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Article");
        values.put("meaning", "Akole");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Artist");
        values.put("meaning", "Alagbada");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "As");
        values.put("meaning", "Bi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Ask");
        values.put("meaning", "Gba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Attack");
        values.put("meaning", "Ta ti ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Attention");
        values.put("meaning", "Aṣayan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Audience");
        values.put("meaning", "Alejo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Author");
        values.put("meaning", "Onkọwe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Authority");
        values.put("meaning", "Aṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Auto");
        values.put("meaning", "Atuo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Available");
        values.put("meaning", "Wọle");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Avoid");
        values.put("meaning", "Yọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Away");
        values.put("meaning", "Lẹhin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Baby");
        values.put("meaning", "Ọmọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Bad");
        values.put("meaning", "Buburu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Bag");
        values.put("meaning", "Apo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Ball");
        values.put("meaning", "Rogodo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Bank");
        values.put("meaning", "Ile ifowopamọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Bar");
        values.put("meaning", "Ile ọti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Base");
        values.put("meaning", "Ipilẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Be");
        values.put("meaning", "Jẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Beat");
        values.put("meaning", "Lu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Beautiful");
        values.put("meaning", "Lẹwa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Because");
        values.put("meaning", "Nitori");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Become");
        values.put("meaning", "Di");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Bed");
        values.put("meaning", "Iyọ̀wu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Before");
        values.put("meaning", "Ṣaaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Begin");
        values.put("meaning", "Bẹrẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Behavior");
        values.put("meaning", "iwa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Behind");
        values.put("meaning", "Lẹhin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Believe");
        values.put("meaning", "Gbọ̀gbọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Benefit");
        values.put("meaning", "Anfani");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Best");
        values.put("meaning", "Ọpọ̀ju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Better");
        values.put("meaning", "dara ju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Between");
        values.put("meaning", "Laarin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Beyond");
        values.put("meaning", "Lẹ́ẹ̀kọ̀ọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Big");
        values.put("meaning", "Nla");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Bill");
        values.put("meaning", "Iwe ti owo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Billion");
        values.put("meaning", "Bilọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Bit");
        values.put("meaning", "Iwọn kekere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Black");
        values.put("meaning", "Dudu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Blood");
        values.put("meaning", "Ẹjẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Blue");
        values.put("meaning", "Ọ̀fẹ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Board");
        values.put("meaning", "Igbọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Body");
        values.put("meaning", "Ara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Book");
        values.put("meaning", "Iwe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Born");
        values.put("meaning", "Bi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Both");
        values.put("meaning", "Mejeeji");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Box");
        values.put("meaning", "Iyọ̀pọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Boy");
        values.put("meaning", "Ọmọkunrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Break");
        values.put("meaning", "Fọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Bring");
        values.put("meaning", "Mu wa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Brother");
        values.put("meaning", "Ẹgbọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Budget");
        values.put("meaning", "Isẹ́ eto owo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Build");
        values.put("meaning", "Kọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Building");
        values.put("meaning", "Ilé");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Business");
        values.put("meaning", "Iṣẹ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "But");
        values.put("meaning", "Ṣugbọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Buy");
        values.put("meaning", "Ra");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "By");
        values.put("meaning", "Nipasẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Call");
        values.put("meaning", "Pe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Camera");
        values.put("meaning", "Ẹ̀míà");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Campaign");
        values.put("meaning", "Iṣẹ́ ìpolongo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Can");
        values.put("meaning", "Ṣe ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Cancer");
        values.put("meaning", "Akẹsan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Candidate");
        values.put("meaning", "Ọmọṣẹ́ ìdìbò");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Capital");
        values.put("meaning", "Ìlú olu-ilu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Car");
        values.put("meaning", "Ẹ̀rọ̀ ọkọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Card");
        values.put("meaning", "Kaadi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Care");
        values.put("meaning", "Iṣẹ́ abojuto");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Career");
        values.put("meaning", "Iṣẹ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Carry");
        values.put("meaning", "Gbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Case");
        values.put("meaning", "Ẹ̀ka");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Catch");
        values.put("meaning", "Mu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Cause");
        values.put("meaning", "Ṣe okunfa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Cell");
        values.put("meaning", "Sẹli");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Center");
        values.put("meaning", "Aarin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Century");
        values.put("meaning", "Ọgọ̀rọ̀ọ̀dún");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Central");
        values.put("meaning", "Aarin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Certain");
        values.put("meaning", "Dájú");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Certainly");
        values.put("meaning", "Dájú");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Citizen");
        values.put("meaning", "Ọmọ ilu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "City");
        values.put("meaning", "Ilu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Civil");
        values.put("meaning", "Ẹ̀tọ́ ọmọ ilu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Claim");
        values.put("meaning", "Gbàgbọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Class");
        values.put("meaning", "Kọ́lẹ̀jì");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Clear");
        values.put("meaning", "Kọ́kọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Clearly");
        values.put("meaning", "Kọ́kọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Close");
        values.put("meaning", "Fọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Coach");
        values.put("meaning", "Olukọni");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Cold");
        values.put("meaning", "Tutu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Collection");
        values.put("meaning", "Iwọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "College");
        values.put("meaning", "Kọ́lẹ̀jì");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Color");
        values.put("meaning", "Àwọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Come");
        values.put("meaning", "Wa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Commercial");
        values.put("meaning", "Iṣẹ́ ọjà");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Common");
        values.put("meaning", "Àwọn gbogbo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Community");
        values.put("meaning", "Agbegbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Company");
        values.put("meaning", "Ile-owo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Compare");
        values.put("meaning", "Ṣe àwọn àyẹ̀wò pọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Computer");
        values.put("meaning", "Kọmputa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Concern");
        values.put("meaning", "Iṣoro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Condition");
        values.put("meaning", "Ipo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Consider");
        values.put("meaning", "ronu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Construction");
        values.put("meaning", "ila");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Consultant");
        values.put("meaning", "agba oye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Consume");
        values.put("meaning", "je");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Consumer");
        values.put("meaning", "olumulo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Consumption");
        values.put("meaning", "lilo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Contact");
        values.put("meaning", "aso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Contain");
        values.put("meaning", "mu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Container");
        values.put("meaning", "apo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Continue");
        values.put("meaning", "tẹsiwaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Control");
        values.put("meaning", "ṣakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Congress");
        values.put("meaning", "igbimọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Cost");
        values.put("meaning", "iye owo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Could");
        values.put("meaning", "le");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Country");
        values.put("meaning", "orilẹ-ede");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Couple");
        values.put("meaning", "tọkọtaya");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Course");
        values.put("meaning", "ẹkọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Court");
        values.put("meaning", "ẹjọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Crime");
        values.put("meaning", "ẹ̀sẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Cultural");
        values.put("meaning", "ẹ̀tọ́ ẹ̀dá");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Culture");
        values.put("meaning", "ẹ̀dá");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Cup");
        values.put("meaning", "ife");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Current");
        values.put("meaning", "igbalode");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Customer");
        values.put("meaning", "onílé ìṣowo");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Cut");
        values.put("meaning", "ge");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Chair");
        values.put("meaning", "aye");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Challenge");
        values.put("meaning", "ija");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Chance");
        values.put("meaning", "anfani");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Change");
        values.put("meaning", "iyipada");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Character");
        values.put("meaning", "iwa");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Charge");
        values.put("meaning", "idanwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Check");
        values.put("meaning", "ṣayẹwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Child");
        values.put("meaning", "ọmọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Choice");
        values.put("meaning", "àyanfẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Choose");
        values.put("meaning", "yan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Church");
        values.put("meaning", "ṣọọṣi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Dead");
        values.put("meaning", "kú");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Deal");
        values.put("meaning", "ṣe adehun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Death");
        values.put("meaning", "iku");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Debate");
        values.put("meaning", "jiroro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Decade");
        values.put("meaning", "egbe ọdun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Decide");
        values.put("meaning", "pinnu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Decision");
        values.put("meaning", "ipinnu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Deep");
        values.put("meaning", "jin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Defend");
        values.put("meaning", "gbowoju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Defendant");
        values.put("meaning", "olujebi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Defense");
        values.put("meaning", "igbowoju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Defensive");
        values.put("meaning", "alagbowoju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Deficit");
        values.put("meaning", "aṣiṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Define");
        values.put("meaning", "ṣe asọye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Definitely");
        values.put("meaning", "laisi aṣiṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Definition");
        values.put("meaning", "asọye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Degree");
        values.put("meaning", "iye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Delay");
        values.put("meaning", "ṣe idaduro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Democracy");
        values.put("meaning", "ìṣàkóso ọ̀rọ̀ ọ̀rọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Democrat");
        values.put("meaning", "olóṣàkóso ọ̀rọ̀ ọ̀rọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Democratic");
        values.put("meaning", "nípa ìṣàkóso ọ̀rọ̀ ọ̀rọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Depict");
        values.put("meaning", "ṣe aworan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Describe");
        values.put("meaning", "ṣe alaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Description");
        values.put("meaning", "alaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Design");
        values.put("meaning", "ṣe àkọṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Despite");
        values.put("meaning", "laisi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Detail");
        values.put("meaning", "ìfọ̀rọ̀ ọ̀rọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Determine");
        values.put("meaning", "pinnu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Develop");
        values.put("meaning", "ṣe idagbasoke");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Development");
        values.put("meaning", "idagbasoke");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Device");
        values.put("meaning", "ohun elo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Devote");
        values.put("meaning", "fi gbogbo ọkàn sí");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Die");
        values.put("meaning", "kú");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Difference");
        values.put("meaning", "iyato");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Die");
        values.put("meaning", "kú");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Difference");
        values.put("meaning", "iyato");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Different");
        values.put("meaning", "yatọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Difficult");
        values.put("meaning", "lele");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Dinner");
        values.put("meaning", "ọ̀rọ̀ alẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Direction");
        values.put("meaning", "itọsọna");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Director");
        values.put("meaning", "oludari");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Discover");
        values.put("meaning", "ṣe awari");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Discuss");
        values.put("meaning", "sọrọ̀ tọ̀pọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Discussion");
        values.put("meaning", "ọ̀rọ̀ sọrọ̀ tọ̀pọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Disease");
        values.put("meaning", "àrun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Do");
        values.put("meaning", "ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Doctor");
        values.put("meaning", "oníṣẹ́ iwosan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Dog");
        values.put("meaning", "ajá");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Door");
        values.put("meaning", "ọ̀rọ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Down");
        values.put("meaning", "isalẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Draw");
        values.put("meaning", "ṣe aworan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Dream");
        values.put("meaning", "òrírí");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Drive");
        values.put("meaning", "ṣe awakọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Drop");
        values.put("meaning", "ṣubu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Drug");
        values.put("meaning", "oògùn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "During");
        values.put("meaning", "lakoko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Early");
        values.put("meaning", "ìbẹ̀rẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Easy");
        values.put("meaning", "rọrọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Eat");
        values.put("meaning", "jẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Economic");
        values.put("meaning", "ọ̀rọ̀-aje");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Economy");
        values.put("meaning", "aje");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Edge");
        values.put("meaning", "eti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Education");
        values.put("meaning", "ẹ̀kọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Effect");
        values.put("meaning", "ipa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Effort");
        values.put("meaning", "ìsẹ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Either");
        values.put("meaning", "eyi tàbí eyikejì");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Election");
        values.put("meaning", "ìdibo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Employee");
        values.put("meaning", "oṣiṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "End");
        values.put("meaning", "pari");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Energy");
        values.put("meaning", "agbara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Enjoy");
        values.put("meaning", "gbadun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Enough");
        values.put("meaning", "to");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Enter");
        values.put("meaning", "wọle");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Entire");
        values.put("meaning", "gbogbo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Environment");
        values.put("meaning", "ayika");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Environmental");
        values.put("meaning", "ti ayika");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Episode");
        values.put("meaning", "iṣẹlẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Equal");
        values.put("meaning", "deede");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Especially");
        values.put("meaning", "paapaa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Establish");
        values.put("meaning", "daduro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Even");
        values.put("meaning", "paapaa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Evening");
        values.put("meaning", "aṣalẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Event");
        values.put("meaning", "iṣẹlẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Everybody");
        values.put("meaning", "gbogbo eniyan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Everyone");
        values.put("meaning", "gbogbo eniyan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Everything");
        values.put("meaning", "gbogbo nkan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Evidence");
        values.put("meaning", "ẹri");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Exactly");
        values.put("meaning", "pato");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Example");
        values.put("meaning", "apẹẹrẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Executive");
        values.put("meaning", "oṣiṣẹ agba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Exist");
        values.put("meaning", "wa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Expect");
        values.put("meaning", "ro pe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Experience");
        values.put("meaning", "iriri");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Expert");
        values.put("meaning", "oludari");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Explain");
        values.put("meaning", "salaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Eye");
        values.put("meaning", "oju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Face");
        values.put("meaning", "ọju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fact");
        values.put("meaning", "otitọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Factor");
        values.put("meaning", "aṣoju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fail");
        values.put("meaning", "kọsile");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fall");
        values.put("meaning", "ṣubu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Family");
        values.put("meaning", "ebi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Far");
        values.put("meaning", "jinna");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fast");
        values.put("meaning", "yara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Father");
        values.put("meaning", "baba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fear");
        values.put("meaning", "ẹru");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Federal");
        values.put("meaning", "apapo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Feel");
        values.put("meaning", "ri");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Feeling");
        values.put("meaning", "igbadun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Few");
        values.put("meaning", "diẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Field");
        values.put("meaning", "aaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fight");
        values.put("meaning", "jagun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Final");
        values.put("meaning", "ikẹhin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Finally");
        values.put("meaning", "nipari");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Financial");
        values.put("meaning", "owo-owo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Find");
        values.put("meaning", "ri");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Finish");
        values.put("meaning", "pari");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Finger");
        values.put("meaning", "ika");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fire");
        values.put("meaning", "ina");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Firm");
        values.put("meaning", "ti o ṣọra");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "First");
        values.put("meaning", "akọkọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fish");
        values.put("meaning", "eja");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Five");
        values.put("meaning", "marun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Floor");
        values.put("meaning", "ilẹ̀ẹ̀ka");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fly");
        values.put("meaning", "fò");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Focus");
        values.put("meaning", "ṣe akiyesi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Follow");
        values.put("meaning", "tẹle");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Food");
        values.put("meaning", "ounjẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Foot");
        values.put("meaning", "ẹsẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "For");
        values.put("meaning", "fún");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Force");
        values.put("meaning", "agbara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Foreign");
        values.put("meaning", "ajeji");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Forget");
        values.put("meaning", "gbàgbẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Form");
        values.put("meaning", "ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Former");
        values.put("meaning", "tẹlẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Forward");
        values.put("meaning", "siwaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Free");
        values.put("meaning", "ọfẹ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Friend");
        values.put("meaning", "ọrẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "From");
        values.put("meaning", "lati");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Front");
        values.put("meaning", "iwaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Fund");
        values.put("meaning", "owo-inu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Future");
        values.put("meaning", "ọjọ́ iwaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Game");
        values.put("meaning", "ere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Garden");
        values.put("meaning", "ọ̀gbà");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Gas");
        values.put("meaning", "epo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "General");
        values.put("meaning", "gbogbogbo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Generation");
        values.put("meaning", "ẹyọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Get");
        values.put("meaning", "gba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Glass");
        values.put("meaning", "gilasi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Go");
        values.put("meaning", "lo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Goal");
        values.put("meaning", "ibi ti o fẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Good");
        values.put("meaning", "dara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Government");
        values.put("meaning", "ìjọba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Great");
        values.put("meaning", "nla");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Green");
        values.put("meaning", "ewé ewura");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Group");
        values.put("meaning", "ẹgbẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Grow");
        values.put("meaning", "dagba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Growth");
        values.put("meaning", "ìdàgbà");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Guess");
        values.put("meaning", "ṣe ìyẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Gun");
        values.put("meaning", "ibon");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Guy");
        values.put("meaning", "ọ̀kunrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Girl");
        values.put("meaning", "obirin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Give");
        values.put("meaning", "fún");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Attack");
        values.put("meaning", "tà ti ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hair");
        values.put("meaning", "irun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Half");
        values.put("meaning", "idaji");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hand");
        values.put("meaning", "ọwọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hang");
        values.put("meaning", "gbé");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Happen");
        values.put("meaning", "ṣẹlẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Happy");
        values.put("meaning", "dún");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hard");
        values.put("meaning", "líle");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Have");
        values.put("meaning", "ní");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "He");
        values.put("meaning", "o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Head");
        values.put("meaning", "ori");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Health");
        values.put("meaning", "ìlera");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hear");
        values.put("meaning", "gbọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Heart");
        values.put("meaning", "ọkàn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Heat");
        values.put("meaning", "gbona");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Heavy");
        values.put("meaning", "eru");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Help");
        values.put("meaning", "iranlowo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Her");
        values.put("meaning", "o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Here");
        values.put("meaning", "nibi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Herself");
        values.put("meaning", "ara ara o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "High");
        values.put("meaning", "ga");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Him");
        values.put("meaning", "o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Himself");
        values.put("meaning", "ara ara o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "His");
        values.put("meaning", "rẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "History");
        values.put("meaning", "itan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hit");
        values.put("meaning", "lu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hold");
        values.put("meaning", "mu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Home");
        values.put("meaning", "ile");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hope");
        values.put("meaning", "ireti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hospital");
        values.put("meaning", "ile iwosan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hot");
        values.put("meaning", "gbona");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hotel");
        values.put("meaning", "hotẹẹli");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hour");
        values.put("meaning", "waƙati");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "House");
        values.put("meaning", "ile");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "How");
        values.put("meaning", "bi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "However");
        values.put("meaning", "sibẹsibẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Huge");
        values.put("meaning", "tobi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Human");
        values.put("meaning", "eniyan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Hundred");
        values.put("meaning", "ọgọrun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Husband");
        values.put("meaning", "ọkọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Idea");
        values.put("meaning", "ero");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Identify");
        values.put("meaning", "mọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Image");
        values.put("meaning", "aworan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Imagine");
        values.put("meaning", "foju inu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Impact");
        values.put("meaning", "ikolu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Important");
        values.put("meaning", "pataki");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Improve");
        values.put("meaning", "se dara si");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Include");
        values.put("meaning", "fi sinu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Including");
        values.put("meaning", "pẹlu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Increase");
        values.put("meaning", "pọ si");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Indeed");
        values.put("meaning", "nitõtọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Indicate");
        values.put("meaning", "fihan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Individual");
        values.put("meaning", "ọmọ eniyan ọkan-ọkan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Industry");
        values.put("meaning", "ẹka iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Information");
        values.put("meaning", "alaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Inside");
        values.put("meaning", "inu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Instead");
        values.put("meaning", "dipo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Institution");
        values.put("meaning", "ile-iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Interest");
        values.put("meaning", "ifẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Interesting");
        values.put("meaning", "ti o nifẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "International");
        values.put("meaning", "agbaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Interview");
        values.put("meaning", "ibewo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Into");
        values.put("meaning", "sinu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Introduce");
        values.put("meaning", "ṣe afihan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Introduction");
        values.put("meaning", "ifihan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Investment");
        values.put("meaning", "iṣowo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Involve");
        values.put("meaning", "kọpa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Issue");
        values.put("meaning", "ọrọ");
        db.insert("words", null, values);


        values.clear();
        values.put("word", "Item");
        values.put("meaning", "ohun elo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "It");
        values.put("meaning", "o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Its");
        values.put("meaning", "ti o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Itself");
        values.put("meaning", "ara rẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Job");
        values.put("meaning", "iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Join");
        values.put("meaning", "dapọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Just");
        values.put("meaning", "o kan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Japan");
        values.put("meaning", "Japan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Jeep");
        values.put("meaning", "jeepu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Jelly");
        values.put("meaning", "jeli");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Jet");
        values.put("meaning", "jeti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Jigsaw");
        values.put("meaning", "iṣọriga");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Jingle");
        values.put("meaning", "orin igbadun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Attack");
        values.put("meaning", "Ta ti ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Journey");
        values.put("meaning", "irin ajo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Joy");
        values.put("meaning", "idunnu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Judge");
        values.put("meaning", "agbejọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Juice");
        values.put("meaning", "juisi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Jumble");
        values.put("meaning", "idẹgbẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Jump");
        values.put("meaning", "ṣe igbiyanju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Jungle");
        values.put("meaning", "igbo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Junior");
        values.put("meaning", "ọmọde kékeré");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Keep");
        values.put("meaning", "pa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Key");
        values.put("meaning", "bọtini");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kid");
        values.put("meaning", "ọmọde");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kill");
        values.put("meaning", "pa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kind");
        values.put("meaning", "ọrọ inu rere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kitchen");
        values.put("meaning", "ibi ti a nṣe ounje");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Know");
        values.put("meaning", "mọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Knowledge");
        values.put("meaning", "imo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "King");
        values.put("meaning", "oba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kiss");
        values.put("meaning", "fi ẹnu mu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kick");
        values.put("meaning", "tẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Keyboard");
        values.put("meaning", "bọtini kọmputa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Knot");
        values.put("meaning", "títakùn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Knock");
        values.put("meaning", "kọlù");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kale");
        values.put("meaning", "kẹ́li");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kangaroo");
        values.put("meaning", "kangaroo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kite");
        values.put("meaning", "ẹyẹ oju omi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Knapsack");
        values.put("meaning", "àpò ẹ̀rù");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kinetic");
        values.put("meaning", "ṣiṣẹ̀ nígbà́ tí a nṣiṣẹ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kettle");
        values.put("meaning", "agọ̀n");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Khaki");
        values.put("meaning", "khaki");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kit");
        values.put("meaning", "àpò");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Knight");
        values.put("meaning", "ọkọ ologun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Knead");
        values.put("meaning", "fọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kneel");
        values.put("meaning", "kúnkún");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Knit");
        values.put("meaning", "kọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Knowledgeable");
        values.put("meaning", "ọmọlẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Krypton");
        values.put("meaning", "krypton");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kiosk");
        values.put("meaning", "abule");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Kerchief");
        values.put("meaning", "aso ẹyọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Land");
        values.put("meaning", "ilẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Language");
        values.put("meaning", "ede");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Large");
        values.put("meaning", "tobi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Last");
        values.put("meaning", "ipari");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Late");
        values.put("meaning", "pẹ̀pẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Later");
        values.put("meaning", "leyin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Laugh");
        values.put("meaning", "rẹrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Law");
        values.put("meaning", "ofin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Lawyer");
        values.put("meaning", "agbẹjọro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Lay");
        values.put("meaning", "fi silẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Lead");
        values.put("meaning", "dari");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Leader");
        values.put("meaning", "olori");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Learn");
        values.put("meaning", "kọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Least");
        values.put("meaning", "kekere julọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Leave");
        values.put("meaning", " lọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Left");
        values.put("meaning", "osi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Leg");
        values.put("meaning", "ẹsẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Legal");
        values.put("meaning", "ofin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Less");
        values.put("meaning", "kekere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Let");
        values.put("meaning", "jẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Letter");
        values.put("meaning", "leta");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Level");
        values.put("meaning", "ipele");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Lie");
        values.put("meaning", "sọ asiwere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Life");
        values.put("meaning", "igbesi aye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Light");
        values.put("meaning", "imọlẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Like");
        values.put("meaning", "fẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Likely");
        values.put("meaning", "o ṣeeṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Line");
        values.put("meaning", "ila");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "List");
        values.put("meaning", "atokọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Listen");
        values.put("meaning", "tẹtisi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Little");
        values.put("meaning", "kekere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Live");
        values.put("meaning", "gbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Local");
        values.put("meaning", "agbegbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Long");
        values.put("meaning", "gigun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Look");
        values.put("meaning", "wo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Lose");
        values.put("meaning", "padanu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Loss");
        values.put("meaning", "sonu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Lot");
        values.put("meaning", "pupọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Love");
        values.put("meaning", "ife");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Low");
        values.put("meaning", "kekere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Magazine");
        values.put("meaning", "iwe iroyin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Main");
        values.put("meaning", "akọkọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Maintain");
        values.put("meaning", "ṣe abojuto'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Major");
        values.put("meaning", "pataki'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Majority");
        values.put("meaning", "ọpọ̀ju'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Make");
        values.put("meaning", "ṣe'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Man");
        values.put("meaning", "ọkunrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Manage");
        values.put("meaning", "ṣakoso'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Management");
        values.put("meaning", "isakoso'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Manager");
        values.put("meaning", "oṣiṣẹ́ isakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Attack");
        values.put("meaning", "Ta ti ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Magazine");
        values.put("meaning", "iwe iroyin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Main");
        values.put("meaning", "akọkọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Maintain");
        values.put("meaning", "ṣe abojuto");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Major");
        values.put("meaning", "pataki");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Majority");
        values.put("meaning", "ọpọ̀ju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Make");
        values.put("meaning", "ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Man");
        values.put("meaning", "ọkunrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Manage");
        values.put("meaning", "ṣakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Management");
        values.put("meaning", "isakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Manager");
        values.put("meaning", "oṣiṣẹ́ isakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Many");
        values.put("meaning", "pupọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Market");
        values.put("meaning", "ọja");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Marriage");
        values.put("meaning", "igbeyawo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Material");
        values.put("meaning", "ohun elo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Matter");
        values.put("meaning", "ọrọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "May");
        values.put("meaning", "le");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Maybe");
        values.put("meaning", "o le ṣee");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Me");
        values.put("meaning", "mi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Mean");
        values.put("meaning", "túmọ si");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Measure");
        values.put("meaning", "iwọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Media");
        values.put("meaning", "awọn igbeewo'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Medical");
        values.put("meaning", "iṣẹ́ ilera'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Meet");
        values.put("meaning", "pade'");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Meeting");
        values.put("meaning", "ipade'");
        db.insert("words",null, values);

        values.clear();
        values.put("word", "Member");
        values.put("meaning", "ọmọ ẹgbẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Memory");
        values.put("meaning", "iranti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Message");
        values.put("meaning", "ifiranṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Method");
        values.put("meaning", "ọna");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Middle");
        values.put("meaning", "arin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Might");
        values.put("meaning", "agbara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Military");
        values.put("meaning", "ọmọ ogun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Million");
        values.put("meaning", "miliọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Mind");
        values.put("meaning", "okan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Minute");
        values.put("meaning", "iṣẹju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Miss");
        values.put("meaning", "padanu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Mission");
        values.put("meaning", "iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Model");
        values.put("meaning", "awoṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Modern");
        values.put("meaning", "ode oni");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Moment");
        values.put("meaning", "akoko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Money");
        values.put("meaning", "owo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Month");
        values.put("meaning", "oṣu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "More");
        values.put("meaning", "siwaju sii");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Morning");
        values.put("meaning", "owurọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Most");
        values.put("meaning", "gbogbo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Mother");
        values.put("meaning", "iya");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Mouth");
        values.put("meaning", "ẹnu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Move");
        values.put("meaning", "gbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Movement");
        values.put("meaning", "iṣesi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Movie");
        values.put("meaning", "fiimu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Mr");
        values.put("meaning", "Ọga");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Mrs");
        values.put("meaning", "Iyaafin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Much");
        values.put("meaning", "pupọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Music");
        values.put("meaning", "orin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Must");
        values.put("meaning", "gbọdọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "My");
        values.put("meaning", "mi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Myself");
        values.put("meaning", "ara mi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Name");
        values.put("meaning", "oruko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Nation");
        values.put("meaning", "orilẹ-ede");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "National");
        values.put("meaning", "ti orilẹ-ede");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Natural");
        values.put("meaning", "ti ọ̀run");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Nature");
        values.put("meaning", "ọ̀run");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Near");
        values.put("meaning", "nitosi");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Nearly");
        values.put("meaning", "fẹ̀ẹ̀");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Necessary");
        values.put("meaning", "pataki");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Need");
        values.put("meaning", "nilo");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Network");
        values.put("meaning", "nẹtiwọki");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Never");
        values.put("meaning", "ko, rara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "New");
        values.put("meaning", "tuntun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "News");
        values.put("meaning", "iroyin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Newspaper");
        values.put("meaning", "iwe iroyin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Next");
        values.put("meaning", "tẹle");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Nice");
        values.put("meaning", "dun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Night");
        values.put("meaning", "alẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "No");
        values.put("meaning", "kò");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "None");
        values.put("meaning", "kò si eyikeyi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Nor");
        values.put("meaning", "tabi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "North");
        values.put("meaning", "ariwa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Not");
        values.put("meaning", "kò");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Note");
        values.put("meaning", "akiyesi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Notice");
        values.put("meaning", "ṣe akiyesi");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Nothing");
        values.put("meaning", "kò si nkankan");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Now");
        values.put("meaning", "bayii");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Number");
        values.put("meaning", "nọmba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Occur");
        values.put("meaning", "waye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Of");
        values.put("meaning", "ti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Off");
        values.put("meaning", "kuro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Offer");
        values.put("meaning", "pese");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Office");
        values.put("meaning", "ọfiisi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Officer");
        values.put("meaning", "oluṣe");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Official");
        values.put("meaning", "osise");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Often");
        values.put("meaning", "nigbagbogbo");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Oh");
        values.put("meaning", "oh!");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Oil");
        values.put("meaning", "epo");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Ok");
        values.put("meaning", "daradara");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Old");
        values.put("meaning", "atijọ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "On");
        values.put("meaning", "lori");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Once");
        values.put("meaning", "lekan");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "One");
        values.put("meaning", "kan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Only");
        values.put("meaning", "nikan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Onto");
        values.put("meaning", "si lori");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Open");
        values.put("meaning", "ṣiṣi");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Operation");
        values.put("meaning", "iṣẹ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Opportunity");
        values.put("meaning", "aye");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Option");
        values.put("meaning", "aṣayan");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Order");
        values.put("meaning", "aṣẹ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Organization");
        values.put("meaning", "aṣọpọ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Other");
        values.put("meaning", "miiran");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Outside");
        values.put("meaning", "sọdi");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Over");
        values.put("meaning", "lori");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Own");
        values.put("meaning", "ara");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Owner");
        values.put("meaning", "oluṣakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Page");
        values.put("meaning", "iwe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Pain");
        values.put("meaning", "ipalara");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Painting");
        values.put("meaning", "aworan");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Paper");
        values.put("meaning", "iwe");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Parent");
        values.put("meaning", "obi");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Part");
        values.put("meaning", "apakan");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Participant");
        values.put("meaning", "olupadi");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Particular");
        values.put("meaning", "pataki");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Particularly");
        values.put("meaning", "paapaa");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Partner");
        values.put("meaning", "aladani");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Party");
        values.put("meaning", "egbe");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Pass");
        values.put("meaning", "kọja");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Past");
        values.put("meaning", "sẹhin");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Patient");
        values.put("meaning", "alaisan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Pattern");
        values.put("meaning", "apẹẹrẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Pay");
        values.put("meaning", "sanwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Peace");
        values.put("meaning", "alafia");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "People");
        values.put("meaning", "eniyan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Per");
        values.put("meaning", "fun ọkọọkan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Perform");
        values.put("meaning", "ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Performance");
        values.put("meaning", "iṣẹ ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Perhaps");
        values.put("meaning", "boya");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Period");
        values.put("meaning", "akoko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Person");
        values.put("meaning", "eniyan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Personal");
        values.put("meaning", "ti ara ẹni");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Pick");
        values.put("meaning", "yan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Picture");
        values.put("meaning", "aworan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Piece");
        values.put("meaning", "apakan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Place");
        values.put("meaning", "ibi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Plan");
        values.put("meaning", "ètò");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Plant");
        values.put("meaning", "igi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Play");
        values.put("meaning", "ṣere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Player");
        values.put("meaning", "oluṣere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Point");
        values.put("meaning", "ojuami");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Police");
        values.put("meaning", "ọlọpa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Policy");
        values.put("meaning", "eto");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Political");
        values.put("meaning", "ti ṣe ede ijọba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Politics");
        values.put("meaning", "ede ijọba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Poor");
        values.put("meaning", "alaini");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Popular");
        values.put("meaning", "olokiki");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Population");
        values.put("meaning", "olugbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Position");
        values.put("meaning", "ipo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Positive");
        values.put("meaning", "rere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Possible");
        values.put("meaning", "ṣeeṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Power");
        values.put("meaning", "agbara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Practice");
        values.put("meaning", "iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Prepare");
        values.put("meaning", "pese");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Present");
        values.put("meaning", "fihan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "President");
        values.put("meaning", "oluṣiwaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Pressure");
        values.put("meaning", "titẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Pretty");
        values.put("meaning", "lẹwa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Prevent");
        values.put("meaning", "dẹkun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Price");
        values.put("meaning", "iye owo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Private");
        values.put("meaning", "aṣiri");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Probably");
        values.put("meaning", "ṣeeṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Problem");
        values.put("meaning", "iṣoro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Process");
        values.put("meaning", "ilana");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Produce");
        values.put("meaning", "ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Product");
        values.put("meaning", "ọja");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Production");
        values.put("meaning", "iṣelọpọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Professional");
        values.put("meaning", "ọjọgbọn");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Professor");
        values.put("meaning", "olukowe");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Program");
        values.put("meaning", "eto");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Project");
        values.put("meaning", "iṣẹ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Property");
        values.put("meaning", "ohun-ini");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Protect");
        values.put("meaning", "dabobo");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Prove");
        values.put("meaning", "ṣe afihan");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Provide");
        values.put("meaning", "pese");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Public");
        values.put("meaning", "gbogbogbo");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Pull");
        values.put("meaning", "fa");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Purpose");
        values.put("meaning", "idi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quality");
        values.put("meaning", "didara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Question");
        values.put("meaning", "ibeere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quickly");
        values.put("meaning", "yara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quite");
        values.put("meaning", "pupọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quick");
        values.put("meaning", "yara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Queen");
        values.put("meaning", "ọbabinrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quarter");
        values.put("meaning", "idaji");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quote");
        values.put("meaning", "asọtẹlẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quiet");
        values.put("meaning", "alafia");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quit");
        values.put("meaning", "da duro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quiz");
        values.put("meaning", "iṣe idanwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quaint");
        values.put("meaning", "lẹwa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quack");
        values.put("meaning", "ẹyọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quad");
        values.put("meaning", "kọta");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quarry");
        values.put("meaning", "ọdẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quake");
        values.put("meaning", "gbigbọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quaver");
        values.put("meaning", "ẹrẹrẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quench");
        values.put("meaning", "tutu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quintet");
        values.put("meaning", "marun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quotient");
        values.put("meaning", "aṣayan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Quibble");
        values.put("meaning", "ṣe iyaniyan");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Quiche");
        values.put("meaning", "ẹfọ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Quid");
        values.put("meaning", "owo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Race");
        values.put("meaning", "ìṣapáta");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Radio");
        values.put("meaning", "redio");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Raise");
        values.put("meaning", "gbe soke");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Range");
        values.put("meaning", "iwọn");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Rate");
        values.put("meaning", "iye");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Rather");
        values.put("meaning", "dara ju lọ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Reach");
        values.put("meaning", "de");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Read");
        values.put("meaning", "ka");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Ready");
        values.put("meaning", "ṣetẹyẹ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Real");
        values.put("meaning", "otitọ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Reality");
        values.put("meaning", "ọtọọlẹ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Realize");
        values.put("meaning", "mọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Really");
        values.put("meaning", "dajudaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Reason");
        values.put("meaning", "idi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Receive");
        values.put("meaning", "gba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Recent");
        values.put("meaning", "tuntun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Recently");
        values.put("meaning", "laipe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Recognize");
        values.put("meaning", "mọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Record");
        values.put("meaning", "ṣakoso");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Red");
        values.put("meaning", "pupa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Reduce");
        values.put("meaning", "dinku");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Reflect");
        values.put("meaning", "fiyesile");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Region");
        values.put("meaning", "agbegbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Relate");
        values.put("meaning", "so ohun kan si ohun kan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Relationship");
        values.put("meaning", "ṣe aṣọkan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Religious");
        values.put("meaning", "ti ẹsin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Remain");
        values.put("meaning", "duro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Remember");
        values.put("meaning", "ranti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Remove");
        values.put("meaning", "yọ kuro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Report");
        values.put("meaning", "ṣe alaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Represent");
        values.put("meaning", "ṣe aṣọkan fun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Republican");
        values.put("meaning", "Republikani");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Require");
        values.put("meaning", "beere fun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Research");
        values.put("meaning", "ṣe iwadi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Resource");
        values.put("meaning", "aṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Respond");
        values.put("meaning", "dahun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Response");
        values.put("meaning", "idahun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Responsibility");
        values.put("meaning", "ojọba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Rest");
        values.put("meaning", "isinmi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Result");
        values.put("meaning", "abajade");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Return");
        values.put("meaning", "pada");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Reveal");
        values.put("meaning", "fi han");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Rich");
        values.put("meaning", "ọlọrọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Right");
        values.put("meaning", "ọtun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Rise");
        values.put("meaning", "dide");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Risk");
        values.put("meaning", "ewu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Road");
        values.put("meaning", "ọnà");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Rock");
        values.put("meaning", "okuta");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Role");
        values.put("meaning", "ipa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Room");
        values.put("meaning", "yara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Rule");
        values.put("meaning", "ofin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Safe");
        values.put("meaning", "ailewu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Same");
        values.put("meaning", "kanna");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Save");
        values.put("meaning", "gba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Say");
        values.put("meaning", "wi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Scene");
        values.put("meaning", "iyẹwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Science");
        values.put("meaning", "ẹ̀kọ́ imọ-jinlẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Scientist");
        values.put("meaning", "oluwadi imọ-jinlẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Score");
        values.put("meaning", "iye idanwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "School");
        values.put("meaning", "ile-iwe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sea");
        values.put("meaning", "omi okun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Season");
        values.put("meaning", "akoko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Seat");
        values.put("meaning", "ijoko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Second");
        values.put("meaning", "keji");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Section");
        values.put("meaning", "apakan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Security");
        values.put("meaning", "aabo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "See");
        values.put("meaning", "ri");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Seek");
        values.put("meaning", "wa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Seem");
        values.put("meaning", "dabi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Scientist");
        values.put("meaning", "oluwadi imọ-jinlẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Score");
        values.put("meaning", "iye idanwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "School");
        values.put("meaning", "ile-iwe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sea");
        values.put("meaning", "omi okun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Season");
        values.put("meaning", "akoko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Seat");
        values.put("meaning", "ijoko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Second");
        values.put("meaning", "keji");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Section");
        values.put("meaning", "apakan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Security");
        values.put("meaning", "aabo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "See");
        values.put("meaning", "ri");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Seek");
        values.put("meaning", "wa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Seem");
        values.put("meaning", "dabi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sell");
        values.put("meaning", "ta");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Send");
        values.put("meaning", "ranṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Senior");
        values.put("meaning", "agba");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sense");
        values.put("meaning", "oye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Series");
        values.put("meaning", "jara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Serious");
        values.put("meaning", "tobi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Serve");
        values.put("meaning", "sin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Service");
        values.put("meaning", "iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Set");
        values.put("meaning", "ṣeto");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Seven");
        values.put("meaning", "meje");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Several");
        values.put("meaning", "pupọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Shake");
        values.put("meaning", "Gbigbọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Share");
        values.put("meaning", "Pin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "She");
        values.put("meaning", "O");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Shoot");
        values.put("meaning", "Tọpa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Short");
        values.put("meaning", "Kùtù");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Shot");
        values.put("meaning", "Tọpa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Should");
        values.put("meaning", "Lẹẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Shoulder");
        values.put("meaning", "Efuufu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Show");
        values.put("meaning", "Fi han");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Side");
        values.put("meaning", "Apa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sign");
        values.put("meaning", "Aami");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Significant");
        values.put("meaning", "Pataki");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Similar");
        values.put("meaning", "Ba kanna");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Simple");
        values.put("meaning", "Simpẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Simply");
        values.put("meaning", "Lẹẹkanṣo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Since");
        values.put("meaning", "Lẹyin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sing");
        values.put("meaning", "Kọrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Single");
        values.put("meaning", "Kọọkan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sister");
        values.put("meaning", "Aburo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sit");
        values.put("meaning", "Joko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Site");
        values.put("meaning", "Ibi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Situation");
        values.put("meaning", "Ipo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Size");
        values.put("meaning", "Iwọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Skill");
        values.put("meaning", "Ọgbọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Skin");
        values.put("meaning", "Ẹ̀yọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Small");
        values.put("meaning", "Kùrù");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Smile");
        values.put("meaning", "Irinrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Social");
        values.put("meaning", "Awọn eniyan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Society");
        values.put("meaning", "Agbegbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Soldier");
        values.put("meaning", "Oṣogun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sometimes");
        values.put("meaning", "Lẹẹẹkanṣo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Something");
        values.put("meaning", "Nkan kan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Son");
        values.put("meaning", "Ọmọkunrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sound");
        values.put("meaning", "Ohun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Source");
        values.put("meaning", "Orisun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "South");
        values.put("meaning", "Guusu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Southern");
        values.put("meaning", "Guusu ila-oorun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Space");
        values.put("meaning", "Aaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Speak");
        values.put("meaning", "Sọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Special");
        values.put("meaning", "Patakì");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Specific");
        values.put("meaning", "Ṣe pataki");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Speech");
        values.put("meaning", "Ọrọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Spend");
        values.put("meaning", "Lo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sport");
        values.put("meaning", "Ere idaraya");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Spring");
        values.put("meaning", "Ọsẹ̀");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Staff");
        values.put("meaning", "Ọjọ́gbọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Stage");
        values.put("meaning", "Ipele");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Stand");
        values.put("meaning", "Jọkò");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Standard");
        values.put("meaning", "Ilana");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Star");
        values.put("meaning", "Irawo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Start");
        values.put("meaning", "Bẹrẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "State");
        values.put("meaning", "Ipinle");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Statement");
        values.put("meaning", "Alaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Station");
        values.put("meaning", "Ile-iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Stay");
        values.put("meaning", "Jọwọ duro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Step");
        values.put("meaning", "Igbesẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Still");
        values.put("meaning", "Siwaju si");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Stock");
        values.put("meaning", "Iṣura");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Stop");
        values.put("meaning", "Duro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Store");
        values.put("meaning", "Ile itaja");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Story");
        values.put("meaning", "Akọsọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Student");
        values.put("meaning", "Akeko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Study");
        values.put("meaning", "Iwadi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Stuff");
        values.put("meaning", "Ohun elo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Style");
        values.put("meaning", "Iṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Strategy");
        values.put("meaning", "Ìṣe aṣa");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Street");
        values.put("meaning", "Ita");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Strong");
        values.put("meaning", "Gbogbo");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Structure");
        values.put("meaning", "Ilana");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Subject");
        values.put("meaning", "Aṣayan");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Success");
        values.put("meaning", "Aṣeyọri");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Successful");
        values.put("meaning", "Aṣeyọri");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Such");
        values.put("meaning", "Iru bẹẹ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Suddenly");
        values.put("meaning", "Lẹẹkanso");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Suffer");
        values.put("meaning", "Jiya");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Suggest");
        values.put("meaning", "Fúnni imọran");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Summer");
        values.put("meaning", "Oṣu ooru");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Support");
        values.put("meaning", "Atilẹyin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Sure");
        values.put("meaning", "Daada");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Surface");
        values.put("meaning", "Ipara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "System");
        values.put("meaning", "Eto");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Take");
        values.put("meaning", "Mu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Talk");
        values.put("meaning", "So");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Task");
        values.put("meaning", "Iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Tax");
        values.put("meaning", "Isan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Teach");
        values.put("meaning", "Kọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Teacher");
        values.put("meaning", "Olukọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Team");
        values.put("meaning", "Ẹgbẹ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Technology");
        values.put("meaning", "Imọ-ẹrọ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Television");
        values.put("meaning", "Tẹlifisiọnu");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Tell");
        values.put("meaning", "Sọ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Tend");
        values.put("meaning", "Rọ");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Term");
        values.put("meaning", "Ọdun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Test");
        values.put("meaning", "Iṣe idanwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Time");
        values.put("meaning", "Aago");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "To");
        values.put("meaning", "Si");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Today");
        values.put("meaning", "Ojo iwọnle");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Together");
        values.put("meaning", "Papọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Tonight");
        values.put("meaning", "Ojo alale");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Too");
        values.put("meaning", "Ju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Top");
        values.put("meaning", "Oke");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Total");
        values.put("meaning", "gbogbo");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Tough");
        values.put("meaning", "Nira");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Toward");
        values.put("meaning", "Siwaju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Town");
        values.put("meaning", "ìgboro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Turn");
        values.put("meaning", "yipada");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "TV");
        values.put("meaning", "Tẹlifisiọnu");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Twenty");
        values.put("meaning", "ọgọrun meji");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Twice");
        values.put("meaning", "lemeji");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Twin");
        values.put("meaning", "ibeji");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Two");
        values.put("meaning", "meji");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Type");
        values.put("meaning", "Iru");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Typical");
        values.put("meaning", "aṣoju");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Than");
        values.put("meaning", "ju");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Thank");
        values.put("meaning", "ṣeun");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "That");
        values.put("meaning", "pe");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "The");
        values.put("meaning", "awọn");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Their");
        values.put("meaning", "wọn");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Them");
        values.put("meaning", "wọn");
                db.insert("words", null, values);

        values.clear();
        values.put("word", "Themselves");
        values.put("meaning", "ara wọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Then");
        values.put("meaning", "lẹhinna");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Theory");
        values.put("meaning", "ilana");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "There");
        values.put("meaning", "nibẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "These");
        values.put("meaning", "awọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "They");
        values.put("meaning", "wọn");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Think");
        values.put("meaning", "ro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Thing");
        values.put("meaning", "nkan");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Third");
        values.put("meaning", "kẹta");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "This");
        values.put("meaning", "yi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Those");
        values.put("meaning", "awọn naa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Though");
        values.put("meaning", "ṣe o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Thought");
        values.put("meaning", "ero");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Thousand");
        values.put("meaning", "ọgọrun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Threat");
        values.put("meaning", "eewu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Three");
        values.put("meaning", "mẹta");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Through");
        values.put("meaning", "kọja");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Throughout");
        values.put("meaning", "jakejado");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Throw");
        values.put("meaning", "fifọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Thus");
        values.put("meaning", "nitorina");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Trade");
        values.put("meaning", "iṣowo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Traditional");
        values.put("meaning", "aṣa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Training");
        values.put("meaning", "ikẹkọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Travel");
        values.put("meaning", "irin-ajo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Treat");
        values.put("meaning", "tọju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Treatment");
        values.put("meaning", "itọju");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Tree");
        values.put("meaning", "igi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Trial");
        values.put("meaning", "idanwo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Trip");
        values.put("meaning", "ìrìn-ajo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Trouble");
        values.put("meaning", "ìṣòro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Truck");
        values.put("meaning", "ọkọ̀-ẹru");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Truth");
        values.put("meaning", "òtitọ́");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Try");
        values.put("meaning", "gbìyànjú");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Under");
        values.put("meaning", "labẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Understand");
        values.put("meaning", "mọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Unit");
        values.put("meaning", "ẹyuniti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "United");
        values.put("meaning", "apọpọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Universal");
        values.put("meaning", "gbogbo agbaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Universe");
        values.put("meaning", "aye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "University");
        values.put("meaning", "ile-ẹkọ giga");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Unknown");
        values.put("meaning", "aimọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Unless");
        values.put("meaning", "ki");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Unlikely");
        values.put("meaning", "ko ṣee ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Until");
        values.put("meaning", "titi di");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Unusual");
        values.put("meaning", "aṣiwere");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Up");
        values.put("meaning", "soke");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Upon");
        values.put("meaning", "lori");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Use");
        values.put("meaning", "lilo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Usually");
        values.put("meaning", "maa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Umbrella");
        values.put("meaning", "òbò");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Valley");
        values.put("meaning", "àfonífojì");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Valuable");
        values.put("meaning", "iyelori");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Value");
        values.put("meaning", "iye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Variation");
        values.put("meaning", "ayipada");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Variety");
        values.put("meaning", "oniruuru");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Various");
        values.put("meaning", "oniruuru");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Very");
        values.put("meaning", "pupọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Victim");
        values.put("meaning", "oluṣẹbi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "View");
        values.put("meaning", "oju wo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Village");
        values.put("meaning", "abule");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Violence");
        values.put("meaning", "iwa-ipa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Visit");
        values.put("meaning", "ibewo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Voice");
        values.put("meaning", "ohun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Vote");
        values.put("meaning", "idibo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wait");
        values.put("meaning", "duro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Walk");
        values.put("meaning", "rin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wall");
        values.put("meaning", "odi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Want");
        values.put("meaning", "fẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "War");
        values.put("meaning", "ogun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Watch");
        values.put("meaning", "wo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Water");
        values.put("meaning", "omi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Way");
        values.put("meaning", "ọna");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "We");
        values.put("meaning", "awa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wealth");
        values.put("meaning", "ọrọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Weapon");
        values.put("meaning", "ohun-ija");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wear");
        values.put("meaning", "wọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Week");
        values.put("meaning", "ọsẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Weight");
        values.put("meaning", "iwowo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Welcome");
        values.put("meaning", "kaabo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Well");
        values.put("meaning", "daradara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "West");
        values.put("meaning", "apa iwọ-oorun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Western");
        values.put("meaning", "ti iwọ-oorun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wet");
        values.put("meaning", "tutu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "What");
        values.put("meaning", "kini");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Whatever");
        values.put("meaning", "bi o ti ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "When");
        values.put("meaning", "nigbati");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Where");
        values.put("meaning", "ibi ti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Whether");
        values.put("meaning", "boya");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Which");
        values.put("meaning", "eyi ti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "While");
        values.put("meaning", "lakoko");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "White");
        values.put("meaning", "funfun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Who");
        values.put("meaning", "tani");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Whole");
        values.put("meaning", "gbogbo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Whom");
        values.put("meaning", "ẹni ti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Whose");
        values.put("meaning", "ẹni ti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Why");
        values.put("meaning", "eyi ti");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wide");
        values.put("meaning", "tobi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wife");
        values.put("meaning", "aya");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Will");
        values.put("meaning", "yoo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Win");
        values.put("meaning", "ṣẹgun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wind");
        values.put("meaning", "afẹfẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Window");
        values.put("meaning", "iyẹfun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wish");
        values.put("meaning", "ife");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "With");
        values.put("meaning", "pẹlu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Within");
        values.put("meaning", "laarin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Without");
        values.put("meaning", "laisi");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Woman");
        values.put("meaning", "obinrin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wonder");
        values.put("meaning", "iyalẹnu");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Word");
        values.put("meaning", "ọrọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Work");
        values.put("meaning", "iṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Worker");
        values.put("meaning", "oṣiṣẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "World");
        values.put("meaning", "agbaye");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Worry");
        values.put("meaning", "iṣoro");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Would");
        values.put("meaning", "yoo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Write");
        values.put("meaning", "kọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Writer");
        values.put("meaning", "onkọwe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Wrong");
        values.put("meaning", "aṣiṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yard");
        values.put("meaning", "yara");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yeah");
        values.put("meaning", "jee");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Year");
        values.put("meaning", "ọdun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yes");
        values.put("meaning", "ṣe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yet");
        values.put("meaning", "sibẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "You");
        values.put("meaning", "o");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Young");
        values.put("meaning", "ọdọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Your");
        values.put("meaning", "rẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yourself");
        values.put("meaning", "ara rẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yesterday");
        values.put("meaning", "ana");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yellow");
        values.put("meaning", "ofeefee");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Youth");
        values.put("meaning", "ọdọ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yacht");
        values.put("meaning", "ọkọ omi itura");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yoga");
        values.put("meaning", "yoga");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yield");
        values.put("meaning", "fi silẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yawn");
        values.put("meaning", "gbẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yummy");
        values.put("meaning", "dun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yearly");
        values.put("meaning", "ọdun-ọdun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yell");
        values.put("meaning", "kigbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yolk");
        values.put("meaning", "awọ ara eyin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yahoo");
        values.put("meaning", "Yahoo");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yelp");
        values.put("meaning", "yelp");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yonder");
        values.put("meaning", "kọja");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Yule");
        values.put("meaning", "Yule");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zone");
        values.put("meaning", "agbegbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zero");
        values.put("meaning", "ọfẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zoo");
        values.put("meaning", "ọsin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zen");
        values.put("meaning", "Zen");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zest");
        values.put("meaning", "ifun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zebra");
        values.put("meaning", "ẹranko awọ dudu funfun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zigzag");
        values.put("meaning", "zigzag");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zinc");
        values.put("meaning", "zinc");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zany");
        values.put("meaning", "ọdẹ");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zipper");
        values.put("meaning", "fifa");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zoom");
        values.put("meaning", "ṣanra");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zucchini");
        values.put("meaning", "ọgbin irugbin");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zillion");
        values.put("meaning", "ọgọọgọrun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zeus");
        values.put("meaning", "Ọlọrun");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zonal");
        values.put("meaning", "agbegbe");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zygote");
        values.put("meaning", "zygote");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zombie");
        values.put("meaning", "zombie");
        db.insert("words", null, values);

        values.clear();
        values.put("word", "Zenith");
        values.put("meaning", "oke giga");
        db.insert("words", null, values);

        db.close();
    }
}
