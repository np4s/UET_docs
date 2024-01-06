import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game() {
    }

    public Game(Board board) {
        this.board = board;
    }

    /**
     * ok.
     */
    public void movePiece(Piece piece, int endX, int endY) {
        if (piece.canMove(board, endX, endY)) {
            Move move = new Move(piece.getCoordinatesX(), endX,
                    piece.getCoordinatesY(), endY, piece);
            Piece killedPiece = board.getAt(endX, endY);
            if (killedPiece != null) {
                move.setKilledPiece(killedPiece);
                board.removeAt(killedPiece.getCoordinatesX(), killedPiece.getCoordinatesY());
            }

            piece.setCoordinatesX(endX);
            piece.setCoordinatesY(endY);

            moveHistory.add(move);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
