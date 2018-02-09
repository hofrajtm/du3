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

        System.out.println("NÁHODNÉ INTEGERY");

        // Nadefinování hodnot polí pole pro náhodné integery.
        int[][] poleIntegerNahodne = polePoli;
        int Min = -10000; //Integer.MIN_VALUE;
        int Max = 10000; //Integer.MAX_VALUE;
        for (int i = 0; i < poleIntegerNahodne.length; i++) {
            for (int j = 0; j < poleIntegerNahodne[i].length; j++) {
                poleIntegerNahodne[i][j] = (int) (Math.random() * (Min) + Math.random() * (Max));
            }
        }      

        System.out.println();
        System.out.println("SETŘÍDĚNÉ INTEGERY");

        // Nadefinování hodnot polí pole pro setříděné integery.
        int[][] poleIntegerSetridene = polePoli;
        for (int i = 0; i < poleIntegerSetridene.length; i++) {
            for (int j = 0; j < poleIntegerSetridene[i].length; j++) {
                poleIntegerSetridene[i][j] = j + 1;
            }
        }

        System.out.println();
        System.out.println("MIXOVANÉ INTEGERY");

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

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            int temp = array[j];
            while (j > 0 && temp > array[j-1]) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }
    
    public static void bubbleSort(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = x.length - 1; j > i; j--) {
                if (x[j] < x[j - 1]) {
                    int temp = x[j];
                    x[j] = x[j - 1];
                    x[j - 1] = temp;
                }
            }
        }
    }
    
    public static void quicksort(int[] array, int left, int right){
        if(left < right){
            int boundary = left;
            for(int i = left + 1; i < right; i++){
                if(array[i] > array[left]){
                    swapB(array, i, ++boundary);
                }
            }
        swapB(array, left, boundary);
        quicksort(array, left, boundary);
        quicksort(array, boundary + 1, right);
        }    
    }
    
    private static void swapB(int[] array, int left, int right){
        int tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }
    
    public static void heapsort(Comparable[] array, boolean descending) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            repairTop(array, array.length - 1, i, descending ? 1 : -1);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swapH(array, 0, i);
            repairTop(array, i - 1, 0, descending ? 1 : -1);
        }
    }
    
    private static void repairTop(Comparable[] array, int bottom, int topIndex, int order) {
        Comparable tmp = array[topIndex];
        int succ = topIndex * 2 + 1;
        if (succ < bottom && array[succ].compareTo(array[succ + 1]) == order) {
        succ++;
        }
 
        while (succ <= bottom && tmp.compareTo(array[succ]) == order) {
            array[topIndex] = array[succ];
            topIndex = succ;
            succ = succ * 2 + 1;
            if (succ < bottom && array[succ].compareTo(array[succ + 1]) == order) {
                succ++;
            }
        }
        array[topIndex] = tmp;
    }
    
    private static void swapH(Comparable[] array, int left, int right) {
        Comparable tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }
    
    public static aplikaceTridicichAlgoritmu (int [] array) {
        System.out.println(" Insert sort");
        insertSort(array[0]);
        System.out.println("   Čas pro data o velikosti 10^2: " + System.nanoTime());
        insertSort(array[1]);
        System.out.println("   Čas pro data o velikosti 10^3: " + System.nanoTime());
        insertSort(array[2]);
        System.out.println("   Čas pro data o velikosti 10^4: " + System.nanoTime());
        insertSort(array[3]);
        System.out.println("   Čas pro data o velikosti 10^5: " + System.nanoTime());
        insertSort(array[4]);
        System.out.println("   Čas pro data o velikosti 10^6: " + System.nanoTime());

        System.out.println(" Bubble sort");
        bubbleSort(array[0]);
        System.out.println("   Čas pro data o velikosti 10^2: " + System.nanoTime());
        bubbleSort(array[1]);
        System.out.println("   Čas pro data o velikosti 10^3: " + System.nanoTime());
        bubbleSort(array[2]);
        System.out.println("   Čas pro data o velikosti 10^4: " + System.nanoTime());
        bubbleSort(array[3]);
        System.out.println("   Čas pro data o velikosti 10^5: " + System.nanoTime());
        bubbleSort(array[4]);
        System.out.println("   Čas pro data o velikosti 10^6: " + System.nanoTime());

        System.out.println(" Quicksort");
        quicksort(array[0], 0, array.length);
        System.out.println("   Čas pro data o velikosti 10^2: " + System.nanoTime());
        quicksort(array[1], 0, array.length);
        System.out.println("   Čas pro data o velikosti 10^3: " + System.nanoTime());
        quicksort(array[2], 0, array.length);
        System.out.println("   Čas pro data o velikosti 10^4: " + System.nanoTime());
        quicksort(array[3], 0, array.length);
        System.out.println("   Čas pro data o velikosti 10^5: " + System.nanoTime());
        quicksort(array[4], 0, array.length);
        System.out.println("   Čas pro data o velikosti 10^6: " + System.nanoTime());

        System.out.println(" Heapsort");
        heapsort(array[0], false);
        System.out.println("   Čas pro data o velikosti 10^2: " + System.nanoTime());
        heapsort(array[1]);
        System.out.println("   Čas pro data o velikosti 10^3: " + System.nanoTime());
        heapsort(array[2]);
        System.out.println("   Čas pro data o velikosti 10^4: " + System.nanoTime());
        heapsort(array[3]);
        System.out.println("   Čas pro data o velikosti 10^5: " + System.nanoTime());
        heapsort(array[4]);
        System.out.println("   Čas pro data o velikosti 10^6: " + System.nanoTime());
    }
}