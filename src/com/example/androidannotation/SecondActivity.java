package com.example.androidannotation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

@EActivity(R.layout.second_main)
public class SecondActivity extends Activity {
	/**
	 * @Extra ��������Activity֮�䴫ֵ
	 */
	@Extra(MainActivity.NAME_KEY)
	String name;
	
	@Extra(MainActivity.AGE_KEY)
	String age;
	
	@ViewById(R.id.nameView)
	TextView nameView;
	
	@ViewById(R.id.ageView)
	TextView ageView;
	
	@AfterViews
	public void initView() {
		nameView.setText(name);
		ageView.setText(age);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
}
