import java.util.Arrays;

public class HybridSort {
    // veri yapıları sınav sorusu: mege sort yazılacak ancak cep bellek yerine insertion sort kullanılacak.

    // Küçük diziler için eşik değeri.
    // Genellikle 10 ile 32 arasında bir değer seçilir.
    private static final int THRESHOLD = 10; // eğer dizi 10 elemandan azsa direkt olarak insertion sort yapması için

    public static void main(String[] args) {
        int[] arr = {23, 11, 5, 8, 2, 88, 55, 9, 30, 7, 1, 40, 15, 3};

        System.out.println("Sıralanmadan önce: " + Arrays.toString(arr));

        hybridMergeSort(arr, 0, arr.length - 1);

        System.out.println("Sıralandıktan sonra: " + Arrays.toString(arr));
    }

    // Ana sıralama fonksiyonu
    public static void hybridMergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Dizi boyutu eşik değerden küçük veya eşitse Insertion Sort kullan
            if ((right - left + 1) <= THRESHOLD) {
                insertionSort(arr, left, right);
            } else {
                // Büyükse klasik Merge Sort ile bölmeye devam et
                int mid = left + (right - left) / 2;

                hybridMergeSort(arr, left, mid);
                hybridMergeSort(arr, mid + 1, right);

                merge(arr, left, mid, right);
            }
        }
    }

    // Belirli bir aralık için Insertion Sort (Araya Ekleme Sıralaması)
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            // Key değerini doğru konuma yerleştir
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Klasik Merge (Birleştirme) fonksiyonu
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // sol dizinin kaç elmanlı olduğu
        int n2 = right - mid;  // sağ dizinin kaç elmanlı olduğu

        // Geçici diziler
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Verileri geçici dizilere kopyala
        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[mid + 1 + j];

        // Dizileri birleştir
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Kalan elemanları kopyala
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
