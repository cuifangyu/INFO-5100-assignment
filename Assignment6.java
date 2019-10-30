package Assignment6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Assignment6 {

    /*
    ArrayList is implemented as a resizable array and LinkedList is implemented as a double linked list.
    ArrayList internally uses a dynamic array to store the elements.
    LinkedList internally uses a doubly linked list to store the elements.
    ArrayList search operation is pretty fast compared to the LinkedList search operation.
    LinkedList remove operation gives O(1) performance while ArrayList gives O(n) in worst case and O(1) in best case.
     */

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mapping = new HashMap<>();
        Set<Integer> occurrence = new HashSet<>();
        for(int i : arr) {
            mapping.put(i, mapping.getOrDefault(i, 0)+1);
        }
        for(int o : mapping.values()) {
            if(!occurrence.add(o)) {
                return false;
            }
        }
        return true;
    }

    class MyHashMap {
        int size=1000000;
        Hashnode[] harr;
        class Hashnode{
            int key;
            int value;
            public Hashnode(int k,int v){
                key=k;
                value=v;
            }
        }

        public MyHashMap() {
            harr=new Hashnode[size];
        }
        int hash(int k){
            return ( k )%size;
        }

        public void put(int key, int value) {
            Hashnode g=new Hashnode(key,value);
            int index=hash(key);
            if(harr[index]==null){
                harr[index]=g;}
            else{
                harr[index].key=key;
                harr[index].value=value;
            }
        }

        public int get(int key) {
            if(harr[hash(key)]!=null){
                return harr[hash(key)].value;
            }
            else{
                return -1;
            }
        }

        public void remove(int key) {
            if(harr[hash(key)]!=null){
                harr[hash(key)]=null;
            }
            else{
                return ;
            }
        }
    }

}
