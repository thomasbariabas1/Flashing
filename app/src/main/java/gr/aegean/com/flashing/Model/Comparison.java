package gr.aegean.com.flashing.Model;

/**
 * Created by phantomas on 3/30/2017.
 */

public class Comparison {
    private String letter;
    private String[] morsecode;

    Comparison(String letter,String[] morsecode){
        this.letter=letter;
        this.morsecode=morsecode;
    }

    public String[] getMorsecode(){

        return this.morsecode;
    }
    public String getLetter(){
        return this.letter;
    }
}
