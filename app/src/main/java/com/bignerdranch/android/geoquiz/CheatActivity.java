package com.bignerdranch.android.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

	public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN = "come.bignerdranch.android.geoquiz.answer_shown";
	private boolean mAnswerIsTrue;
	private TextView mAnswerTextView;
	private Button mShowAnswer;

	public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
		Intent i = new Intent(packageContext, CheatActivity.class);
		i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);

		return i;
	}

	public static boolean wasAnswerShown(Intent result){
		return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
	}




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
		mShowAnswer = (Button) findViewById(R.id.show_answer_button);
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mAnswerIsTrue) {
					mAnswerTextView.setText(R.string.true_button);
				} else {
					mAnswerTextView.setText(R.string.false_button);
				}
				setAnswerShownResult(true);
			}
		});
	}

		private void setAnswerShownResult(boolean isAnswerShown){
			Intent data = new Intent();
			data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
			setResult(RESULT_OK, data);
	}
}
