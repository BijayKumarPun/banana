package com.example.mango.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mango.R;
import com.example.mango.fragments.Camera2Fragment;

public class CameraScanActivity extends AppCompatActivity {
    private static final String TAG = CameraScanActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_scan);

        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2Fragment.newInstance())
                    .commit();
        }

    }
}
