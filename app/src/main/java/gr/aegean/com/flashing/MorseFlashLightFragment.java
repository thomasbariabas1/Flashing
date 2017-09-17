package gr.aegean.com.flashing;

import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

import gr.aegean.com.flashing.Model.MorseCode;


public class MorseFlashLightFragment extends Fragment {
    MorseCode morse = new MorseCode();
    Button sosbutton;
    Button sendmorse;
    EditText textformorse;
    static Camera camera = null;

    public static MorseFlashLightFragment newInstance() {
        return new MorseFlashLightFragment();
    }

    @Override
    public void onCreate(Bundle outstate) {
        super.onCreate(outstate);
    }

    public View onCreateView(LayoutInflater i, ViewGroup group, Bundle outstate) {
        super.onCreateView(i, group, outstate);
        View view = i.inflate(R.layout.morse_flashlight_fragment, group, false);
        sosbutton = (Button) view.findViewById(R.id.sosbutton);
        sendmorse = (Button) view.findViewById(R.id.texttomorsebutton);
        textformorse = (EditText) view.findViewById(R.id.texttomorse);

        morse.putMorseCode("A", new String[]{".", "-"});
        morse.putMorseCode("B", new String[]{"-", ".", ".", "."});
        morse.putMorseCode("C", new String[]{"-", ".", "-", "."});
        morse.putMorseCode("D", new String[]{"-", ".", ","});
        morse.putMorseCode("E", new String[]{"."});
        morse.putMorseCode("F", new String[]{".", ".", "-", "."});
        morse.putMorseCode("G", new String[]{"-", "-", "."});
        morse.putMorseCode("H", new String[]{".", ".", ".", "."});
        morse.putMorseCode("I", new String[]{".", "."});
        morse.putMorseCode("J", new String[]{".", "-", "-", "-"});
        morse.putMorseCode("K", new String[]{"-", ".", "-"});
        morse.putMorseCode("L", new String[]{".", "-", ".", "."});
        morse.putMorseCode("M", new String[]{"-", "-"});
        morse.putMorseCode("N", new String[]{"-", "."});
        morse.putMorseCode("O", new String[]{"-", "-", "-"});
        morse.putMorseCode("P", new String[]{".", "-", "-", "."});
        morse.putMorseCode("Q", new String[]{"-", "-", ".", "-"});
        morse.putMorseCode("R", new String[]{".", "-", "."});
        morse.putMorseCode("S", new String[]{".", ".", "."});
        morse.putMorseCode("T", new String[]{"-"});
        morse.putMorseCode("U", new String[]{".", ".", "-"});
        morse.putMorseCode("V", new String[]{".", ".", ".", "-"});
        morse.putMorseCode("W", new String[]{".", "-", "-"});
        morse.putMorseCode("X", new String[]{"-", ".", ".", "-"});
        morse.putMorseCode("Y", new String[]{"-", ".", "-", "-"});
        morse.putMorseCode("Z", new String[]{"-", "-", ".", "."});
        morse.putMorseCode("1", new String[]{".", "-", "-", "-", "-"});
        morse.putMorseCode("2", new String[]{".", ".", "-", "-", "-"});
        morse.putMorseCode("3", new String[]{".", ".", ".", "-", "-"});
        morse.putMorseCode("4", new String[]{".", ".", ".", ".", "-"});
        morse.putMorseCode("5", new String[]{".", ".", ".", ".", "."});
        morse.putMorseCode("6", new String[]{"-", ".", ".", ".", "."});
        morse.putMorseCode("7", new String[]{"-", "-", ".", ".", "."});
        morse.putMorseCode("8", new String[]{"-", "-", "-", ".", "."});
        morse.putMorseCode("9", new String[]{"-", "-", "-", "-", "."});
        morse.putMorseCode("0", new String[]{"-", "-", "-", "-", "-"});
        sosbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textformorse.setEnabled(false);
                sendmorse.setEnabled(false);
                sendMorse(morse.getMorsecodeOfLetter("SOS".split("(?!^)")));
            }
        });


        return view;
    }

    public void sendMorse(final ArrayList<String[]> wordtomorse) {
        long time=0;


       final  Handler handler = new Handler();
        for (int i = 0; i < wordtomorse.size(); i++) {
            final String[] morseword = wordtomorse.get(i);
            Log.e("MorseCode", "" + Arrays.toString(wordtomorse.get(i)));
            camera = Camera.open();
            final Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
            camera.startPreview();
            for (final String morseletter : morseword) {
                if (morseletter.equals(".")) {
                    time = 1000;
                } else {
                    time = 4000;
                }

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            camera.setParameters(parameters);
                            camera.stopPreview();

                        }
                    }, time);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();

            }


        }


        textformorse.setEnabled(true);
        sendmorse.setEnabled(true);

    }


}
