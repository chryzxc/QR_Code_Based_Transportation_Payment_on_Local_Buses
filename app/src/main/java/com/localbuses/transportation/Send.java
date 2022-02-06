package com.localbuses.transportation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class Send extends AppCompatActivity {
    String walletId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        Intent intent = new Intent(Send.this, Scanner.class);
        startActivityForResult(intent, 1);

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if(data != null){
                    walletId  = data.getStringExtra("walletId");

                    Toast.makeText(this, walletId, Toast.LENGTH_SHORT).show();

                }



            }
            if  (resultCode == RESULT_CANCELED){
                finish();
            }
        }
    }

}