import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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
            while (j >= 0 && arr.get(j) > key)
            {
                arr.add(j+1, arr.remove(j));
                j = j-1;
            }
        }
    }

    private static int mean(ArrayList<Integer> data){
        int ttl = 0;
        int count = 0;
        for(int x: data){
            ttl += x;
            count++;
        }
        return ttl/count;
    }

    private static int mode(ArrayList<Integer> data){
        HashMap<Integer, Integer> numlist = new HashMap<>();
        for(int x: data){
            if(numlist.containsKey(x)){
                numlist.put(x, numlist.get(x) + 1);
            }
            else{
                numlist.put(x, 1);
            }
        }
        int most = 0;
        int num = 0;
        for(int z: numlist.keySet()){
            if(numlist.get(z) > most){
                most = numlist.get(z);
                num = z;
            }
        }
        return num;
    }

    private static int median(ArrayList<Integer> data){
        int size = data.size();
        int ind = size/2;
        if(size%2 == 0){
            int lowi = size/2;
            int highi = size/2 + 1;
            int med = (data.get(lowi) + data.get(highi)) / 2;
            return med;
        }
        else{
            return data.get(ind);
        }
    }


    public static void main(String[] args) throws IOException{
        ArrayList<Integer> data = new ArrayList<>();
        if (args.length == 1){
            System.out.println("Reading csv's from file: " + args[0]);
            File f = new File(args[0]);
            Scanner fin = new Scanner(f);
            while(fin.hasNext()){
                String input = fin.nextLine();
                String[] csv = input.split(",");
                for(String x: csv){
                    data.add(Integer.valueOf(x));
                }
            }
            isort(data);
        }
        else if(args.length == 0){
            System.out.println("Please enter your data, one number at a time, enter a non-integer when done");
            lpop(data);
            isort(data);
        }
        else {
            System.out.println("usage: java ltools.java [fname:]");
        }
        System.out.println("List sorted.");
        System.out.println("Options: [p]rint, [o]utput to file, [mo]de, [me]dian, [mea]n, [ou]tput to file with data");
        System.out.println("Enter a blank line when finished");
        Scanner in = new Scanner(System.in);
        String x;
        while(!( x =in.nextLine()).equals("")){
            if(x.equals("p")){
                System.out.println(data);
            }
            else if(x.equals("o")){
                BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
                String o ="";
                for(int d: data){
                    o += d;
                    o += ",";
                }
                String[] ou = o.split("");
                ou[o.length()] = "";
                String ret = "";
                for(String z: ou){
                    ret += z;
                }
                out.write(ret);
                out.close();
            }
            else if(x.equals("mo")){
                System.out.println(mode(data));
            }
            else if(x.equals("mea")){
                System.out.println(mean(data));
            }
            else if (x.equals("me")){
                System.out.println(median(data));
            }
            else if(x.equals("ou")){

            }
            else{
                System.out.println("Options: [p]rint, [o]utput to file, [mo]de, [me]dian, [mea]n," +
                        " [ou]tput to file with data");

            }
        }
    }
}
