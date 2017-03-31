package gr.aegean.com.flashing.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by phantomas on 3/30/2017.
 */

public class MorseCode {
    private ArrayList<Comparison> Alpabet = new ArrayList<>();

    public MorseCode(){
        Alpabet = new ArrayList<>();
    }
    public void putMorseCode(String letter,String[] morsecode){
     Alpabet.add(new Comparison(letter,morsecode));
    }

    public String[] getMorsecodeOfLetter(String letter){
        for(Comparison c:Alpabet){
            if(c.getLetter().equals(letter)){
                return c.getMorsecode();
            }
        }
        return null;
    }
    public  ArrayList<String[]> getMorsecodeOfLetter(String[] letter){
        ArrayList<String[]> morse = new ArrayList<>();
        Log.e("beforemorse",""+ Arrays.toString(letter));

            for(String l:letter) {

                    Log.e("one morse",""+ Arrays.toString(getMorsecodeOfLetter(l)));
                    morse.add(getMorsecodeOfLetter(l));

            }

        return morse;
    }
}
