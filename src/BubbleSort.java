public class BubbleSort {

    static int[] bubble(int dizi[], int n) {

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (dizi[j] > dizi[j + 1]) {
                    int temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;
                }
            }
        }
        return dizi;
    }
    public static void main(String[] args){
        int dizi[] = {3, 6, 9, 2, 5, 8, 1, 4, 7};
        int n = dizi.length;
        bubble(dizi, n);
        System.out.print("Sıralı dizi: " );
        for (int i =0; i<dizi.length; i++){
            System.out.print(dizi[i]+", ");
        }
    }
}
