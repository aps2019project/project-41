public class Buff extends Spell {
    private int activeTime;
    public Buff(String id, String name, int price, int mana , int activeTime){
        super(id , name , price , mana);
        this.activeTime = activeTime ;
    }

}

