package edu.scccd.madrigal.android.lyokoquiz;

/**
 * Question.java
 * Models a Question for the FizzQuiz app.
 * March 31, 2018
 */

public class Question
{
    private int mQuestionId;
    private boolean mAnswer;

    public Question(int questionTextId, boolean answer) {
        mQuestionId = questionTextId;
        mAnswer = answer;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int questionId) {
        mQuestionId = questionId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
