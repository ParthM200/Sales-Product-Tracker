import java.util.Scanner;
import java.util.ArrayList;

public class menu {
    private Scanner numberScanner;

    private SalesPerson[] salesPerson;
    private ArrayList<product> productBuilder = new ArrayList<product>();

    private int userSelection;

    private int arrayCount;
    private int arrayCount1;

    public menu() {
        numberScanner = new Scanner(System.in);

        userSelection = 0;
        while (userSelection == 0) {
            System.out.println("Please select which option you would like to do: ");
            System.out.println("");

            System.out.println("Option 1 - Enter new salesperson information");

            System.out.println("Option 2 - Update existing salesperson goal");

            System.out.println("Option 3 - Build Product Database");

            System.out.println("Option 4 - Update existing product info");

            System.out.println("Option 99 - Finished");
            System.out.println("");

            System.out.print("Enter your selection - ");

            String test3 = "";
            if (!(test3 = numberScanner.nextLine()).isEmpty()) {
                try {
                    userSelection = Integer.parseInt(test3);
                    {
                        // New Employee Info
                        if (userSelection == 1) {
                            userSelection = 1;

                            // Creates new instance of build class
                            build myBuild = new build();

                            // salesPerson array updated after being passed into the runner method of the
                            // build class
                            salesPerson = myBuild.runner(salesPerson);

                            userSelection = 0;
                        }
                        // Update exisitng employee info
                        else if (userSelection == 2) {
                            userSelection = 2;

                            updateGoal myGoal = new updateGoal();
                            salesPerson = myGoal.runner(salesPerson);

                            userSelection = 0;
                        }
                        // Add new products to database
                        else if (userSelection == 3) {
                            userSelection = 3;

                            // Checks for empty arraylist
                            if (productBuilder.isEmpty()) {
                                System.out.println("\nThere are no products currently in the database");
                            }

                            // Prints products already in database
                            else {
                                System.out.println("Products currently in database: \n");
                                for (int i = 0; i < productBuilder.size(); i++) {
                                    System.out.println("Product " + (i + 1) + ": " + productBuilder.get(i));
                                }

                            }

                            buildProductArray myProduct = new buildProductArray();
                            productBuilder = myProduct.runner(productBuilder);

                            userSelection = 0;
                        }

                        else if (userSelection == 4) {
                            userSelection = 4;

                            if (productBuilder.isEmpty()) {
                                System.out.println("");
                                System.out.println(
                                        "Database is currently empty, you must enter products before you can update them");
                                userSelection = 0;
                            }

                            else {
                                System.out.println(" ");
                                System.out.println("Products currently in database: \n");

                                for (product x : productBuilder) {
                                    System.out.println("Product " + (arrayCount + 1) + ":" + x);
                                    System.out.println("");
                                    arrayCount++;

                                }
                                updateProductInfo product = new updateProductInfo();
                                productBuilder = product.runner(productBuilder);

                                System.out.println("");
                                System.out.println("Newest version of products currently in database: ");
                                for (product y : productBuilder) {
                                    System.out.println("Product " + (arrayCount1 + 1) + ":" + " " + y);
                                    System.out.println("");
                                    arrayCount1++;

                                }

                                arrayCount = 0;
                                arrayCount1 = 0;

                            }

                            userSelection = 0;
                        }

                        else if (userSelection == 99) {
                            System.out.println("End");
                            userSelection = 1;
                        } else {
                            System.out.println("You must select either option 1, 2, 3 or 99!");
                            userSelection = 0;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Option number can only be integers");
                    System.out.println("Currently only options 1, 2, 3, and 99 are availabe");
                    System.out.println("");
                    userSelection = 0;
                }
            } else {
                System.out.println("");
                System.out.println("You must select option 1, 2, 3 or 99!");

            }
        }

    }

    public void runner() {

    }
}
