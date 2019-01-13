# Zxing Barcode Scanning Intent Demo
An ugly demo application to show how to trigger barcode scanning using `com.google.zxing.client.android.SCAN` intent from your app so that barcode scanning apps (like com.google.zxing.client.android or camera apps) can scan the barcodes and return its result.

## The main intent code:
```java
    public void startIntent() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "ONE_D_MODE");
        intent.putExtra("SCAN_FORMATS", "CODE_39,CODE_93,CODE_128,DATA_MATRIX,ITF,CODABAR,EAN_13,EAN_8,UPC_A,QR_CODE");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String scanValue = data.getStringExtra("SCAN_RESULT");
        ((TextView) findViewById(R.id.scannedValue)).setText(scanValue);
    }
```

![Broken Screenshot](https://raw.githubusercontent.com/vishwasmdamle/zxing-intent-demo/master/screenshots/main-activity-screenshot.png)
