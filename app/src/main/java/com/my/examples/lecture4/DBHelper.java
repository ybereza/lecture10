/**
 * Copyrigh Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vlad on 14/04/16.
 */
public class DBHelper extends SQLiteOpenHelper {

	private static int DB_VERSION = 1;
	private static String DB_NAME = "contacts";
	private Context context;

	private static String DT_NAME = "contacts";
	private static String FN_ID = "id";
	private static String FN_NAME = "full_name";
	private static String FN_PHONE1 = "phone1";
	private static String FN_PHONE2 = "phone2";
	private static String FN_EMAIL = "email";

	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String query = "create table " + DT_NAME + " ("
				+ FN_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ FN_NAME + "  TEXT, "
				+ FN_PHONE1 + "  TEXT, "
				+ FN_PHONE2 + "  TEXT, "
				+ FN_EMAIL + "  TEXT )";
		db.execSQL(query);
		// TODO: Load data from content provider
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO: Drop all tables
		drop();
		onCreate(db);
	}

	public void drop() {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DROP TABLE IF EXISTS `conctacts`");
		db.close();
	}

	public void addContact(AppContact contact) {
		SQLiteDatabase db = getWritableDatabase();
		assert db != null;
		ContentValues v = new ContentValues();
		v.put(FN_NAME, contact.getName());
		v.put(FN_PHONE1, contact.getPhone1());
		v.put(FN_PHONE2, contact.getPhone2());
		v.put(FN_EMAIL, contact.getEmail());
		db.insert(DT_NAME, null, v);
		db.close();
	}

	public AppContact getContactByName(String contactName) {
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query(DT_NAME, null, FN_NAME+"=?", new String[]{contactName}, null, null, null);
		AppContact contact = null;
		if (cursor != null) {
			cursor.moveToFirst();
			String name = cursor.getString(cursor.getColumnIndex(FN_NAME));
			String phone1 = cursor.getString(cursor.getColumnIndex(FN_PHONE1));
			String phone2 = cursor.getString(cursor.getColumnIndex(FN_PHONE2));
			String email = cursor.getString(cursor.getColumnIndex(FN_PHONE2));
			contact = new AppContact(name);
			contact.setEmail(email);
			contact.setPhone1(phone1);
			contact.setPhone2(phone2);
			cursor.close();
			db.close();
		}
		return contact;
	}

	public long getSize() {
		SQLiteDatabase db = getReadableDatabase();
		long cnt = DatabaseUtils.queryNumEntries(db, DT_NAME);
		return cnt;
	}

	public Cursor getAllData() {
		SQLiteDatabase db = getReadableDatabase();
		return db.query(DT_NAME, null, null, null, null, null, null);
	}

	public static class AppContact {
		private String name;
		private String phone1;
		private String phone2;
		private String email;

		public AppContact(String name ) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone1() {
			return phone1;
		}

		public void setPhone1(String phone1) {
			this.phone1 = phone1;
		}

		public String getPhone2() {
			return phone2;
		}

		public void setPhone2(String phone2) {
			this.phone2 = phone2;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}
}
