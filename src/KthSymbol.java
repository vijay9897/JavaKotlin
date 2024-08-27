import java.util.Scanner;

public class KthSymbol {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
        while (true) {
            int n = scanner.nextInt();
            if (n == 0)
                break;
            String nthRow = getRow(n);
            System.out.println(">>>Result:" + nthRow);
        }
    }

    public static String getRow(int i) {
        if (i == 1) {
            return "0";
        }
        String result = getRow(i-1);
        StringBuilder builder = new StringBuilder();
        for (char ch: result.toCharArray()) {
            if (ch == '0') {
                builder.append("01");
            } else {
                builder.append("10");
            }
        }
        return builder.toString();
    }
}
