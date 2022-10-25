package com.example.demo.Coding.Recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SumOfArray {
    public static int sumOfArray (List<Integer> bill, int n) {
        if(n==0){
            return bill.get(0);
        }
        return bill.get(n) + sumOfArray(bill, n-1);
    }

    public static void main(String[] args) {
        String name = "hello-world";
        String run = "docker run ";
        run = run.concat(name).concat(" -it --detach --env-file");
        System.out.println(run);
        List<Integer> bill = new ArrayList<>();
        bill.add(8);
        bill.add(4);
        bill.add(11);
        List<Integer> copyBil = new ArrayList<>();
        copyBil = bill;
        System.out.println(copyBil);
        //int val = (int) ( 4 - Math.pow(2,4));
        //System.out.println(sumOfArray(bill, bill.size()-1));
        // curl -u super_user:welcome1 -X PUT --data-binary @$MODULE_HOME/bmd.zip http://localhost:$PORT/metadata
        String moduleHome = "home/adityana";
        String curlCommand = "curl -u super_user:welcome1 -X PUT --data-binary ";
        //curlCommand = curlCommand.concat(moduleHome) + File.separator + "bmd.zip " +
    }
}
