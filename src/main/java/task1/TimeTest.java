package task1;

import java.util.Scanner;

public class TimeTest {
      public static void main(String[] args) {
        TimeCount timeCount = new TimeCount(System.currentTimeMillis(),5);

        Thread threadSec = new Thread(()->{
            while (true){
                synchronized (timeCount){
                    timeCount.showNextTime();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadNotific = new Thread(()->{
            while (true){
                synchronized (timeCount){
                    timeCount.showNextNotification();
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadSec.start();
        threadNotific.start();

         while (true) {
             synchronized (timeCount) {
                 timeCount.setTime(System.currentTimeMillis());
             };

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
