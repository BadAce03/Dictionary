package com.example.dictionary;

import android.os.Parcel;
import android.os.Parcelable;

public class Word implements Parcelable {

    private String word;
    private String meaning;

    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    protected Word(Parcel in) {
        word = in.readString();
        meaning = in.readString();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(word);
        dest.writeString(meaning);
    }
}

