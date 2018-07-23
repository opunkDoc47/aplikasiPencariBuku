package com.example.asus.coba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

public class menuUtama extends AppCompatActivity {
 SparkButton button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu_utama);
        button1=(SparkButton) findViewById(R.id.button1);
        button1.setChecked(false);
        button1.setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {

            }

            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
                if (buttonState) {
                    listbuku();
                } else {
                   // Button is inactive
                }
            }

            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
    }

    private void listbuku() {
        Intent i = new Intent(menuUtama.this, ListBuku.class);
        i.putExtra("tabel", "ori");
        i.putExtra("value", "null");
        startActivity(i);
        finish();
    }
}
