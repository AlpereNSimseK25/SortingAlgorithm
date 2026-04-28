import java.util.Stack;

public class BubbleSortOrnekCozum {

    static int[] bubble(int dizi[]) {

        Stack<Integer> cift = new Stack<Integer>();
        Stack<Integer> tek = new Stack<Integer>();

        int eski_k;
        int yeni_k;
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi.length - 1 - i; j++) {
                if (dizi[j] > dizi[j + 1]) {
                    yeni_k = dizi[j];
                    eski_k = dizi[j + 1];
                    dizi[j] = eski_k;
                    dizi[j + 1] = yeni_k;
                }
            }
        }
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] % 2 == 0) {
                cift.push(dizi[i]);
            } else {
                tek.push(dizi[i]);
            }
        }
        System.out.println("Çift sayılar stack'i: " + cift);
        System.out.println("Tek sayılar stack'i: " + tek);


        return dizi;
    }

    public static void main(String[] args) {
        int dizi[] = {3, 6, 9, 2, 5, 8, 1, 4, 7};

        System.out.print("Sıralı dizi: ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ", ");
        }
        System.out.println("");

        bubble(dizi);

    }
}
