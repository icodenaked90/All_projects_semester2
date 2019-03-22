import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Scanner;

public class Mandatory2_DataInput {

    public static void main(String[] args) {
        boolean stack = true;
        boolean que = true;
        boolean smallfirst = true;

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Integer> quelist = new ArrayList<>();
        ArrayList<Integer> stacklist = new ArrayList<>();
        ArrayList<Integer> smalllist = new ArrayList<>();





        for (int i = 0; i < N; i++) {

            String input = sc.next();
            int number = sc.nextInt();

            if (input.equals("I")) {
                quelist.add(number);
                stacklist.add(number);
                if (smallfirst) {
                    smalllist.add(number);
                    Collections.sort(smalllist);


                }
            }
            if (input.equals("E")) {
                if (stacklist.get(stacklist.size() - 1) != number && stack) {
                    stack = false;
                } else {
                    stacklist.remove(stacklist.size() - 1);
                    stacklist.trimToSize();
                }
                if (quelist.get(0) != number && que) {
                    que = false;
                } else {
                    quelist.remove(0);
                    quelist.trimToSize();
                }
                if (smalllist.get(0) != number && smallfirst) {
                    smallfirst = false;
                } else {
                    smalllist.remove(0);
                    smalllist.trimToSize();
                }
            }
        }
        if (que){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        if (stack){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        if (smallfirst){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
