import java.util.Scanner;

public class Algorithm3peak {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a size of array");
        int N = sc.nextInt();
        //declaring array
        int[] arr = new int[N];
        //Accepts N elements
//        System.out.println("Enter" + N + "elements");

        int i;
        for (i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;
        System.out.println(peak3(arr, i,j));


    }

    public static int peak3(int[] arr,int i,int j) {
        int m = (i + j) / 2;
        if (arr[m] >= arr[i - 1] && arr[m] >= arr[i + 1]) {
            return m;
        } else if (arr[m - 1] > arr[m]) {
            return peak3(arr, i, m - 1);
        } else if (arr[m] < arr[m + 1]) {
            return peak3(arr, m + 1,j);
        }return -1;
    }


}
