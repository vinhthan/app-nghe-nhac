package com.tmv.appmusic2;

import android.Manifest;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvSong;
    String[] item;

    //List<>
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSong = (ListView) findViewById(R.id.lvSong);

        RuntimePermission();
    }

    public void RuntimePermission() {//xin những quyền j viết hết trong ngặc đơn bên dưới (vd: CAMERA, PHONE...)
        Dexter.withActivity(this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        display();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();

    }

    public ArrayList<File> findSong(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        for (File singfile : files) {
            if (singfile.isDirectory() && !singfile.isHidden()) {
                arrayList.addAll(findSong(singfile));
            } else {
                if (singfile.getName().endsWith(".mp3") || singfile.getName().endsWith(".wav")) {
                    arrayList.add(singfile);

                }
            }
        }
        return arrayList;
    }

    void display() {
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());

        item = new String[mySongs.size()];
        for (int i = 0; i < mySongs.size(); i++) {
            item[i] = mySongs.get(i).getName().toString().replace(".mp3", "").replace(".wav", "");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, item);
        lvSong.setAdapter(adapter);
    }
}
//implementation 'com.karumi:dexter:5.0.0' (đơn giản hoá xin quyền truy cập ud trong android)
