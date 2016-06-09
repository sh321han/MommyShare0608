//package com.sh321han.mommyshare.GoogleMap;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.TextView;
//
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.model.Marker;
//import com.sh321han.mommyshare.R;
//
//import java.util.Map;
//
///**
// * Created by dongja94 on 2016-05-12.
// */
//public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
//    Map<Marker, POI> poiResolver;
//    View contentView;
//    TextView nameView, telView, addressView;
//
//    public MyInfoWindowAdapter(Context context, Map<Marker,POI> poiResolver) {
//        contentView = LayoutInflater.from(context).inflate(R.layout.view_info_window, null);
//        nameView = (TextView)contentView.findViewById(R.id.text_name);
//        telView = (TextView)contentView.findViewById(R.id.text_tel);
//        addressView = (TextView)contentView.findViewById(R.id.text_address);
//        this.poiResolver = poiResolver;
//    }
//    @Override
//    public View getInfoWindow(Marker marker) {
//        POI poi = poiResolver.get(marker);
//        nameView.setText(poi.name);
//        telView.setText(poi.telNo);
//        addressView.setText(poi.getAddress());
//        return contentView;
//    }
//
//    @Override
//    public View getInfoContents(Marker marker) {
//        POI poi = poiResolver.get(marker);
//        nameView.setText(poi.name);
//        telView.setText(poi.telNo);
//        addressView.setText(poi.getAddress());
//        return contentView;
//    }
//}
