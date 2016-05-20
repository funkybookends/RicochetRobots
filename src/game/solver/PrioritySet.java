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
class PrioritySet<Key> {
    private final ArrayList<Key> heap;
    private final HashMap<Key, Integer> entries;
        
    protected PrioritySet(){
        heap = new ArrayList<>();
        entries = new HashMap<>();
    }
    
    protected void add(Key newKey, Integer newValue){
        if (!entries.containsKey(newKey)){
            //add brand new key
            heap.add(newKey);
            entries.put(newKey, newValue);
            siftUp();
        }
        else if (entries.get(newKey) > newValue){
            //update if better
            entries.replace(newKey, newValue);
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
        siftDown();
        print();
        test();
        return r;
    }
    
    private void siftDown(){
        int k = 0;
        int l = 2*k+1;
        while (l < heap.size()){
            int max=l, r=l+1;
            if (r < heap.size()) {
                if (aGTb(l, r)){
                    max++;
                }
            }
            if (aGTb(k, max)){
                Key temp = heap.get(k);
                heap.set(k, heap.get(max));
                heap.set(max, temp);
                k = max;
                l = 2*k +1;
                System.out.println("swapped");
            }
            else {
                break;
            }
        }
        test();
    }
    
    private void siftUp(int k){
        while (k>0) {
            int p = (k-1)/2;
            Key item = heap.get(k);
            Key parent = heap.get(p);
            
            if (!aGTb(item, parent)){
                heap.set(k, parent);
                heap.set(p, item);
                
                k=p;
            }
            else {
                break;
            }
        }
        test();
    }
    
    private void siftUp(){
        siftUp(heap.size()-1);
    }
    
    private boolean aGTb(Key a, Key b){
        return entries.get(a) > entries.get(b);
    }
    
    private boolean aGTb(int a, int b){
        return entries.get(heap.get(a)) > entries.get(heap.get(b));
    }
    
    private void print(){
        int i = 0;
        for (Key k : heap){
            System.out.println(i + " " + k.toString() + " - " + entries.get(k));
            i++;
        }
        System.out.println();
    }
    
    private void test(){
        for (int i = 0; i<heap.size(); i ++){
            int l = (2*i) + 1;
            int r = (2*2) + 2;
            assert(aGTb(l, i));
            assert(aGTb(r, i));
        }
        System.out.println("Test passed");
    }
    
}
