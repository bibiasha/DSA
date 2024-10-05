import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        Heap minHeap = new Heap();
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(1);
        
        // Loop until the heap is empty
        while (!minHeap.isEmpty()) {
            // Print the current minimum element (root)
            System.out.println("Peek: " + minHeap.peek());

            // Remove the minimum element (root)
            minHeap.remove();
        }
    }

    static class Heap {
        ArrayList<Integer> heapArray = new ArrayList<>();
        
        public void add(int data) {
            heapArray.add(data);
            int x = heapArray.size() - 1; // x is the child index
            int par = (x - 1) / 2; // par is the parent index

            // Adjust the heap upwards
            while (x > 0 && heapArray.get(x) < heapArray.get(par)) {
                int temp = heapArray.get(x);
                heapArray.set(x, heapArray.get(par));
                heapArray.set(par, temp);
                
                // Move up the tree
                x = par;
                par = (x - 1) / 2;
            }
        }
        
        public int peek() {
            return heapArray.get(0); // Return the root (minimum) element
        }

        public int remove() {
            if (heapArray.size() == 0) {
                throw new NoSuchElementException("Heap is empty");
            }

            // Swap root with the last element
            int data = heapArray.get(0);
            int temp = heapArray.get(0);
            heapArray.set(0, heapArray.get(heapArray.size() - 1));
            heapArray.set(heapArray.size() - 1, temp);

            // Remove the last element
            heapArray.remove(heapArray.size() - 1);

            // Heapify down to maintain the heap property
            heapify(0);

            return data; // Return the removed element
        }

        // Add the isEmpty method
        public boolean isEmpty() {
            return heapArray.isEmpty();
        }

        // Heapify down method
        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < heapArray.size() && heapArray.get(left) < heapArray.get(smallest)) {
                smallest = left;
            }

            if (right < heapArray.size() && heapArray.get(right) < heapArray.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                // Swap
                int temp = heapArray.get(i);
                heapArray.set(i, heapArray.get(smallest));
                heapArray.set(smallest, temp);

                // Continue heapifying downwards
                heapify(smallest);
            }
        }
    }
}
