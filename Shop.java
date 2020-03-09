import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
//Created by ESMAAEEL FAAKHERI ALAMDAARI
public class Shop {
    public static void main(String[] args) throws ClassNotFoundException {
        
//////////This are some people with stuff
        Person h_4 = new Person(9000000 , "ali20" , "alihasani" , "123447479956789" , "ali20@gmail.com" , "canada" , "09144444444" , "alishop" , "iran" , "081965572424");
        Person h_3 = new Person(3000000 , "hasan52" , "hasanemami" , "35353646" , "hasan52@gmail.com" , "tabriz" , "093353536345" , "hasanstore" , "alamdar" , "9646334");
        Person h_2 = new Person(2000000 , "navid36" , "navidvegari" , "474745754" , "navid36@gmail.com" , "tehran" , "1231310903" , "navidcompony" , "jolfa" , "9898008");
        Person h_1 = new Person(5000000 , "amir89" , "amirazizi" , "346463335" , "amir89@gmail.com" , "amrica" , "12319009313" , "amircompony" , "khorasan" , "99935353");
        Person c_3 = new Person(2325 , "sam12" , "samjones" , "35357755" , "sam12@gmail.com" , "amirica" , "9994646");
        Person c_2 = new Person(25474 , "eminem18" , "slimshady" , "77472" , "eminem@gmail.com" , "amirica" , "11903");
        Person c_1 = new Person(243 , "ed122" , "edsheeran" , "7468335" , "es122@gmail.com" , "amirica" , "5642123");
        Person s_1 = new Person(2300000 , 2000000 , 100 , 80 , 45 , "shoe" , "red" , true , "it isn't perfct");
        Person s_2 = new Person(1232000 , 1000000 ,20 , 11 , 120 , "ball" , "black" , true , "it is awsome");
        Person s_3 = new Person(4030000 , 4000000 ,200, 40 , 90 , "carpet" , "blue" , true , "it is perfct");
        Person s_4 = new Person(2002000 , 2000000 ,300, 8889 , 90 , "socks" , "yellow" , true , "it is bad");
        Person s_5 = new Person(4000200 , 4000000 ,400 , 24 , 99 , "chair" , "white" , true , "it is perfct");
        Person s_6 = new Person(3000300 , 3000000 , 140 , 140 , 29 , "book" , "green" , true , "it is perfct");
        
    Map<Integer,Object> StuffDic = new HashMap<>();    
    Map<String,Integer> Dic = new HashMap<>();        
    BTREES<Integer, Object> st = new BTREES<>();
    BTREES<Integer, Object> stuf = new BTREES<>();

/////////now we produce some customers and some sellermans and some stuffs
    
    List<Person> customers = new ArrayList<>();
    List<Person> sellers = new ArrayList<>();
    List<Person> stuffs = new ArrayList<>();
    Random rand = new Random();
    
    for(int j=1 ; j<=10 ; j++)
    {
     int i = j * 1000000;   
     Person p = new Person(i,"seller "+i,"Fullname "+i,"Password "+i,"Email "+i+"@E.F.A.com","Address "+i,"Phone number "+i,"ComponyName "+i,"ComponyAddress "+i,"ComponyPhone "+i);    
     sellers.add(p);
    }
    
    for(int j=1 ; j<=10 ;j++)
    {
     int i = rand.nextInt(1000);
     Person p = new Person(i,"customer "+i,"Fullname "+i,"Password "+i,"Email "+i+"@E.F.A.com","Address "+i,"Phone number "+i);    
     customers.add(p);
    }
//Created by ESMAAEEL FAAKHERI ALAMDAARI    
    for(int i=1 ; i<=10 ;i++)
    {
        int id = rand.nextInt(10000000);
        int count = rand.nextInt(1000);
        double price = rand.nextInt(1000) * 1.5;
        int y = id-(id%1000000);
     Person p = new Person(id, y ,count, count,price,"stuff "+i,"color "+i,true,"our stuff is perfect");    
     stuffs.add(p);
     StuffDic.put(p.GetID(),p);
    }

    for(Person p : sellers)
        st.put(p.GetID(), p);
    for(Person p : customers)
        st.put(p.GetID(), p);
    for(Person p : stuffs)
        stuf.put(p.GetID(),p);
//    
/////////read and write object in a file(database)
//To write in and read from people in a file
//Created by ESMAAEEL FAAKHERI ALAMDAARI
try {
    FileOutputStream f = new FileOutputStream(new File("DataBase.txt"));
    ObjectOutputStream o = new ObjectOutputStream(f);
    
    //Write objects

    ArrayList k = st.GetTotal();
    int y = 0;
    
    for(Object p : k)
    {
        Person w = (Person) p;
        o.writeObject(w);
        y++;
    }
  
    o.close();
    f.close();

    // Read objects
    
    FileInputStream fi = new FileInputStream(new File("DataBase.txt"));
    ObjectInputStream oi = new ObjectInputStream(fi);
    
    for(int i=1 ; i<=y ; i++)
    {
     Person pr_i = (Person) oi.readObject();  
     st.put(pr_i.GetID(), pr_i);
     Dic.put(pr_i.GetUserName(), pr_i.GetID());
    }

    oi.close();
    fi.close();

    } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
    } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
            e.printStackTrace();
    }catch (ClassNotFoundException e) {
            e.printStackTrace();
    }
