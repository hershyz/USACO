public class Main {

    public static void main(String[] args) {

        int[] bales = {4, 2, 10, 7, 1};
        System.out.println(hayBales(bales));
    }

    public static int hayBales(int[] arr) {

        int total = 0;
        for (int n : arr) {
            total += n;
        }
        double raw = Math.round(Double.valueOf(total) / Double.valueOf(arr.length));
        int avg = (int)raw;

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > avg) {
                ans += (arr[i] - avg);
            }
        }

        return ans;
    }
}
