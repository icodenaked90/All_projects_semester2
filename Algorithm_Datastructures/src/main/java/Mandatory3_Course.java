import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mandatory3_Course {

    static void BFS(Node node){

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            node = q.remove();
            System.out.println(node.data + "");
            if (node.left != null){
                q.add(node.left);
            }
            if (node.right != null){
                q.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Node tree = Input();
            BFS(tree);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static Node Input(){
        Scanner scan = new Scanner(System.in);
        Node root = new Node(scan.nextInt());

        return root;

    }

}

