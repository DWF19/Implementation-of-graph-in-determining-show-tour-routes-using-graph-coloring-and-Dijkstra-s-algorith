package Graph;

public class node {
    int number;
    Vertex data;
    node next;
    node prev;
    public node (Vertex data){
        this.data = data;
    }

    public node(int number) {
        this.number = number;
    }

}
