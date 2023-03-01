package programame.desembalse;

import java.util.Scanner;

public class Desembalse {
    public static int solve(int[] altures){
        int capacitat = 0;
        int alturaPoble = altures[altures.length - 1];
        for (int i = 0; i < altures.length; i++) {
            capacitat += alturaPoble - altures[i];
        }
        return capacitat;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int distancia = scanner.nextInt();
            if(distancia == 0)
                break;

            int[] altures = new int[distancia];
            for (int i = 0; i < distancia; i++) {
                altures[i] = scanner.nextInt();
            }

            System.out.println(solve(altures));
        }
    }
}
