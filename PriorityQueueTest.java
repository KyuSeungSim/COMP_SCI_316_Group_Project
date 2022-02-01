/*
 * Project: Class Assignment Week 13
 * Group: 11
 * Name: Nicholas Daniels, KyuSeung Sim
 * Class: COMP SCI 316-0800
 * Date: DEC 01 2020
 */

import java.util.PriorityQueue;

public class PriorityQueueTest {
   public static void main(String[] args) {
                           
      PriorityQueue<SpaceTime> queue = new PriorityQueue<>();
      
      // insert elements to queue
      queue.offer(new SpaceTime(3.4, 9.8, 5.4, 2, 30, 55));          
      queue.offer(new SpaceTime(4.3, 8.9, 4.5, 5, 45, 30));  
      queue.offer(new SpaceTime(0.0, 0.0, 0.0, 0, 00, 00)); 

      System.out.println("Polling from queue List");
      System.out.println();
      
      // display elements in queue
      while(!queue.isEmpty()) {
    	  System.out.println(queue.poll()); // view top element
      }
   } 
}