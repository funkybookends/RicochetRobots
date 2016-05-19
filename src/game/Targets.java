/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author caspar
 */
class Targets implements Iterable<Target> {
    private ArrayList<Target> targets;

    @Override
    public Iterator<Target> iterator() {
        return targets.iterator();
    }
    
    public Targets(){
        targets = new ArrayList<>();
    }
    
    public void mapTarget(Target target, Square location){
        target.setLocation(location);
        targets.add(target);
    }    
}
