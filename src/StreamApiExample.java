import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class StreamApiExample {

    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть число (або 'exit' для завершення введення): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Неправильний формат числа. Спробуйте ще раз.");
            }
        }


        int sumOfEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сума парних чисел: " + sumOfEvenNumbers);


        List<Integer> doubledNumbers = numbers.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
        System.out.println("Числа, помножені на 2: " + doubledNumbers);


        int maxNumber = numbers.stream()
                .max(Integer::compare)
                .orElse(0);
        System.out.println("Максимальне число: " + maxNumber);


        String oddNumbersAsString = numbers.stream()
                .filter(num -> num % 2 != 0)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Непарні числа: " + oddNumbersAsString);


        double average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println("Середнє арифметичне: " + average);

        scanner.close();
    }

}