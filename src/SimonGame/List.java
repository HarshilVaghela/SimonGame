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
public interface List<E> {

    int size();

    boolean isEmpty();

    E get(int i) throws IndexOutOfBoundsException;

    E set(int i, E element) throws IndexOutOfBoundsException;

    void add(int i, E element) throws IndexOutOfBoundsException;

    E remove(int i) throws IndexOutOfBoundsException;
}
