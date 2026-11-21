import java.util.Scanner;

public class baitap {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        System.out.print("Nhập năm bất kì: ");
        int nam = k.nextInt();
        System.out.print("Nhập tháng bất kì: ");
        int thang = k.nextInt();
        if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) {
            System.out.println("Tháng " + thang + " năm " + nam + " có 31 ngày");
        } else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
            System.out.println("Tháng " + thang + " năm " + nam + " có 30 ngày");
        }
        if (thang == 2) {
            if ((nam%4==0 && nam%100!=0) || nam%400==0) {
                System.out.println("Tháng " + thang + " năm " + nam + " có 29 ngày");
            } else {
                System.out.println("Tháng " + thang + " năm " + nam + " có 28 ngày");
            }
        }
    }
}

