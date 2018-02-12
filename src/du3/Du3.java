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
        int Min = 0; //Integer.MIN_VALUE;
        int Max = 0; //Integer.MAX_VALUE;
        switch (poleIntegerNahodne.length) {
            case 100:
                Min = -100;
                Max = 100;
                break;
            case 1000:
                Min = -1000;
                Max = 1000;
                break;
            case 10000:
                Min = -10000;
                Max = 10000;
                break;
            case 100000:
                Min = -100000;
                Max = 100000;
                break;
            case 1000000:
                Min = -1000000;
                Max = 1000000;
                break;
        }
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
    public static void quicksort(int[] pole) {
        quicksortOmezeny(pole, 0, pole.length - 1);
    }

    private static void quicksortOmezeny(int[] pole, int levy, int pravy) {
        if (pravy >= levy) {
            int pivot = levy;
            int novyPivot = quicksortProhozeniPrvku(pole, levy, pravy, pivot);
            quicksortOmezeny(pole, levy, novyPivot - 1);
            quicksortOmezeny(pole, novyPivot + 1, pravy);
        }
    }

    private static int quicksortProhozeniPrvku(int[] pole, int levy, int pravy, int pivot) {
        int temp = pole[pivot];
        pole[pivot] = pole[pravy];
        pole[pravy] = temp;
        int i = levy;
        for (int j = levy; j < pravy; j++) {
            if (pole[j] < pole[pravy]) {
                temp = pole[i];
                pole[i] = pole[j];
                pole[j] = temp;
                i++;
            }
        }
        temp = pole[i];
        pole[i] = pole[pravy];
        pole[pravy] = temp;
        return i;
    }

    // Merge Sort
    public static void mergeSort(int[] pole) {
        if (pole.length <= 1) {
            return;
        }
        int stredPole = pole.length / 2;
        int[] levePole = new int[stredPole];
        for (int i = 0; i < stredPole; i++) {
            levePole[i] = pole[i];
        }
        int[] pravePole = new int[pole.length - stredPole];
        for (int i = stredPole; i < pole.length; i++) {
            pravePole[i - stredPole] = pole[i];
        }
        mergeSort(levePole);
        mergeSort(pravePole);
        mergeSlitiPoli(pole, levePole, pravePole);
    }

    private static void mergeSlitiPoli(int[] pole, int[] levePole, int[] pravePole) {
        int i = 0;
        int j = 0;
        while ((i < levePole.length) && (j < pravePole.length)) {
            if (levePole[i] < pravePole[j]) {
                pole[i + j] = levePole[i];
                i++;
            } else {
                pole[i + j] = pravePole[j];
                j++;
            }
        }
        if (i < levePole.length) {
            while (i < levePole.length) {
                pole[i + j] = levePole[i];
                i++;
            }
        } else {
            while (j < pravePole.length) {
                pole[i + j] = pravePole[j];
                j++;
            }
        }
    }

    // Metoda pro aplikaci třídících algoritmů na jednotlivé datové struktury.
    public static void aplikaceTridicichAlgoritmu(int[][] pole) {
        System.out.println(" Insert sort");
        for (int i = 0; i < pole.length; i++) {
            long casPocatecni = System.nanoTime();
            insertSort(pole[i]);
            System.out.println("   Čas pro data o velikosti 10^" + (i + 2) + ": " + (System.nanoTime() - casPocatecni) + " nanosekund");
        }

        System.out.println(" Bubble sort");
        for (int i = 0; i < pole.length; i++) {
            long casPocatecni = System.nanoTime();
            bubbleSort(pole[i]);
            System.out.println("   Čas pro data o velikosti 10^" + (i + 2) + ": " + (System.nanoTime() - casPocatecni) + " nanosekund");
        }

        System.out.println(" Quicksort");
        for (int i = 0; i < pole.length; i++) {
            long casPocatecni = System.nanoTime();
            quicksort(pole[i]);
            System.out.println("   Čas pro data o velikosti 10^" + (i + 2) + ": " + (System.nanoTime() - casPocatecni) + " nanosekund");
        }

        System.out.println(" Merge sort");
        for (int i = 0; i < pole.length; i++) {
            long casPocatecni = System.nanoTime();
            mergeSort(pole[i]);
            System.out.println("   Čas pro data o velikosti 10^" + (i + 2) + ": " + (System.nanoTime() - casPocatecni) + " nanosekund");
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