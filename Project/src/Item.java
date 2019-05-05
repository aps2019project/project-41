import java.util.ArrayList;

public class Item {
    private String id;
    private String name;
    private int price ;
    private static ArrayList<Item> items = new ArrayList<Item>();

    public Item(){

        items.add(this);
    }

    public int getPrice() {
        return price;
    }

    public static ArrayList<Item> getItems(){
        return items;
    }

    public String getID(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void tajDanaE() {


    }

    public void namuseSepar(){

    }

    public void kamaneDamol(){

    }


    public void nushDaroo(){

    }


    public void tireDoShakh(){

    }



    public void pareSimorgh(){

    }


    public void Exir(){

    }



    public void majuneMana(){

    }



    public void majuneRuEnTani(){

    }



    public void nefrineMarg(){

    }



    public void randomDamage(){

    }



    public void terrorHood(){

    }


    public void bladesOFAgility(){

    }

    public void kingWisdom(){

    }



    public void assassiationDagger(){

    }


    public void poisonousDagger(){

    }



    public void shockHammer(){

    }



    public void soulEater(){

    }


    public void qosleTamid(){

    }



    public void shamshireChini(){

    }


}
