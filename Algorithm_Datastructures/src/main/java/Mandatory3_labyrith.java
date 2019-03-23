import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mandatory3_labyrith {

    static Queue queList = new LinkedList();
    static boolean[][] visited;
    static int[][] Step;
    static int arraySize;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int xK = 0;
        int yK = 0;
        Cordinates start = new Cordinates(xK, yK);

        arraySize = scan.nextInt();
        visited = new boolean[arraySize][arraySize];

        for (int i = 0; i<arraySize; i++) {
            for (int n = 0; n<arraySize; n++) {
                visited[i][n] = false;
            }
        }

        visited[0][0] = true;

        Step = new int[arraySize][arraySize];
        Step[0][0] = 1;


        queList.add(start);

        String line;
        String[][] array = new String[arraySize][arraySize];
        for (int n = 0; n<arraySize; n++) {
            line = scan.next();

            array[n] = line.split("");

        }

        while (!queList.isEmpty() && visited[arraySize-1][arraySize-1] == false){
            Cordinates currentCordinate = (Cordinates) ((LinkedList) queList).getFirst();
            xK = currentCordinate.getxK();
            yK = currentCordinate.getyK();
            ((LinkedList) queList).removeFirst();
            moveChecker(array, xK, yK);
        }

        System.out.println(Step[arraySize-1][arraySize-1]);

    }





    public static void moveChecker(String[][] board, int xK, int yK) {

        int currentStep = Step[yK][xK];
        if (xK == 0) {
            String letterCheck = board[yK][1];
            if (!board[yK][xK].equals(letterCheck) && visited[yK][1] == false){
                visited[yK][1] = true;
                Step[yK][1] = (currentStep+1);
                Cordinates nyQue = new Cordinates(yK,1);
                queList.add(nyQue);
            }

        } else if (xK == (arraySize-1)) {
            String letterChecker = board[yK][(arraySize-2)];
            if (!board[yK][xK].equals(letterChecker) && visited[yK][arraySize-2] == false){
                visited[yK][arraySize-2] = true;
                Step[yK][arraySize-2] = (currentStep+1);
                Cordinates nyQue = new Cordinates(yK,arraySize-2);
                queList.add(nyQue);
            }
        } else {

            int smallXK = xK-1;
            int bigXK = xK+1;

            String bigLetter = board[yK][bigXK];
            String smallLetter = board[yK][smallXK];

            if (!board[yK][xK].equals(smallLetter) && visited[yK][smallXK] == false) {

                Step[yK][smallXK] = (currentStep+1);
                Cordinates nyQue = new Cordinates(yK, smallXK);
                queList.add(nyQue);
                visited[yK][smallXK] = true;

            }
            if (!board[yK][xK].equals(bigLetter) && visited[yK][bigXK] == false) {
                Step[yK][bigXK] = (currentStep+1);
                Cordinates nyQue = new Cordinates(yK, bigXK);
                queList.add(nyQue);
                visited[yK][bigXK] = true;
            }

        }


        if (yK == 0) {
            String letterChecker = board[1][xK];
            if (!board[yK][xK].equals(letterChecker) && visited[1][xK] == false){
                Step[1][xK] = (currentStep+1);
                Cordinates newQue = new Cordinates(1,xK);
                visited[1][xK] = true;
                queList.add(newQue);
            }
        }  else if (yK == (arraySize-1)) {
            String letterChecker = board[arraySize-2][(xK)];
            if (!board[yK][xK].equals(letterChecker) && visited[arraySize-2][xK] == false){
                Step[arraySize-2][xK] = (currentStep+1);
                Cordinates newQue = new Cordinates(arraySize-2,xK);
                visited[arraySize-2][xK] = true;
                queList.add(newQue);
            }} else {

            int smallYK = yK-1;
            int bigYK = yK+1;

            String bigLetterChecker = board[bigYK][xK];
            String smallLetterChecker = board[smallYK][xK];

            if (!board[yK][xK].equals(smallLetterChecker) && visited[smallYK][xK] == false) {

                visited[smallYK][xK] = true;
                Step[smallYK][xK] = (currentStep+1);
                Cordinates newQue = new Cordinates(smallYK, xK);
                queList.add(newQue);

            }
            if (!board[yK][xK].equals(bigLetterChecker) && visited[bigYK][xK] == false) {

                visited[bigYK][xK] = true;
                Step[bigYK][xK] = (currentStep+1);
                Cordinates newQue = new Cordinates(bigYK, xK);
                queList.add(newQue);

            }

        }

    }

}
