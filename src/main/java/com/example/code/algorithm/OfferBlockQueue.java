package com.example.code.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列
 */
public class OfferBlockQueue {
    //容器
    private List<Integer> list=new ArrayList<>();
    private volatile int size;//实际容量
    private volatile int capacity;//允许容量
    private Lock lock=new ReentrantLock();
    //condition
    private Condition isNull=lock.newCondition();
    private Condition isFull=lock.newCondition();

    OfferBlockQueue(int cap){
        this.capacity=cap;
    }
    public void add(int data){
        try{
            lock.lock();
            try {
                while(size>=capacity){
                    System.out.println("--------满了");
                    isFull.await();
                }

            } catch (InterruptedException e) {
                isFull.signal();
                e.printStackTrace();
            }
            size++;
            list.add(data);
            isNull.signal();
        }
        finally{
            lock.unlock();
        }
    }

    public int take(){
        try{
            lock.lock();
            try {
                while(size==0){
                    System.out.println("--------空了");
                    isNull.await();
                }
            } catch (InterruptedException e) {
                isNull.signal();
                e.printStackTrace();
            }
            size--;
            int data=list.get(0);
            list.remove(0);
            isFull.signal();
            return data;
        }
        finally{
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        OfferBlockQueue queue = new OfferBlockQueue(5);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                queue.add(i);
                System.out.println("塞入" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (; ; ) {
                System.out.println("消费"+queue.take());
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
    }
}
