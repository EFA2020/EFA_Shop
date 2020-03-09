import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//Created by ESMAAEEL FAAKHERI ALAMDAARI
public class Person implements Serializable {
    int ID;
    private static final long serialVersionUID = 1L;
    private String UserName;
    private String FullName;
    private String Password;
    private String Email;
    private String Address;
    private String Phone;
    private String ComponyName;
    private String ComponyAddress;
    private String ComponyPhone;
    private String Name;
    private String Color;
    private String MoreDetails;
    private int Number;
    private int Count;
    private int OwnerId;
    private boolean Available;
    private double Price;
    BTREES<Integer, Object> btree = new BTREES<>();
    Map<String,Integer> Dic = new HashMap<>();
    public Person(int ID , String UserName , String FullName , String Password , String Email , String Address , String Phone , String ComponyName , String ComponyAddress , String ComponyPhone)
    {
        this.ID = ID;
        this.UserName = UserName;
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.Phone = Phone;
        this.ComponyAddress = ComponyAddress;
        this.ComponyName = ComponyName;
        this.ComponyPhone = ComponyPhone;
    }
    public Person(int ID , String UserName , String FullName , String Password , String Email , String Address , String Phone)
    {
        this.ID = ID;
        this.UserName = UserName;
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.Phone = Phone;
    }
    public Person()
    {
        this( 0, "EFA" , "ESMAEEL" , "1212" , "EFA@EFA.com" , "ALAMDAAR" , "00000000" , null , null , null);
    }
    public Person(int ID , int Number , double Price , String Name)
    {
        this.ID = ID;
        this.Number = Number;
        this.Price = Price;
        this.Name = Name;
    }
    public Person(int ID , int OwnerId ,int Count , int Number , double Price , String Name , String Color , boolean Available , String MoreDetails)
    {
        this.ID = ID;
        this.Count = Count;
        this.OwnerId = OwnerId;
        this.Number = Number;
        this.Price = Price;
        this.Name = Name;
        this.Color = Color;
        this.Available = Available;
        this.MoreDetails = MoreDetails;
    }
    
    public int GetID()
    {
        return this.ID;
    }
    public String GetUserName()
    {
        return this.UserName;
    }
    public String GetPassword()
    {
        return this.Password; 
    }
    public String GetFullName()
    {
        return this.FullName;
    }
    public String GetEmail()
    {
        return this.Email;
    }
//Created by ESMAAEEL FAAKHERI ALAMDAARI    
    public String GetAddress()
    {
        return this.Address;
    }
    public String GetPhone()
    {
        return this.Phone;
    }
    public String GetComponyName()
    {
        return this.ComponyName;
    }
    public String GetComponyAddress()
    {
        return this.ComponyAddress;
    }
    public String GetComponyPhone()
    {
        return this.ComponyPhone;
    }
    public int GetOwnerId()
    {
        return this.OwnerId;
    }
    public int GetNumber()
    {
        return this.Number;
    }
    public String GetColor()
    {
        return this.Color;
    }
    public String GetMoreDetails()
    {
        return this.MoreDetails;
    }
    public String GetName()
    {
        return this.Name;
    }
    public boolean Available()
    {
        return this.Available;
    }
    public double GetPrice()
    {
        return this.Price;
    }
    public void SetNumber( int Number)
    {
        this.Number = Number;
    }
    public void SetOwnerId(int Id)
    {
        this.OwnerId = Id;
    }
    public void SetPrice( double price)
    {
        this.Price = price;
    }
    public void SetAvailable( boolean Available)
    {
        this.Available = Available;
    }
    public void SetMoreDetails( String MoreDetails)
    {
        this.MoreDetails = MoreDetails;
    }
    public void SetCount( int Count)
    {
        this.Count = Count;
    }
    public int GetCount()
    {
        return this.Count;
    }
//Created by ESMAAEEL FAAKHERI ALAMDAARI
    public void addstuff(Person s , int number){
         if(s.GetNumber() >= number)
         {
            addstuff(s.GetID(),number,s.GetPrice(),s.GetName());
            s.SetNumber(s.GetNumber() - number);
         }
         else
             System.out.println("We Don't have that amount of " + s.GetName() + ", We Only Have : " + s.GetNumber());
     }   
    private void addstuff(int id , int number , double price , String name)
       {
          Person p = new Person(id,number,price,name);
          if(btree.get(id) == null)
                btree.put(p.GetID(),p);
          else
                btree.update(p.GetID(),number);    
       }
    public double cart()
   {
      return btree.Total();
   }
     public void Property(Map S)
    {   double totalincome = 0;
        double total = 0;
        int min = this.GetID();
        int max = min + 1000000;
            System.out.println("Your Stuff is here .... ");
            System.out.println();
             Iterator iterator = S.entrySet().iterator();   
            while (iterator.hasNext()) {
             Map.Entry me2 = (Map.Entry) iterator.next();
            int id = (Integer) me2.getKey();
            Person val = (Person) me2.getValue();

            if(id >= min && id < max)
            {
                System.out.println(val.toString());
                totalincome += val.GetPrice() * (val.GetCount()-val.GetNumber());
                total += val.GetPrice() * val.GetCount();
                System.out.println("Your total wealth is: " + total  + " and your total income is: " + totalincome);
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            }
            if(id >= max)
                break;
        }
}
    @Override
    public String toString()        
    {
    int j = 1000000;
    if(ID < j)
        return "ID: " + ID + "\nUserName: " + UserName + "\nFullName: " + FullName + "\nPassword: " + Password + "\nAddress: " + Address + "\nPhone: " + Phone;
    else
    {
        if( ID%j == 0)
            return "ID:" + ID + "\nUserName: " + UserName + "\nFullName: " + FullName + "\nPassword: " + Password + "\nAddress: " + Address + "\nPhone: " + Phone + "\nComponyName: " + ComponyName + "\nComponyAddress: " + ComponyAddress + "\nComponyPhone: " + ComponyPhone; 
        else
            return "ID:" + ID + "\nOwnerId: " + OwnerId + "\nCount: " + Count + "\nNumber: " + Number + "\nPrice: " + Price + "\nName: " + Name + "\nColor: " + Color + "\nAvailable: " + Available + "\nMoreDetails: " + MoreDetails;
      }
   }
}
//Created by ESMAAEEL FAAKHERI ALAMDAARI