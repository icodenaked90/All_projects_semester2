import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String number;
        String temp;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("127.0.0.1",8000);
        Scanner sc1 = new Scanner(s.getInputStream());
        System.out.println("Enter any number");
        number = sc.next();
        PrintStream p = new PrintStream(s.getOutputStream());
        p.println(number);
        temp = sc1.next();
        System.out.println(temp);


    }

}