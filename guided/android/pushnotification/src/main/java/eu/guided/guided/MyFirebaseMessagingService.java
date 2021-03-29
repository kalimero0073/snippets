package eu.guided.guided;

import android.content.Context;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "GUIDed";

    @Override
    public void onNewToken(String mToken) {
        super.onNewToken(mToken);
        Log.d(TAG, mToken);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        super.onMessageReceived(remoteMessage);

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            String title = remoteMessage.getData().get("title");
            String body = remoteMessage.getData().get("body");
            displayNotification(getApplicationContext(), title, body);
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "title: " + remoteMessage.getNotification().getTitle());
            Log.d(TAG, "body: " + remoteMessage.getNotification().getBody());
            String title = remoteMessage.getNotification().getTitle();
            String body = remoteMessage.getNotification().getBody();
            displayNotification(getApplicationContext(), title, body);
        }

    }

    private void displayNotification(Context context, String title, String body) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "simplified_coding")
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(1, mBuilder.build());
    }

}
