/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.solver;

import game.Board;
import game.Direction;
import game.Robot;
import game.Square;
import game.State;
import game.Target;

/**
 *
 * @author caspar
 */
public class Solver {
    private final Board board;
    private final State startState;
    private final Robot robot;
    private final Target target;
    private Solution solution;

    public Solver(Board board, State startState, Robot robot, Target target){
        this.board = board;
        this.startState = startState;
        this.robot = robot;
        this.target = target;
    }
    /**
     * @return the solution
     */
    public Solution getSolution() {
        if (this.solution == null) solve();
        return solution;
    }
    
    private void solve(){
        SolverQueue queue = new SolverQueue();
        startState.setStartState();
        queue.add(startState);
        
        State frontier;
        int max = 2<<16;
        int cur = 0;
        
        do {
            cur++;
            frontier = queue.pop();
            if (isWin(frontier, robot, target)) {
                break;
            }
            else {
                for (Robot robotName : frontier){
                    for (Direction d : Direction.values()){
                        queue.add(frontier.getDecendant(board, robotName, d));
                    }
                }
            }
                    
        } while (cur < max);
        
        if (isWin(frontier,robot,target)){
            //solution has been found, it is frontier
            target.setVisited();
            this.solution = new Solution(frontier, board);
        } 
    }
    
    private boolean isWin(State s, Robot robot, Target target){
        Square robotLoc =  s.findRobot(robot);
        Square targetLoc = target.getLocation();
        return robotLoc.equals(targetLoc);
    }
    
    
}
