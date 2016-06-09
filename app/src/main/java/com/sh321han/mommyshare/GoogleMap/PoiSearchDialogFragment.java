package com.sh321han.mommyshare.GoogleMap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.R;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.Request;

/**
 * Created by dongja94 on 2016-05-12.
 */
public class PoiSearchDialogFragment extends DialogFragment {

    EditText keywordView;

    public interface OnPoiSearchResultCallback {
        public void onPoiSearchResult(SearchPOIInfo info);
    }
    OnPoiSearchResultCallback mListener;
    public void setOnPoiSearchResultCallback(OnPoiSearchResultCallback callback) {
        mListener = callback;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poi_search_dialog, container, false);
        keywordView = (EditText)view.findViewById(R.id.edit_keyword);
        Button btn = (Button)view.findViewById(R.id.btn_search);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = keywordView.getText().toString();
                if (!TextUtils.isEmpty(keyword)) {
                    try {
                        NetworkManager.getInstance().getTMapSearchPOI(getContext(), keyword, new NetworkManager.OnResultListener<SearchPOIInfo>() {
                            @Override
                            public void onSuccess(Request request, SearchPOIInfo result) {
                                if (mListener != null) {
                                    mListener.onPoiSearchResult(result);
                                }
                                dismiss();
                            }

                            @Override
                            public void onFail(Request request, IOException exception) {
                                Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
                                dismiss();
                            }
                        });
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.dialog_width), ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}
