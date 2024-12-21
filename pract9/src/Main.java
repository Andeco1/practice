import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        System.out.println(arr);
        arr = Set(arr);
        System.out.println(arr);
        System.out.println(Find(arr,2));
        System.out.println(Max(arr));

        Circle circle1 = new Circle(2);
        Circle circle2 = new Circle(4);
        Circle circle3 = new Circle(3);
        ArrayList<Circle> circles = new ArrayList<>(Arrays.asList(new Circle[]{circle1, circle2, circle3}));
        System.out.println(Max(circles).getRadius());
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(4);
        arr1.add(3);
        ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>();
        arr2.add(arr1);
        arr2.add(arr);
        System.out.println(Max2(arr2));


    }

    public static <T> ArrayList<T> Set(ArrayList<T> arr){
        ArrayList<T> newArr = new ArrayList<T>();
        for(T obj:arr){
            if(!newArr.contains(obj)){
                newArr.add(obj);
            }
        }
        return newArr;
    }

    public static <T> int Find(ArrayList<T> arr, T obj){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == (obj)){
                return i;
            }
        }
        return -1;
    }

    public static <T extends Comparable> T Max(ArrayList<T> arr){
        T maxT = arr.get(0);
        for(T obj: arr){
            if(maxT.compareTo(obj)<0){
                maxT=obj;
            }
        }
        return maxT;
    }

    public static <E extends Comparable> E Max2(ArrayList<ArrayList<E>> arr){
        E maxT = Max(arr.get(0));
        for(ArrayList<E> obj: arr){
            if(maxT.compareTo(Max(obj))<0){
                maxT=Max(obj);
            }
        }
        return maxT;
    }

}