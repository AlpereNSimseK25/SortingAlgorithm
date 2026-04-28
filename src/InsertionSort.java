public class InsertionSort {
    static int[] insertion(int dizi[]){

        for (int i=1; i<dizi.length; i++){
            if(dizi[i]<dizi[i-1]){
                int j;
                int temp = dizi[i];
                for (j=i; j>0 && dizi[j-1]>temp; j--){
                    dizi[j]=dizi[j-1];
                }
                dizi[j]=temp;
            }
        }
        return dizi;
    }

    public static void main(String[] args){
        int dizi[] = {3, 6, 9, 2, 5, 8, 1, 4, 7};

        insertion(dizi);
        System.out.print("Sıralı dizi: ");
        for (int i=0; i<dizi.length; i++){
            System.out.print(dizi[i]+", ");
        }
    }
}
