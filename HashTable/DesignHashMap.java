package HashTable;

public class DesignHashMap {

    int [][] ar;
    public DesignHashMap() {
        this.ar = new int[1000001][2];
    }

    public void put(int key, int value) {
        this.ar[key][0] = value;
        this.ar[key][1] = 1;
    }

    public int get(int key) {
        return this.ar[key][1] ==0? -1 : this.ar[key][0];
    }

    public void remove(int key) {
        this.ar[key][0] = -1;
        this.ar[key][1] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */