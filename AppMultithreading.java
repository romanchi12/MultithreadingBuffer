package org.abitpoisk;

/**
 * Created by Роман on 23.07.2017.
 */
public class AppMultithreading {
    public static void main(String...args){
        PagesBuffer pagesBuffer = new PagesBuffer();
        PagesProducersPool pagesProducersPool = new PagesProducersPool(pagesBuffer,4);
        PagesConsumerPool pagesConsumerPool = new PagesConsumerPool(pagesBuffer, 2);
        pagesProducersPool.poolStart();
        pagesConsumerPool.poolStart();
        pagesConsumerPool.poolInterrupt();
    }
}
