public class Main {

    public static void main(String[] args) {

        double[] numbers = {3.14, 1.618, -4.2, 0, 2.7, -9.8, 6.6, -3, 7, -1.1, 8.9, -5.5, 10.01, -2.2, 4.444};

        double sum = 0;
        int counter = 0;
        boolean afterNegative = false;
        for (double number : numbers) {
            if (number < 0) {
                afterNegative = true;
                continue;
            }
            if (afterNegative) {
                sum += number;
                counter ++;
            }
        }

        System.out.println("Sum: " + sum + " counter: " + counter);
        System.out.println(sum / counter);

    }

}