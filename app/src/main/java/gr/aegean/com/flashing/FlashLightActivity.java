package gr.aegean.com.flashing;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.Image;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import gr.aegean.com.flashing.Model.MorseCode;

public class FlashLightActivity extends AppCompatActivity {

    private ToggleButton button;
    static Camera camera = null;
    static final int CAMERA_PERMISSION=0;
    MorseCode morse = new MorseCode();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);
        button = (ToggleButton) findViewById(R.id.toggle);

        morse.putMorseCode("A",new String[]{".","-"});
        morse.putMorseCode("B",new String[]{"-",".",".","."});
        morse.putMorseCode("C",new String[]{"-",".","-","."});
        morse.putMorseCode("D",new String[]{"-",".",","});
        morse.putMorseCode("E",new String[]{"."});
        morse.putMorseCode("F",new String[]{".",".","-","."});
        morse.putMorseCode("G",new String[]{"-","-","."});
        morse.putMorseCode("H",new String[]{".",".",".","."});
        morse.putMorseCode("I",new String[]{".","."});
        morse.putMorseCode("J",new String[]{".","-","-","-"});
        morse.putMorseCode("K",new String[]{"-",".","-"});
        morse.putMorseCode("L",new String[]{".","-",".","."});
        morse.putMorseCode("M",new String[]{"-","-"});
        morse.putMorseCode("N",new String[]{"-","."});
        morse.putMorseCode("O",new String[]{"-","-","-"});
        morse.putMorseCode("P",new String[]{".","-","-","."});
        morse.putMorseCode("Q",new String[]{"-","-",".","-"});
        morse.putMorseCode("R",new String[]{".","-","."});
        morse.putMorseCode("S",new String[]{".",".","."});
        morse.putMorseCode("T",new String[]{"-"});
        morse.putMorseCode("U",new String[]{".",".","-"});
        morse.putMorseCode("V",new String[]{".",".",".","-"});
        morse.putMorseCode("W",new String[]{".","-","-"});
        morse.putMorseCode("X",new String[]{"-",".",".","-"});
        morse.putMorseCode("Y",new String[]{"-",".","-","-"});
        morse.putMorseCode("Z",new String[]{"-","-",".","."});
        morse.putMorseCode("1",new String[]{".","-","-","-","-"});
        morse.putMorseCode("2",new String[]{".",".","-","-","-"});
        morse.putMorseCode("3",new String[]{".",".",".","-","-"});
        morse.putMorseCode("4",new String[]{".",".",".",".","-"});
        morse.putMorseCode("5",new String[]{".",".",".",".","."});
        morse.putMorseCode("6",new String[]{"-",".",".",".","."});
        morse.putMorseCode("7",new String[]{"-","-",".",".","."});
        morse.putMorseCode("8",new String[]{"-","-","-",".","."});
        morse.putMorseCode("9",new String[]{"-","-","-","-","."});
        morse.putMorseCode("0",new String[]{"-","-","-","-","-"});





        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){

// Here, thisActivity is the current activity
            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.CAMERA)) {

                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA},
                            CAMERA_PERMISSION);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }
            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {

                        //ToDo something
                        camera = Camera.open();
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        camera.startPreview();

                    } else {
                        //ToDo something
                        camera = Camera.open();
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(parameters);
                        camera.stopPreview();
                        camera.release();


                    }
                }
            });
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAMERA_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
