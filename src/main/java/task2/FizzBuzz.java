package task2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FizzBuzz {
    private static final int FIZZ_BUZZ = 15;
    private static final int FIZZ = 3;
    private static final int BUZZ = 5;
    private int currentNumeric;

    private Queue<String> result = new LinkedList<>();

    private String comma = "";
    private boolean isFizzBuzz = true;
    private boolean isFizz = true;
    private boolean isBuzz = true;

    public boolean processEnd() {
        return isFizzBuzz && isBuzz && isFizz && result.isEmpty();
    }

    public boolean processNextNumeric(int nextNumeric) {
        if (isFizzBuzz && isFizz && isBuzz) {
            synchronized (this) {
                currentNumeric = nextNumeric;
                isFizzBuzz = false;
                isFizz = false;
                isBuzz = false;
                return true;
            }
        }

        return false;
    }

    public void fizzBuzz() {
        if (!isFizzBuzz && !isFizz && !isBuzz) {
            synchronized (this) {
                if (currentNumeric % FIZZ_BUZZ == 0) {
                    result.add("fizzbuzz");
                    isFizzBuzz = true;
                    isFizz = true;
                    isBuzz = true;
                } else {
                    isFizzBuzz = true;
                }
            }
        }
    }

    public void fizz() {
        if (isFizzBuzz && !isFizz) {
            synchronized (this) {
                if (currentNumeric % FIZZ == 0) {
                    result.add("fizz");
                    isFizzBuzz = true;
                    isFizz = true;
                    isBuzz = true;
                } else {
                    isFizz = true;
                }
            }

        }
    }

    public void buzz() {
        if (isFizz && !isBuzz) {
            synchronized (this) {
                if (currentNumeric % BUZZ == 0) {
                    result.add("buzz");
                } else {
                    result.add(String.valueOf(currentNumeric));
                }
                isFizzBuzz = true;
                isFizz = true;
                isBuzz = true;
            }
        }
    }

    public void number() {
        if (!result.isEmpty()) {
            System.out.print(comma + result.remove());
            comma = ", ";
        }
    }
}
