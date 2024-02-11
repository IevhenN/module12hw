package task2;

public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        int n = 15;

        Thread threadA = new Thread(() -> {
            while (true) {
                fizzBuzz.fizz();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadB = new Thread(() -> {
            while (true) {
                fizzBuzz.buzz();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadC = new Thread(() -> {
            while (true) {
                fizzBuzz.fizzBuzz();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadD = new Thread(() -> {
            while (true) {
                fizzBuzz.number();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        for (int i = 1; i <= n; i++) {
            while (!fizzBuzz.processNextNumeric(i)) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        while (!fizzBuzz.processEnd()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.exit(0);
    }
}
