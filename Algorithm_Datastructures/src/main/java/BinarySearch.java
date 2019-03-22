import java.util.Scanner;

/**
 * Binary search
 * i) works with sorted array
 * arr = [11, 15, 16, 19, 25, 36, 67 ]
 * search = 15
 *
 * Step 1:
 * low = 0 , high = 6
 * mid = (low+ high)/2 = 3, arr[3] = 19, 19>15
 * Step 2:
 * low = 0, high = mid-1 = 3 - 1 = 2
 * mid = (0+2)/2 = 1
 * arr[1] = 15
 *
 * Phesudo code
 * low = 0 , high = size -1 , search = x
 * while(low <= high) {
 *     mid = (low + high)/2;
 *     if (arr[mid] == search){
 *         return
 *     }else if (search > arr[mid]){
 *         low = mid + 1;
 *     }else if (arr[mid] > search){
 *         high = mid -1;
 *     }
 * }
 *
 *
 *
 */

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        int i;
        for (i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] queries = new int[M];
        int j;
        for (j = 0; j < M; j++) {
            queries[j] = sc.nextInt();

        }
        System.out.println(binarySearch(arr, queries));
    }

    public static int binarySearch(int[] arr, int[] queries) {

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < queries.length; j++) {
                if (arr[i] == queries[j]){
                    return 1;
                }
            }
        }return 0;
    }
}