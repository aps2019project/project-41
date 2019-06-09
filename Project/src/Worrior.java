public interface Worrior {
    default void attack(Card targetCard){
        if(targetCard instanceof Hero)
            ((Hero)targetCard).setHp(((Hero)targetCard).getHp() - this.ap);
        else if(targetCard instanceof Minion)
            ((Minion)targetCard).setHp(((Hero)targetCard).getHp() - this.ap);

    }

    default void counterAttack(Card targetCard){
        this.attack(targetCard);
    }
}
