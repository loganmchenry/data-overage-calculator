package DataCalculator;

import java.util.Scanner;

/**
 *
 * @author logan
 */
public class Calculator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double cost;
        int size;
        int dataLimit = 0; // limit for the entire plan
        double dataPerPerson = 0; // limit for each person based on dataLimit / # of people 
        
        System.out.print("Enter the number of people on the data plan: ");
        size =  Integer.parseInt(in.nextLine());
        Consumer[] list = new Consumer[size];

        for (int i = 0; i < list.length; i++) {
            System.out.print("Enter the name of person " + i + " on the plan: ");
            list[i] = (new Consumer(in.nextLine()));
        }
        
        for (int i = 0; i < list.length; i++) {
            System.out.print("How much data did " + list[i].getName() + " use? ");
            list[i].setData(in.nextDouble());
            //System.out.print("\n");
        }


        System.out.print("What is the data limit for the entire plan (in gigabytes)? ");
        dataLimit = in.nextInt();
        dataPerPerson = dataLimit / size;
        System.out.print("What was the total cost of overages? $");
        cost = in.nextDouble();

        calculate(list, cost, dataPerPerson);
        //System.out.println("\n or...");
        //altCalculate(list, cost);

    }

    //ctor
    public Calculator() {
    }

    //calculates usage
    public static void calculate(Consumer[] list, double cost, double dataPerPerson) {
        double total = 0;
        

        for (int i = 0; i < list.length; i++) {
            if (list[i].getData() > dataPerPerson) {
                total += (list[i].getData() - dataPerPerson);
            }
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].getData() > dataPerPerson) {
                double percent = ((list[i].getData() - dataPerPerson) / total);
                list[i].setOwed(percent * cost);
                System.out.printf(list[i].getName() + " owes: $%.01f \n", list[i].getOwed());
            } else {
                System.out.println(list[i].getName() + " owes nothing for overages!");
            }
        }

    }

    //calculates usage
    public static void altCalculate(Consumer[] list, double cost) {
        double total = 0;
        for (int i = 0; i < list.length; i++) {
            total += (list[i].getData());
        }
        for (int i = 0; i < list.length; i++) {
            double percent = (((list[i].getData()) / total));
            list[i].setOwed(percent * cost);
            System.out.printf(list[i].getName() + " owes: $%.01f \n", list[i].getOwed());
        }
    }

}
