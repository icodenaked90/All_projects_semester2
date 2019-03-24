import java.util.ArrayList;
import java.util.List;

public class Mandatory3_BFSCourses {



        static class Node{
            Node(int data){
                this.data = data;
                this.left = null;
                this.right = null;
                this.visited = false;
            }
            int data;
            Node left;
            Node right;
            boolean visited;
        }

        public static void main(String[] args) {



            //The tree:
            //   3
            //  / \
            // 1   2
            // \  / \
            //  4    3

            Node node1 = new Node(3);
            Node node2 = new Node(1);
            Node node3 = new Node(2);
            Node node4 = new Node(4);
            Node node5 = new Node(3);

            node1.left = node2;
            node1.right = node3;
            node1.right = node4;
            node3.right = node5;


            breadthFirstSearch(node5);

        }

        private static void breadthFirstSearch(Node node){
            List<Node> al = new ArrayList<>();
            al.add(node);
            while(!al.isEmpty()){
                node = al.get(0);
                if(node.left != null){
                    int index = al.size();
                    al.add(index,node.left);
                }
                if(node.right != null){
                    int index = al.size();
                    al.add(index,node.right);
                }
                System.out.print(al.get(0).data+" ");
                al.remove(0);


            }
        }

    }

