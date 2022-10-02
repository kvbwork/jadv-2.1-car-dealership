package kvbdev;

import java.util.LinkedList;
import java.util.Queue;

public class CarDealership {
    private Queue<Car>  queue = new LinkedList<>();

    public synchronized void accept(Car car){
        queue.add(car);
        notify();
    }

    public synchronized boolean isEmpty(){
        return queue.isEmpty();
    }

    public synchronized Car get() throws InterruptedException {
        if (isEmpty()){
            System.out.println("Машин нет");
            wait();
        }
        return queue.poll();
    }

}
