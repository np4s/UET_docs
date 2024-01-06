public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * ok.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    /**
     * ok.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        if (!color.equals("white") && !color.equals("black")) {
            return;
        }
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    /**
     * ok.
     */
    public abstract String getSymbol();

    /**
     * ok.
     */
    public abstract boolean canMove(Board board, int endX, int endY);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * ok.
     */
    public boolean checkPosition(Piece piece) {
        return 1 <= piece.getCoordinatesX() && piece.getCoordinatesX() <= 8
                && 1 <= piece.getCoordinatesY() && piece.getCoordinatesY() <= 8;
    }
} 