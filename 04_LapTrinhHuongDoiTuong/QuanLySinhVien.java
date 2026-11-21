import java.util.Scanner;

public class App {
    String Name;
    String Birthday;
    double Math;
    double Phys;
    double IT;
    double Aver;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        Name = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        Birthday = sc.nextLine();
        System.out.print("Nhap diem Math: ");
        Math = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap diem Phys: ");
        Phys = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap diem IT: ");
        IT = Double.parseDouble(sc.nextLine());
    }

    public void display() {
        System.out.println("Name: " + Name + " | Birthday: " + Birthday + 
                           " | Math: " + Math + " | Phys: " + Phys + 
                           " | IT: " + IT + " | Aver: " + String.format("%.2f", getAver()));
    }

    public void editName(String newName) {
        this.Name = newName;
    }

    public void editIT(double newIT) {
        this.IT = newIT;
    }

    public void delete() {
        this.Name = "";
        this.Birthday = "";
        this.Math = 0;
        this.Phys = 0;
        this.IT = 0;
    }

    public double getAver() {
        return (Math + Phys + IT) / 3;
    }

    public int ranking() {
        double avg = getAver();
        if (avg >= 8.0) return 1;
        else if (avg >= 6.5) return 2;
        else if (avg >= 5.0) return 3;
        else return 4;
    }

    public static void main(String[] args) {
        App Dat = new App();
        App Khiem = new App();

        System.out.println("=== NHAP THONG TIN CHO SINH VIEN DAT ===");
        Dat.input();

        System.out.println("\n=== NHAP THONG TIN CHO SINH VIEN KHIEM ===");
        Khiem.input();

        System.out.println("\n=== THONG TIN CHI TIET ===");
        System.out.print("Dat -> ");
        Dat.display();
        System.out.print("Khiem -> ");
        Khiem.display();

        System.out.println("\n=== SO SANH DIEM TRUNG BINH ===");
        double avgDat = Dat.getAver();
        double avgKhiem = Khiem.getAver();

        if (avgDat > avgKhiem) {
            System.out.println("Dat co diem trung binh cao hon Khiem (" + String.format("%.2f", avgDat) + " so voi " + String.format("%.2f", avgKhiem) + ")");
        } else if (avgDat < avgKhiem) {
            System.out.println("Khiem co diem trung binh cao hon Dat (" + String.format("%.2f", avgKhiem) + " so voi " + String.format("%.2f", avgDat) + ")");
        } else {
            System.out.println("Dat va Khiem co diem trung binh bang nhau (" + String.format("%.2f", avgDat) + ")");
        }
    }
}