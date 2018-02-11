/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du3;

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
        aplikaceTridicichAlgoritmu(poleIntegerNahodne);

        System.out.println();
        System.out.println("SETŘÍDĚNÉ INTEGERY");

        // Nadefinování hodnot polí pole pro setříděné integery.
        int[][] poleIntegerSetridene = polePoli;
        for (int i = 0; i < poleIntegerSetridene.length; i++) {
            for (int j = 0; j < poleIntegerSetridene[i].length; j++) {
                poleIntegerSetridene[i][j] = j + 1;
            }
        }
        aplikaceTridicichAlgoritmu(poleIntegerSetridene);

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
                poleIntegerMixovane[i][nahodnyPrvek] = (int) (Math.random() * (-(poleIntegerMixovane[i].length)) + Math.random() * ((poleIntegerMixovane[i].length)));
                zmenenePrvky += 1;
            } while (zmenenePrvky != (poleIntegerMixovane[i].length / 100));
        }
        aplikaceTridicichAlgoritmu(poleIntegerMixovane);
    }

    // Metoda třídění dle přímého vkládání, tj. Insert sort.
    public static void insertSort(int[] pole) {
        for (int i = 0; i < pole.length; i++) {
            int j = i;
            int temp = pole[j];
            while (j > 0 && pole[j - 1] > temp) {
                pole[j] = pole[j - 1];
                j--;
            }
            pole[j] = temp;
        }
    }

    // Metoda bublinkového třídění, tj. Bubble sort.
    public static void bubbleSort(int[] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = pole.length - 1; j > i; j--) {
                if (pole[j] < pole[j - 1]) {
                    int temp = pole[j];
                    pole[j] = pole[j - 1];
                    pole[j - 1] = temp;
                }
            }
        }
    }

    // Metoda Quicksort.
    public static void quicksort(int[] pole, int levy, int pravy) {
        if (levy < pravy) {
            int mez = levy;
            for (int i = levy + 1; i < pravy; i++) {
                if (pole[i] > pole[levy]) {
                    prohozeniPrvku(pole, i, ++mez);
                }
            }
            prohozeniPrvku(pole, levy, mez);
            quicksort(pole, levy, mez);
            quicksort(pole, mez + 1, pravy);
        }
    }

    private static void prohozeniPrvku(int[] pole, int levy, int pravy) {
        int temp = pole[pravy];
        pole[pravy] = pole[levy];
        pole[levy] = temp;
    }

    // Metoda Merge sort.
    public static void mergeSort(int[] pole, int[] pomocnePole, int levy, int pravy) {
        if (levy == pravy) {
            return;
        }
        int stredniIndex = (levy + pravy) / 2;
        mergeSort(pole, pomocnePole, levy, stredniIndex);
        mergeSort(pole, pomocnePole, stredniIndex + 1, pravy);
        merge(pole, pomocnePole, levy, pravy);
        for (int i = levy; i <= pravy; i++) {
            pole[i] = pomocnePole[i];
        }
    }

    private static void merge(int[] pole, int[] pomocnePole, int levy, int pravy) {
        int stredniIndex = (levy + pravy) / 2;
        int levyIndex = levy;
        int pravyIndex = stredniIndex + 1;
        int pomocnePoleIndex = levy;
        while (levyIndex <= stredniIndex && pravyIndex <= pravy) {
            if (pole[levyIndex] >= pole[pravyIndex]) {
                pomocnePole[pomocnePoleIndex] = pole[levyIndex++];
            } else {
                pomocnePole[pomocnePoleIndex] = pole[pravyIndex++];
            }
            pomocnePoleIndex++;
        }
        while (levyIndex <= stredniIndex) {
            pomocnePole[pomocnePoleIndex] = pole[levyIndex++];
            pomocnePoleIndex++;
        }
        while (pravyIndex <= pravy) {
            pomocnePole[pomocnePoleIndex] = pole[pravyIndex++];
            pomocnePoleIndex++;
        }
    }

    // Metoda pro aplikaci třídících algoritmů na jednotlivé datové struktury.
    public static void aplikaceTridicichAlgoritmu(int[][] pole) {
        System.out.println(" Insert sort");
        for (int i = 0; i < pole.length; i++) {
            insertSort(pole[i]);
            System.out.println("   Čas pro data o velikosti 10^" + (i + 2) + ": " + System.nanoTime());
        }

        System.out.println(" Bubble sort");
        for (int i = 0; i < pole.length; i++) {
            bubbleSort(pole[i]);
            System.out.println("   Čas pro data o velikosti 10^" + (i + 2) + ": " + System.nanoTime());
        }

        System.out.println(" Quicksort");
        for (int i = 0; i < pole.length; i++) {
            quicksort(pole[i], 0, pole.length);
            System.out.println("   Čas pro data o velikosti 10^" + (i + 2) + ": " + System.nanoTime());
        }

        System.out.println(" Merge sort");
        for (int i = 0; i < pole.length; i++) {
            mergeSort(pole[i], pole[i], 0, pole.length);
            System.out.println("   Čas pro data o velikosti 10^" + (i + 2) + ": " + System.nanoTime());
        }
    }

//        // Tisk pole polí.
//        // Varianta A
//        for (int i = 0; i < poleIntegerNahodny.length; i++) {
//            for (int j = 0; j < poleIntegerNahodny[i].length; j++) {
//                System.out.print(poleIntegerNahodny[i][j] + " ");
//            }
//            System.out.println(" ");
//        }
//        // Varianta B
//        System.out.print(Arrays.toString(polePoli[0]));
//        System.out.print(Arrays.toString(polePoli[1]));
//        System.out.print(Arrays.toString(polePoli[2]));
//        System.out.print(Arrays.toString(polePoli[3]));
//        System.out.print(Arrays.toString(polePoli[4]));
}