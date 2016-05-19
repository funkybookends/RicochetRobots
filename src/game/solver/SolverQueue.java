/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.solver;

import game.State;
import java.util.Collection;

/**
 *
 * @author caspar
 */
public class SolverQueue {
    //private UniqueHeap<State> heap;
    private UniqueSearchHeap<State> heap;
    
    protected SolverQueue(){
        //heap = new UniqueHeap<>();
        heap = new UniqueSearchHeap<>();
    }
    
    protected void add(State newState){
        int value = newState.getMoveNumber();
        //heap.add(newState, value);
        heap.add(newState, value);
    }
    
    protected State pop(){
        //return heap.pop();
        return heap.pop();
    }

    protected void addAll(Collection<State> decendants) {
        decendants.stream().forEach(s -> add(s));
    }
    
    
}
