public class QuickSort {

    static int[] quick(int dizi[], int low, int high) {
        if (high - low <= 1) { // dizi iki elemanlı veya tek elemanlıysa direkt diziyi yazdır
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

    public static void main(String[] args) {
        int dizi[] = {3, 6, 9, 2, 5, 8, 1, 4, 7};
        int low = 0;
        int high = dizi.length - 1;

        quick(dizi, low, high);
        System.out.print("Sıralanmış dizi: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }

    }
}
