/**
 * 
 */
package com.example.android_test_listen_phonecall;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @author lv.hang
 *
 */
public class ListencallService extends Service{

	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		
		Log.i("ListencallService", "onCreate");
		
		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

		final IntentFilter filter = new IntentFilter();
		filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
		final BroadcastReceiver PhoneCallReceiver = new BroadcastReceiver() {

			@Override
			public void onReceive(final Context context, final Intent intent) {
				Log.i("ListencallService", "received phonecall");
				// TODO Auto-generated method stub
				String action = intent.getAction();

				if (action.equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
					String phoneNumber = intent
							.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
					Log.i("ListencallService", "PhoneNumber " + phoneNumber);
				}
				;
			}
		};

		registerReceiver(PhoneCallReceiver, filter);
	}
	
	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		Log.v("ListencallService", "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onStart(Intent intent,int startId){
		Log.v("ListencallService", "onStart");
		super.onStart(intent, startId);
	}

}
