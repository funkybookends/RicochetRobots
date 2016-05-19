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
public class Line {

    /**
     * The locations of the barriers
     */
    protected ArrayList<Integer> barriers;

    /**
     * constructor, makes a new empty array List
     */
    protected Line(){
        barriers = new ArrayList<>();
    }

    /**
     * Finds the landing location for a robot moving from origin in the 
     * direction of increasing, accounts for the other robots
     * @param robotBarriers the barriers created by the other robots
     * @param origin the starting position
     * @param increasing true if the robot is moving right or down
     * @return the landed upon position
     */
    protected Integer move(ArrayList<Integer> robotBarriers, 
                Integer origin, boolean increasing)
    {
            ArrayList<Integer> allBarriers = new ArrayList();
            allBarriers.addAll(this.barriers);
            allBarriers.addAll(robotBarriers);
            
            if (increasing){                
                return allBarriers.stream()
                        .filter(s -> s > origin)
                        .min(Integer::compare).get() - 1;
                //Minus 1 since barriers are always to the top left of a square
            }
            else {
                return allBarriers.stream()
                        .filter(s -> s <= origin)
                        .max(Integer::compare).get();
            }

        }
    }
