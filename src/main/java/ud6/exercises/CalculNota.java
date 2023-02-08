package ud6.exercises;

import java.util.Locale;
import java.util.Scanner;

public class CalculNota {
    private static final double WEIGHT_PRACTICES = 0.4;
    private static final double WEIGHT_EXAMS = 0.6;
    private static final double MIN_PRACTICES = 5;
    private static final double MIN_EXAMS = 4;
    private static final double MIN_TOTAL = 5;
    private static final double MARGE_LLINDAR = 0.25;
    private static final int LLINDARS_PERMESOS = 1;

    public static double calcularNotaToal(double practices, double exams){
       return practices * WEIGHT_PRACTICES + exams * WEIGHT_EXAMS;
    }

    public static int calcularLlindarsSuperats(double practices, double exams, double total){
        int llindarsSuperats = 0;
        if(exams < MIN_EXAMS && exams >= MIN_EXAMS - MARGE_LLINDAR)
            llindarsSuperats++;
        if(practices < MIN_PRACTICES && practices >= MIN_PRACTICES - MARGE_LLINDAR)
            llindarsSuperats++;
        if(total <  MIN_TOTAL && total >= MIN_TOTAL - MARGE_LLINDAR)
            llindarsSuperats++;
        return llindarsSuperats;
    }

    public static boolean passaMinimsRequerits(double practices, double exams, double total, int llindarSuperats){
        boolean passaExam = exams >= MIN_EXAMS - MARGE_LLINDAR;
        boolean passaPractices = practices >= MIN_PRACTICES - MARGE_LLINDAR;
        boolean passaTotal = total >= MIN_TOTAL - MARGE_LLINDAR;
        boolean passaLlindars = llindarSuperats <= LLINDARS_PERMESOS;
        return passaExam && passaPractices && passaTotal && passaLlindars;
    }

    public static String calcularNotaButlleti(double practices, double exams, double total, int llindarsSuperats){
        boolean passaMinimsRequirits = passaMinimsRequerits(practices, exams, total, llindarsSuperats);
        if (!passaMinimsRequirits)
            return "No superat";
        else if (total >= 9)
            return "Excel·lent";
        else if (total >= 7)
            return "Notable";
        else if (total >= 6)
            return "Bé";
        else
            return "Suficient";
    }

    public static String calcularNota(double practices, double exams){
        double total = calcularNotaToal(practices, exams);
        int llindarsSuperats = calcularLlindarsSuperats(practices, exams, total);
        String notaButlleti = calcularNotaButlleti(practices, exams, total, llindarsSuperats);
        return notaButlleti;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Nota de pràctiques:");
        double practices = in.nextDouble();
        System.out.println("Nota d'exàmens:");
        double exams = in.nextDouble();

        System.out.println(calcularNota(practices, exams));
    }
}