public class Spell extends Card{
    private int mana;
    private MapCell[] spellTarget ;

    public Spell(String id, String name, int price, int mana ){
        super(id, name, price);
        this.mana = mana;
    }

    public void apply(MapCell[] spellTarget){
        this.spellTarget = spellTarget;
        for(MapCell mapCell : spellTarget)
            apply(mapCell);
    }

    private void apply(MapCell mapCell){

    }

    public int getMana() {
        return mana;
    }

    public MapCell[] getSpellTarget() {
        return spellTarget;
    }

    @Override
    public String getCardType() {
        return "Spell";
    }
}

