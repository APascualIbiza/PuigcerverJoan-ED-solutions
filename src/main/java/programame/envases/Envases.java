package programame.envases;

import java.util.Scanner;

public class Envases {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCases = scanner.nextInt();
        for (int i = 0; i < nCases; i++) {
            int pesNet = scanner.nextInt();
            int pesTotal = scanner.nextInt();

            int pesEnvase = pesTotal - pesNet;

            System.out.println(pesEnvase);
        }
    }
}