//To write in and read from stuffs in a file
try {
    FileOutputStream f = new FileOutputStream(new File("StuffBase.txt"));
    ObjectOutputStream o = new ObjectOutputStream(f);
    
    //Write objects

    ArrayList k = stuf.GetTotal();
    int y = 0;
    
    for(Object p : k)
    {
        Person w = (Person) p;
        o.writeObject(w);
        y++;
    }
  
    o.close();
    f.close();

    // Read objects
    //Created by ESMAAEEL FAAKHERI ALAMDAARI
    FileInputStream fi = new FileInputStream(new File("StuffBase.txt"));
    ObjectInputStream oi = new ObjectInputStream(fi);
    
    for(int i=1 ; i<=y ; i++)
    {
     Person pr_i = (Person) oi.readObject();  
     stuf.put(pr_i.GetID(), pr_i);
     StuffDic.put(pr_i.GetID(), pr_i);
    }

    oi.close();
    fi.close();

    } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
    } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
            e.printStackTrace();
    }catch (ClassNotFoundException e) {
            e.printStackTrace();
    }

//////////There is some code to see how the program works
    BTREES<Integer, Object> t = new BTREES<>();
    BTREES<Integer, Object> s = new BTREES<>();
//    Map<Integer,Object> StuffD = new HashMap<>();    
    Map<String,Integer> D = new HashMap<>();        
//We add some selesman to the B-tree
    t.put(h_1.GetID(), h_1);   
    t.put(h_2.GetID(), h_2);
    t.put(h_3.GetID(), h_3);
    t.put(h_4.GetID(), h_4);
//we add some customer to the B-tree
    t.put(c_1.GetID(), c_1);
    t.put(c_2.GetID(), c_2);
    t.put(c_3.GetID(), c_3);
//We add some stuff to the B-tree
    t.put(s_1.GetID(), s_1);   
    t.put(s_2.GetID(), s_2);
    t.put(s_3.GetID(), s_3);
    t.put(s_4.GetID(), s_4);
    t.put(s_5.GetID(), s_5);   
    t.put(s_6.GetID(), s_6);    
//Now add the people to the Dictionary
    D.put(h_1.GetUserName(), h_1.GetID());
    D.put(h_2.GetUserName(), h_2.GetID());
    D.put(h_3.GetUserName(), h_3.GetID());
    D.put(h_4.GetUserName(), h_4.GetID());
    D.put(c_1.GetUserName(), c_1.GetID());
    D.put(c_2.GetUserName(), c_2.GetID());
    D.put(c_3.GetUserName(), c_3.GetID());
    
////At first we sign in the shop
////It can detect that if username --or-- password is right  
//
    t.Signin(t, D ,c_1.GetUserName() , c_1.GetPassword());
    t.Signin(t, D, h_1.GetUserName() , h_1.GetPassword());
    System.out.println();
    
////###############//Customer
////Add stuff to the customer's cart

    c_1.addstuff(s_6, 44);
    c_1.addstuff(s_6, 50);
    c_1.addstuff(s_3, 454);
    c_1.addstuff(s_2, 4);

////Show what we have in the cart
////When we add a stuff to a cart , it will reduce it's count from shop

    c_1.cart();
    
    System.out.println("count is : "+s_6.GetCount());
    System.out.println("number is : "+s_6.GetNumber());
    System.out.println();

//###############//Selesman
//Get all the stuff that the selesman has added

  h_1.Property(StuffDic);

    }
}
//Created by ESMAAEEL FAAKHERI ALAMDAARI