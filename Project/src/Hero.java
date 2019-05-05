public class Hero extends Card{
    private int hp;
    private int ap;
    private int coolDown;
    private int attackRange;
    private String attackType;
    private Spell specialPower;
    private int manaNeededForSpecialPower;
    private String strikeType;


    public Hero(String id, String name, int price,int hp, int ap, int coolDown, int attackRange, String attackType,
                Spell specialPower, String strikeType) {
        super(id, name, price);
        this.hp = hp;
        this.ap = ap;
        this.coolDown = coolDown;
        this.attackRange = attackRange;
        this.attackType = attackType;
        this.specialPower = specialPower;
        this.strikeType = strikeType;
    }

    public int getHp() {
        return hp;
    }

    public int getAp() {
        return ap;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public String getAttackType() {
        return attackType;
    }

    public Spell getSpecialPower() {
        return specialPower;
    }

    public String getStrikeType() {
        return strikeType;
    }

    public int getManaNeededForSpecialPower(){return manaNeededForSpecialPower; }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    @Override
    public String getCardType() {
        return "Hero";
    }
}
