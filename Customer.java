//Created by ESMAAEEL FAAKHERI ALAMDAARI

public class Customer extends Person
{    
    private static final long serialVersionUID = 1L;
    BTREES<Integer, Object> btree = new BTREES<>();
    public Customer(int ID, String UserName, String FullName, String Password, String Email, String Address, String Phone) {
        super(ID, UserName, FullName, Password, Email, Address, Phone ,null,null,null);
    }
    public Customer()
    {
        this(156 , "EFA" , "ESMAEEL" , "1212" , "mehdi@wee.com" , "Tehrani" , "00000000");
    }
//this is a method to add stuff to customer's cart
    @Override
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
      //Created by ESMAAEEL FAAKHERI ALAMDAARI
    @Override
       public double cart()
       {
           return btree.Total();
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
}
//Created by ESMAAEEL FAAKHERI ALAMDAARI
