package milestone;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MyArrayList myArrayList =  new MyArrayList();

        ArrayList arrayList = new ArrayList();

        //arrayList.add(5);


        myArrayList.add(11.5);
        myArrayList.add(10);
        myArrayList.add(9);
        myArrayList.add(8.7);
        myArrayList.add(7);
        myArrayList.add(6);
        System.out.println("Value of element by index 3: " + myArrayList.get(3));
        myArrayList.add(20,3);
        System.out.println("Value of element by index 3 after addding new value: " + myArrayList.get(3));

        System.out.println("Size of myArrayList: " + myArrayList.get());
        myArrayList.remove(3);
        System.out.println("Size of myArrayList after removing: " + myArrayList.get());
        System.out.println("Value of index 3  after removing: " + myArrayList.get(3));
        myArrayList.clear();
        System.out.println("Size of myArrayList after clear: " + myArrayList.get());

    }
}