package kr.co.mikarusoft.findbookstore;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button upload, list, map;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upload = (Button)findViewById(R.id.btnUpload);
        list = (Button)findViewById(R.id.btnList);
        map = (Button)findViewById(R.id.btnMap);

        upload.setOnClickListener(this);
        list.setOnClickListener(this);
        map.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == upload){
            intent = new Intent(this, BookstoreInfoUploader.class);
            startActivity(intent);

            finish();
        }else if(view == list){
            intent = new Intent(this, DataList.class);
            startActivity(intent);

            finish();
        }else if (view == map) {
            intent = new Intent(this, BookstoreMap.class);
            startActivity(intent);

            finish();
        }
    }

}
