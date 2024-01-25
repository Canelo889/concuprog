package Pattern.Strategy.Sort;

import Pattern.Strategy.Sort.behavior.BubbleSortBehavior;
import Pattern.Strategy.Sort.behavior.InsertSortBehavior;
import Pattern.Strategy.Sort.behavior.SelectionSortBehavior;
import Pattern.Strategy.Sort.sort.Sorter;

/**
 * Design patterns Lab 2 - Strategy
 */
public class StrategySortLauncher {
    
    public static void main(String[] args) {
        StrategySortLauncher launcher = new StrategySortLauncher();
        launcher.test();
    }
    
    public void test() {
        int[] tab1 = { 99, 11, 2, 33, 12, 1, 0, 99, 34, 35 } ;
        int[] tab2 = { 99, 11, 2, 33, 12, 1, 0, 99, 34, 35 } ;
        int[] tab3 = { 99, 11, 2, 33, 12, 1, 0, 99, 34, 35 } ;
        
        Sorter sorter = new Sorter();
        
        System.out.println("test bubble sort");
        sorter.setSortBehavior(new BubbleSortBehavior());
        sorter.sort(tab1);
        sorter.showVectorData(tab1);
        
        System.out.println("test insert sort");
        sorter.setSortBehavior(new InsertSortBehavior());
        sorter.sort(tab2);
        sorter.showVectorData(tab2);
        
        System.out.println("test selection sort");
        sorter.setSortBehavior(new SelectionSortBehavior());
        sorter.sort(tab3);
        sorter.showVectorData(tab3);
    }
}
