public class Map {
    private MapCell[][] mapCells;

    public Map() {
        this.mapCells = new MapCell[5][9];
    }

    public MapCell[][] getMapCells() {
        return mapCells;
    }

    public void moveCard(MapCell fromCell, MapCell toCell) {
        toCell = fromCell;
        fromCell = null;
    }

    public void addCardToMap(Card card, MapCell cell) {
        cell.setCard(card);
    }

    public void attack(MapCell fromCell, MapCell toCell) {

    }

}
