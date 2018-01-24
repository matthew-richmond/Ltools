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

    /**
     * helper function to populate data, reads from stdin.
     * Handles type-checking, as it terminates when it recieves
     * something that isn't an Int
     */
    private static void lpop(ArrayList<Integer> data){
        Scanner in = new Scanner(System.in);
        System.out.print(">");
        String x;
        int z;
        while(!(x = in.nextLine()).equals("")){
            System.out.println(x);
            z = Integer.valueOf(x);
            System.out.print(">");
            data.add(z);
        }
        in.close();
    }

    /**
     * Sorts data using an insertion sort algorithm
     * since isort is an in-place sort, no need for a return type
     * @param arr the arraylist containing the data that needs sorted
     */
    private static void isort(ArrayList<Integer> arr)
    {
        int i, key, j;
        for (i = 1; i < arr.size(); i++)
        {
            key = arr.get(i);
            j = i-1;

       /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
            while (j >= 0 && arr.get(j) > key)
            {
                arr.add(j+1, arr.remove(j));
                j = j-1;
            }
        }
    }

    public static void main(String[] args){
        if (args.length == 1){
            System.out.println("Reading csvs from file: " + args[1]);
        }
        else if(args.length == 0){
            System.out.println("Please enter your data, one number at a time, enter a non-integer when done");
            ArrayList<Integer> data = new ArrayList<>();
            lpop(data);
            isort(data);
            System.out.println(data);
        }
        else {
            System.out.println("useage: java ltools.java [fname:]");
        }
    }
}
