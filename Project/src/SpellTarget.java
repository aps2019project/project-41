public class SpellTarget {
    private Spell spell;
    private boolean canSelectTheCell;
    //1->true   0->false    -1 ->all
    private int onEnemy;
    private int onHero;
    private int onMinion;
    private int squareSideLength;

    private Spell getSpell() {
        return spell;
    }

    public boolean CanSelectTheCell() {
        return canSelectTheCell;
    }

    public int getOnEnemy() {
        return onEnemy;
    }

    public int getOnHero() {
        return onHero;
    }

    public int getOnMinion() {
        return onMinion;
    }

    public int getSquareSideLength() {
        return squareSideLength;
    }

    public SpellTarget(Spell spell, boolean canSelectTheCell, int onEnemy, int onHero, int onMinion, int squareSideLength) {
        this.spell = spell;
        this.canSelectTheCell = canSelectTheCell;
        this.onEnemy = onEnemy;
        this.onHero = onHero;
        this.onMinion = onMinion;
        this.squareSideLength = squareSideLength;
    }

    public boolean checkIfIsTarget(Map map, int x, int y) {
        Card card = map.getMapCells()[x][y].getCard();
        if (squareSideLength > 1) {

        } else if (card != null) {
            boolean isEnemy = (card.getPlayer() != getSpell().getPlayer());
            if ((onEnemy == 1 && isEnemy) || (onEnemy == 0 && !isEnemy) || onEnemy == -1) {
                if ((card.getCardType().equals("Hero") && onHero == 1) ||
                        (card.getCardType().equals("Minion") && onMinion == 1)) {
                        return true;
                }
            }
        }
        return false;
    }
}

