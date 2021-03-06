package com.example.android_test_listen_phonecall;

import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.i("Phonecall", "MainActivity start");
		
		Intent intent = new Intent(MainActivity.this,ListencallService.class);
		
		bindService(intent,connection,BIND_AUTO_CREATE);
		Log.i("Phonecall", "bindService");
		
		startService(intent);
		Log.i("Phonecall", "startService");
		
		
//		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//
//		final IntentFilter filter = new IntentFilter();
//		filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
//		final BroadcastReceiver PhoneCallReceiver = new BroadcastReceiver() {
//
//			@Override
//			public void onReceive(final Context context, final Intent intent) {
//				Log.i("Phonecall", "received phonecall");
//				// TODO Auto-generated method stub
//				String action = intent.getAction();
//
//				if (action.equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
//					String phoneNumber = intent
//							.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
//					Log.i("Phonecall", "PhoneNumber " + phoneNumber);
//				}
//				;
//			}
//		};
//
//		registerReceiver(PhoneCallReceiver, filter);
	}
	
	ServiceConnection connection = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			// TODO Auto-generated method stub
			Log.v("MainActivityaa","onServiceConnected");
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			Log.v("MainActivityaa","onServiceDisconnected");
		}
	};
}
