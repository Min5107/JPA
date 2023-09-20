package jpa_basic;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] array = new int[n][2];

        for(int i=0; i<n; i++){
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }
        Arrays.sort(array,(o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i=0; i<n; i++){
            System.out.println(array[i][0] + " " + array[i][1]);
        }

    }
}