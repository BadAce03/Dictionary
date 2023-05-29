package com.example.dictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dictionary.Word;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, List<Word> wordList) {
        super(context, 0, wordList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Word word = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(word.getWord());

        return convertView;
    }
}

