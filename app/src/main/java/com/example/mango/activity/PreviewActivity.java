package com.example.mango.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.mango.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreviewActivity extends AppCompatActivity {

    private static final String TAG = PreviewActivity.class.getSimpleName();

    @BindView(R.id.iv_image_preview)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_activity);
        ButterKnife.bind(this);

        if (getIntent()!=null){

                if (getIntent().getExtras()!=null){
                    if (getIntent().getExtras().get("imagePath")!=null){
                        Log.d(TAG, getIntent().getExtras().get("imagePath").toString());
                        getFileFromStorage(getIntent().getExtras().get("imagePath").toString());
                    }
                }

        }

    }

    private void getFileFromStorage(String path) {
        try {
            File f=new File(path);
            Bitmap bitmap = BitmapFactory.decodeStre   am(new FileInputStream(f));
            //set image to the imageview
            imageView.setImageBitmap(bitmap);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
