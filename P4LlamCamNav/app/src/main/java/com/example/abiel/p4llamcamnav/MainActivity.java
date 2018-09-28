package com.example.abiel.p4llamcamnav;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.NavigableMap;

public class MainActivity extends AppCompatActivity {
    Button btnCall, btnCamera, btnNav;
    private static final int CAMERA_PIC_REQUEST = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = (Button) findViewById(R.id.call);
        btnCamera = (Button)findViewById(R.id.camera);
        btnNav = (Button)findViewById(R.id.navigation);

        final Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        final Intent navigation = new Intent();
        final Intent call = new Intent(Intent.ACTION_DIAL);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(camera, CAMERA_PIC_REQUEST);
            }
        });

        btnNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation.setAction(Intent.ACTION_VIEW);
                navigation.addCategory(Intent.CATEGORY_BROWSABLE);
                navigation.setData(Uri.parse("https://www.stackoverflow.com"));
                startActivity(navigation);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call.setData(Uri.parse("tel:6642853870"));
                startActivity(call);
            }
        });
    }
}
