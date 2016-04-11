package com.example.mat.susapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.api.services.youtube.YouTube;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainSelect extends AppCompatActivity {

    private List<String> btnList;
    private static YouTube TheTube;
    private int btnTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_select);


        InitList();

        //Guide to registration of App and YouTube player integration
        //http://javatechig.com/android/youtubeplayerview-example-in-android-using-youtube-api
    }


    protected void InitList() {
        btnList = new ArrayList<>();

        btnList.add("Button1");
        btnList.add("Button2");
        btnList.add("Button3");
        btnList.add("Button4");
        btnList.add("Button5");
        btnList.add("Button6");
        btnList.add("Button7");
        btnList.add("Button8");

        LinearLayout linLayout = new LinearLayout(this);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams linLayoutParam = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linLayout, linLayoutParam);

        btnTag = 1;
        for (final String btnStr : btnList) {
            final Button btn1 = new Button(this);
            btn1.setText(btnStr);
            linLayout.addView(btn1);
            btn1.setTag(btnTag);
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    btnHandler(btn1.getTag().hashCode());
                }
            });
          btnTag++;
        }
    }

    protected void btnHandler(int Tag) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast;

     switch (Tag){
         case 1:
             //Do something
             toast = Toast.makeText(context, "Do something", duration);
             toast.show();

             Intent intent = new Intent(this, player.class);
             startActivity(intent);

             break;
         case 2:
             //Do something else
             toast = Toast.makeText(context, "Do something else", duration);
             toast.show();
             break;
         default:
             //Unknown button or call
             toast = Toast.makeText(context, "Unknown button or call", duration);
             toast.show();
             break;
     }
    }

}

