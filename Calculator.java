package ATTCalculator;

import java.util.Scanner;

/**
 *
 * @author logan
 */
public class Calculator {

    public static void main(String[] args) {
        Consumer Austin = new Consumer("Austin");
        Consumer Leslie = new Consumer("Leslie");
        Consumer Sissy = new Consumer("Sissy");
        Consumer Patrick = new Consumer("Patrick");
        Consumer Mandi = new Consumer("Mandi");
        Consumer Heather = new Consumer("Heather");
        Consumer Logan = new Consumer("Logan");
        Consumer Rick = new Consumer("Rick");

        Consumer[] list = new Consumer[8];
        list[0] = Austin;
        list[1] = Leslie;
        list[2] = Sissy;
        list[3] = Patrick;
        list[4] = Mandi;
        list[5] = Heather;
        list[6] = Logan;
        list[7] = Rick;

        Scanner in = new Scanner(System.in);
        double cost;

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
