

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        long end = System.currentTimeMillis();
        System.out.println("--- Using String + ---");
        System.out.println("Execution time: " + (end - start) + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2)); 
        }
        s = sb.toString();
        end = System.currentTimeMillis();
        System.out.println("\n--- Using StringBuilder ---");
        System.out.println("Execution time: " + (end - start) + " ms"); 
    }
}