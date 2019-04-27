public class Minion extends Card{
    private int hp;
    private int ap;
    private int mana;
    private int attacks;
    private int attackRange;
    private String attackType;
    private int specialAbilityNumber;
    private String group;
    private String type;
    //constructor, getter, setter
    public Minion(int hp, int ap, int mana, int attacks, int attackRange, String attackType, int specialAbilityNumber, String group, String type) {
        this.hp = hp;
        this.ap = ap;
        this.mana = mana;
        this.attacks = attacks;
        this.attackRange = attackRange;
        this.attackType = attackType;
        this.specialAbilityNumber = specialAbilityNumber;
        this.group = group;
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public int getAp() {
        return ap;
    }

    public int getMana() {
        return mana;
    }

    public int getAttacks() {
        return attacks;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public String getAttackType() {
        return attackType;
    }

    public int getSpecialAbilityNumber() {
        return specialAbilityNumber;
    }

    public String getGroup() {
        return group;
    }

    public String getType() {
        return type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    void useSpecialAbility(){

    }

}
