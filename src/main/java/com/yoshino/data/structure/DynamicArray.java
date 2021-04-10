package com.yoshino.data.structure;

import lombok.ToString;

import java.util.*;

@ToString
public class DynamicArray<E> extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    private int size;

    private E[] elementData;


    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray(int initialCapacity) {
        size = 0;
        if (initialCapacity > 0) {
            this.elementData = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = (E[]) EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                initialCapacity);
        }
    }

    public DynamicArray() {
        this.elementData = (E[]) EMPTY_ELEMENTDATA;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData[index];
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
        return true;
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private Object[] grow(int minCapacity) {
        elementData = Arrays.copyOf(elementData,
            newCapacity(minCapacity + 1));
        System.out.println("grow:" + size + " " + elementData.length);
        return elementData;
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData.length == 0) {
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            }
            if (minCapacity < 0) {
                // overflow
                throw new OutOfMemoryError();
            }
                return minCapacity;
        }
        return newCapacity - MAX_ARRAY_SIZE <= 0
            ? newCapacity
            : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE)
            ? Integer.MAX_VALUE
            : MAX_ARRAY_SIZE;
    }


    @Override
    public E remove(int index) {
        return null;
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Object[] objects = new Object[10];
        System.out.println(objects.length);
        List<String> strings = new DynamicArray<>();
        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }
        System.out.println(strings);

    }
}
