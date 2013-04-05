package edu.uchicago.cs.gerber.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

//you will need to define an array like this in your strings.xml file
//<string-array name="sports">
//<item>Archery</item>
//<item>Basketball</item>
//<item>Football</item>
//<item>Hunting</item>
//<item>Kite Surfing</item>
//<item>Running</item>
//<item>Sailing</item>
//<item>Squash</item>
//</string-array>

//you will also need a layout like this:
//<?xml version="1.0" encoding="utf-8"?>
//<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//    android:layout_width="fill_parent"
//    android:layout_height="fill_parent"
//    android:orientation="horizontal" >
//
//    <Spinner
//        android:id="@+id/spnOne"
//        android:layout_width="0dp"
//        android:layout_height="50dp"
//        android:layout_weight="1" />
//
//    <Spinner
//        android:id="@+id/spnTwo"
//        android:layout_width="0dp"
//        android:layout_height="50dp"
//        android:layout_weight="1" />
//
//</LinearLayout>

//################################################
// This example shows how to use ArrayAdapter to populate spinners
//################################################
public class SpinnersActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_spinner);

		// the target view
		Spinner spnOne = (Spinner) findViewById(R.id.spnOne);
		ArrayAdapter<String> adpArray = new ArrayAdapter<String>(
		// the context
				this,
				// the target list item layout (defined in android)
				android.R.layout.simple_list_item_1,
				// the sources (raw array)
				new String[] { "Tokyo", "Guangzhou", "Seoul", "Shanghai",
						"Delhi", "Mumbai", "MexicoCity", "Karachi",
						"NewYorkCity", "SãoPaulo", "Jakarta", "LosAngeles",
						"Osaka", "Kolkata", "Beijing", "Moscow", "Cairo",
						"BuenosAires", "Dhaka", "Tehran" });

		// this is optional for formatting
		// adpArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// apply adapter to target View
		spnOne.setAdapter(adpArray);

		// the target view
		Spinner spnTwo = (Spinner) findViewById(R.id.spnTwo);
		ArrayAdapter<CharSequence> adpArrayFromResource = ArrayAdapter
				.createFromResource(
				// the context
						this,
						// the sources
						R.array.sports,
						// the target list item
						android.R.layout.simple_spinner_item);

		// apply adapter to target view
		spnTwo.setAdapter(adpArrayFromResource);

	}
}