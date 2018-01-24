import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Matthew Richmond
 * mjr1408@cs.rit.edu
 *
 */
public class ltools {
    private ArrayList<Integer> data = new ArrayList<>(); //Data to be stored and used by these tools

    /**
     * helper function to populate data, reads from stdin.
     * Handles type-checking, as it terminates when it recieves
     * something that isn't an Int
     */
    private void lpop(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int x = in.nextInt();
            data.add(x);
        }
    }

    /**
     * Sorts data using an insertion sort algorithm
     * since isort is an in-place sort, no need for a return type
     * @param data the arraylist containing the data that needs sorted
     */
    private void isort(ArrayList<Integer> data){
        int i = 0;
        while (i < data.size()){
            int x = data.get(i);
            int j = i - 1;
            while (j >= 0 && data.get(j) > x){
                data.add(j+1, data.remove(j));
                j--;
            }
            data.add(j+1,x);
            i++;
        }
    }

    public void main(String[] args){
        if (args.length == 2){
            System.out.println("Reading csvs from file: " + args[1]);
        }
        else if(args.length == 1){
            System.out.println("Please enter your data, one number at a time, enter a non-integer when done");
            lpop();
            isort(data);
            System.out.println(data);
        }
        else {
            System.out.println("useage: java ltools.java [fname:]");
        }
    }
}
