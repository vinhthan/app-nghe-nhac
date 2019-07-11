package com.tmv.appmusic2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tvSongName;
    SeekBar seekBar;
    ImageView imPlay, imPause, imRewind, imFast, imList, imEqua, imReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AnhXa();
    }



    private void AnhXa() {
        tvSongName = (TextView) findViewById(R.id.tvSongName);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        imPlay = (ImageView) findViewById(R.id.imPlay);
        imPause = (ImageView) findViewById(R.id.imPause);
        imRewind = (ImageView) findViewById(R.id.imRewind);
        imFast = (ImageView) findViewById(R.id.imFast);
        imList = (ImageView) findViewById(R.id.imList);
        imEqua = (ImageView) findViewById(R.id.imEqua);
        imReplay = (ImageView) findViewById(R.id.imReplay);
    }
}
