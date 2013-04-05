package edu.uchicago.cs.gerber.adapters;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


//################################################
//This example shows how to use CursorAdapter to populate ListActivity
//################################################
public class CursorAdapterActivity extends ListActivity   {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//get a cursor from the contacts 
		Cursor cur = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI,null, null, null, null); 
		
		//source fields from the content provider
		String[] strSources = new String[] { ContactsContract.Contacts.DISPLAY_NAME  };
		
		//view ids of the resource (android internal resource) for views to display cols from cursor above
		int[] nTargets = new int[] { android.R.id.text1 };
		

		SimpleCursorAdapter scaAdapter = new SimpleCursorAdapter(
				//the context
				this,
				//the target list item layout that houses the data fields
				android.R.layout.simple_list_item_1, 
				//the cursor
				cur, 
				//the source fields as strings
				strSources, 
				//the target
				nTargets,
				//this is a an optional Flag called FLAG_AUTO_REQUERY which has been deprecated, you can either
				//ignore this param (don't list it at all), or just pass in zero
				//if you were to pass in  FLAG_AUTO_REQUERY, it results in the cursor being requeried on the 
				//UI thread which is a performance hit
				0
				);
		
		
		setListAdapter(scaAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Toast.makeText(this, "you clicked index " + position, Toast.LENGTH_LONG).show();
		
		
	}
	
	
	

}
