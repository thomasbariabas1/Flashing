package gr.aegean.com.flashing.Model;

import java.util.ArrayList;

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
}
