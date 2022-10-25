package com.example.demo.Coding.MachineCoding.Chess;

import java.util.HashMap;
import java.util.Map;

public class Board {

    Map<Position,Piece> pieces = new HashMap<>();
    public void makeMove(Piece piece, Position destinaion) {
        pieces.remove(piece.currentPosition);
        pieces.put(destinaion,piece);

    }

    public Piece get(Position destination) {
        if(pieces.get(destination)!=null) {
            return pieces.get(destination);
        }
        return null;
    }
}
