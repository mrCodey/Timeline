package com.example.timeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.tools.DataAdapter;
import com.example.tools.DataText;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView mListview;
	private DataAdapter mDataAdapter;
	private ArrayList<DataText> mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListview = (ListView) findViewById(R.id.line_list);
		mList=new ArrayList<DataText>();
		addData();
		SortList(mList);
		mDataAdapter = new DataAdapter(getApplicationContext(), mList);
		mListview.setAdapter(mDataAdapter);
	}

	/*
	 * list添加数据
	 */
	public void addData() {
		DataText dataText1 = new DataText("141600", "asdffasdfasdfasdfas");
		mList.add(dataText1);
		DataText dataText2 = new DataText("141600", "asdffasdfasdfasdfas");
		mList.add(dataText2);
		DataText dataText3 = new DataText("141601", "asdffasdfasdfasdfas");
		mList.add(dataText3);
		DataText dataText4 = new DataText("141602", "asdffasdfasdfasdfas");
		mList.add(dataText4);
		DataText dataText5 = new DataText("141603", "asdffasdfasdfasdfas");
		mList.add(dataText5);
		DataText dataText6 = new DataText("141604", "asdffasdfasdfasdfas");
		mList.add(dataText6);
		DataText dataText7 = new DataText("141605", "asdffasdfasdfasdfas");
		mList.add(dataText7);
		DataText dataText8 = new DataText("141606", "asdffasdfasdfasdfas");
		mList.add(dataText8);
		DataText dataText9 = new DataText("141607", "asdffasdfasdfasdfas");
		mList.add(dataText9);
		DataText dataText10 = new DataText("141607", "asdffasdfasdfasdfas");
		mList.add(dataText10);
	}


	public void SortList(List<DataText> list)
	{
		Comparator<DataText> comparator=new Comparator<DataText>() {
			
			@Override
			public int compare(DataText lhs, DataText rhs) {
				// TODO Auto-generated method stub
				return lhs.getDate().compareTo(rhs.getDate());
			}
		};
		Collections.sort(list, comparator);
	}
	
	
	
	
	
	
	
	
	
	

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 * 
	 * @Override public boolean onOptionsItemSelected(MenuItem item) { // Handle
	 * action bar item clicks here. The action bar will // automatically handle
	 * clicks on the Home/Up button, so long // as you specify a parent activity
	 * in AndroidManifest.xml. int id = item.getItemId(); if (id ==
	 * R.id.action_settings) { return true; } return
	 * super.onOptionsItemSelected(item); }
	 */
}
