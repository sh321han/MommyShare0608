package com.sh321han.mommyshare.GoogleMap;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.sh321han.mommyshare.Write.WriteLocationActivity;

import java.util.List;

public class GeofenceService extends Service {
    public GeofenceService() {
    }

    NotificationManager mNM;

    @Override
    public void onCreate() {
        super.onCreate();
        mNM = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        GeofencingEvent event = GeofencingEvent.fromIntent(intent);
        if (!event.hasError()) {
            List<Geofence> geofences = event.getTriggeringGeofences();
            for (Geofence geofence : geofences) {
                Toast.makeText(this, "id : " + geofence.getRequestId(), Toast.LENGTH_SHORT).show();
                showNotifycation(geofence);
            }
            Location location = event.getTriggeringLocation();
            Toast.makeText(this, "current : " + location, Toast.LENGTH_SHORT).show();
        }
        return Service.START_NOT_STICKY;
    }

    private void showNotifycation(Geofence geofence) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("geofencing...");
        builder.setContentTitle("geofence");
        builder.setContentText("id : " + geofence.getRequestId());
        Intent intent = new Intent(this, WriteLocationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        mNM.notify(1, builder.build());
    }
}
