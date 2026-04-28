public class SelectionSort {
    static int[] selection(int dizi[]) {
        for (int i = 0; i < dizi.length - 1; i++) {
            int min = dizi[i];
            int index = i;

            for (int j = i + 1; j < dizi.length; j++) {
                if (dizi[j] < min) {
                    min = dizi[j];
                    index = j;
                }
            }
            dizi[index] = dizi[i];
            dizi[i] = min;
        }
        return dizi;
    }

    public static void main(String[] args) {
        int dizi[] = {3, 6, 9, 2, 5, 8, 1, 4, 7};

        selection(dizi);
        System.out.print("Sıralı dizi: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }
    }
}
