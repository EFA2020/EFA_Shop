import java.util.Iterator;
import java.util.Map;
//this the selesman which is inherited from the Person class 
//Created by ESMAAEL FAKHERI ALAMDARI
public class SelesMan extends Person {
    private static final long serialVersionUID = 1L;
    private String ComponyName;
    private String ComponyAddress;
    private String ComponyPhone;
    BTREES<Integer, Object> btree = new BTREES<>();

    public SelesMan(int ID, String UserName, String FullName, String Password, String Email, String Address, String Phone , String ComponyName , String ComponyAddress , String ComponyPhone) {
        super(ID, UserName, FullName, Password, Email, Address, Phone , ComponyName , ComponyAddress , ComponyPhone );
        this.ComponyAddress =  ComponyAddress;
        this.ComponyName = ComponyName;
        this.ComponyPhone = ComponyPhone;
    }
//Created by ESMAAEEL FAAKHERI ALAMDAARI
    
    public SelesMan()
    {
        this(1000000, "ALI" , "ALppppppppI" , "1212" , "ALi@gamil.com" , "Irani" , "00000000" , "EFACOMPONY" , " ALAMDAAR" , "12114141" );
    }
    @Override
        public int GetID()
    {
        return this.ID;
    }
    @Override
    public String GetUserName()
    {
        return this.GetUserName(); 
    }
    @Override
    public String GetPassword()
    {
        return super.GetPassword(); 
    }
    @Override
    public String GetEmail()
    {
        return super.GetEmail();
    }
    @Override
    public String GetAddress()
    {
        return super.GetAddress();
    }
    @Override
    public String GetPhone()
    {
        return super.GetPhone();
    }
    @Override
    public String GetFullName()
    {
        return super.GetFullName();
    }
    @Override
    public String GetComponyName()
    {
        return this.ComponyName;
    }
    @Override
    public String GetComponyAddress()
    {
        return this.ComponyAddress;
    }
    @Override
    public String GetComponyPhone()
    {
        return this.ComponyPhone;
    }
// a method to get all of the sellesman's stuffs with total income
    @Override
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
}
//Created by ESMAEL FAKHERI ALAMDARI

