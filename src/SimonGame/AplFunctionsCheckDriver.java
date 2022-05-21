/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimonGame;

/**
 *
 * @author Harshilkumar Vaghela(3116318)
 * @date October 28,2020(Assignment-2)
 */
public class AplFunctionsCheckDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayPositionalList<String> l = new ArrayPositionalList<>();
        l.addLast("Albus");//adding all elements at the end of the list
        l.addLast("Ron");
        l.addLast("Hermoine");
        l.addFirst("Harry");//adding the element at the beginnig of the list
        Position<String> p = l.first();
        System.out.println("Assigning first position:");
        DisplayList(l, p);
        p = l.after(p);
        p = l.after(p);
        System.out.println("Checking the after method(Moving to Third position): ");
        DisplayList(l, p);
        p = l.before(p);
        System.out.println("Checking the before method(Moving back 1 position)): ");//will check all methods from this position now
        DisplayList(l, p);
        l.addAfter(p, "Bill");
        System.out.println("Checking the addAfter method: ");
        DisplayList(l, p);
        l.addBefore(p, "Ginny");
        System.out.println("Checking the addBefore method: ");
        DisplayList(l, p);
        l.set(p, "Dolores");
        System.out.println("Checking the set method: ");
        DisplayList(l, p);
        l.remove(p);
        System.out.println("Checking the remove method: ");
        DisplayList(l, p);
        p = l.last();
        System.out.println("Assigning the last position: ");
        DisplayList(l, p);

        ArrayPositionalList<Integer> m = new ArrayPositionalList<>();
        m.addLast(8);
        m.addLast(6);
        m.addLast(7);
        m.addLast(5);
        m.addLast(3);
        m.addLast(0);
        m.addLast(9);
        System.out.println("Before insertionSort :" + m);
        insertionSort(m);
        System.out.println("After insertionSort: " + m);

    }

    public static void insertionSort(ArrayPositionalList<Integer> l) {
        int n = l.size();
        Position<Integer> pos = l.first();
        for (int k = 0; k < l.size() - 1; k++) {
            pos = l.after(pos);
            int cur = pos.getElement();
            Position<Integer> pos2 = pos;
            while (pos2 != l.first() && l.before(pos2).getElement() > cur) {
                l.set(pos2, l.before(pos2).getElement());
                pos2 = l.before(pos2);
            }
            l.set(pos2, cur);
        }
    }

    public static void DisplayList(ArrayPositionalList<String> l, Position<String> p) {
        System.out.println("Position :" + p);
        System.out.println("APL :" + l);
    }

}
