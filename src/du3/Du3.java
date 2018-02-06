/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du3;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Martin
 */
public class Du3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Vytvoření pole integerů s daty o zadaných velikostech, které
        odpovídají 10^k, kde k = 2, 3, 4, 5, 6.*/
        int[] velikostPole = new int []{100, 1000, 10000, 100000, 1000000};
        
        // For cyklus pro aplikaci dat o jednotlivých velikostech.
        for (int i = 0; i < velikostPole.length; i++) {
            
            int[] pole = new int[velikostPole[i]];
        
            int Min = Integer.MIN_VALUE;
            int Max = Integer.MAX_VALUE;
            
            /* For cyklus pro generování náhodného integeru do jednotlivých
            prvů pole.*/
            for (int j = 0; j < pole.length; j++) {
                pole[j] = (int) (Math.random() * (Max) + Math.random() * (Min));           
            }
            
        System.out.println(Arrays.toString(pole));
        
        }
    }
    
//    void insertSort (int[] x, int temp) {
//        for(int i = 0; i < x.length; i++) {
//            int j = i; //Zapamatuj index zpracovávaného prvku
//            double prvek = x[i];
//            while (j > 0 && x[j-1] > prvek) { //Porovnavani s seteridenou casti
//                temp = x[j]; //Prohozeni za pouziti
//                x[j] = x[j-1]; //pomocne promenne temp
//                x[j-1] = temp;
//                j = j - 1; //Dekrementace indexu
//            }
//        }
//    }
//    
//    void bubbleSort(int[] x) {
//        for (int i = 0;i < x.length; i++) {
//            for (int j = x.length-1; j > i; j--) { //Prohledavani od konce
//                if (x[j] < x[j-1]) {
//                    int temp = x[j]; //Prohozeni za pouziti
//                    x[j] = x[j-1]; //pomocne promenne temp
//                    x[j-1] = temp;
//                }
//            }
//        }
//    }
//    
//    public static void quicksort(int[] array, int left, int right){
//        if(left < right){
//            int boundary = left;
//            for(int i = left + 1; i < right; i++){
//                if(array[i] > array[left]){
//                    swapB(array, i, ++boundary);
//                }
//            }
//        swapB(array, left, boundary);
//        quicksort(array, left, boundary);
//        quicksort(array, boundary + 1, right);
//        }    
//    }
//    
//    private static void swapB(int[] array, int left, int right){
//        int tmp = array[right];
//        array[right] = array[left];
//        array[left] = tmp;
//    }
//    
//    public static void heapSort(Comparable[] array, boolean descending) {
//        for (int i = array.length / 2 - 1; i >= 0; i--) {
//            repairTop(array, array.length - 1, i, descending ? 1 : -1);
//        }
//        for (int i = array.length - 1; i > 0; i--) {
//            swapH(array, 0, i);
//            repairTop(array, i - 1, 0, descending ? 1 : -1);
//        }
//    }
//    
//    private static void repairTop(Comparable[] array, int bottom, int topIndex, int order) {
//        Comparable tmp = array[topIndex];
//        int succ = topIndex * 2 + 1;
//        if (succ < bottom && array[succ].compareTo(array[succ + 1]) == order) {
//        succ++;
//        }
// 
//        while (succ <= bottom && tmp.compareTo(array[succ]) == order) {
//            array[topIndex] = array[succ];
//            topIndex = succ;
//            succ = succ * 2 + 1;
//            if (succ < bottom && array[succ].compareTo(array[succ + 1]) == order) {
//                succ++;
//            }
//        }
//        array[topIndex] = tmp;
//    }
//    
//    private static void swapH(Comparable[] array, int left, int right) {
//        Comparable tmp = array[right];
//        array[right] = array[left];
//        array[left] = tmp;
//    }
}