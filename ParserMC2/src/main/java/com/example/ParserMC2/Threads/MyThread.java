package com.example.ParserMC2.Threads;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {

    public void run(){
       try {
           System.out.println("In thread");
           TimeUnit.SECONDS.sleep(2);
           System.out.println("DONE");
           System.exit(0);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}