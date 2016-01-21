package com.fleetlabs.common.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.fleetlabs.common.R;
import com.fleetlabs.library.imagepicker.ImagePicker;
import com.fleetlabs.library.imagepicker.ImagePickerCallback;
import com.fleetlabs.library.utils.ImageUtil;

public class MultipartUploadActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private Button btnImagePickerCamera;
    private Button btnImagePickerGallery;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipart_upload);
        mContext = this;

        btnImagePickerCamera = (Button) findViewById(R.id.btnImagePickerCamera);
        btnImagePickerGallery = (Button) findViewById(R.id.btnImagePickerGallery);
        ivImage = (ImageView) findViewById(R.id.ivImage);

        btnImagePickerCamera.setOnClickListener(this);
        btnImagePickerGallery.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        ImagePicker.setOnActivityResult(requestCode, resultCode, result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnImagePickerCamera:
                ImagePicker.getImageFromCamera(this, new ImagePickerCallback() {

                    @Override
                    public void onSuccess(String path) {
                        Log.i("TAG", "onSuccess" + path);
                        ImageUtil.load(mContext, path, ivImage);
                    }

                    @Override
                    public void onFailed(Exception e) {
                        Log.i("TAG", "onFailed:" + e.getMessage());
                    }
                });
                break;
            case R.id.btnImagePickerGallery:
                ImagePicker.getImageFromGallery(this, new ImagePickerCallback() {

                    @Override
                    public void onSuccess(String path) {
                        Log.i("TAG", "onSuccess" + path);
                        ImageUtil.load(mContext, path, ivImage);
                    }

                    @Override
                    public void onFailed(Exception e) {
                        Log.i("TAG", "onFailed:" + e.getMessage());
                    }
                });
                break;
        }
    }
}
