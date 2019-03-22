import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mandatory3_labyrith {

    static Queue que = new LinkedList();
    static boolean[][] visited;
    static int[][] steps;
    static int arraySize;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int xK = 0;
        int yK = 0;
        kords start = new kords(xK, yK);

        //når det virker
        arraySize = scan.nextInt();
        // test
        //arraySize = 5;




        //Starter listen op med første gæt på 0,0
        visited = new boolean[arraySize][arraySize];
        //Alle i arrayet bliver initialiseret til false
        for (int i = 0; i<arraySize; i++) {
            for (int j = 0; j<arraySize; j++) {
                visited[i][j] = false;
            }
        }

        visited[0][0] = true;

        steps = new int[arraySize][arraySize];
        steps[0][0] = 1;


        que.add(start);

/*
        String[][] array = new String[][] {
                {"A","A","A","B","A"},
                {"B", "B","B","B","B"},
                {"A","B","A","A","A"},
                {"A","B","B","B","B"},
                {"A","A","A","A","A"}
        };
*/
        String row;
        String[][] array = new String[arraySize][arraySize];
        for (int i = 0; i<arraySize; i++) {
            row = scan.next();

            array[i] = row.split("");

        }


        while (!que.isEmpty() && visited[arraySize-1][arraySize-1] == false){
            kords atm = (kords) ((LinkedList) que).getFirst();
            xK = atm.getxK();
            yK = atm.getyK();
            ((LinkedList) que).removeFirst();
            moveChecker(array, xK, yK);
        }

        System.out.println(steps[arraySize-1][arraySize-1]);



    }





    public static void moveChecker(String[][] board, int xK, int yK) {

        int currentStep = steps[yK][xK];
        //hvis x er 0
        if (xK == 0) {
            String letterChecker = board[yK][1];
            if (!board[yK][xK].equals(letterChecker) && visited[yK][1] == false){
                //skriv kode for hvordan den forsætter
                visited[yK][1] = true;
                steps[yK][1] = (currentStep+1);
                kords nyQue = new kords(yK,1);
                que.add(nyQue);
            }

        } else if (xK == (arraySize-1)) {
            String letterChecker = board[yK][(arraySize-2)];
            if (!board[yK][xK].equals(letterChecker) && visited[yK][arraySize-2] == false){
                visited[yK][arraySize-2] = true;
                steps[yK][arraySize-2] = (currentStep+1);
                kords nyQue = new kords(yK,arraySize-2);
                que.add(nyQue);
            }
            //LAV HER HVIS DEN ER I SLUTNINGEN
        } else {

            int smallXK = xK-1;
            int bigXK = xK+1;

            String bigLetterChecker = board[yK][bigXK];
            String smallLetterChecker = board[yK][smallXK];

            if (!board[yK][xK].equals(smallLetterChecker) && visited[yK][smallXK] == false) {

                visited[yK][smallXK] = true;
                steps[yK][smallXK] = (currentStep+1);
                kords nyQue = new kords(yK, smallXK);
                que.add(nyQue);

            }
            if (!board[yK][xK].equals(bigLetterChecker) && visited[yK][bigXK] == false) {

                visited[yK][bigXK] = true;
                steps[yK][bigXK] = (currentStep+1);
                kords nyQue = new kords(yK, bigXK);
                que.add(nyQue);

            }

        }

        //hvis y er 0
        if (yK == 0) {
            String letterChecker = board[1][xK];
            if (!board[yK][xK].equals(letterChecker) && visited[1][xK] == false){
                visited[1][xK] = true;
                steps[1][xK] = (currentStep+1);
                kords nyQue = new kords(1,xK);
                que.add(nyQue);
            }
        }  else if (yK == (arraySize-1)) {
            String letterChecker = board[arraySize-2][(xK)];
            if (!board[yK][xK].equals(letterChecker) && visited[arraySize-2][xK] == false){
                visited[arraySize-2][xK] = true;
                steps[arraySize-2][xK] = (currentStep+1);
                kords nyQue = new kords(arraySize-2,xK);
                que.add(nyQue);
            }} else {

            int smallYK = yK-1;
            int bigYK = yK+1;

            String bigLetterChecker = board[bigYK][xK];
            String smallLetterChecker = board[smallYK][xK];

            if (!board[yK][xK].equals(smallLetterChecker) && visited[smallYK][xK] == false) {

                visited[smallYK][xK] = true;
                steps[smallYK][xK] = (currentStep+1);
                kords nyQue = new kords(smallYK, xK);
                que.add(nyQue);

            }
            if (!board[yK][xK].equals(bigLetterChecker) && visited[bigYK][xK] == false) {

                visited[bigYK][xK] = true;
                steps[bigYK][xK] = (currentStep+1);
                kords nyQue = new kords(bigYK, xK);
                que.add(nyQue);

            }

        }

    }

}
