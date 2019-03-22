import java.util.Scanner;

public class Algorithm2Peak {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a size of array");
        int N = sc.nextInt();
        //declaring array
        int[] arr = new int[N];
        //Accepts N elements
//        System.out.println("Enter" + N + "elements");

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(peak2(arr));


    }

    public static int peak2(int[] arr) {
        int max = 0;
        for (int i = 0; i <= arr.length - 1; i++){

            if (arr[i] >= arr[max]){
                max = i;
            }

        } return max;
    }
}