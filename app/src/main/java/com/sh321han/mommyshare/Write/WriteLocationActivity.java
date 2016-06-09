package com.sh321han.mommyshare.Write;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.VisibleRegion;
import com.sh321han.mommyshare.R;

public class WriteLocationActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks,
        OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnCameraChangeListener,
        GoogleMap.OnMarkerDragListener {

    GoogleApiClient mClient;
    Button btn_setPresentLoc;
    double locX, locY;
    public static final String RESULT_LOCX = "result_locX";
    public static final String RESULT_LOCY = "result_locY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addApi(ActivityRecognition.API)
                .enableAutoManage(this, this)
                .addConnectionCallbacks(this)
                .build();
        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);
        fragment.getMapAsync(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_dialog_map);

        btn_setPresentLoc = (Button) findViewById(R.id.btn_setpresentLoc);

        btn_setPresentLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (currentMarker != null) {
                    LatLng latLng = currentMarker.getPosition();
                    locX = latLng.latitude;
                    locY = latLng.longitude;

                }

//                Intent data = new Intent();
//                data.putExtra(RESULT_LOCX, locX);
//                data.putExtra(RESULT_LOCY, locY);
//                setResult(Activity.RESULT_OK, data);


                String ok = "ok";
                Intent intent = new Intent();
                intent.putExtra("ok", ok);
                intent.putExtra(RESULT_LOCX, locX);
                intent.putExtra(RESULT_LOCY, locY);

                setResult(RESULT_OK, intent);

                finish();


            }
        });


    }

    GoogleMap mMap;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnCameraChangeListener(this);
        mMap.setOnMarkerDragListener(this);
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }


    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        VisibleRegion region = mMap.getProjection().getVisibleRegion();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return true;
    }


//    @Override
//    public void onMapLongClick(LatLng latLng) {
//        addMarker(latLng.latitude, latLng.longitude);
//    }

    Marker currentMarker = null;

    private void addMarker(double lat, double lng) {
        if (currentMarker == null) {
            MarkerOptions options = new MarkerOptions();
            options.position(new LatLng(lat, lng));
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
            options.anchor(0.5f, 1f);
//        options.title("MyMarker");
//        options.snippet("marker description");
            options.draggable(true);
            currentMarker = mMap.addMarker(options);
        } else {
            currentMarker.setPosition(new LatLng(lat, lng));
        }


    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(mClient);
        displayMessage(location);
        addMarker(location.getLatitude(), location.getLongitude());
        LocationRequest request = new LocationRequest();
        request.setInterval(10000);
        request.setFastestInterval(5000);
        request.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        LocationServices.FusedLocationApi.requestLocationUpdates(mClient, request, mListener);
    }

    LocationListener mListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            displayMessage(location);
        }
    };

    private void displayMessage(Location location) {
        if (location != null) {
            moveMap(location.getLatitude(), location.getLongitude(), 15f);
        }
    }

    private void moveMap(double lat, double lng, float zoom) {
        CameraPosition position = new CameraPosition.Builder()
                .target(new LatLng(lat, lng))
                .zoom(zoom)
                .build();

        CameraUpdate update = CameraUpdateFactory.newCameraPosition(position);

        if (mMap != null) {
            mMap.moveCamera(update);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.location, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.btn_ok:
                Toast.makeText(WriteLocationActivity.this, "완료", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

