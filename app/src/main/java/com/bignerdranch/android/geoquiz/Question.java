package com.bignerdranch.android.geoquiz;

/**
 * Created by Tony on 2/24/2016.
 */
public class Question {

    private int mTextResID;
    private boolean mAnswerTrue;

    public Question(int textResID, boolean answerTrue) {

        mAnswerTrue = answerTrue;
        mTextResID = textResID;
    }

    public void setTextResID(int textResID) {
        mTextResID = textResID;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }


    public int getTextResID() {
        return mTextResID;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }}




