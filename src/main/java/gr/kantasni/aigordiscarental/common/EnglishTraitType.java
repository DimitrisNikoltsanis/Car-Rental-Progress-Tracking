package gr.kantasni.aigordiscarental.common;

import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
public enum EnglishTraitType {
    FUEL ("Fuel"),
    SEATS ("Seats"),
    DOORS ("Doors"),
    TRANSMISSION ("Transmission"),
    AIR_CONDITIONING ("Air conditioning"),
    LUGGAGE ("Luggage"),
    EXTRAS ("Extras");

    private String text;

    private EnglishTraitType(String s){
        this.text = s;
    }

    @Override
    public String toString(){
        return text;
    }
}
