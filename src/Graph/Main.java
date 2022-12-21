package Graph;

public class Main {
    public static void main(String[] args) {
        String[] namakota = {"Mataram", "Gerung", "Sekotong", "Praya", "Kopang", "Kuta",
                "Selong", "Jerowaru", "Aik Mel", "Pringgabaya",
                "Sambelia", "Sembalun", "Tanjung", "Bayan", "Gangga"};
        GraphJurnal lombok = new GraphJurnal();
        int[] jarak = new int[15];
        int[] derajat;
        int[] graphcolor;
        linklist colorpick = new linklist();
        for (int i = 0; i< 15; i++) {
            lombok.addVertex(i, namakota[i]);
        }

        lombok.addEdge(2, 1, 51);
        lombok.addEdge(0, 1, 18);
        lombok.addEdge(12, 0, 41);
        lombok.addEdge(12, 14, 24);
        lombok.addEdge(14, 13, 45);
        lombok.addEdge(11, 13, 37);
        lombok.addEdge(13, 10, 43);
        lombok.addEdge(10, 9, 38);
        lombok.addEdge(9, 8, 23);
        lombok.addEdge(8, 11, 42);
        lombok.addEdge(9, 6, 27);
        lombok.addEdge(8, 6, 21);
        lombok.addEdge(6, 4, 30);
        lombok.addEdge(6, 7, 35);
        lombok.addEdge(7, 5, 43);
        lombok.addEdge(4, 3, 20);
        lombok.addEdge(4, 0, 33);
        lombok.addEdge(3, 5, 26);
        lombok.addEdge(3, 1, 30);
        lombok.addEdge(3, 7, 51);

        derajat = lombok.degree();
        graphcolor = lombok.Graphcoloring();
        int max = 0;
        int indexmax = 0;
        for (int i = 0; i<derajat.length; i++) {
            if (derajat[i] > max) {
                max = derajat[i];
                indexmax = i;
            }
        }
        for (int i = 0; i<lombok.v; i++) {
            if (i != indexmax&&graphcolor[i] == graphcolor[indexmax]) {
                colorpick.addpriority(i);
            }
        }
        jarak = lombok.djikstra(indexmax);
        int indexmin = 0;
        int totaltempuh = 0;
        int jarakkota = 0;
        Vertex cur = lombok.findver(indexmax);

        System.out.println("---------Jalur Show Tour KUFAKU BAND --------");
        System.out.println(cur.kota + " (" + jarak[indexmax] + " km) Grand Opeening ->");
        while(true){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<jarak.length; i++){
                node bantu = colorpick.head;
                while(bantu != null){
                    if(i == bantu.number){
                        if(jarak[i] <min){
                            min = jarak[i];
                            indexmin = i;
                        }
                        break;
                    }
                    bantu = bantu.next;
                }
            }
            jarakkota = 0;
            jarakkota += jarak[indexmin];
            if(jarakkota> 100) break;
            totaltempuh+=jarakkota;
            cur = lombok.findver(indexmin);
            System.out.println(cur.kota + " (" +jarakkota + " km) ->");
            colorpick.remove(indexmin);
            jarak = lombok.djikstra(indexmin);
        }
        System.out.println("Jarak yang ditempuh : " +totaltempuh);
        System.out.println("FINISH");
    }

}
