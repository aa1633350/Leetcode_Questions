package com.example.demo.Coding.BinarySearch;

public class FirstLastOccurence {

    static int lowerBinary(int a[],int key)
    {
        int low=0;
        int high=9;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(a[mid]>=key)
            {
                high=mid-1;

            }else if(a[mid]<key)
            {
                if(a[mid+1]==key)
                    return mid+1;
                low=mid+1;
            }
        }
        return low;
    }


    static int upperBinary(int a[],int key)
    {
        int low=0;
        int high=9;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(a[mid]<=key)
            {
                low=mid+1;

            }else if(a[mid]>key)
            {
                if(a[mid-1]==key)
                    return mid-1;
                high=mid-1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int [] a={1,1,10,10,10,10,10,20,20,21};

        int ans=lowerBinary(a,20);
        int x=upperBinary(a,20);
        System.out.println(ans);
        System.out.println(x);

    }
}
