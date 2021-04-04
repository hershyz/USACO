import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //User input:
        Scanner scn = new Scanner(System.in);
        String rawParam1 = scn.nextLine();
        String[] rawArr1 = rawParam1.split(" ");
        int[] NL = new int[rawArr1.length];
        for (int i = 0; i < NL.length; i++) {
            NL[i] = Integer.valueOf(rawArr1[i]);
        }
        String rawParam2 = scn.nextLine();
        String[] rawArr2 = rawParam2.split(" ");
        int[] citations = new int[rawArr2.length];
        for (int i = 0; i < citations.length; i++) {
            citations[i] = Integer.valueOf(rawArr2[i]);
        }

        int current = hIndex(citations);
        int allowed = NL[1];

        if (allowed == 0) {
            System.out.println(current);
            return;
        }

        int lastSuccess = current;
        int trial = lastSuccess + 1;
        while (true) {
            int result = check(citations, allowed, trial);
            if (result < 0) {
                break;
            }
            if (result >= 0) {
                allowed = result;
                lastSuccess = trial;
                trial++;
            }
        }

        System.out.println(lastSuccess);
    }

    public static int hIndex(int[] citations) {
        int highest = 0;
        for (int i = 1; i < citations.length; i++) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    count++;
                }
            }
            if (count >= i) {
                highest++;
            }
        }
        return highest;
    }

    public static int check(int[] citations, int allowed, int target) {

        int had = 0;
        List<Integer> lower = new ArrayList<>();
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= target) {
                had++;
            }
            else {
                lower.add(target - citations[i]);
            }
        }

        int required = target - had;
        int total = 0;
        Collections.sort(lower);

        for (int i = 0; i < required; i++) {
            total += lower.get(i);
        }

        return (allowed - total);
    }
}
