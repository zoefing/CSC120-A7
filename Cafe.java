/**
 * the cafe class creates a cafe type building
 * this class contians methods to sell coffee and restock the cafe
 * the class also contains a main method to test the class
 */
public class Cafe extends Building {

    // variables
    
    /**
     * the number of ounces of coffee remaining in inventory, intialized at 0
     */
    private int nCoffeeOunces = 0;

    /**
     * the number of sugar packets remaining in inventory, intialized at 0
     */
    private int nSugarPackets = 0;

    /**
     * the number of splashes of cream remaining in inventory, intialized at 0
     */
    private int nCreams = 0;

    /**
     * the number of cups remaining in inventory, intialized at 0
     */
    private int nCups = 0;

    /**
     * boolean value to check if the cafe has an elevator
     */
    boolean hasElevator;

    // constructor

    /**
     * constructs a cafe object with the specified name, address, number of floors, and inventory
     * 
     * @param name           the name of the cafe
     * @param address        the address of the cafe
     * @param numFloors      the number of floors in the cafe
     * @param hasElevator    true if the cafe has an elevator, false otherwise
     * @param nCoffeeOunces  the number of ounces of coffee in the cafe's inventory
     * @param nSugarPackets  the number of sugar packets in the cafe's inventory
     * @param nCreams        the number of splashes of cream in the cafe's inventory
     * @param nCups          the number of cups in the cafe's inventory
     */
    public Cafe(String name, String address, int numFloors, boolean hasElevator, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        // take the variables name, address, and number of floors from the building class
        super(name, address, numFloors);

        // set up the new variable hasElevator
        this.hasElevator = hasElevator;

        // set up some new variables (for the inventory)
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

        // print statment just for fun :)
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * constructs a cafe object with only the specified name and address
     * 
     * @param name    the name of the cafe
     * @param address the address of the cafe
     */
    public Cafe(String name, String address) {
        this(name, address, 1, false, 0, 0, 0, 0);
        System.out.println("You have built a cafe: ☕");
    }

    // methods

    /**
     * check if sufficient inventory to sell coffee
     * if inventory contains enough coffee, sugar, cream, and cups, then sell a coffee of the specified size with the specified number of sugar packets and cream splashes
     * if inventory does not contain enough coffee, sugar, cream, or cups, then print apology and then restock
     * 
     * @param size          the size of the coffee
     * @param nSugarPackets the number of sugar packets in the coffee
     * @param nCreams       the number of cream splashes in the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        // print statments just for fun :)
        System.out.println("Thank you for your order!");
        System.out.println("Checking inventory...");

        // check to see if there is enough coffee, sugar, cream, and cups to make the coffee

        // if there is not enough coffee, sugar, cream, or cups to make the coffee, then print apology and restock
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            // print apology
            System.out.println("Sorry, we do not have enough ingredients to make that coffee.");

            // restock the cafe's inventory to be able to make the coffee
            restock(100, 100, 100, 100);
        }

        // precautionary statement. assumingly there should never be an order that cannot be fulfilled with 100 of each ingredient!
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            System.out.println("Apologies, even after restocking, we still cannot fulfill your order.");
            System.out.println("There is a dramatic supply chain shortage of coffee, sugar, cream, and/or cups.");
            System.out.println("Please come back later.");

        } else {
            System.out.println("Preparing coffee...");
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Enjoy your coffee!");
        }
    }

    /**
     * overloaded sellCoffee method to allow for the sale of a coffee with no sugar or cream
     * 
     * @param size the size of the coffee
     */
    public void sellCoffee(int size) {
        sellCoffee(size, 0, 0);
    }

    /**
     * restocks the cafe's inventory by adding the specified number of coffee ounces, sugar packets, cream splashes, and cups
     * 
     * @param nCoffeeOunces  the number of ounces of coffee to restock
     * @param nSugarPackets  the number of sugar packets to restock
     * @param nCreams        the number of cream splashes to restock
     * @param nCups          the number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        // print statment just for fun :)
        System.out.println("Restocking...");

        // "restocking" the inventory by adding new quanity onto current inventory
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += +nCups;

        // print statment just for fun :)
        System.out.println("Inventory restocked!");
    }

    /**
     * an additional function to visualize the inventory
     * this is done by printing out the inventory
     */
    private void inventory() {
        System.out.println("Inventory:");
        System.out.println("Coffee: " + this.nCoffeeOunces + " ounces");
        System.out.println("Sugar: " + this.nSugarPackets + " packets");
        System.out.println("Cream: " + this.nCreams + " splashes");
        System.out.println("Cups: " + this.nCups + " cups");
    }

    /**
     * does not allow public access to floors other than the first floor for non-employees by overriding the goToFloor method from the Building class
     * 
     * @param floorNum the floor number to go to
     */
    @Override 
    public void goToFloor(int floorNum) {
        // check if the requested floor is the first floor
        if (floorNum == 1) {
            // allow access to the first floor
            super.goToFloor(floorNum);
        } else {
            // print apology message indicating restriction to the first floor
            System.out.println("Sorry, " + this.name + " does not permit movement off the first floor.");
        }
    }

    /**
     * shows the options available at the cafe by overriding the showOptions method from the Building class
     * 
     * @return a string representation of the options available at the cafe
     */
    @Override 
    public void showOptions() {
        // check if the cafe has an elevator
        if (this.hasElevator) {
            System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goToFloor(n)\n + sellCoffee(size)\n + sellCoffee(size, nSugarPackets, nCreams)\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)\n + inventory");
        } else {
            System.out.println("Available options at " + this.name + ": \n + enter() \n + exit() \n + sellCoffee(size)\n + sellCoffee(size, nSugarPackets, nCreams)\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)\n + inventory()");
        }
    }

    /**
     * returns a string representation of the cafe object
     * 
     * @return a string representation of the cafe object
     */
    // public String toString() {
    //     String desc = super.toString();
    //     desc += "\nThis cafe has " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " sugar packets, " + this.nCreams + " cream splashes, and " + this.nCups + " cups.";
    //     return desc;
    // }
    
    // // main method

    // /**
    //  * main method to test the cafe class
    //  * 
    //  * @param args command line arguments
    //  */
    // public static void main(String[] args) {
    //     Cafe Antoinettes = new Cafe("Antoinettes", "417 Warburton Ave", 2, true, 0, 0, 0, 0);
    //     System.out.println(Antoinettes);
    //     // Antoinettes.sellCoffee(1, 2, 1);
    //     // Antoinettes.inventory();
    //     Antoinettes.showOptions();
    //     Antoinettes.goToFloor(2);
    // }
}