package edu.uchicago.cs.gerber.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//_lstsaa
//code adapted from this post
//http://shenhengbin.wordpress.com/2012/03/17/listview-simpleadapter/
public class SimpleAdapterActivity extends Activity {
	private ListView lsvListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.simpleadapter);
	}
}