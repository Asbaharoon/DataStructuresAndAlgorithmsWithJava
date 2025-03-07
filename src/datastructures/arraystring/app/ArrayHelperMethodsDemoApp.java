package datastructures.arraystring.app;

import util.GenericUtil;

import java.util.Arrays;
import java.util.List;

public class ArrayHelperMethodsDemoApp {
    public static void main(String[] args){
        //Beware use wrapper types such as Integer instead of primitive
        // int becuase the helper methods are defined for Object type
        // and won't work on primitives.
        Integer[] a=new Integer[10];
        Integer[] arr={0,1,2,3,4,5,6,7,8,9};
        Integer[] empty=new Integer[10];


        //copy upto given length, print first 5 elem in this case
            a=Arrays.copyOf(arr,5);

        GenericUtil.printArray(a);

        //create string rep of array and return comma seprated,
        //squre bracket enclosed values [1,2,3]
        GenericUtil.print(Arrays.toString(a));

        //Sorts array, the elements must be comparable
        Arrays.sort(a);

        //create list from the array
        List<Integer> list= Arrays.asList(a);

       // Arrays.compare(a,arr); //dont know

        //do a bin search and return the index, return -1 if nnot found
        int index=Arrays.binarySearch(a,2);

        //fill all elements of array with a given val
        Arrays.fill(empty,1);




    }
}
