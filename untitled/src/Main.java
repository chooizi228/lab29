import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите десятичное число: ");
        int decimal = scanner.nextInt();

        int binary = 0;
        int remainder;
        int power = 0;

        while (decimal > 0) {
            remainder = decimal % 2;
            binary += remainder * Math.pow(10, power);
            decimal /= 2;
            power++;
        }

        System.out.println("Двоичное представление: " + binary);
    }
}

