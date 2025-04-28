
public class PostcodeMinHeap {

    private String[] Heap;
    private int size;
    private int maxSize;

    // Constructor
    public PostcodeMinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.Heap = new String[maxSize + 1];

    }

    // used to return the number of postcodes in heap
    public int count() {
        return size;
    }

    // to return the position of parent node
    private int parent(int pos) {
        return pos / 2;
    }

    // to return the position of left node
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // to return the position of right node
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }
// if the nodes are correct

    private Boolean isLeaf(int pos) {
        if (pos > (size / 2)) {
            return true;
        }
        return false;
    }

    //Swap nodes
    private void swap(int fpos, int spos) {
        String temp;
        temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;

    }

    //sift up process
    private void siftUp(int pos) {
        while (pos > 1 && Heap[pos].compareTo(Heap[parent(pos)]) < 0) {
            swap(pos, parent(pos));
            pos = parent(pos);

        }
    }

    //sift down process
    private void siftDown(int pos) {
        while (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int smallest = left;

            if (right <= size && Heap[right].compareTo(Heap[left]) < 0) {
                smallest = right;
            }
            if (Heap[pos].compareTo(Heap[smallest]) <= 0) {
                break;
            }

            swap(pos, smallest);
            pos = smallest;

        }

    }

    // insert method
    public void insert(String postcode) {
        if (size >= maxSize) {
            return;
        }
        Heap[++size] = postcode;
        siftUp(size);

    }
// method to extract minimum

    public String ExtractMinimum() {
        if (size == 0) {
            return null;
        }
        String minimum = Heap[1];

        Heap[1] = Heap[size];
        size--;

        if (size > 0) {
            siftDown(1);
        }
        return minimum;

    }
    //method to search

    public boolean Search(String postcode) {

        for (int i = 1; i <= size; i++) {
            if (Heap[i].equals(postcode)) {
                return true;
            }
        }
        return false;
    }

    // To sort in ascending order
    public String[] InOrder() {
        String[] result = new String[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = ExtractMinimum();
        }
        return result;

    }




    //method to keep heap
    public String[] InOrderKeep(){
        PostcodeMinHeap copy = new PostcodeMinHeap(maxSize);
        copy.size = this.size;
        System.arraycopy(this.Heap, 0, copy.Heap, 0, this.size + 1);

        String [] array = new String[copy.size];
        for (int i = 0; i < array.length; i++){
            array[i] = copy.ExtractMinimum();
        }
        return array;





    }

}
