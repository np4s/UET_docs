public class Rook extends Piece {
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    /**
     * ok.
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * ok.
     */
    @Override
    public boolean canMove(Board board, int endX, int endY) {
        int startX = this.getCoordinatesX();
        int startY = this.getCoordinatesY();

        if (endX != startX && endY != startY) {
            return false;
        }

        if (!checkPosition(this)) {
            return false;
        }

        if (endX == startX) {
            int moveY = endY < startY ? -1 : 1;
            for (int i = 1; i < Math.abs(endY - startY); i++) {
                if (board.getAt(startX, startY + i * moveY) != null) {
                    return false;
                }
            }
        } else {
            int moveX = endX < startX ? -1 : 1;
            for (int i = 1; i < Math.abs(endX - startX); i++) {
                if (board.getAt(startX + i * moveX, startY) != null) {
                    return false;
                }
            }
        }

        if (board.getAt(endX, endY) != null) {
            return (!board.getAt(endX, endY).getColor().equals(this.getColor()));
        }

        return true;
    }
}
