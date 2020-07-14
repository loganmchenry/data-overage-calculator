package ATTCalculator;

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
        
        System.out.print("Enter the number of people on the data plan: ");
        size = in.nextInt();
        Consumer[] list = new Consumer[size];

        for (int i = 0; i < list.length; i++) {
            System.out.print("Enter the name of person " + i + " on the plan: ");
            list[i] = (new Consumer(in.nextString()));
            System.out.print("\n");
        }
        
        for (int i = 0; i < list.length; i++) {
            System.out.print("How much data did " + list[i].getName() + " use? ");
            list[i].setData(in.nextDouble());
            //System.out.print("\n");
        }

        System.out.print("What was the total cost of overages? $");
        cost = in.nextDouble();

        calculate(list, cost);
        //System.out.println("\n or...");
        //altCalculate(list, cost);

    }

    //ctor
    public Calculator() {
    }

    //calculates usage
    public static void calculate(Consumer[] list, double cost) {
        double total = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getData() > 5.0) {
                total += (list[i].getData() - 5);
            }
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].getData() > 5.0) {
                double percent = ((list[i].getData() - 5) / total);
                list[i].setOwed(percent * cost);
                System.out.printf(list[i].getName() + " owes: $%.01f \n", list[i].getOwed());
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
