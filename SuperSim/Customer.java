import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
/**
 * Write a description of class Customer here.
 * 
 * @author AngryPirates First Mate Alex
 * @version 0.1
 */
public class Customer
{
    private final String CUSTOMER_TYPE; 
    private final int ID;
    private final int  MIN_ITEMS = 1; 
    private final int MAX_ITEMS;
    private final int ITEMS_TO_PICK; //Range of items to pick dependent on type of Customer.
    private int TIME_PER_ITEM = 5; //Arbitrary
    private final int TOTAL_ITEMS_AVAIL;
    private int shoppingTime; //The time the customer spends picking items
    private ArrayList<Item> trolley;
    private Random rand;
    private Math math;
    private ArrayList<Item> productList;
    //private final String  LOYALTY_CARD_NUMBER = "Parrot";
    private int timeInStore;
    private int timeInQueue;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(ArrayList<Item> productList,int myId, int hour)
    {
        this.productList = productList;
        ID = myId;
        timeInStore = 0;
        trolley = new ArrayList<Item>();
        rand = new Random();
        TOTAL_ITEMS_AVAIL = productList.size();
        /*Code to bias random based on time
         * Might have to change from switch to if and ifelse or have if and else if calculate the int for
         * switch based omc probabilities and distributions and then have a rand.nextInt() as last else.
         */
        double multiplyer = math.abs(rand.nextGaussian()*2*14); //Probability * Mean * StdDev then absolute.
        switch(rand.nextInt(5)){
            case 0: MAX_ITEMS = 5; CUSTOMER_TYPE = "Business"; break;
            case 1: MAX_ITEMS = 15; CUSTOMER_TYPE = "Old"; break;
            case 2: MAX_ITEMS = 90; CUSTOMER_TYPE = "Family"; break;
            case 3: MAX_ITEMS = 3; CUSTOMER_TYPE = "Children"; break;
            case 4: MAX_ITEMS = 25; CUSTOMER_TYPE = "Generic"; break;
            default: MAX_ITEMS = MIN_ITEMS; CUSTOMER_TYPE = "Generic"; break;//Ensures the compiler knows that it can always set MAX_ITEMS
        }
        int itemPickLimit = TOTAL_ITEMS_AVAIL;
        while(itemPickLimit >= TOTAL_ITEMS_AVAIL){//Makes sure the Customer can't choose more items than exist.
            itemPickLimit = MIN_ITEMS + rand.nextInt(MAX_ITEMS - MIN_ITEMS); //Finds range to pick items.
        }
        ITEMS_TO_PICK = itemPickLimit;
        setShoppingTime(ITEMS_TO_PICK * TIME_PER_ITEM);
    }    

    public double addItem()
    {
<<<<<<< HEAD
        double itemPrice = 0;
        if(shoppingTime % (rand.nextInt(shoppingTime)+1) == 0){ //If timeinstore % timeperitem == 0. Might do by ticks so shoppingTime % ticks == 0
=======
        if(shoppingTime % (rand.nextInt(TIME_PER_ITEM)+1) == 0){ //If timeinstore % timeperitem == 0. Might do by ticks so shoppingTime % ticks == 0
>>>>>>> d7294f87ea1acd4b3a8adff50b889a0c15995d33
            if(trolley.size() < ITEMS_TO_PICK){
                Item itemSelect = productList.get(rand.nextInt(TOTAL_ITEMS_AVAIL));
                trolley.add(itemSelect);
                shoppingTime-= (TIME_PER_ITEM);
                itemPrice += itemSelect.getPrice();
            }
            else{
                //Customer has all required items
                setShoppingTime(0);
            }
        }
        timeInStore++;
        
        return itemPrice;
    }

    /**
     * An accessor method for use in the Store class
     * @return trolley.size() The number of items in the Customer's 'trolley'
     */
    public int getTrolleyCount()
    {
        return trolley.size();   
    }

    /**
     * An accessor method for use in the Store class
     * @return SHOPPING_TIME
     */
    public int getShoppingTime()
    {
        return shoppingTime;
    }

    /**
     * A mutator method to decrement the time remaining to pick items based on the global time from the Store class
     * @param newTime the new global time
     */
    public void setShoppingTime(int newTime)
    {
        shoppingTime = newTime;
    }

    /**
     * An accessor method to make use of the 'trolley' in the Checkout and Store classes
     * @return trolley An ArrayList of Item containing what the customer has 'chosen'
     */
    public ArrayList<Item> getTrolley()
    {
        return trolley;
    }

    public Item removeTrolleyItem()
    {
        return trolley.remove(0);
    }

    public int getTimeInStore()
    {
        return timeInStore;
    }

    /**/

    public void incWait()
    {
        timeInQueue++;
    }

    public int getTimeInQueue()
    {
        return timeInQueue;
    }
}
