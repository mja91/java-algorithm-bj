import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num = Integer.parseInt(sc.nextLine());
        for (int i=0; i<num; i++) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            String[] strArr = str.split(" ");
            for (int j=0; j<strArr.length; j++) {
                String now = strArr[j];
                String nowResult = "";
                char[] charArr = now.toCharArray();
                for (int k=charArr.length-1; k>=0; k--) {
                    nowResult += charArr[k];
                }
                sb.append(nowResult).append(" ");
            }

            String result = sb.toString();
            result = result.substring(0, result.length()-1);
            System.out.println(result);
        }

        sc.close();
    }
}