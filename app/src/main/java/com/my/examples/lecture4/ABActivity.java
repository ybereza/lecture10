/**
 * Copyrigh Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ABActivity extends AppCompatActivity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.settings:
				openSettings();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	void openSettings() {
		Intent i = new Intent(this, SettingsActivity.class);
		startActivity(i);
	}
}
