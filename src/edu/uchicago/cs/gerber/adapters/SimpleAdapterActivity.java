package edu.uchicago.cs.gerber.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

//code adapted from this post
//http://shenhengbin.wordpress.com/2012/03/17/listview-simpleadapter/
public class SimpleAdapterActivity extends Activity {
	private ListView lsvListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.simpleadapter);
		lsvListView = (ListView) findViewById(R.id.list);

		List<? extends Map<String, ?>> data =  getData();
		
		SimpleAdapter adapter = new SimpleAdapter(
				//a context for this simple adapter (usuallly this activity)
				this, 
				//the List<? extends Map<String, ?>> of your data either hard-coded 
				//or assigned from resources
				data, 
				//this is the layout (called item.xml) file that contains the fields you will map to
				R.layout.item,
				//the names of the key fields in your map (see below)
				new String[] { "iconKey", "nameKey", "textKey" },
				//the names of the fields found in above item.xml,  as int[] array (as resource ids)
				new int[] {R.id.userIcon, R.id.username, R.id.usertext });

		lsvListView.setAdapter(adapter);
	}

	//################################################
	// you can put the data in the map programmatically 
	//################################################
	List<? extends Map<String, ?>> getData() {
		List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();

		Map map = new HashMap();
		map.put("iconKey", R.drawable.scorpion);
		map.put("nameKey", "Scorpion");
		map.put("textKey", "Scorpion is a resurrected ninja in the Mortal Kombat fighting game series. He is one of the few original characters, ");
		list.add(map);
		
		map = new HashMap();
		map.put("iconKey", R.drawable.ice);
		map.put("nameKey", "Sub-Zero");
		map.put("textKey", "Sub-Zero is a video game character from the Mortal Kombat series and one of the original characters in the first Mortal Kombat game in 1992.");
		list.add(map);

		return list;
	}
}