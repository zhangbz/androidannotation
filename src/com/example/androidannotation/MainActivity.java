package com.example.androidannotation;

import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@EActivity(R.layout.activity_main)//����EActivity,��EService���õñȽ���
public class MainActivity extends Activity {
	public static final String NAME_KEY = "name_key";
	public static final String AGE_KEY = "age_key";
	/**
	 * Button�ؼ���ʼ��
	 * ����ָ��id����Ĭ�ϰ�����������
	 */
	@ViewById(R.id.button1)
	Button button;
	
	@ViewById(R.id.button2)
	Button button2;
	
	@ViewById(R.id.textView2)
	TextView textView2;
	
	/**
	 * ��ʼ�����id���ŵ�������
	 */
	@ViewsById({R.id.textView3, R.id.textView4})
	List<TextView> list;
	/**
	 * ΪIDΪbutton1�Ŀؼ���Ӽ����¼�
	 */
	@Click(R.id.button1)
	public void startActivity() {
		Intent intent = new Intent(MainActivity.this, SecondActivity_.class);
		intent.putExtra(NAME_KEY, "name");
		intent.putExtra(AGE_KEY, "18");
		startActivity(intent);
	}
	
	@Click(R.id.button2)
	public void startService() {
		Intent intent = new Intent(MainActivity.this, MyService_.class);
		startService(intent);
	}	
	/**
	 * @Click�÷���
	 * @LongClick�÷�ͬ@Click
	 */
	@Click({R.id.textView3, R.id.textView4})
	public void showToast() {
		Toast.makeText(MainActivity.this, "ok", 1).show();
	}
	/**
	 * ��ʼ��֮������
	 */
	@AfterViews
	public void setTextView() {
		textView2.setText("Hello World");
		for (TextView textView : list) {
			textView.setText("Hello World");
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }
}
