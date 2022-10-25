package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class MinEnergyLeetCode {

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {


        int ans =0;
        for(int i = 0; i<energy.length; i++) {
            int hoursNeededForEnergy = 0, hoursNeededForExp=0;
            if(energy[i]>=initialEnergy ) {
                hoursNeededForEnergy+=(energy[i]-initialEnergy)+1;
                initialEnergy += hoursNeededForEnergy;
            }
            if(experience[i]>=initialExperience) {
                hoursNeededForExp+=(experience[i]-initialExperience)+1;
                initialExperience+=hoursNeededForExp;
            }

            if(energy[i] < initialEnergy && experience[i] < initialExperience){
                initialEnergy-=energy[i];
                initialExperience+=experience[i];
            }

            ans += hoursNeededForEnergy + hoursNeededForExp;
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr1 = {1,4,3,2};
        int [] arr2 = {2,6,3,1};
        //System.out.println(minNumberOfHours(5,3,arr1,arr2));

    }
}
