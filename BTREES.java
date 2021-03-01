import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Created by ESMAEL FAKHERI ALAMDARI

public class BTREES<Key extends Comparable<Key>, Value> implements Serializable  {
    // max children per B-tree node = M-1     (M>2)
    private static final int M = 6;
    Map<String,Integer> Dic = new HashMap<>();
    private Node root;       
    private int height;      
    private int n;          

    // helper B-tree node data type
    private static final class Node implements Serializable {
        private int m;                             // number of children
        private Entry[] children = new Entry[M];   // the array of children
        private Node(int k) { m = k; }             // create a node with k children
    }

    // internal nodes: only use key and next
    // external nodes: only use key and value
    
    private static class Entry implements Serializable {
        private Comparable key;
        private final Object val;
        private Node next;     // helper field to iterate over array entries
        public Entry(Comparable key, Object val, Node next) {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public BTREES() {root = new Node(0);}
    public boolean isEmpty() {return size() == 0;}
    public int size() {return n;}
    public int height() {return height;}
    
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return search(root, key, height);
    }

    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;
        // external node
        if (ht == 0) {
            for (int j = 0; j < x.m; j++) {
                if (eq(key, children[j].key)) return (Value) children[j].val;
            }
        }
        // internal node
        else {
            for (int j = 0; j < x.m; j++) {
                if (j+1 == x.m || less(key, children[j+1].key))
                    return search(children[j].next, key, ht-1);
            }
        }
        return null;
    }
//Created by ESMAEL FAKHERI ALAMDARI

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null");
        Node u = insert(root, key, val, height);
        n++;           // we add size each time we add the new value
        if (u == null) return;
        // need to split root
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
        Person p = (Person) val;
        if(p.GetName() == null)
            Dic.put(p.GetFullName() , p.GetID());
    }

    public void update(Key key , int number) {
        if(key == null) throw new IllegalArgumentException("argument key to update is null");
        Person p = (Person) get(key);
        if(p == null) throw new IllegalArgumentException("argument is not found");
        p.SetNumber(number);
    }
    
    private Node insert(Node h, Key key, Value val, int ht) {
        int j;
        Entry t = new Entry(key, val, null);

        // external node
        if (ht == 0) {
            for (j = 0; j < h.m; j++) {
                if (less(key, h.children[j].key)) break;
            }
        }
        // internal node
        else {
            for (j = 0; j < h.m; j++) {
                if ((j+1 == h.m) || less(key, h.children[j+1].key)) {
                    Node u = insert(h.children[j++].next, key, val, ht-1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--)
            h.children[i] = h.children[i-1];
        
        h.children[j] = t;
        h.m++;
        if (h.m < M) return null;
        else         return split(h);
    }

    // split node in half
    private Node split(Node h) {
        Node t = new Node(M/2);
        h.m = M/2;
        for (int j = 0; j < M/2; j++)
            t.children[j] = h.children[M/2+j];
        return t;
    }
//Created by ESMAAEEL FAAKHERI ALAMDAARI

    public void delete(Key key){
        delete(root, key, height);
    }
    private Entry delete(Node h, Key key, int ht){
        Entry[] children = h.children;
        int j;
        if(ht == 0){
            for(j=0; j < h.m; j++){
                if(eq(key, children[j].key)){
                    break;
                } 
            }
        }else {
            for(j=0;j < h.m; j++){
                if(j+1 == h.m || less(key, children[j+1].key)){
                    Entry deleted = delete(children[j].next, key, ht - 1);
                    if(children[j].next.m < M / 2){
                        children[j].next = combine(children[j - 1].next, children[j].next);
                        if(children[j].next.m == 0)
                            break;
                    }
                    return deleted;
                }
            }
        }
    
        Entry toReturn = children[j];
        for(int i = j; i < h.m; i++){
            children[i] = children[i + 1];
        }
        h.m--;
        n--;
        if(h.m == 0)
            h = null;
        return toReturn;
    }
    private Node combine(Node a, Node b){
        int size = a.m;
        for (int i = size; i < size + b.m; i++){
            a.children[i] = b.children[i - b.m];
            a.m++;
        }
        if(a.m < M)
            b.m = 0;
        else
            b = split(a);
        return b;
    }   
    @Override
    public String toString() {return toString(root, height, "") + "\n";}

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.m; j++) {
                s.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        }
        else {
            for (int j = 0; j < h.m; j++) {
                if (j > 0) s.append(indent + "(" + children[j].key + ")\n");
                s.append(toString(children[j].next, ht-1, indent + "     "));
            }
        }
        return s.toString();
    }   
//    a method to use in gui when a person wants to sign in to the site
    public void Signin(BTREES B , Map p , String username , String password)
    { 
       if(p.get(username) == null)
       {
           System.out.println("Sorry, Your Username Is Wrong");
       }
       else
       {
       int id = (int) p.get(username);
       Person human = (Person) B.get(id);
       if(human.GetPassword().equals(password))
           System.out.println("WELCOM " + human.GetFullName() + " ,You Are Signed In");
       else
           System.out.println("Sorry, Your Password Is Wrong");
     }
    }
//Created by ESMAAEEL FAAKHERI ALAMDAARI
//  this is a method to get all elements of the tree and it is used for the customer
    
    public double Total(){return Total(root , height);}
            
    public double Total(Node head , int ht)
    {  
        Entry[] children = head.children; 
        double total = 0;
        if(ht == 0)
        { 
            for (int g=0 ; g < head.m ; g++ )
            {
              Person s = (Person) children[g].val;
              total += s.GetNumber() * s.GetPrice();   
              System.out.println("Stuff is " + s.GetName() +" => count : " + s.GetNumber() + " each one costs => " + s.GetPrice() );
            }
        }
        else
        {
            for (int j = 0; j < head.m; j++) {
                Total(children[j].next, ht-1);    
            }
        }
        return total;
    }
    
    private boolean less(Comparable k1, Comparable k2) {return k1.compareTo(k2) < 0;}
    
    private boolean eq(Comparable k1, Comparable k2) {return k1.compareTo(k2) == 0;}
    
    ArrayList<Person> p = new ArrayList<Person>();

//  this is a method to get all elements of the tree and it is used for the selesman
    public ArrayList GetTotal()
    {
        ArrayList<Person> p = new ArrayList<Person>();
        return GetTotal(root , p , height);
    }

    public ArrayList GetTotal(Node head , ArrayList p , int ht)
    {  
        Entry[] children = head.children; 
        if(ht == 0)
        { 
            for (int g=0 ; g < head.m ; g++ )
            {
              Person s = (Person) children[g].val;
              p.add(s);
            }                
        }
            else
        {
            for (int j = 0; j < head.m; j++) {
                GetTotal(children[j].next,p, ht-1);   
            }
        }
        return p;
    }
}
//Created by ESMAEL FAKHERI ALAMDARI
