package Graph;

public class linklist {
    node head;
    node tail;
    boolean isEmpty(){

        return head == null;
    }
    public void remove(int currentdata){
        node current = head;
        node prev = null;
        if(current.number == currentdata){
            head = head.next;
            return;
        }
        while(current != null &&current.number != currentdata){
            prev = current;
            current = current.next;
        }
        if(current == null){
            return;
        }
        prev.next = current.next;
    }
    void addpriority(int data){
        node baru = new node(data);
        if (head == null) {
            head = tail = baru;
            return;
        }
        node bantu = head;
        while(bantu != null){
            if(head.number>baru.number){
                baru.next = head;
                head.prev = baru;
                head = baru;
                return;
            }else if(tail.number<= baru.number){
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
                return;
            }else if(baru.number>= bantu.number&&baru.number<bantu.next.number ){
                baru.next = bantu.next;
                baru.prev = bantu;
                bantu.next.prev = baru;
                bantu.next = baru;
                return;
            }
            bantu = bantu.next;
        }
    }
    void addpriority(Vertex data){
        node baru = new node(data);
        if (head == null) {
            head = tail = baru;
            return;
        }
        node bantu = head;
        while(bantu != null){
            if(head.data.label>baru.data.label){
                baru.next = head;
                head.prev = baru;
                head = baru;
                return;
            }else if(tail.data.label<= baru.data.label){
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
                return;
            }else if(baru.data.label>= bantu.data.label&&baru.data.label<bantu.next.data.label ){
                baru.next = bantu.next;
                baru.prev = bantu;
                bantu.next.prev = baru;
                bantu.next = baru;
                return;
            }
            bantu = bantu.next;
        }
    }
    Vertex remove(){
        node simpan = head;
        if(head == null){
            return null;
        }else if(head == tail){
            head = null;
        }else{
            head = head.next;
        }
        return simpan.data;
    }

}
