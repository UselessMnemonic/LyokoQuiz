package edu.scccd.madrigal.android.lyokoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class LyokoQuizActivity extends AppCompatActivity {

    private static final String TAG = "LyokoQuizActivity";
    private static final String INDEX_KEY = "index";

	private Button mTrueButton, mFalseButton, mHintButton;
	private ImageButton mNextButton, mPrevButton, mRandomButton;
	private TextView mQuestionTextView, mQuestionNumberView;

	private Question[] mQuestionBank = {
			new Question(R.string.question1, R.string.hint1, false),
			new Question(R.string.question2, R.string.hint2, true),
			new Question(R.string.question3, R.string.hint3, false),
			new Question(R.string.question4, R.string.hint4, true),
			new Question(R.string.question5, R.string.hint5, false),
			new Question(R.string.question6, R.string.hint6, true),
			new Question(R.string.question7, R.string.hint7, false),
			new Question(R.string.question8, R.string.hint8, false),
			new Question(R.string.question9, R.string.hint9, true),
			new Question(R.string.question10, R.string.hint10, true),
	};

	private int mCurrentIndex = 0;

	private void updateQuestion() {
		mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getQuestionId());
		mQuestionNumberView.setText((mCurrentIndex+1) + "/" + mQuestionBank.length);
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

		Log.d(TAG, "the sytem just called onCreate(Bundle) and life is good?");

		//grab references to widgets
		mTrueButton = findViewById(R.id.true_button);
		mFalseButton = findViewById(R.id.false_button);
		mNextButton = findViewById(R.id.next_button);
		mPrevButton = findViewById(R.id.prev_button);
		mQuestionTextView = findViewById(R.id.question_text_view);
		mQuestionNumberView = findViewById(R.id.question_number_view);
		mHintButton = findViewById(R.id.hint_button);
		mRandomButton = findViewById(R.id.random_button);

		//retrieve state or start new
		if(savedInstanceState != null)
			mCurrentIndex = savedInstanceState.getInt(INDEX_KEY);
		else
			mCurrentIndex = 0;

		updateQuestion();

		//give widgets their listeners
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
                int nextIndex;
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

	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG,"onStart() called");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d(TAG,"onPause() called");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG,"onResume() called");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d(TAG,"onStop() called");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG,"onDestroy() called");
	}

	@Override
	protected void onSaveInstanceState(Bundle bundle)
	{
		super.onSaveInstanceState(bundle);
		Log.i(TAG, "onSaveInstanceState");
		bundle.putInt(INDEX_KEY, mCurrentIndex);
	}
}