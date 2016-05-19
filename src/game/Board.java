/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author caspar
 */
public class Board {
    private final int boardSize;
    private final Targets targets;

    /**
     * Holds the row barriers of the board
     */
    public final Line[] rows;

    /**
     * holds the col barriers of the board
     */
    public final Line[] cols;

    /**
     * Parses a charBoard to find all the permenant barriers
     * @param board the charBoard to parse
     * @param insize the size of the board
     */
    protected Board(char[][] board){
        int insize = board.length * 2 + 1;
        this.boardSize = insize/2;
        rows = new Line[boardSize];
        cols = new Line[boardSize];

        for (int i = 0; i < boardSize; i++){
            rows[i] = new Line();
            cols[i] = new Line();
        }

        for (int i = 0; i < insize; i += 2){
            for (int j = 1; j < insize; j += 2){
                if (board[i][j] == '-') cols[j/2].barriers.add(i/2);
            }
        }

        for (int i = 1; i < insize; i += 2){
            for (int j = 0; j < insize; j += 2){
                if (board[i][j] == '|') rows[i/2].barriers.add(j/2);
            }
        }
        
                //get Targets
        targets = new Targets();
        for (int i = 1; i < insize - 1; i+=2){
            for (int j =1; j < insize -1; j +=2){
                if (Target.isTarget(board[i][j])){
                    Square loc = new Square(i/2,j/2);
                    Target targetName = Target.getByLabel(board[i][j]);
                    targets.mapTarget(targetName, loc);
                }
            }
        }
    }
    
    public String toString(State state){
        int outSize = boardSize*2+1;
        char outBoard[][] = new char[outSize][outSize];
        for (int i = 0; i < outSize; i++){
            for (int j = 0; j < outSize; j++){
                outBoard[i][j] = ' ';
            }
        }
        for (int i = 0; i < outSize; i += 2){
            for (int j = 0; j < outSize; j += 2){
                outBoard[i][j] = '+';
            }
        }
        for (int i = 0; i < boardSize; i++){
            for (Integer barrier : rows[i].barriers) {
                outBoard[i*2+1][barrier*2] = '|';
            }
            for (Integer barrier : cols[i].barriers) {
                outBoard[barrier*2][i*2+1] = '-';
            }
        }
//        for (Character target : targets.keySet()){
//            Square loc = targets.get(target);
//            int x = loc.row*2+1;
//            int y = loc.col*2+1;
//            outBoard[x][y] = target;
//        }

        for (Target t : targets){
            Square loc = t.location;
            int x = loc.row*2+1;
            int y = loc.col*2+1;            
            outBoard[x][y] = t.toString().charAt(0);
            
        }
        for (Robot robot : state){
            Square loc = state.findRobot(robot);            
            int x = loc.row*2+1;
            int y = loc.col*2+1;
            outBoard[x][y] = robot.toString().charAt(0);
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < outSize; i++){
            for (int j = 0; j < outSize; j++){
                out.append(outBoard[i][j]);
            }
            out.append("\n");
        }
        return out.toString();                
    }

    /**
     * Finds the landing square
     * @param slider the name of the robot to move
     * @param dir in the direction
     * @param state will account for robots in state
     * @return Square the landed position
     */
    protected Square slide(Robot slider, Direction dir, State state){
        Square origin = state.findRobot(slider);
        Line movementLine;
        if (dir.movesOnRow){
            movementLine = rows[origin.row];
        }
        else {
            movementLine = cols[origin.col];
        }
        ArrayList<Integer> robotBarriers = new ArrayList<>();

        for (Robot robot : state){
            if (robot != slider){
                Square robotLoc = state.findRobot(robot);
                if (dir.movesOnRow && robotLoc.row == origin.row){
                    robotBarriers.add(robotLoc.col);
                    robotBarriers.add(robotLoc.col+1);
                }
                if (!dir.movesOnRow && robotLoc.col == origin.col){
                    robotBarriers.add(robotLoc.row);
                    robotBarriers.add(robotLoc.row+1);
                }
            }
        }

        if (dir.movesOnRow){
            Integer col = movementLine.move(robotBarriers, 
                    origin.col, dir.increasing);
            return new Square(origin.row, col);
        }
        else {
            Integer row = movementLine.move(robotBarriers, 
                    origin.row, dir.increasing);
            return new Square(row, origin.col);
        }

    }
    
    
    
}
