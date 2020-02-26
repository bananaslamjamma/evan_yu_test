
import java.util.HashMap;
import java.util.Map;

/**
 * February 26th 2020
 * @author EVAN YU
 */
//linkedlist & hashmap implementation of a lru cache (no time expiration)
public class LRUCache {
    
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> node_map;
    int cache_capacity;
    
    public LRUCache(int capacity){
        //initialize hashmap
        node_map = new HashMap(capacity);
        //set capacity
        this.cache_capacity = capacity;
        //connects out head and tail nodes together
        head.next = tail;
        tail.prev = head;
    }
    /**
     * get the value of the key exists in the cache
     * @param key
     * @return 
     */
    public int get(int key){
        int result =-1;
        Node node = node_map.get(key);
        if(node !=null){
            result = node.val;
            remove(node);
            add(node); 
        }
        return result;
    }
    
    /**
     * hashmap method
     * set or insert value if the key is nto already present
     * if cache is filled, delete least recently used item before inserting new item
     * @param key
     * @param value 
     */
    public void put(int key, int value){
        Node node = node_map.get(key);
        //overwriting the node
        if(node != null){
            remove(node);
            //update it's value
            node.val = value;
            //put in front
            add(node);
        }else {
            //if it already exists
            if (node_map.size() == cache_capacity){
                //check if reached capacity
                //remove from hashmap
                node_map.remove(tail.prev.key);
                //remove from linked list
                remove(tail.prev);
            }

            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            
            //new node on hashmap
            node_map.put(key,new_node);
            //add to linkedlist
            add(new_node);
        }
    }
    
    /**
     * Inserts the node infront of the list
     * @param node 
     */
    public void add(Node node){
        Node head_next = head.next;
        node.next = head_next;
        
        head_next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    /**
     * Removes the
     * @param node 
     */
    public void remove(Node node){
        Node next_node = node.next;
        Node prev_node = node.prev;
        //change the reference of the next node
        next_node.prev = prev_node;
        prev_node.next = next_node;
    }
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}
