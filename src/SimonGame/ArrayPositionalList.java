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
public class ArrayPositionalList<E> implements PositionalList<E> {

    private static class Site<E> implements Position<E> {

        private int index;
        private E element;

        public Site(E e, int i) {
            index = i;
            element = e;
        }

        public E getElement() throws IllegalStateException {
            if (index == -1) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public void setElement(E e) {
            element = e;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int i) {
            index = i;
        }

        public String toString() {
            return element.toString();
        }
    }

    public static final int CAPACITY = 16;
    private Site<E>[] data;
    private int size = 0;

    public ArrayPositionalList() {
        this(CAPACITY);
    }

    public ArrayPositionalList(int capacity) {
        data = (Site<E>[]) new Site[capacity];
    }

    private Position<E> position(Site<E> node) {

        return node;
    }

    @Override
    public int size() {
        return size; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return size == 0; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> first() {
        return data[0]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> last() {
        return data[size - 1]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Site<E> l = validate(p);
        if (l.getIndex() == 0) {
            return null;
        }
        return data[l.getIndex() - 1];//To change body of generated methods, choose Tools | Templates.
    }

    private Site<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Site)) {
            throw new IllegalArgumentException("Invalid p");
        }
        if (p == null) {
            return null;
        }
        Site<E> site = (Site<E>) p;

        return site;
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Site<E> l = validate(p);
        if (l.getIndex() == size) {
            return null;
        }
        return data[l.getIndex() + 1];
    }

    @Override
    public Position<E> addFirst(E e) throws IllegalStateException {
        if (size == data.length) // not enough capacity
        {
            throw new IllegalStateException("Array is full");
        }
        for (int k = size - 1; k >= 0; k--) // start by shifting rightmost
        {
            data[k + 1] = data[k];
            data[k + 1].setIndex(k + 1);
        }
        Site<E> d = new Site(e, 0);
        data[0] = d; // ready to place the new element
        size++;
        return d;
    }

    @Override
    public Position<E> addLast(E e) throws IllegalStateException {
        if (size == data.length) // not enough capacity
        {
            throw new IllegalStateException("Array is full");
        }

        Site<E> d = new Site(e, size);
        data[size] = d; // ready to place the new element
        size++;
        return d;
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException, IllegalStateException {
        Site<E> site = validate(p);
        int index = site.getIndex();
        Site<E> newest = new Site(e, index);
        if (size == data.length) // not enough capacity
        {
            throw new IllegalStateException("Array is full");
        }
        for (int k = size - 1; k >= index; k--) {// start by shifting rightmost
            data[k + 1] = data[k];
            data[k + 1].setIndex(k + 1);
        }
        data[index] = newest; // ready to place the new element
        size++;
        return newest;
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException, IllegalStateException {
        Site<E> site = validate(p);
        int index = site.getIndex();
        Site<E> newest = new Site(e, index + 1);
        if (size == data.length) // not enough capacity
        {
            throw new IllegalStateException("Array is full");
        }
        for (int k = size - 1; k >= index + 1; k--) {// start by shifting rightmost
            data[k + 1] = data[k];
            data[k + 1].setIndex(k + 1);
        }
        data[index + 1] = newest; // ready to place the new element
        size++;
        return newest;
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Site<E> site = validate(p);
        E answer = site.getElement();//as we don't need to change the index here, we shouldn't bother taking the index of site
        site.setElement(e);
        return answer;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Site<E> site = validate(p);
        int index = site.getIndex();
        E temp = data[index].getElement();
        for (int k = index; k < size - 1; k++) { // shift elements to fill hole
            data[k] = data[k + 1];
            data[k].setIndex(k);
        }
        data[size - 1] = null; // help garbage collection
        size--;
        return temp;
    }
    // this is the proper place for cur

    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(" [" + data[i].getIndex() + "] " + data[i].getElement().toString());
        }
        return sb.toString();
    }

}
