/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.solver;

import game.Board;
import game.State;
import java.util.ArrayList;

/**
 *
 * @author caspar
 */
public class Solution {
    private ArrayList<State> sol;
    private Board board;

    public Solution(State winState, Board board) {
        this.board = board;
        
        sol = new ArrayList<>();        
        while (winState.getParent() != null){
            sol.add(0, winState);
            winState = winState.getParent();
        }
        
    }
    
    public String toString(){
        StringBuilder out = new StringBuilder();
        int move = 0;
        for (State s : sol){
            out.append(move++ + ". " + s.getInstructions());
            out.append("\n");
            out.append(board.toString(s));
            out.append("\n");
        }
        return out.toString();
    }
    
}
