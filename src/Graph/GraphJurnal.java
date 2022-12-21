package Graph;
import java.util.Arrays;

public class GraphJurnal {
    Vertex head;
    Vertex tail;
    int v = 0;
    void addVertex(int label, String  kota){
        Vertex baru = new Vertex(label, kota);
        if(head == null){
            head = tail = baru;
        }else{
            tail.next = baru;
            tail = baru;
        }
        v++;
    }

    Vertex findver(int src){
        Vertex cur = head;
        while(cur != null){
            if(cur.label == src){
                break;
            }
            cur = cur.next;
        }
        return cur;
    }
    void addEdge(int src, int dest, int weight){
        Vertex asal = findver(src);
        Vertex tujuan = findver(dest);
        Edge bantu = asal.edge;
        if(bantu == null) {
            asal.edge = new Edge(tujuan, weight);
        }else{
            while(bantu.nextEdge != null) {
                bantu = bantu.nextEdge;
            }
            bantu.nextEdge = new Edge(tujuan, weight);
        }
        Edge bantu2 = tujuan.edge;
        if(bantu2 == null){
            tujuan.edge= new Edge(asal,weight);
        }else {
            while (bantu2.nextEdge != null) {
                bantu2 = bantu2.nextEdge;
            }
            bantu2.nextEdge = new Edge(asal, weight);
        }
    }
    int [] degree(){
        int [] derajat = new int[v];
        for(int i = 0; i< v; i++){
            Vertex cur = findver(i);
            Edge bantu = cur.edge;
            while(bantu != null){
                derajat[i] +=1;
                bantu = bantu.nextEdge;
            }
        }
        return derajat;
    }

    public int [] Graphcoloring() {
        int[] result = new int[v];
        Arrays.fill(result, -1);
        boolean [] available = new boolean[v];
        Arrays.fill(available, true);
        result[0] = 0;
        for(int i = 1; i<v; i++){
            Vertex cur = findver(i);
            Edge bantu = cur.edge;
            while(bantu != null){
                if(result[bantu.end.label] != -1){
                    available[result[bantu.end.label]] = false;
                }
                bantu = bantu.nextEdge;
            }
            int color = 0;
            for(; color< v; color++){
                if(available[color]){
                    break;
                }
            }
            result[cur.label] = color;
            Arrays.fill(available, true);
        }
        return result;
    }

    int [] djikstra(int src){
        int [] jarak = new int[v];
        int [] prev = new int[v];
        linklist helper = new linklist();
        boolean [] visited = new boolean[v];
        for(int i = 0; i<v; i++){
            if(i == src){
                jarak [i] = 0;
            }else{
                jarak[i] = Integer.MAX_VALUE;
            }
            prev[i] = -1;
        }
        int UkeV = 0; //jarakantar 2 node yang dicek (u - v)
        Vertex asal = findver(src);
        helper.addpriority(asal);
        while(!helper.isEmpty()){
            Vertex cur = helper.remove();
            Edge bantu = cur.edge;
            while(bantu != null){
                UkeV = jarak[cur.label] + bantu.weight;
                if(UkeV<jarak[bantu.end.label]){
                    jarak[bantu.end.label] = UkeV;
                }
                if(!visited[bantu.end.label]){
                    helper.addpriority(bantu.end);
                    prev[bantu.end.label] = cur.label;
                }
                bantu = bantu.nextEdge;
            }
            visited[cur.label] = true;
        }
        return jarak;
    }

}
