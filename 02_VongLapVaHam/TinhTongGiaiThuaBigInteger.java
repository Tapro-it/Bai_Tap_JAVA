import java.math.BigInteger;
import java.util.Scanner;

public class baitap3 {
    public static BigInteger fact(int n) {
        BigInteger kq = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            kq = kq.multiply(BigInteger.valueOf(i));
        }
        return kq;
    }
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        System.out.print("Nhập số nguyên a : ");
        int a = k.nextInt();
        System.out.print("Nhập số nguyên b : ");
        int b = k.nextInt();
        System.out.print("Nhập số nguyên c : ");
        int c = k.nextInt();
        System.out.print("Nhập số nguyên d : ");
        int d = k.nextInt();
        System.out.print("Nhập số nguyên e : ");
        int e = k.nextInt();
       BigInteger S = fact(a).add(fact(b)).add(fact(c)).add(fact(d)).add(fact(e));
       System.out.println("Tổng S = " + S);
    }
}