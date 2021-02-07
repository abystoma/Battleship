package battleship;

public enum Arsenal {
    AIRCRAFT("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    private String name;
    private int size;

    Arsenal (String name, int size) {
        this.name = name;
        this.size = size;        
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    } 
}
