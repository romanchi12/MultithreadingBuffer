package org.abitpoisk;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Роман on 23.07.2017.
 */
public class PagesBuffer extends LinkedList {
    int MAX_PAGES = 2;
    @Override
    public synchronized Object removeFirst() {
        while(this.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object o =  super.removeFirst();
        System.out.println("Consumer consume " + o);
        this.notifyAll();
        return o;
    }

    @Override
    public synchronized void addLast(Object o) {
        while(this.size() + 1 > MAX_PAGES){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer produce " + o);
        super.addLast(o);
        this.notifyAll();
    }
}
