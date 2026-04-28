public class AllSort {


    static int[] bubble(int dizi[]) {
        for (int i = 0; i < dizi.length - 1; i++) {
            for (int j = 0; j < dizi.length - 1 - i; j++) {
                if (dizi[j] > dizi[j + 1]) {
                    int temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;
                }
            }
        }
        return dizi;
    }

    static int[] quick(int dizi[], int low, int high) {
        if (high - low <= 1) {
            return dizi;
        }
        int pivot = dizi[high];
        int split = low;
        for (int i = low; i < high; i++) {
            if (dizi[i] < pivot) {
                int temp = dizi[i];
                dizi[i] = dizi[split];
                dizi[split] = temp;
                split++;
            }
        }
        int temp2 = dizi[split];
        dizi[split] = dizi[high];
        dizi[high] = temp2;

        quick(dizi, low, split - 1);
        quick(dizi, split + 1, high);

        return dizi;
    }

    static int[] selection(int dizi[]) {
        for (int i = 0; i < dizi.length - 1; i++) {
            int min = dizi[i];
            int index = i;
            for (int j = i + 1; j < dizi.length; j++) {
                if (dizi[j] < min) {
                    dizi[j] = min;
                    index = j;
                }
            }
            dizi[index] = dizi[i];
            dizi[i] = min;
        }
        return dizi;
    }

    static int[] insertion(int dizi[]) {
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] < dizi[i - 1]) {
                int j;
                int temp = dizi[i];
                for (j = i; j > 0 && dizi[j - 1] > temp; j--) {
                    dizi[j] = dizi[j - 1];
                }
                dizi[j] = temp;
            }
        }
        return dizi;
    }

    static int[] merge(int dizi[], int low_1, int high_1) {
        if (high_1 - low_1 <= 1) {
            return dizi;
        }
        int split = low_1 + (high_1 - low_1) / 2;
        merge(dizi, low_1, split);
        merge(dizi, split, high_1);

        int gecici[] = new int[split - low_1];
        for (int j = 0; j < (split - low_1); j++) {
            gecici[j] = dizi[low_1 + j];
        }
        int m1 = 0;
        int m2 = split;
        int i = low_1;
        while (i < m2 && m2 < high_1) {
            if (gecici[m1] < dizi[m2]) {
                dizi[i++] = gecici[m1++];
            } else {
                dizi[i++] = dizi[m2++];
            }
            while (i < m2) {
                dizi[i++] = gecici[m1++];
            }
        }
        return dizi;
    }

    public static void main(String[] args) {
        int dizi[] = {3, 6, 9, 2, 5, 8, 1, 4, 7};

        bubble(dizi);
        System.out.print("Buble: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }
        System.out.println();

        int low = 0;
        int high = dizi.length - 1;
        System.out.print("Quick: ");
        quick(dizi, low, high);
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }
        System.out.println();

        System.out.print("Selection: ");
        selection(dizi);
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }
        System.out.println();

        System.out.print("Insertion: ");
        insertion(dizi);
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }
        System.out.println();

        int high_1 = dizi.length - 1;
        int low_1 = 0;
        System.out.print("Merge: ");
        merge(dizi, low_1, high_1);
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }
        System.out.println();

    }
}
