package Generics.Introducao;

import java.util.Scanner;

public class ExemploGenerics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintService<Integer> printService = new PrintService<>();

        System.out.println("Quantos valores?");
        int length = sc.nextInt();

        for (int index = 0; index < length; index++) {
            int value = sc.nextInt();
            printService.add(value);
        }

        printService.print();
    }
}
