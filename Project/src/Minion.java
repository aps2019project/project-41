import java.util.ArrayList;

public class Minion extends Card{
    private int hp;
    private int ap;
    private int mana;
    private int attacks;
    private int startRange;
    private int endRange;
    private int specialAbilityNumber;
    private String group;
    private AttackType type;
    //constructor, getter, setter
    public Minion(String id, String name, int price, int mana,int hp, int ap, AttackType type,int startRange,int endRange,
              int specialAbilityNumber, String group) {
        super(id, name, price);
        this.hp = hp;
        this.ap = ap;
        this.mana = mana;
        this.startRange = startRange;
        this.endRange = endRange;
        this.specialAbilityNumber = specialAbilityNumber;
        this.group = group;
        this.type = type;
        Card.getCards().add(this);
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

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public int getSpecialAbilityNumber() {
        return specialAbilityNumber;
    }

    public String getGroup() {
        return group;
    }

    public AttackType getType() {
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

    @Override
    public String getCardType() {
        return "Minion";
    }

    public void createDefaultMinionsOfGame(){
        new Minion("1","Kamandar-fars",300,2,6,4,AttackType.ranged,1,7,0,"fars");
        new Minion("2","ShamshirZan-fars",400,2,6,4,AttackType.melee,0,1,0,"fars");
        new Minion("3","NeizeDar-fars",500,1,5,3,AttackType.hybrid,0,3,0,"fars");
        new Minion("4","AsbSavar-fars",200,4,10,6,AttackType.melee,0,1,0,"fars");
        new Minion("5","Pahlavan-fars",600,9,24,6,AttackType.melee,0,1,0,"fars");
        new Minion("6","Sepahsalar-fars",800,7,12,4,AttackType.melee,0,1,0,"fars");
        new Minion("7","Kamandar-toorani",500,1,3,4,AttackType.ranged,1,5,0,"toorani");
        new Minion("8","GhollabSangdar-toorani",600,1,4,2,AttackType.ranged,1,7,0,"toorani");
        new Minion("9","NeizeDar-toorani",600,1,4,4,AttackType.hybrid,1,3,0,"toorani");
        new Minion("10","Jasoos-toorani",700,4,6,6,AttackType.melee,0,1,0,"toorani");
        new Minion("11","GorzDar-toorani",450,2,3,10,AttackType.melee,0,1,0,"toorani");
        new Minion("12","Shahzade-toorani",800,6,6,10,AttackType.melee,0,1,0,"toorani");
        new Minion("13","Div-siah",300,9,14,10,AttackType.hybrid,0,7,0,"div");
        new Minion("14","Ghool-SangAndaz",300,9,12,12,AttackType.ranged,1,7,0,"ghool");
        new Minion("15","Oghab",200,2,0,2,AttackType.ranged,1,3,0,"");
        new Minion("16","Div-gorazSavar",300,6,16,8,AttackType.melee,0,1,0,"div");
        new Minion("17","Ghool-takCheshm",500,7,12,11,AttackType.hybrid,0,3,0,"ghool");
        new Minion("18","Mar-sammi",300,4,5,6,AttackType.ranged,1,4,0,"");
        new Minion("19","Ezhdehay-atashAndaz",250,5,9,5,AttackType.ranged,1,4,0,"");
        new Minion("20","Shire-darande",600,2,1,8,AttackType.melee,0,1,0,"");
        new Minion("21","Mar-ghoolpeykar",500,8,14,7,AttackType.ranged,1,5,0,"");
        new Minion("22","Gorg-sefid",400,5,8,2,AttackType.melee,0,1,0,"");
        new Minion("23","Palang",400,4,6,2,AttackType.melee,0,1,0,"");
        new Minion("24","Gorg",400,3,6,1,AttackType.melee,0,1,0,"");
        new Minion("25","Jadoogar",550,4,5,4,AttackType.ranged,1,3,0,"jadoogar");
        new Minion("26","Jadoogar-aazam",550,6,6,6,AttackType.ranged,1,5,0,"jadoogar");
        new Minion("27","Jen",500,5,10,4,AttackType.ranged,1,4,0,"");
        new Minion("28","Goraz-vahshi",500,6,10,14,AttackType.melee,0,1,0,"");
        new Minion("29","Piran",400,8,20,12,AttackType.melee,0,1,0,"");
        new Minion("30","Giv",450,4,5,7,AttackType.ranged,1,5,0,"");
        new Minion("31","Bahman",450,8,16,9,AttackType.melee,0,1,0,"");
        new Minion("32","Ashkboos",400,7,14,8,AttackType.melee,0,1,0,"");
        new Minion("33","Iraj",500,4,6,20,AttackType.ranged,1,3,0,"");
        new Minion("34","Ghool-bozorg",600,9,30,8,AttackType.hybrid,0,2,0,"ghool");
        new Minion("35","Ghool-doSar",550,4,10,4,AttackType.melee,0,1,0,"ghool");
        new Minion("36","Nane-sarma",500,3,3,4,AttackType.ranged,1,5,0,"");
        new Minion("37","Foolad-zereh",650,3,1,1,AttackType.melee,0,1,0,"");
        new Minion("38","Siavash",350,4,8,5,AttackType.melee,0,1,0,"");
        new Minion("39","Shah-ghool",600,5,10,4,AttackType.melee,0,1,0,"ghool");
        new Minion("40","Arzhang-Div",600,3,6,6,AttackType.melee,0,1,0,"div");


    }
}
