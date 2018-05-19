import brachAndBound.BranchAndBound;
import brachAndBound.bound.Bound;
import brachAndBound.bound.HardBound;
import brachAndBound.bound.SoftBound;
import brachAndBound.problem.IOFileKnapsack;
import brachAndBound.problem.KnapsackProblem;

import java.util.Scanner;

public class Main {

    private static final String MENU = "1. Generate a random knapsack.\n" +
                                       "2. Load a knapsack from a file.\n" +
                                       "3. Save the knapsack in a file.\n" +
                                       "4. Execute Branch and Bound algo.\n" +
                                       "5. Out.\n" +
                                       "Option (1-5): ";

    private static Scanner sc = new Scanner(System.in);


    public static void main(String [] args) {
        int op = 0;
        String aux = null;
        KnapsackProblem kP = null;
        Bound bound = null;

        do{
            System.out.print(MENU);

            try{
                op = Integer.parseInt(sc.nextLine());
                switch (op){

                    case 1:
                        int numObj;
                        do { numObj = askNumObj(); } while (numObj == -1);
                        kP = KnapsackProblem.getRandomKnapsackProblem(numObj);
                        System.out.println(kP);
                        break;

                    case 2:
                        System.out.print("Introduce a file name: ");
                        aux = sc.nextLine();
                        kP = IOFileKnapsack.getKnapSack(aux);
                        System.out.println(kP);
                        break;

                    case 3:
                        System.out.print("Introduce a file name: ");
                        aux = sc.nextLine();
                        IOFileKnapsack.writeKnapsack(kP, aux);
                        break;

                    case 4:
                        if(kP == null)
                            throw new Exception("There is no a knapsack problem.");

                        System.out.println("Do you want a soft or hard bound? (s, h): ");
                        aux = sc.nextLine();
                        if(!aux.equalsIgnoreCase("s") && !aux.equalsIgnoreCase("h"))
                            throw new Exception(aux + " is not a valid answer.");

                        if(aux.equalsIgnoreCase("s"))
                            bound = new SoftBound();
                        else
                            bound = new HardBound();

                        BranchAndBound bb = new BranchAndBound(bound, kP);
                        bb.calculateOptimalSolution();
                        System.out.println(bb);
                        break;

                    case 5:
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
                op = 0;
            }

        } while(op != 5);

    }

    private static int askNumObj(){
        int numObj;
        System.out.print("Please, choose the object´s number you want\n" +
                "Number: ");
        try{
            numObj = Integer.parseInt(sc.nextLine());
            if(numObj <= 0)
                throw new Exception("The number must be > 0");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        return numObj;
    }

}
