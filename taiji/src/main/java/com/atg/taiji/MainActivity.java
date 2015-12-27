package com.atg.taiji;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        final Taiji taiji = new Taiji(this);
        setContentView(taiji);

        final Handler handler = new Handler() {
            private float degress = 0;

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                taiji.setRotate(degress += 2);
                this.sendEmptyMessageDelayed(0, 20);
            }
        };
        handler.sendEmptyMessageDelayed(0, 20);
    }
}
