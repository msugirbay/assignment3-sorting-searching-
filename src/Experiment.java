import java.util.Arrays;

public class Experiment {
    Sorter s = new Sorter();
    Searcher src = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy = arr.clone();
        long start = System.nanoTime(); 
        if (type.equals("basic")) s.basicSort(copy);
        else s.advancedSort(copy);
        return System.nanoTime() - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        Arrays.sort(arr); 
        long start = System.nanoTime();
        src.search(arr, target);
        return System.nanoTime() - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};
        System.out.println("Size | Type | Basic (ns) | Advanced (ns)");
        for (int size : sizes) {
            int[] arr = s.generateRandomArray(size);
            long t1 = measureSortTime(arr, "basic");
            long t2 = measureSortTime(arr, "advanced");
            System.out.println(size + " | Random | " + t1 + " | " + t2);
        }
    }
}
