package edu.scccd.madrigal.android.lyokoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class LyokoQuizActivity extends AppCompatActivity {

	private Button mTrueButton, mFalseButton, mHintButton;
	private ImageButton mNextButton, mPrevButton, mRandomButton;
	private TextView mQuestionTextView;

	private Question[] mQuestionBank = new Question[]{
			new Question(R.string.question_question1, R.string.question_hint1, false),
			new Question(R.string.question_question2, R.string.question_hint2, true),
			new Question(R.string.question_question3, R.string.question_hint3, false),
			new Question(R.string.question_question4, R.string.question_hint4, true),
			new Question(R.string.question_question5, R.string.question_hint5, false),
			new Question(R.string.question_question6, R.string.question_hint6, true)
	};

	private int mCurrentIndex = 0;

	private void updateQuestion() {
		mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getQuestionId());
	}

	private void checkAnswer(boolean answer) {
		if(answer == mQuestionBank[mCurrentIndex].isAnswer())
			Toast.makeText(LyokoQuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(LyokoQuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lyoko_quiz);

		mTrueButton = findViewById(R.id.true_button);
		mFalseButton = findViewById(R.id.false_button);
		mNextButton = findViewById(R.id.next_button);
		mPrevButton = findViewById(R.id.prev_button);
		mQuestionTextView = findViewById(R.id.question_text_view);
		mHintButton = findViewById(R.id.hint_button);
		mRandomButton = findViewById(R.id.random_button);

		updateQuestion();

		mTrueButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				checkAnswer(true);
			}
		});
		mFalseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				checkAnswer(false);
			}
		});
		mNextButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view)
			{
				mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;
				updateQuestion();
			}
		});
		mPrevButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view)
			{
				mCurrentIndex -= 1;
				if(mCurrentIndex < 0)
					mCurrentIndex = mQuestionBank.length - 1;
				updateQuestion();
			}
		});
        mRandomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                int nextIndex = 0;
                do {
                    nextIndex = (new Random().nextInt(mQuestionBank.length));
                }while(nextIndex == mCurrentIndex);

                mCurrentIndex = nextIndex;
                updateQuestion();
            }
        });
        mHintButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(LyokoQuizActivity.this, mQuestionBank[mCurrentIndex].getHintId(), Toast.LENGTH_SHORT).show();
            }
        });
	}
}