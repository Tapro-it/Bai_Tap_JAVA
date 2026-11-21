import java.util.Scanner;

public class Exercise {
    /* public static void main(String[] args) {
       int [] array = new int[100]; //giới hạn số lượng phần tử của mảng là 100
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter n: ");
       int n = sc.nextInt();
    for (int i = 0; i < n; i++) { //vòng lặp để nhập các phần tử của mảng
        System.out.print("Enter value for array[" + i + "]= ");
        array[i] = sc.nextInt();
    }
    //nhập xong thì tính tổng các phần tử của mảng
    int sum = 0;
	for (int j = 0; j < n; j++) {
            sum += array[j];
        }
        // In ra tổng các phần tử của mảng
        System.out.println("Sum of array elements: " + sum);
        }  */
    public static void InputArray(int[] array, int n){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for array[" + i + "]= ");
            array[i] = sc.nextInt();
        }
    }
    public static void OutputArray(int[] array, int n){
        int min = array[0];
        for (int j = 0; j < n; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        System.out.println("min of array elements: " + min);
    } 
    public static void MaxArray(int[] array, int n){
        int max = array[0];
        for (int j = 0; j < n; j++) {
            if (array[j] > max) {
                max = array[j];
            }
        }
        System.out.println("max of array elements: " + max);
    } 
    public static void SumArray(int[] array, int n){
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += array[j];
        }
        System.out.println("Sum of array elements: " + sum);
    }
    public static void SapXep(int[] array, int n){
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // In xuống dòng sau khi in xong mảng
    }
    public static void main(String[] args) {
        int[] mang = new int[100];
        System.out.print("Enter n: ");;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        InputArray(mang, n);
        SapXep(mang, n);
        OutputArray(mang, n);
        SumArray(mang, n);
}
}

