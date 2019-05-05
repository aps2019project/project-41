public class Spell extends Card{
    int mana;
    SpellTarget spellTarget;
    /* maybe some changes in UML */
    public Spell(String id, String name, int price, int mana){
        super(id, name, price);
        this.mana = mana;
    }


    @Override
    public String getCardType() {
        return "Spell";
    }
}
