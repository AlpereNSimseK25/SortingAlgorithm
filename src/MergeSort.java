public class MergeSort {
    static int[] merge(int dizi[], int low, int high) {
        if (high - low <= 1) { // eğer dizide 1 veya 0 eleman varsa sıralmaya gerek yoktur
            return dizi;
        }
        int split = (high + low) / 2;
        merge(dizi, low, split);
        merge(dizi, split, high);

        int[] strach = new int[split - low]; // strach geçici dizi sol tarafı depolar
        for (int j = 0; j < (split - low); j++) {
            strach[j] = dizi[low + j];
        }
        int m1 = 0; // geçici dizinin başını gösterir
        int m2 = split; // ana dizinin başını gösterir
        int i = low;
        while (i < m2 && m2 < high) {
            if (strach[m1] <= dizi[m2]) { // sol ve sağ diziler tek diziye toplanır
                dizi[i++] = strach[m1++];
            } else {
                dizi[i++] = dizi[m2++];
            }
        }
        while (i < m2) {
            dizi[i++] = strach[m1++];
        }
        return dizi;
    }

    public static void main(String[] args) {

        int dizi[] = {3, 6, 9, 2, 5, 8, 1, 4, 7};
        int high = dizi.length;
        int low = 0;

        merge(dizi, low, high);
        System.out.print("Sıralı dizi: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }

    }
}
