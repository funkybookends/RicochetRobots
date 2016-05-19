/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author caspar
 */
public class Square {
    protected final int row;
    protected final int col;

    protected Square(int x, int y){
        row = x;
        col = y;
    }
    
    public boolean equals(Square s){
        return s.col == this.col && s.row == this.row;
    }
    
    public String toString(){
        return "("+row+","+col+")";
    }
}