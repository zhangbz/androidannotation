package com.example.androidannotation;

import org.androidannotations.annotations.EService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

@EService
public class MyService extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("MyService", "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
