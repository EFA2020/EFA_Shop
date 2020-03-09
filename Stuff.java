public class Stuff extends Person{
        private int ID;
        private static final long serialVersionUID = 1L;
        private int Number;
        private int Count;
        private int OwnerId;
        private String Name;
        private String Color;
        private String MoreDetails;
        private boolean Available;
        private double Price;

        public Stuff(int ID ,int OwnerId ,int Count,int Number , double Price , String Name , String Color , boolean Available ,String MoreDetails)
        {
            this.Available = Available;
            this.Color = Color;
            this.OwnerId = OwnerId;
            this.Count = Count;
            this.ID = ID;
            this.MoreDetails = MoreDetails;
            this.Name = Name;
            this.Price = Price;
            this.Number = Number;
        }
        public Stuff()
        {
            this(3,1000000,23,20,23422.3,"adfa","Afafa",true,"weawedaadadad");
        }
        @Override
        public void SetNumber( int Number)
        {
            this.Number = Number;
        }
        @Override
        public void SetCount( int Count)
        {
            this.Count = Count;
        }
        @Override
        public int GetCount()
        {
            return this.Count;
        }
        @Override
        public void SetOwnerId(int Id)
        {
            this.OwnerId = Id;
        }
        @Override
        public void SetPrice( double price)
        {
            this.Price = price;
        }
        @Override
        public void SetAvailable( boolean Available)
        {
            this.Available = Available;
        }
        @Override
        public void SetMoreDetails( String MoreDetails)
        {
            this.MoreDetails = MoreDetails;
        }
        @Override
        public int GetID()
        {
            return this.ID;
        }
        @Override
        public int GetOwnerId()
        {
            return this.OwnerId;
        }
        @Override
        public int GetNumber()
        {
            return this.Number;
        }
        @Override
        public String GetColor()
        {
            return this.Color;
        }
        @Override
        public String GetMoreDetails()
        {
            return this.MoreDetails;
        }
        @Override
        public String GetName()
        {
            return this.Name;
        }
        @Override
        public boolean Available()
        {
            return this.Available;
        }
        @Override
        public double GetPrice()
        {
            return this.Price;
        }       
}
