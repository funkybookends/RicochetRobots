/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 *
 * @author caspar
 */
class UniqueSearchHeap<Key> {
    private ArrayList<Key> heap;
    private HashMap<Key, Entry> entries;
    
    private class Entry{
        private int value;
        private boolean popped;
        
        private Entry(int value){
            this.value = value;
            this.popped = false;
        }
    }
        
    protected UniqueSearchHeap(){
        heap = new ArrayList<>();
        entries = new HashMap<>();
    }
    
    protected void add(Key newKey, Integer newValue){
        if (!entries.containsKey(newKey)){
            //add brand new key
            heap.add(newKey);
            entries.put(newKey, new Entry(newValue));
            System.out.println(newKey.toString());
            siftUp();
        }
        else if (newValue < entries.get(newKey).value){
            //update if better
            entries.get(newKey).value = newValue;
            int location = heap.indexOf(newKey);
            siftUp(location);
        }
        //do nothing because it's worse
    }
    
    protected Key pop() throws NoSuchElementException {
        if (heap.isEmpty()){
            throw new NoSuchElementException();
        }
        if (heap.size() == 1){
            return heap.remove(0);
        }
        Key r = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        entries.get(r).popped = true;
        siftDown();
        return r;
    }
    
    private void siftDown(){
        int k = 0;
        int l = 2*k+1;
        while (l < heap.size()){
            int max=l, r=l+1;
            if (r < heap.size()) {
                if (entries.get(heap.get(r)).value > entries.get(heap.get(l)).value){
                    max++;
                }
            }
            if (entries.get(heap.get(k)).value < entries.get(heap.get(max)).value){
                Key temp = heap.get(k);
                heap.set(k, heap.get(max));
                heap.set(max, temp);
                k = max;
                l = 2*k +1;
            }
            else {
                break;
            }
        }
    }
    
    private void siftUp(int k){
        while (k>0) {
            int p = (k-1)/2;
            Key item = heap.get(k);
            Key parent = heap.get(p);
            
            if (entries.get(item).value > entries.get(parent).value){
                heap.set(k, parent);
                heap.set(p, item);
                
                k=p;
            }
            else {
                break;
            }
        }
    }
    
    private void siftUp(){
        siftUp(heap.size()-1);
    }
    
}
