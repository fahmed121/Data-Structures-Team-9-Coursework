package BinarySearchTree.src;//import java.util.ArrayList;
//
//public class Benchmark {
//
//    public Benchmark() {
//
//    }
//
//    public void BenchmarkMinHeap() {
//
//    }
//
//    public BinaryTree CreateBTree(ArrayList<String> postcodes) {
//        BinaryTree Tree = new BinaryTree();
//
//        for (int i = 1; i < postcodes.size(); i++) {
//            Tree.Insert(postcodes.get(i));
//        }
//        return Tree;
//    }
//
//    public MinHeap createHeap(ArrayList<String> postcode) {
//        MinHeap heap = new MinHeap(postcode.size());
//
//        for (int n = 0; n < postcode.size() - 1; n++) {
//
//            heap.insert(postcode.get(n));
//
//        }
//        return heap;
//    }
//
//    public AVLTree createAVLTree(ArrayList<String> postcodes) {
//        AVLTree Tree = new AVLTree();
//
//        for (int i = 1; i < postcodes.size(); i++) {
//            Tree.Insert(postcodes.get(i));
//        }
//        return Tree;
//    }
//
//    public long Btreeinsert(ArrayList<String> postcodes) {
//
//        BinaryTree test = new BinaryTree();
//        String postcode = "N1 0DG";
//        long start = System.nanoTime();
//        test.Insert(postcode);
//        long end = System.nanoTime();
//
//        long total = end - start;
//
//        return total;
//    }
//
//    public long Btreedelete(ArrayList<String> postcodes) {
//        BinaryTree test = new BinaryTree();
//        String postcode = "N1 0DG";
//        long start = System.nanoTime();
//        test.Delete(postcode);
//        long end = System.nanoTime();
//
//        long total = end - start;
//
//        return total;
//    }
//
//    public long BtreeSearch(ArrayList<String> postcodes) {
//        BinaryTree test = new BinaryTree();
//        String postcode = "N1 0DG";
//        long start = System.nanoTime();
//        test.Search(postcode);
//        long end = System.nanoTime();
//
//        long total = end - start;
//
//        return total;
//    }
//
//    public long BtreeCount(ArrayList<String> postcodes) {
//        BinaryTree test = new BinaryTree();
//        long start = System.nanoTime();
//        test.getCount();
//        long end = System.nanoTime();
//
//        long total = end - start;
//
//        return total;
//    }
//
//    public long BtreeInOrder(ArrayList<String> postcodes) {
//        BinaryTree test = new BinaryTree();
//        long start = System.nanoTime();
//        test.InOrder();
//        long end = System.nanoTime();
//
//        long total = end - start;
//
//        return total;
//    }
//
//    public long HeapInsert(ArrayList<String> postcodes) {
//
//        MinHeap heap = new MinHeap(1000);
//        String postcode = "N1 0DG";
//        long start = System.nanoTime();
//        heap.insert(postcode);
//        long end = System.nanoTime();
//
//        long total = end - start;
//        return total;
//    }
//
//    public long HeapSearch(ArrayList<String> postcodes) {
//        MinHeap heap = new MinHeap(1000);
//        String postcode = "N1 0DG";
//        long start = System.nanoTime();
//        heap.Search(postcode);
//        long end = System.nanoTime();
//
//        long total = end - start;
//        return total;
//
//    }
//
//    public long HeapExtractMin(ArrayList<String> postcodes) {
//        MinHeap heap = new MinHeap(1000);
//        long start = System.nanoTime();
//        heap.ExtractMinimum();
//        long end = System.nanoTime();
//
//        long total = end - start;
//        return total;
//    }
//
//    public long HeapInOrder(ArrayList<String> postcodes) {
//        MinHeap heap = new MinHeap(1000);
//        long start = System.nanoTime();
//        heap.InOrder();
//        long end = System.nanoTime();
//
//        long total = end - start;
//        return total;
//    }
//
//    public long HeapCount(ArrayList<String> postcodes) {
//        MinHeap heap = new MinHeap(1000);
//        long start = System.nanoTime();
//        heap.InOrder();
//        long end = System.nanoTime();
//        long total = end - start;
//        return total;
//
//    }
//
//    public long AVLInOrder(ArrayList<String> postcodes) {
//
//        long start = System.nanoTime();
//
//        long end = System.nanoTime();
//        long total = end - start;
//        return total;
//    }
//
//    public long AVLCount(ArrayList<String> postcodes) {
//        long start = System.nanoTime();
//
//        long end = System.nanoTime();
//        long total = end - start;
//        return total;
//    }
//
//    public long AVLSearch(ArrayList<String> postcodes) {
//        long start = System.nanoTime();
//
//        long end = System.nanoTime();
//        long total = end - start;
//        return total;
//    }
//
//    public long AVLDelete(ArrayList<String> postcodes) {
//        long start = System.nanoTime();
//
//        long end = System.nanoTime();
//        long total = end - start;
//        return total;
//    }
//
//    public long AVLInsert(ArrayList<String> postcodes) {
//
//        long start = System.nanoTime();
//
//        long end = System.nanoTime();
//        long total = end - start;
//        return total;
//    }
//}
