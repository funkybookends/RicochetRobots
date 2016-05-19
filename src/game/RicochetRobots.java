/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.solver.Solution;
import game.solver.Solver;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author caspar
 */
public class RicochetRobots {
    private Board board; // holds the permenant barriers
    private State state; // State of game i.e. where robots are
        
    public RicochetRobots(FileInputStream fis){
        Scanner in = new Scanner(fis);
        String sline = in.nextLine();
        int insize = sline.length();
        int boardSize = insize/2;
        char charBoard[][] = new char[insize][insize];
        for (int i = 0; i < insize; i++){
            for (int j = 0; j< insize; j++){
                charBoard[i][j] = sline.charAt(j);
            }
            if (in.hasNextLine()) sline = in.nextLine();
        }
        this.board = new Board(charBoard, insize);
       
        state = new State(charBoard, insize);
    }
    
    public String toString(){
        return board.toString(state);
    }
    
    public String toString(State s){
        return board.toString(s);
    }
    
    public Solution solve(Robot r, Target t){
        return new Solver(board, state, r, t).getSolution();
    }
    
    public void setState(State newState){
        this.state = newState;
    }
   
}
