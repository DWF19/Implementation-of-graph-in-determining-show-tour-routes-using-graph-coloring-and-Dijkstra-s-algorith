package Graph;

public class Edge {
    int weight;
    Vertex end;
    Edge nextEdge;
    public Edge (Vertex end, int weight){
        this.end = end;
        this.weight = weight;
    }

}
