import java.util.Scanner;

public class he {
    public static void main(String[] args) {
        // shift + alt + A là bật tắt comment nhiều dòng
      /*   Scanner k = new Scanner(System.in);
        System.out.print("nhap r: ");
        double r = k.nextDouble();
        double chuvi = 2*Math.PI*r;
        double dientich = Math.PI*Math.pow(r,2);
        System.out.printf("chu vi hinh  tron la: %.2f%n", chuvi);
        System.out.printf("dien tich hinh tron la: %.2f%n", dientich); */
        Scanner k = new Scanner(System.in);
        System.out.print("Nhập điểm môn toán: ");
        double   a = k.nextDouble ();
        System.out.print("Nhập điểm môn hóa: ");
        double   b = k.nextDouble ();
        System.out.print ("Nhập điểm môn lý: ");
        double   c = k.nextDouble ();
        double dtb = (a + b + c) / 3.0;
        System.out.printf("điểm trung bình là: %.2f%n", dtb);
        if (dtb >= 8 && dtb < 9) {
            System.out.println("học sinh giỏi");
        }else if (dtb >= 9) {
            System.out.println("học sinh xuất sắc");
        }else if (dtb >= 6.5 && dtb < 8) {
            System.out.println("học sinh khá");
        } else if (dtb >= 5 && dtb < 6.5) {
            System.out.println("học sinh trung bình");
        } else {
            System.out.println("học sinh yếu");
        }
    }
    
}
