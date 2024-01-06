public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    /**
     * ok.
     */
    public String getSymbol() {
        return "B";
    }

    /**
     * ok.
     */
    public boolean canMove(Board board, int endX, int endY) {
        int startX = this.getCoordinatesX();
        int startY = this.getCoordinatesY();

        if (Math.abs(startY - endY) != Math.abs(startX - endX)) {
            return false;
        }

        int moveX = startX > endX ? -1 : 1;
        int moveY = startY > endY ? -1 : 1;
        for (int i = 1; i < Math.abs(startY - endY); i++) {
            int curX = startX + moveX * i;
            int curY = startY + moveY * i;

            if (board.getAt(curX, curY) != null) {
                return false;
            }
        }

        Piece killedPiece = board.getAt(endX, endY);
        if (killedPiece != null && killedPiece.getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }
}
