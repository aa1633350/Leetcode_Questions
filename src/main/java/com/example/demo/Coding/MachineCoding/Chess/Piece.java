package com.example.demo.Coding.MachineCoding.Chess;

public abstract class Piece {

    Position currentPosition;
    Board currentBoard;
    public void move(Position destination) {

        if(isValid(currentPosition,destination)) {

            currentPosition = destination;
        }
        Piece destinationPiece = currentBoard.get(destination);
        if(destinationPiece != null) {

        }
    }

    boolean isValid(Position start, Position end) {
        Board temp = currentBoard;
        temp.makeMove(this, end);
        // If your king is in check then you are not allowed to move
        if(currentKingInCheck(temp)) {
            return false;
        } else {
            Piece destinationPiece = currentBoard.get(end);
//            if(destinationPiece != null && destinationPiece.getColor().equals(color)) {
//                return false;
//            }
            return isValidMove();
        }
    }

//     public Color getColor() {
//        return color;
//     }

    abstract boolean isValidMove();

    boolean currentKingInCheck(Board board) {
        return false;
    }

    abstract void getAllPossibleMoves();
}
