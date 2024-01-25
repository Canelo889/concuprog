package Pattern.Strategy.Sort.sort;

import Pattern.Strategy.Sort.behavior.SortBehavior;

/**
 * Design patterns Lab 2 - Strategy
 */
public class Sorter {

    private SortBehavior sortMethod = null;
    
    public void setSortBehavior(SortBehavior sortmethod) {
        this.sortMethod = sortmethod;
    }
    
    public void sort(int[] vector) {
        this.sortMethod.sort(vector);
    }
    
    public void showVectorData(int[] vector) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<vector.length; i++) {
            sb.append(vector[i] + "\t");
        }
        
        System.out.println(sb.toString());
    }
}
