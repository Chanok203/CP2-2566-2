package from_c_to_java;
import java.util.Scanner;

public class SecondLastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((n / 10) % 10);
    }
}
