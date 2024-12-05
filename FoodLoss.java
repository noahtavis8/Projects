package engr102;

import java.util.Scanner; //preps system for scanner usage

public class FoodLoss {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Welcome to Group 27's food waste algorithm!%n");
        System.out.printf("This program will ask you for food waste inforation and report whether the type of food is efficient or not.%n%n");
        System.out.printf("To begin, please determine whether you would like to input efficiency of food as a percent%n");
        System.out.printf("or input the weight of food produced and the weight of food wasted in pounds.%n%n");
        boolean loop = true;
        
        while(loop) {
            System.out.printf("Enter (1) for efficiency percentage%n");
            System.out.printf("Enter (2) for weight produced and weight wasted%n");
            System.out.printf("Enter (3) to quit the program%n");
            System.out.printf("Your choice: ");
            String choice = input.nextLine();

            switch(choice.toLowerCase()) {
                case "1":
                case "percent":
                case "efficiency":
                case "efficiency percent":
                    percent(input);
                    break;
                case "2":
                case "weight":
                case "weight lost":
                case "weight produced":
                case "weight produced and weight lost":
                    weight(input);
                    break;
                case "3":
                case "q":
                case "quit":
                    loop = false;
                    break;
                default:
                    System.out.printf("%nInput not recognized.%n%n");
            }
        }
        input.close();
    }
                    
    public static void percent(Scanner input) {
        boolean loop = true;
        System.out.printf("You chose to input a percentage.%n%n");
        System.out.printf("Please provide the type of food: ");
        String foodType = input.nextLine();
        while(loop) {
            try {
                System.out.printf("Please provide the percent of food wasted as a whole number%n");
                System.out.printf("(for example, if \"1.1\" is entered it will be treated as 1.1%)%n");
                System.out.printf("Percent as a number: ");
                float percent = input.nextFloat();
                if (percent > 25) {
                    System.out.printf("\n" + foodType + " is an inefficient food source in terms of waste.%n");
                    System.out.printf("Consider choosing another alternative with a higher percentage of efficiency.%n");
                }
                else if (percent <= 25) {
                    System.out.printf(foodType + " is efficient in terms of food waste!");
                    System.out.printf("Consider incorperating this food type into your diet more often.%n");
                }
                loop = false;
            }
            catch(Exception e) {
                System.out.printf("Please enter a number when inputting efficiency percentage.");
                input.nextLine();
            }
        }
    }

    public static void weight(Scanner input) {
        boolean loop = true;
        System.out.printf("You chose to input weight in pounds.%n%n");
        System.out.printf("Please provide the type of food: ");
        String foodType = input.nextLine();
        while(loop) {
            try {
                System.out.printf("Please provide the weight of this food produced as a whole number: ");
                float produced = input.nextFloat();
                System.out.printf("Please provide the weight of this food wasted as a whole number: ");
                float wasted = input.nextFloat();
                float percent = (wasted / produced) * 100;
                System.out.println("The percent of food that was wasted is " + percent + "%.");
                if (percent > 25) {
                    System.out.printf(foodType + " is an inefficient food source in terms of waste.%n");
                    System.out.printf("Consider choosing another alternative with a higher percentage of efficiency.%n");
                }
                else if (percent <= 25) {
                    System.out.printf(foodType + " is efficient in terms of food waste!");
                    System.out.printf("Consider incorperating this food type into your diet more often.%n");
                }
                loop = false;
            }
            catch(Exception e) {
                System.out.printf("Please enter a number when inputting weights.");
            }
        }
    }
}