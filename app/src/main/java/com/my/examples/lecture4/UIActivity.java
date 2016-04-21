/**
 * Copyrigh Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UIActivity extends AppCompatActivity implements View.OnClickListener {

	// The TextView used to display the message inside the Activity.
	private TextView mTextView;

	// The EditText where the user types the message.
	private EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui);

		// Set the listeners for the buttons.
		findViewById(R.id.changeTextBt).setOnClickListener(this);
		findViewById(R.id.activityChangeTextBtn).setOnClickListener(this);

		mTextView = (TextView) findViewById(R.id.textToBeChanged);
		mEditText = (EditText) findViewById(R.id.editTextUserInput);
	}

	@Override
	public void onClick(View view) {
		// Get the text from the EditText view.
		final String text = mEditText.getText().toString();

		switch (view.getId()) {
			case R.id.changeTextBt:
				// First button's interaction: set a text in a text view.
				mTextView.setText(text);
				break;
			case R.id.activityChangeTextBtn:
				// Second button's interaction: start an activity and send a message to it.
				Intent intent = ShowTextActivity.newStartIntent(this, text);
				startActivity(intent);
				break;
		}
	}
}