import java.util.Stack;

public class InsertionSortOrnekCozum {

    static int[] insertion(int dizi[], int eklenecek) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
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
        for (int i = 0; i < dizi.length; i++) {
            s1.push(dizi[i]);
        }
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] < eklenecek) {
                int deger = i;
                for (int j = 0; j < i; j++) {
                    s2.push(s1.pop());
                }
                s2.push(eklenecek);
                for (int j = 0; j < s2.size(); j++) {
                    s1.push(s2.pop());
                }
            }
        }


        return dizi;
    }

    public static void main(String[] args) {
        int dizi[] = {3, 6, 9, 2, 8, 1, 4, 7};
        int eklenecek = 5;

        insertion(dizi, eklenecek);
        System.out.print("Sıralı dizi: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }
    }
}
