import java.util.ArrayList;
import java.util.Scanner;
public class Mandatory2_middleQue {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input;

        int sizeOfOperations = sc.nextInt();

        ArrayList<Integer> middleArray = new ArrayList<>();



        for (int i = 0; i < sizeOfOperations; i++ ){
            input = sc.next();
            if (input.equals("R")){
                middleArray.add(sc.nextInt());
            }else if (input.equals("L")){
                middleArray.add(0,sc.nextInt());
            } else if (input.equals("E")){
                if (middleArray.size()%2 == 0){
                    System.out.println(middleArray.get((middleArray.size()/2)-1));
                    middleArray.remove((middleArray.size()/2)-1);
                } else if (middleArray.size()%2 == 1){
                    System.out.println(middleArray.get((middleArray.size()/2)));
                    middleArray.remove((middleArray.size()/2));
                }
            }

        }


    }
}
