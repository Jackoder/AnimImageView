package com.jackoder.widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class DemoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AnimImageView animImageView = (AnimImageView)findViewById(R.id.aiv_loading);
        findViewById(R.id.btn_anim_toggle).setOnClickListener(new View.OnClickListener() {

            boolean tof;

            @Override
            public void onClick(View v) {
                if (tof) {
                    animImageView.stopAnimation();
                } else {
                    animImageView.startAnimation();
                }
                tof = !tof;
            }
        });
        findViewById(R.id.btn_visible_toggle).setOnClickListener(new View.OnClickListener() {

            boolean tof;

            @Override
            public void onClick(View v) {
                if (tof) {
                    animImageView.setVisibility(View.VISIBLE);
                } else {
                    animImageView.setVisibility(View.INVISIBLE);
                }
                tof = !tof;
            }
        });
    }

}

