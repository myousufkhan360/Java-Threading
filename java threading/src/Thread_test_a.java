/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lab1
 */

import static java.lang.Thread.sleep;

import java.util.*;

class cntr {
    
    public static int count = 0;
}


 class cl_do {
    
     Random rnd = new Random();
    
     public void sleep_now()throws InterruptedException {
         
         int x_period;
         x_period = rnd.nextInt() % 200;
         if(x_period < 0)
             x_period = -x_period;
         sleep(x_period);
     }
     
     public void show_t() {
         int k;
         String x_name = Thread.currentThread().getName();
         try {
             for(k=0; k<12; k++){
                 sleep_now();
                 System.out.println(" " + x_name + " " +k);
                 if ((cntr.count + 1)% 4 == 0)
                     System.out.println();
                 cntr.count++;
             }
         }
         catch (InterruptedException e){
             System.out.println(x_name + "Interrupted");
         }
     }
 }

class clthr_x extends Thread {
    cl_do do_ref;
    clthr_x(String name, cl_do x_ref){
        
        super(name);
        do_ref = x_ref;
        start();
    }
    
    public void run(){
        do_ref.show_t();
    }
}


public class Thread_test_a{
    
    public static void main(String args[])
    {
        cl_do do_ob = new cl_do();
        
        try {
            System.out.println("===================================");
            System.out.println("Executing Multiple Threads: ");
            clthr_x thr_a = new clthr_x("I am A",do_ob);
            clthr_x thr_b = new clthr_x("I am B",do_ob);
            clthr_x thr_c = new clthr_x("I am C",do_ob);
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println("Main Interrupted");
        }
    }
}