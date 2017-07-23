package org.abitpoisk;

/**
 * Created by Роман on 23.07.2017.
 */
//it connects to https://abitpoisk.org.ua, downloads data and saves it to PagesBuffer
public class PagesProducer extends Thread {
    private PagesBuffer pagesBuffer;
    @Override
    public void run() {
        //goig to the internet, downloading data and saving to buffer
        //we need to be synchronized by pagesBuffer, moreover by !exactly! !one! pageBuffer!
        for(int i = 0; i < 5; i++){
            try {
                // producing value e. g. going to the internet and downloading data
                Integer producedValue = new Integer(i);
                //System.out.println("Producer produce: " + producedValue);
                this.pagesBuffer.addLast(producedValue);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " has been interrupted");
                break;
            }
        }
    }
    public PagesProducer(PagesBuffer pagesBuffer){
        this(pagesBuffer, "PageProducer_" + Thread.activeCount());
    }
    public PagesProducer(PagesBuffer pagesBuffer, String name){
        this.pagesBuffer = pagesBuffer;
        this.setName(name);
    }
}
