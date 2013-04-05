package edu.uchicago.cs.gerber.adapters;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//################################################
//This example shows how to use ArrayAdapter to populate a ListActivity
//################################################
public class Main extends ListActivity {

	String[] strActs = new String[] { "SpinnersActivity", "CursorAdapterActivity",
			"SimpleAdapterActivity" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayAdapter<String> adpArray = new ArrayAdapter<String>(
				//context
				this,
				//layout of how the items will be displayed
				android.R.layout.simple_list_item_1, 
				//the array of strings that will be displayed. In this case, 
				//the names of the activities
				strActs);

		adpArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		this.setListAdapter(adpArray);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		String strPackage = getApplicationContext().getPackageName();
		Intent itn = null;

		Class cls = null;
		try {
			cls = Class.forName(strPackage + "." + strActs[position]);
			if (cls != null) {
				itn = new Intent(this, cls);
				startActivity(itn);
			}
		} catch (Exception e) {
			Log.e("error", e.getMessage());
		}

	}

}
