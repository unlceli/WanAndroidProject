package com.lijj.wyx.physical.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lijj.wyx.physical.R;

public class  d  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        TextView textView = findViewById(R.id.textview);

        new Thread(new Runnable() {
            @Override
            public void run() {
                textView.setText("1");
            }
        }).start();

    }
}
