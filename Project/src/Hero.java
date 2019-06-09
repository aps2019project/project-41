import java.util.ArrayList;

public class Hero extends Card implements Worrior{
    private int hp;
    private int ap;
    private int coolDown;
    private int startRange;
    private int endRange;
    private AttackType attackType;
    private Spell specialPower;
    private int manaNeededForSpecialPower;
    private String strikeType;


    public Hero(String id, String name, int price,int hp, int ap,AttackType attackType,int startRange,int endRange,
                Spell specialPower,int manaNeededForSpecialPower,int coolDown) {
        super(id, name, price);
        this.hp = hp;
        this.ap = ap;
        this.coolDown = coolDown;
        this.startRange = startRange;
        this.endRange = endRange;
        this.attackType = attackType;
        this.specialPower = specialPower;
        this.manaNeededForSpecialPower = manaNeededForSpecialPower;
        Card.getCards().add(this);
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

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public AttackType getAttackType() {
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

    public void createDefaultHeroesOfGame() {
        new Hero("1","Dive-Sefid",8000,50,4,AttackType.melee,0,1,null,1,2);
        new Hero("2","Simorgh",9000,50,4,AttackType.melee,0,1,null,3,8);
        new Hero("3","Ezhdeha",8000,50,4,AttackType.melee,0,1,null,0,1);
        new Hero("4","Rakhsh",8000,50,4,AttackType.melee,0,1,null,1,2);
        new Hero("5","Zahhak",10000,50,4,AttackType.melee,0,1,null,1,3);
        new Hero("6","Kaveh",8000,50,4,AttackType.melee,0,1,null,1,3);
        new Hero("7","Arash",10000,30,2,AttackType.ranged,1,6,null,2,2);
        new Hero("8","Afsaneh",11000,40,3,AttackType.ranged,1,3,null,1,2);
        new Hero("9","Esfandiar",12000,35,3,AttackType.hybrid,0,3,null,0,1);
        new Hero("10","Rostam",8000,55,7,AttackType.hybrid,0,4,null,0,0);
    }

    public void attack(Card targetCard){
        if(targetCard instanceof Hero)
            ((Hero)targetCard).setHp(((Hero)targetCard).getHp() - this.ap);
        else if(targetCard instanceof Minion)
            ((Minion)targetCard).setHp(((Hero)targetCard).getHp() - this.ap);

    }

    public void counterAttack(Card targetCard){
        this.attack(targetCard);
    }
}
