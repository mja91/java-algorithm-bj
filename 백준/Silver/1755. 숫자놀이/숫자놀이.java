import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);

        Integer[] numbers = new Integer[end - start + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = start + i;
        }

        Arrays.sort(numbers, Comparator.comparing(num -> convertToWords(num)));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append(" ");
            if ((i + 1) % 10 == 0 || i == numbers.length - 1) {
                System.out.println(sb.toString().trim());
                sb = new StringBuilder();
            }
        }
    }

    static String convertToWords(int number) {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder result = new StringBuilder();
        if (number == 0) {
            return digits[0];
        }
        while (number > 0) {
            int digit = number % 10;
            result.insert(0, digits[digit] + " ");
            number /= 10;
        }
        return result.toString().trim();
    }
}
