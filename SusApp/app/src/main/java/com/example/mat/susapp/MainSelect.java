package com.example.mat.susapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.api.services.youtube.YouTube;

import java.util.ArrayList;
import java.util.List;

public class MainSelect extends AppCompatActivity {

    private List<String> btnList;
    private static YouTube TheTube;

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

        for(String btnStr: btnList) {
            Button btn1 = new Button(this);
            btn1.setText(btnStr);
            linLayout.addView(btn1);
        }
    }

}

