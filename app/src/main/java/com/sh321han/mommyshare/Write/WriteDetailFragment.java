package com.sh321han.mommyshare.Write;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.sh321han.mommyshare.Manager.NetworkManager;
import com.sh321han.mommyshare.MyProductDetail.MyProductDetailActivity;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.WriteData;

import java.io.File;
import java.io.IOException;

import okhttp3.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class WriteDetailFragment extends Fragment {

    private static final int RC_GALLERY = 1;
    private static final int RC_CAMERA = 2;
    ImageView imgview1, imgview2, imgview3;
    ImageButton btn_camera, btn_gallery;

    EditText editText;
    String content;


    private void getImageFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, getCameraCaptureFile());
        startActivityForResult(intent, RC_CAMERA);
    }

    File mCameraCaptureFile;

    private Uri getCameraCaptureFile() {
        File dir = getContext().getExternalFilesDir("myphoto");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        mCameraCaptureFile = new File(dir, "my_photo_"+System.currentTimeMillis()+".jpg");
        return Uri.fromFile(mCameraCaptureFile);
    }

    private void getImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/jpeg");
        startActivityForResult(intent, RC_GALLERY);
    }

    File mUploadFile = null;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mUploadFile != null) {
            outState.putString("uploadfile", mUploadFile.getAbsolutePath());
        }
        if (mCameraCaptureFile != null) {
            outState.putString("cameraFile", mCameraCaptureFile.getAbsolutePath());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_GALLERY) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                String[] projection = {MediaStore.Images.Media.DATA};
                Cursor c = getContext().getContentResolver().query(uri, projection, null, null, null);
                if (c.moveToNext()) {
                    String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                    mUploadFile = new File(path);
                    BitmapFactory.Options opts = new BitmapFactory.Options();
                    opts.inSampleSize = 2;
                    Bitmap bm = BitmapFactory.decodeFile(path, opts);
                    imgview1.setImageBitmap(bm);

                }
            }
            return;
        }

        if (requestCode == RC_CAMERA) {
            if (resultCode == Activity.RESULT_OK) {

                File file = mCameraCaptureFile;
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inSampleSize = 2;
                Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath(), opts);
                imgview1.setImageBitmap(bm);
                mUploadFile = file;

            }
            return;
        }

//        onActivityResult(requestCode, resultCode, data); //
    }

    public WriteDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            String path = savedInstanceState.getString("uploadfile");
            if (!TextUtils.isEmpty(path)) {
                mUploadFile = new File(path);
            }
            path = savedInstanceState.getString("cameraFile");
            if (!TextUtils.isEmpty(path)) {
                mCameraCaptureFile = new File(path);
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final String name = getArguments().getString("name");
        final int rent_fee = getArguments().getInt("rent_fee");
        final String category = getArguments().getString("category");
        final int rent_deposit = getArguments().getInt("rent_deposit");
        final int min_rent_period = getArguments().getInt("min_rent_period");
        final int max_rent_period = getArguments().getInt("max_rent_period");
        final double longitude = getArguments().getDouble("longitude");
        final double latitude = getArguments().getDouble("latitude");



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_write_detail, container, false);

        editText = (EditText) view.findViewById(R.id.edit_detail);
        editText.requestFocus();


        Button button = (Button)getActivity().findViewById(R.id.btn_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //네트워크 매니저

                content = editText.getText().toString();

                NetworkManager.getInstance().ProductWrite(longitude, latitude, name, category, rent_fee, rent_deposit, min_rent_period, max_rent_period, content,
                        new NetworkManager.OnResultListener<WriteData>() {
                            @Override
                            public void onSuccess(Request request, WriteData result) {
                                Intent i = new Intent(getActivity(), MyProductDetailActivity.class);
                                i.putExtra("longitude", longitude);
                                i.putExtra("latitude", latitude);
                                i.putExtra("content", content);
                                i.putExtra("name", name);
                                i.putExtra("category", category);
                                i.putExtra("rent_fee", rent_fee);
                                i.putExtra("rent_deposit", rent_deposit);
                                i.putExtra("min_rent_period", min_rent_period);
                                i.putExtra("max_rent_period", max_rent_period);
                                i.putExtra("home", 1);
                                startActivity(i);

                            }

                            @Override
                            public void onFail(Request request, IOException exception) {

                            }
                        });
            }
        });




        imgview1 = (ImageView) view.findViewById(R.id.image1);
        imgview2 = (ImageView) view.findViewById(R.id.image2);
        imgview3 = (ImageView) view.findViewById(R.id.image3);

        btn_camera = (ImageButton) view.findViewById(R.id.btn_camera);
        btn_gallery = (ImageButton) view.findViewById(R.id.btn_gallery);




        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageFromCamera();
            }
        });

        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageFromGallery();
            }
        });


        return view;
    }


}


