public class Spell extends Card{
    int mana;
    int effectNumber;
    SpellTarget spellTarget;
    /* maybe some changes in UML */
    public Spell(int id, String name, int price, int mana){
        super(id, name, price);
        this.mana = mana;
    }

    @Override
    public String getCardType() {
        return "Spell";
    }
}
