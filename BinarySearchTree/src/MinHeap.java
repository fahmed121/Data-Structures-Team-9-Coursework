package BinarySearchTree.src;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Source code is decompiled from a .class file using FernFlower decompiler.
public class MinHeap {
    private String[] Heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.Heap = new String[maxSize];
    }

    public int count() {
        return this.size;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private Boolean isLeaf(int pos) {
        return pos > this.size / 2 ? true : false;
    }

    private void swap(int fpos, int spos) {
        String temp = this.Heap[fpos];
        this.Heap[fpos] = this.Heap[spos];
        this.Heap[spos] = temp;
    }

    private void siftUp(int pos) {
        while(pos > 1 && this.Heap[pos].compareTo(this.Heap[this.parent(pos)]) < 0) {
            this.swap(pos, this.parent(pos));
            pos = this.parent(pos);
        }

    }

    private void siftDown(int pos) {
        while(true) {
            if (!this.isLeaf(pos)) {
                int left = this.leftChild(pos);
                int right = this.rightChild(pos);
                int smallest = left;
                if (right <= this.size && this.Heap[right].compareTo(this.Heap[left]) < 0) {
                    smallest = right;
                }

                if (this.Heap[pos].compareTo(this.Heap[smallest]) > 0) {
                    this.swap(pos, smallest);
                    pos = smallest;
                    continue;
                }
            }

            return;
        }
    }

    public void insert(String postcode) {
        if (this.size < this.maxSize) {
            this.Heap[++this.size] = postcode;
            this.siftUp(this.size);
        }
    }

    public String ExtractMinimum() {
        if (this.size == 0) {
            return null;
        } else {
            String minimum = this.Heap[1];
            this.Heap[1] = this.Heap[this.size];
            --this.size;
            if (this.size > 0) {
                this.siftDown(1);
            }

            return minimum;
        }
    }

    public boolean Search(String postcode) {
        for(int i = 1; i <= this.size; ++i) {
            if (this.Heap[i].equals(postcode)) {
                return true;
            }
        }

        return false;
    }

    public String[] InOrder() {
        String[] result = new String[this.size];

        for(int i = 0; i < result.length; ++i) {
            result[i] = this.ExtractMinimum();
        }

        return result;
    }
}
