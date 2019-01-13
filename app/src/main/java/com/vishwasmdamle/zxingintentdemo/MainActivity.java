package com.vishwasmdamle.zxingintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClicked(View view) {
        startIntent();
    }

    // Read more here https://github.com/zxing/zxing/blob/master/android/src/com/google/zxing/client/android/Intents.java
    public void startIntent() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "ONE_D_MODE");
        intent.putExtra("SCAN_FORMATS", "CODE_39,CODE_93,CODE_128,DATA_MATRIX,ITF,CODABAR,EAN_13,EAN_8,UPC_A,QR_CODE");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // TODO: This fails if scan failed/skipped. Handle gracefully.
        String scanValue = data.getStringExtra("SCAN_RESULT");
        ((TextView) findViewById(R.id.scannedValue)).setText(scanValue);
    }
}
