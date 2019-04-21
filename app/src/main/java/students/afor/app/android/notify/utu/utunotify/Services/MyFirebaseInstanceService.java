package students.afor.app.android.notify.utu.utunotify.Services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Calendar;
import java.util.Random;

import students.afor.app.android.notify.utu.utunotify.MainActivity;
import students.afor.app.android.notify.utu.utunotify.R;

public class MyFirebaseInstanceService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

      showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    private void showNotification(String title,String body)
    {
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID="students.afor.app.android.notify.utu.utunotify";

            if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O)
            {
                NotificationChannel notificationChannel=new NotificationChannel(NOTIFICATION_CHANNEL_ID,"Notification",NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription("UTU notify");
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.BLUE);
                notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
                notificationChannel.enableLights(true);
                notificationManager.createNotificationChannel(notificationChannel);



            }

        NotificationCompat.Builder notificationBuilder=new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);

        Intent p=new Intent(MyFirebaseInstanceService.this,Notification.class);
        PendingIntent resultPendingIntent=PendingIntent.getActivity(this,1,p,PendingIntent.FLAG_UPDATE_CURRENT);

            notificationBuilder.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.utuimage)
                    .setContentTitle(title)
                    .setContentTitle(title)
                    .setContentInfo("Info")
                    .setContentIntent(resultPendingIntent)
                    .setAutoCancel(true)
                    .setWhen(Calendar.getInstance().getTimeInMillis() )
            .setPriority(NotificationCompat.PRIORITY_HIGH);





        notificationManager.notify(new Random().nextInt(),notificationBuilder.build());
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("TOKENFIREBASE",s);
    }
}