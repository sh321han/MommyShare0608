package com.sh321han.mommyshare.GoogleMap;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;

public class ActivitiesService extends Service {
    public ActivitiesService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
        List<DetectedActivity> list = result.getProbableActivities();
        DetectedActivity activity = result.getMostProbableActivity();
        switch (activity.getType()) {
            case DetectedActivity.IN_VEHICLE :
                activity.getConfidence();
                break;
        }
        return Service.START_NOT_STICKY;
    }
}
