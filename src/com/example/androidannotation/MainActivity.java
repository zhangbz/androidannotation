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

@EActivity(R.layout.activity_main)//多用EActivity,而EService等用得比较少
public class MainActivity extends Activity {
	public static final String NAME_KEY = "name_key";
	public static final String AGE_KEY = "age_key";
	/**
	 * Button控件初始化
	 * 若不指定id，则默认按变量名查找
	 */
	@ViewById(R.id.button1)
	Button button;
	
	@ViewById(R.id.button2)
	Button button2;
	
	@ViewById(R.id.textView2)
	TextView textView2;
	
	/**
	 * 初始化多个id并放到集合中
	 */
	@ViewsById({R.id.textView3, R.id.textView4})
	List<TextView> list;
	/**
	 * 为ID为button1的控件添加监听事件
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
	 * @Click用法二
	 * @LongClick用法同@Click
	 */
	@Click({R.id.textView3, R.id.textView4})
	public void showToast() {
		Toast.makeText(MainActivity.this, "ok", 1).show();
	}
	/**
	 * 初始化之后运行
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
