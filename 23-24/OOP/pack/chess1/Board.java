import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {
    }

    /**
     * ok.
     */
    public void addPiece(Piece newPiece) {
        if (!validate(newPiece.getCoordinatesX(), newPiece.getCoordinatesY())) {
            return;
        }

        for (int i = 0; i < pieces.size(); i++) {
            int curX = pieces.get(i).getCoordinatesX();
            int curY = pieces.get(i).getCoordinatesY();
            if (curX == newPiece.getCoordinatesX() && curY == newPiece.getCoordinatesY()) {
                return;
            }
        }

        pieces.add(newPiece);
    }

    /**
     * ok.
     */
    public boolean validate(int coordinatesX, int coordinatesY) {
        return 1 <= coordinatesX && coordinatesX <= WIDTH
                && 1 <= coordinatesY && coordinatesY <= HEIGHT;
    }

    /**
     * ok.
     */
    public void removeAt(int coordinatesX, int coordinatesY) {
        for (int i = 0; i < pieces.size(); i++) {
            int curX = pieces.get(i).getCoordinatesX();
            int curY = pieces.get(i).getCoordinatesY();
            if (curX == coordinatesX && curY == coordinatesY) {
                pieces.remove(i);
                break;
            }
        }
    }

    /**
     * ok.
     */
    public Piece getAt(int coordinatesX, int coordinatesY) {
        for (int i = 0; i < pieces.size(); i++) {
            int curX = pieces.get(i).getCoordinatesX();
            int curY = pieces.get(i).getCoordinatesY();
            if (curX == coordinatesX && curY == coordinatesY) {
                return pieces.get(i);
            }
        }

        return null;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
