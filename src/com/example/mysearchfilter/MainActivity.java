package com.example.mysearchfilter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
	EditText txtSearch;
	ListView lv;
	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtSearch = (EditText) this.findViewById(R.id.editText1);
        this.lv = (ListView) this.findViewById(R.id.listView1);
        list.add("abba");
        list.add("abcd");
        list.add("altab");
        list.add("baka");
        list.add("bomba");
        list.add("bala");
        list.add("carlo");
        list.add("carla");
        list.add("calizah");
        list.add("dendi");
        list.add("dondo");
        this.txtSearch.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				String str = arg0.toString();
				Pattern pattern = Pattern.compile(str);
				ArrayList<String> mylist = new ArrayList<String>();
				for(int i = 0;i<list.size();i++){
					Matcher m = pattern.matcher(list.get(i));
					if(m.find()){
						mylist.add(list.get(i));
					}
				}
				adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,mylist);
				lv.setAdapter(adapter);
			}});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
