
import java.util.Random;

public class App {

    public static void main(String[] args) {

        ListArrayOfInteger L1 = new ListArrayOfInteger();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            L1.add(r.nextInt(10));
        }

        ListArrayOfInteger L4 = new ListArrayOfInteger();
        for (int i = 0; i < 10; i++) {
            L4.add(r.nextInt(10));
        }


        //int tam = 10;
        //ListArrayOfInteger L2 = new ListArrayOfInteger();
        //for (int i = 0; i < tam / 2; i++) {
        //    L2.add(i);
        //    L2.add(0, i);
        //}
        System.out.println("L1: " + L1);
        //System.out.println("L2: " + L2);

        //L2.remove(0);
        //L2.removeByIndex(0);
        //System.out.println("L2 apos remocoes: " + L2);

        // Testa Sublist
        //int [] l3 = L1.subList(3, 6);
        //for (int i=0; i<l3.length; i++){
        //    System.out.println(l3[i]);
        //}

        //L1.reverse();
        //System.out.println("L1: " + L1);

        //int contador = L1.contaOcorrencias(5);
        //System.out.println(contador);

        /*
        ListArrayOfInteger L3 = new ListArrayOfInteger(20);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        L3.add(4);
        L3.add(5);
        System.out.println(L3);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(4);
        L3.remove(5);
        L3.remove(5);
        L3.remove(5);
        L3.remove(5);
        L3.remove(5);
        L3.remove(5);
        L3.remove(5);
        L3.remove(5);
        L3.remove(5);
        L3.remove(5);
        System.out.println(L3);
        */

        //L1.addFirst(2);
        //System.out.println(L1);

        //int a = L1.removeFirst();
        //System.out.println(L1);
        //System.out.println(a);

        int maior = L1.achaMaior(L1, L4);
        System.out.println(L1);
        System.out.println(L4);
        System.out.println(maior);
        System.out.println();

        int [] v1 = {2,3,4,5,6,7};
        int [] v2 = {3,4,7,6, 8,9,12,13};
         int [] v3 = ListArrayOfInteger.interseccao(v1, v2);

         for (int i=0; i<v3.length; i++){
             System.out.println(v3[i]);
         }
    }
}

