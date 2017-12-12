package com.practice.andrea.practiceapplication;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button randomizer = (Button) findViewById(R.id.button);

        randomizer.setOnClickListener(new OnClickListener() {
            public void onClick(View v){
                changeColor();
            }
        });
    }

    public String colorPicker(){
        Random rand = new Random();
        List<String> colors = new ArrayList<String>();
        String bgColor = ("#");//new String("#");

        colors.add("CC");
        colors.add("FF");
        colors.add("00");
        colors.add("33");
        colors.add("66");
        colors.add("99");

        for (int i = 0; i < 3; i++) {
            int num = rand.nextInt(6);
            bgColor = bgColor.concat(colors.get(num));
        }

        return bgColor;
    }

    public void changeColor(){
        TextView tv = (TextView) findViewById(R.id.textview);
        RelativeLayout bg = (RelativeLayout) findViewById(R.id.layout);

        tv.setText(colorPicker());
        bg.setBackgroundColor(Color.parseColor(colorPicker()));

        Toast.makeText(getApplicationContext(),"You changed the color!",Toast.LENGTH_LONG).show();
    }
}
