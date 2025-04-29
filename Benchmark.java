
package data.structures.group3;

public class Benchmark {
    
    
    public Benchmark(){
        
    }
    public void BenchmarkMinHeap(){
        
        
        
    }
    
    public long Btreeinsert(){
        
        BinaryTree test = new BinaryTree();
        String postcode = "N1 0DG";
        long start = System.nanoTime();
        test.Insert(postcode);
        long end = System.nanoTime();
        
        long total = end - start;
        
        return total;
    }
    public long Btreedelete(){
        BinaryTree test = new BinaryTree();
        String postcode = "N1 0DG";
        long start = System.nanoTime();
        test.Delete(postcode);
        long end = System.nanoTime();
        
        long total = end - start;
        
        return total;
    }
    public long BtreeSearch(){
        BinaryTree test = new BinaryTree();
        String postcode = "N1 0DG";
        long start = System.nanoTime();
        test.Search(postcode);
        long end = System.nanoTime();
        
        long total = end - start;
        
        return total;
    }
    public long BtreeCount(){
        BinaryTree test = new BinaryTree();
        long start = System.nanoTime();
        test.getCount();
        long end = System.nanoTime();
        
        long total = end - start;
        
        return total;
    }
    public long BtreeInOrder(){
        BinaryTree test = new BinaryTree();
        long start = System.nanoTime();
        test.InOrder();
        long end = System.nanoTime();
        
        long total = end - start;
        
        return total;
    }
    public long HeapInsert(){
        
        MinHeap heap = new MinHeap(1000);
        String postcode ="N1 0DG";
        long start = System.nanoTime();
        heap.insert(postcode);
        long end = System.nanoTime();
        
        long total = end - start;
        return total;
    }
    public long HeapSearch(){
        MinHeap heap = new MinHeap(1000);
        String postcode ="N1 0DG";
        long start = System.nanoTime();
        heap.Search(postcode);
        long end = System.nanoTime();
        
        long total = end - start;
        return total;
        
    }
    public long HeapExtractMin(){
        MinHeap heap = new MinHeap(1000);
        long start = System.nanoTime();
        heap.ExtractMinimum();
        long end = System.nanoTime();
        
        long total = end - start;
        return total;
    }
    public long HeapInOrder(){
        MinHeap heap = new MinHeap(1000);
        long start = System.nanoTime();
        heap.InOrder();
        long end = System.nanoTime();
        
        long total = end - start;
        return total;
    }
    public long HeapCount(){
        MinHeap heap = new MinHeap(1000);
        long start = System.nanoTime();
        heap.InOrder();
        long end = System.nanoTime();
        long total = end - start;
        return total;

    }
    public long AVLInOrder(){
        long start = System.nanoTime();
        
        long end = System.nanoTime();
        long total = end - start;
        return total;
    }
    public long AVLCount(){
        long start = System.nanoTime();
        
        long end = System.nanoTime();
        long total = end - start;
        return total;
    }
        public long AVLSearch(){
        long start = System.nanoTime();
        
        long end = System.nanoTime();
        long total = end - start;
        return total;
    }
        public long AVLDelete(){
        long start = System.nanoTime();
        
        long end = System.nanoTime();
        long total = end - start;
        return total;
    }
        public long AVLInsert(){
                
        long start = System.nanoTime();
        
        long end = System.nanoTime();
        long total = end - start;
        return total;
    }
}

