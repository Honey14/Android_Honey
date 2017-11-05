package com.example.honey.activitypractise;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imageview;
    public static final int REQUEST_IMAGE_CAPTURE = 101;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = findViewById(R.id.imageview);
        Button maps_button = findViewById(R.id.maps_button);
        Button netflix_button = findViewById(R.id.netflix_button);
        Button email_button = findViewById(R.id.email_button);
        Button camera_button = findViewById(R.id.camera_button);
        Button dial_button = findViewById(R.id.dial_button);
        Button call_button = findViewById(R.id.call_button);
        Button sendImage_button = findViewById(R.id.sendImage_button);
        maps_button.setOnClickListener(this);
        netflix_button.setOnClickListener(this);
        email_button.setOnClickListener(this);
        camera_button.setOnClickListener(this);
        dial_button.setOnClickListener(this);
        call_button.setOnClickListener(this);
        sendImage_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null, chooser = null;
        switch(view.getId()){
            case R.id.maps_button:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:19.076,72.8777"));
                chooser = Intent.createChooser(intent,"Show Location");
                startActivity(chooser);
                break;
            case R.id.netflix_button:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.netflix.mediaclient&hl=en"));
                chooser = Intent.createChooser(intent,"Download netflix");
                startActivity(chooser);
                break;
            case R.id.email_button:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,"honey.sonwani@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT,"this is subject");
                intent.putExtra(Intent.EXTRA_TEXT,"content for the emaail");
                intent.setType("plain/text");
               chooser =  Intent.createChooser(intent,"send email");
               startActivity(chooser);
               break;
            case R.id.camera_button:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                chooser = Intent.createChooser(intent,"Open Camera");
                startActivityForResult(chooser,REQUEST_IMAGE_CAPTURE);
                break;
            case R.id.dial_button: //pending
                String number = "+918888888888"; //justdial number
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
                break;
            case R.id.sendImage_button:
                Uri imageuri = Uri.parse("android.resource://com.example.honey.activitypractise/drawable/"+ R.drawable.ic_launcher_background);
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM,imageuri);
                chooser = Intent.createChooser(intent,"Send image");
                startActivity(chooser);
                break;
            case R.id.call_button:
                callPhone();
                break;
        }
    }

    private void callPhone() {
        String no = "198";
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+no));
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
         Bundle extras = data.getExtras();
         Bitmap imageBitmap = (Bitmap) extras.get("data");
         imageview.setImageBitmap(imageBitmap);
        }
    }}