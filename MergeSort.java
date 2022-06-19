import java.util.ArrayList;
import java.util.Scanner;
class MergeSort_np03cs4s220109 {
    // Function to take input from the user
    ArrayList getInput(ArrayList <Integer> al){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to put in your ArrayList : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter element at index [%d] : ", i);
            int n1 = sc.nextInt();
            al.add(n1);
        }
        return al;
    }
    // function to give output that displays the unsorted and sorted arraylist
    void getOutput (ArrayList < Integer > al) {
        System.out.println("The Unsorted ArrayList of entered  Elements is : "+ al);
        sort(al, 0, al.size() - 1);//displays sorted number

        System.out.println("The sorted ArrayList of entered  element is :" + al);
    }
    // function for comparing the elements and storing them in the new sorted arraylist
    void merge(ArrayList < Integer > al, int beg, int mid, int end) {
        ArrayList < Integer > sortedArray = new ArrayList < Integer > ();
        int ix_1 = beg;//starting index number of left sub array list
        int ix_2 = mid+1;// starting index number of right sub array list

        while (ix_1 <= mid && ix_2 <= end) {
            if (al.get(ix_1) < al.get(ix_2)) {
                sortedArray.add(al.get(ix_1));
                ix_1++;
            } else {
                sortedArray.add(al.get(ix_2));
                ix_2++;
            }
        }
        for (int j = ix_1; j <= mid; j++)
            sortedArray.add(al.get(j));

        for (int k = 0; k < sortedArray.size(); k++) {
            al.set(beg + k, sortedArray.get(k));
        }
    }
    //Function to divide the given unsorted arraylist into two halves
    void sort(ArrayList < Integer > al, int beg, int end) {
        if (beg >= end) return;

        int mid = (beg + end) / 2;
        sort(al, beg, mid);
        sort(al, mid + 1, end);
        merge(al, beg, mid, end);// merges the sorted sub arraylist into a single sorted arraylist
    }
    //Main function
    public static void main(String[] args) {
        MergeSort_np03cs4s220109 value = new MergeSort_np03cs4s220109();
        ArrayList < Integer > al = new ArrayList < Integer > ();
        value.getInput(al);
        value.getOutput(al);
    }

}
