import java.sql.Array;
import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> list;

    //добавление элемента
    public void add(int value) {
        list.add(value);
        int i = list.size() - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && list.get(parent) < list.get(i)) {
            int temp = list.get(i);
            list.set(i, list.get(parent));
            list.set(parent, temp);

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    //упорядочение кучи
    public void heapify(int i) {
        int leftChild;
        int rightChild;
        int largestChild;

        while (true){
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < list.size() && list.get(leftChild) > list.get(largestChild)) {
                largestChild = leftChild;
            }

            if (rightChild < list.size() && list.get(rightChild) > list.get(largestChild)) {
                largestChild = rightChild;
            }

            if (largestChild == i) {
                break;
            }

            int temp = list.get(i);
            list.set(i, list.get(largestChild));
            list.set(largestChild, temp);
            i = largestChild;
        }
    }

    //построение кучи
    public void buildHeap(ArrayList<Integer> a) {
        list = a;
        for (int i = list.size() / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    //удаление максимального элемента (первого)
    public int deleteMax() {
        int result = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);
        return result;
    }

    //сортировка кучей
    public void heapSort(ArrayList<Integer> array) {
        buildHeap(array);
        for (int i = array.size() - 1; i >= 0; i--) {
            array.set(i, deleteMax());
            heapify(0);
        }
    }
}
