package edu.scccd.madrigal.android.lyokoquiz;

/**
 * Question.java
 * Models a Question for the FizzQuiz app.
 * March 31, 2018
 */

public class Question
{
    private int mQuestionId;
    private int mHintId;
    private boolean mAnswer;

    public Question(int questionTextId, int hintId, boolean answer) {
        mQuestionId = questionTextId;
        mHintId = hintId;
        mAnswer = answer;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int questionId) {
        mQuestionId = questionId;
    }

    public int getHintId() {
        return mHintId;
    }

    public void setHintId(int hintId) {
        mHintId = hintId;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
