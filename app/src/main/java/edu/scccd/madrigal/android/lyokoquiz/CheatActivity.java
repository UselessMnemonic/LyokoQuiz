package edu.scccd.madrigal.android.lyokoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER = "edu.scccd.madrigal.android.lyokoquiz.answer";
    public static final String CHEATED = "CHEATED";
    Button mShowAnswerButton;
    TextView mAnswerTextView;
    boolean mAnswer;
    boolean mCheated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mShowAnswerButton = findViewById(R.id.show_answer_button);
        mAnswerTextView = findViewById(R.id.answer_text_view);

        mAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER, false);

        if(savedInstanceState != null)
            cheat();

        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cheat();
            }
        });
    }

    private void cheat()
    {
        mAnswerTextView.setText(Boolean.toString(mAnswer));
        mCheated = true;
    }

    public static Intent newIntent(Context packageContext, boolean answer){
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER, answer);
        return intent;
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(CHEATED, mCheated);
    }
}
