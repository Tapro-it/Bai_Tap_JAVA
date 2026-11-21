import java.util.Scanner;

public class he1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
      
        switch (n) {
            case 10,9:
                System.out.println("Xuất sắc");
                break;
            case 8:
                System.out.println("Giỏi");
                break;
            case 7,6:
                System.out.println("Khá");
                break;
            case 5:
                System.out.println("Trung bình");
                break;
            case 4,3,2,1,0:
                System.out.println("Yếu / Kém");
                break;
            default:
                System.out.println("Điểm không hợp lệ!");
        }
    }
    
}
