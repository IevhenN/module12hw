package task2;

class FizzBuzz {
    private final int maxNumber;
    private int currentNumber = 1;

    public FizzBuzz(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (currentNumber <= maxNumber) {
            if (currentNumber % 15 == 0) {
                System.out.println("fizzbuzz");
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizz() throws InterruptedException {
        while (currentNumber <= maxNumber) {
            if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                System.out.println("fizz");
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (currentNumber <= maxNumber) {
            if (currentNumber % 3 != 0 && currentNumber % 5 == 0) {
                System.out.println("buzz");
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (currentNumber <= maxNumber) {
            if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                System.out.println(currentNumber);
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}
