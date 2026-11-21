import java.util.Scanner;

public class he2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n 1. Tìm theo tên \n 2. Tìm theo tác giả \n 3. Tìm theo nhà xuất bản \n 4. Tìm theo tiêu đề \n 5. Thoát \n -> Mời bấm số để chọn: ");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Bạn chọn tìm theo tên");
                break;
            case 2:
                System.out.println("Bạn chọn tìm theo tác giả");
                break;
            case 3:
                System.out.println("Bạn chọn tìm theo nhà xuất bản");
                break;
            case 4:
                System.out.println("Bạn chọn tìm theo tiêu đề");
                break;
            case 5:
                System.out.println("Bạn chọn thoát");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    
}
