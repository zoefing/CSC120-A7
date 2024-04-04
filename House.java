// import statements
import java.util.ArrayList;

/**
 * the house class creates a house type building
 * this class contians methods to add and remove residents from the house
 * the class also contains a main method to test the class
 */
public class House extends Building {

  // variables

  /**
   * boolean value to check if the house has an elevator
   */
  boolean hasElevator;

  /**
   * boolean value to check if the house has a dining room
   */
  boolean hasDiningRoom;

  /**
   * list of residents in the house
   */
  ArrayList<String> residents;

  // constructor

  /**
   * constructs a House object with the specified name, address, number of floors, and features
   * 
   * @param name           the name of the house
   * @param address        the address of the house
   * @param numFloors      the number of floors in the house
   * @param hasElevator    true if the house has an elevator, false otherwise
   * @param hasDiningRoom  true if the house has a dining room, false otherwise
   */
  public House(String name, String address, int numFloors, boolean hasElevator, boolean hasDiningRoom) {
    super(name, address, numFloors);
    this.hasElevator = hasElevator;
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }

 /**
  * constructs a House object with only the specified name and address
  * @param name
  * @param address
  */
  public House(String name, String address) {
    this(name, address, 1, false, false);
    System.out.println("You have built a house: 🏠");
  }

  /**
   * constructs a House object with only the specified name and whether it has a dining room (important stuff!)
   * @param name
   * @param hasDiningRoom
   */
  public House(String name, boolean hasDiningRoom) {
    this(name, "<Address Unknown>", 1, false, hasDiningRoom);
    System.out.println("You have built a house: 🏠");
  }

  // methods

  /**
   * returns a string representation of the house object
   * 
   * @return a string representation of the house object
   */
  public String toString() {
    // create a string representation of the house as the description
    String desc = super.toString();
    // if the house has a dining room, add that to the description
    if (this.hasDiningRoom) {
      desc += "\nThis house has a dining room. ";
    }
    // if the house has an elevator, add that to the description
    if (this.hasElevator) {
      desc += "\nThis house has an elevator. ";
    }
    // return the description
    return desc;
  }

  /**
   * adds a resident to the house
   * 
   * @param name  the name of the resident
   */
  public void moveIn(String name) {
    // add the resident to the list of residents
    this.residents.add(name);
    // print confirmation
    System.out.println(name + " has moved into " + this.name);
  }

  /**
   * removes a resident from the house
   * 
   * @param name  the name of the resident
   * @return      the name of the resident who moved out
   */
  public String moveOut(String name) {
    // check if the person is a resident
    if (this.residents.contains(name)) {
      // remove the resident from the list of residents
      this.residents.remove(name);
      System.out.println(name + " has moved out of " + this.name);
      return name;
    }
    else {
      // print apology
      return (name + " is not a resident of " + this.name);
    }
  }

  /**
   * checks if a person is a resident of the house
   * 
   * @param person  the name of the person
   * @return        true if the person is a resident, false otherwise
   */
  public boolean isResident(String person) {
    // check if the person is a resident & return boolean value
    return this.residents.contains(person);
  }

  @Override 
  public void goToFloor(int floorNum) {
    // check if the house has an elevator
    if (this.hasElevator) {
      // call the goToFloor method from the Building class
      super.goToFloor(floorNum);
    }
    else {
      // print apology
      System.out.println("Sorry, " + this.name + " does not have an elevator. Please use go up or go down.");
    }
  }

  // override the show options method from the Building class 
  @Override 
  public void showOptions() {
    // determines whether house has an elevator and shows options accordingly
    if (this.hasElevator) {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn(name)\n + moveOut(name)\n + isResident(name)");
    }
    else {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + moveIn(name)\n + moveOut(name)\n + isResident(name)");
    }
  }

  // // main method

  // /**
  //  * main method to test the house class
  //  * 
  //  * @param args  command line arguments
  //  */
  // public static void main(String[] args) {
  //   House Albright = new House("Albright House", "7 Bedford Terrace", 4, false, false);
  //   System.out.println(Albright);
  //   House Lamont = new House("Lamont House", "17 Prospect Street", 3, true, true);
  //   System.out.println(Lamont);
  //   // show options
  //   Albright.showOptions();
  //   Albright.goToFloor(3);
  // }
}