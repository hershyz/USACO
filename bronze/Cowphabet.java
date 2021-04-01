import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String raw = scn.nextLine();
        String in = scn.nextLine();

        String[] alphabet = raw.split("");

        int times = 0;
        int aPos = findIndex(alphabet, String.valueOf(in.charAt(0)));
        for (int i = 0; i < in.length(); i++) {
            String currentChar = String.valueOf(in.charAt(i));
            int currentPos = findIndex(alphabet, currentChar);
            if (currentPos <= aPos) {
                aPos = currentPos;
                times++;
            }
            if (currentPos > aPos) {
                aPos = currentPos;
            }
        }

        System.out.println(times);
    }

    public static int findIndex(String[] alphabet, String c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(c)) {
                return i;
            }
        }
        return -1;
    }
}
