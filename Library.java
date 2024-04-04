// import statements
import java.util.Hashtable;

/**
 * the library class creates a libray type building
 * this class contians methods to add and remove titles from the library, check out and return books, and print the collection
 * the class also contains a main method to test the class
 */
public class Library extends Building {

  // variables

  /**
   * boolean value to check if the library has an elevator
   */
  boolean hasElevator;

  /**
   * the collection of titles in the library
   */
  private Hashtable<String, Boolean> collection = new Hashtable<String, Boolean>();

  // constructor

  /**
   * constructs a library object with the specified name, address, and number of floors
   * 
   * @param name      the name of the library
   * @param address   the address of the library
   * @param numFloors the number of floors in the library
   * @param hasElevator true if the library has an elevator, false otherwise
   */
  public Library(String name, String address, int numFloors, boolean hasElevator) {
    super(name, address, numFloors);
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  // overloaded constructor with only name and number of floors
  /**
   * constructs a library object with only the specified name and number of floors
   * 
   * @param name      the name of the library
   * @param numFloors the number of floors in the library
   */
  public Library(String name, int numFloors) {
    super(name, "address unknown", numFloors);
    this.hasElevator = false;
    System.out.println("You have built a library: 📖");
  }

  // methods

  /**
   * adds a title to the library's collection
   * 
   * @param title the title to add to the library's collection
   */
  public void addTitle(String title) {
    collection.put(title, true);
  }

  /**
   * adds a title to the library's collection with an unknown title
   * 
   * @param author the author of the title
   * @param year the year the title was published
   */
  public void addTitle(String author, int year) {
    collection.put("Untitled" + " by " + author + " (" + year + ")", true);
  }

  /**
   * returns true if the title appears in the libary's collection, false otherwise
   * 
   * @param title the title to check for in the library's collection
   * @return true if the title appears as a key in the Libary's collection, false otherwise
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * returns true if the title is currently available, false otherwise
   * 
   * @param title the title to check for in the library's collection
   * @return true if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title) {
    return collection.get(title);
  }

  /**
   * removes a title from the library's collection
   * 
   * @param title the title to remove from the library's collection
   * @return the title that was removed from the library's collection
   */
  public String removeTitle(String title) {
    if (collection.containsKey(title)) {
      collection.remove(title);
      return title;
    } 
    else {
      return ("Sorry, we do not have " + title + " in our collection");   
    }
  }
  
  /**
   * checks out a title from the library's collection
   * 
   * @param title the title to check out from the library's collection
   */
  public void checkOut(String title) {
    // if the title is in the collection
    if (collection.containsKey(title)) {

      // check if the title is available

      // if the title is available
      if (collection.get(title)) {
        // set the title to not available
        collection.put(title, false);
        // print confirmation
        System.out.println("You have checked out " + title);
      } 

      // otherwise, if the title is not available
      else {
        // print apology
        System.out.println("Sorry, " + title + " is already checked out");
      }
    } 
    // otherwise, if the title is not in the collection
    else {
      // print apology
      System.out.println("Sorry, we do not have " + title + " in our collection");
    }
  }

  /**
   * returns a title to the library's collection
   * 
   * @param title the title to return to the library's collection
   */
  public void returnBook(String title) {
    // if the title is in the collection
    if (collection.containsKey(title)) {
      // if the title is not available
      if (!collection.get(title)) {
        // set the title to available
        collection.put(title, true);
        // print confirmation
        System.out.println("You have returned " + title);
      } 
      // if the title is in the collection, but is available
      else {
        // print apology
        System.out.println("Sorry, " + title + " was not checked out");
      }
    } 
    // if the title is not in the collection
    else {
      System.out.println("Sorry " + title + " that is not a title in our collection");
    }
  }

  /**
   * prints the library's collection
   */
  public void printCollection() {
    System.out.println("The library's collection:");
    for (String title:collection.keySet()) {
      System.out.println(title + " - " + (collection.get(title) ? "available" : "checked out"));
    }
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
    // determines whether library has an elevator and shows options accordingly
    if (this.hasElevator) {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(title)\n + addTitle(author, year)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + printCollection()");
    }
    else {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + addTitle(title)\n + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + printCollection()");
    }
  }

  // // main method

  // /**
  //  * main method to test the library class
  //  * 
  //  * @param args command line arguments
  //  */
  // public static void main(String[] args) {
  //   // initialize a new library
  //   Library Neilson = new Library("Neilson Library", "7 Neilson Drive Northampton", 5, true);
  //   System.out.println(Neilson);

  //   // test show options
  //   Neilson.showOptions();

  //   // test entering
  //   Neilson.enter();
  //   // test going up one flight of floors
  //   Neilson.goUp();
  //   // test taking an elevator to the 4th floor
  //   Neilson.goToFloor(4);
  //   // test going down two flights of floors
  //   Neilson.goDown();
  //   Neilson.goDown();
  //   Neilson.goDown();
  //   // test exiting (from first floor)
  //   Neilson.exit();

    // // add books to library collection
    // Neilson.addTitle("The Great Gatsby by F. Scott Fitzgerald");
    // Neilson.addTitle("The Color Purple by Alice Walker");
    // Neilson.addTitle("The Catcher in the Rye by J.D. Salinger");

    // // print collection
    // Neilson.printCollection();
  // }
}