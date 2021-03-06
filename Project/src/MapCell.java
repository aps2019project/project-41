import java.util.ArrayList;

public class MapCell {
    private Card card;
    private ArrayList<Item> items = new ArrayList<>();

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    void addCardToCell(Card card){
        if(this.getCard() == null){
          this.card = card;
        }
        else System.out.println("Error while adding card to cell");
    }

    void removeCardfromCell(){
        if(this.getCard() == null){
            System.out.println("Error! Cell is empty");
        }
        else{
            this.setCard(null);
        }
    }


}
