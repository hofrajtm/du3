/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du3;

import java.util.Arrays;

/**
 *
 * @author Martin
 */
public class Du3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Vytvoření pole polí o zadaných velikostech, které odpovídají 10^k,
        kde k = 2, 3, 4, 5, 6.*/
        int[][] polePoli = new int[5][];
        for (int i = 0; i < polePoli.length; i++) {
            polePoli[i] = new int[(int) Math.pow(10, i + 2)];
        }

        // Nadefinování hodnot polí pole pro náhodné integery.
        int[][] poleIntegerNahodne = polePoli;
        int Min = -10000; //Integer.MIN_VALUE;
        int Max = 10000; //Integer.MAX_VALUE;
        for (int i = 0; i < poleIntegerNahodne.length; i++) {
            for (int j = 0; j < poleIntegerNahodne[i].length; j++) {
                poleIntegerNahodne[i][j] = (int) (Math.random() * (Min) + Math.random() * (Max));
            }
        }

        // Nadefinování hodnot polí pole pro setříděné integery.
        int[][] poleIntegerSetridene = polePoli;
        for (int i = 0; i < poleIntegerSetridene.length; i++) {
            for (int j = 0; j < poleIntegerSetridene[i].length; j++) {
                poleIntegerSetridene[i][j] = j + 1;
            }
        }

        /* Nadefinování hodnot polí pole pro setříděné integery s 1 %
        náhodně prohozených prvků.*/
        int[][] poleIntegerMixovane = polePoli;
        for (int i = 0; i < poleIntegerMixovane.length; i++) {
            for (int j = 0; j < poleIntegerMixovane[i].length; j++) {
                poleIntegerMixovane[i][j] = j + 1;
            }
        }

        for (int i = 0; i < poleIntegerMixovane.length; i++) {
            int zmenenePrvky = 0;
            do {
                int nahodnyPrvek = (int) (Math.random() * poleIntegerMixovane[i].length);
                switch (poleIntegerMixovane[i].length) {
                    case 100:
                        poleIntegerMixovane[i][nahodnyPrvek] = (int) (Math.random() * (-(poleIntegerMixovane[i].length)) + Math.random() * ((poleIntegerMixovane[i].length)));
                        zmenenePrvky += 1;
                        break;
                    case 1000:
                        poleIntegerMixovane[i][nahodnyPrvek] = (int) (Math.random() * (-(poleIntegerMixovane[i].length)) + Math.random() * ((poleIntegerMixovane[i].length)));
                        zmenenePrvky += 1;
                        break;
                    case 10000:
                        poleIntegerMixovane[i][nahodnyPrvek] = (int) (Math.random() * (-(poleIntegerMixovane[i].length)) + Math.random() * ((poleIntegerMixovane[i].length)));
                        zmenenePrvky += 1;
                        break;
                    case 100000:
                        poleIntegerMixovane[i][nahodnyPrvek] = (int) (Math.random() * (-(poleIntegerMixovane[i].length)) + Math.random() * ((poleIntegerMixovane[i].length)));
                        zmenenePrvky += 1;
                        break;
                    case 1000000:
                        poleIntegerMixovane[i][nahodnyPrvek] = (int) (Math.random() * (-(poleIntegerMixovane[i].length)) + Math.random() * ((poleIntegerMixovane[i].length)));
                        zmenenePrvky += 1;
                        break;
                }
            } while (zmenenePrvky != (poleIntegerMixovane[i].length / 100));
        }

        System.out.println(Arrays.toString(poleIntegerMixovane[0]));
        System.out.println(Arrays.toString(poleIntegerMixovane[1]));
        System.out.println(Arrays.toString(poleIntegerMixovane[2]));
        System.out.println(Arrays.toString(poleIntegerMixovane[3]));
        System.out.println(Arrays.toString(poleIntegerMixovane[4]));

        // Tisk pole polí.
        // Varianta A
//        for (int i = 0; i < poleIntegerNahodny.length; i++) {
//            for (int j = 0; j < poleIntegerNahodny[i].length; j++) {
//                System.out.print(poleIntegerNahodny[i][j] + " ");
//            }
//            System.out.println(" ");
//        }
        // Varianta B
//        System.out.print(Arrays.toString(polePoli[0]));
//        System.out.print(Arrays.toString(polePoli[1]));
//        System.out.print(Arrays.toString(polePoli[2]));
//        System.out.print(Arrays.toString(polePoli[3]));
//        System.out.print(Arrays.toString(polePoli[4]));
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
