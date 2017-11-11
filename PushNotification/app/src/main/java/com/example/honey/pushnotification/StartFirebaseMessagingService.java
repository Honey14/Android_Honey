package com.example.honey.pushnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class StartFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("tried well","message received");
        if(remoteMessage!=null && remoteMessage.getNotification()!=null){ //if notification not null show notifcation
            String msg = remoteMessage.getNotification().getBody();

            if(!TextUtils.isEmpty(msg)){ // if body is not empty show body
                showNotification(msg);
            }
        }
   }
   private void showNotification(String msg){
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // managers all notifcations
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notify)
                .setContentTitle("poop poop")
                .setContentText("world is yours, take it");
        //set the icon and text for notifcation
        Intent intent = new Intent(this,MainActivity.class);
        // when user clicks on notifcation, it will open main class
   }
}



