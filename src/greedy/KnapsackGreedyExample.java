package greedy;

/*
* Sample Question
*
* Given weights and values of n items, we need to put these items in a knapsack of capacity W
* to get the maximum total value in the knapsack.

In the 0-1 Knapsack problem, we are not allowed to break items. We either take the whole item
or don’t take it.

Input:
  Items as (value, weight) pairs
  arr[] = {{60, 10}, {100, 20}, {120, 30}}
  Knapsack Capacity, W = 50;
Output:
  Maximum possible value = 240
  by taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240

*/

import java.util.Arrays;
import java.util.Comparator;

public class KnapsackGreedyExample {

    public KnapsackGreedyExample(int[] productValue, int[] productWeight, int maxCapacity) {
        findMaximumValueWithCapacity(productValue, productWeight, maxCapacity);
    }

    private void findMaximumValueWithCapacity(int[] productValue, int[] productWeight, int maxCapacity) {
        ProductItem items[] = new ProductItem[productValue.length];
        for (int index = 0; index < productValue.length; index++) {
            items[index] = new ProductItem(productValue[index], productWeight[index]);
        }

        Arrays.sort(items, new Comparator<ProductItem>() {
            @Override
            public int compare(ProductItem o1, ProductItem o2) {
                return o2.costOfAnItem.compareTo(o1.costOfAnItem);
            }
        });

        Double profit = 0d;
        int currentCapacity = 0;
        for (int index = 0; index < items.length; index++) {
            if (currentCapacity < maxCapacity) {
                if (items[index].totalQuantity > (maxCapacity - currentCapacity)) {
                    double fraction = (double) (maxCapacity - currentCapacity) / items[index].totalQuantity;
                    profit += fraction * items[index].totalValue;
                    currentCapacity = (int) (currentCapacity + fraction * items[index].totalQuantity);
                    break;
                } else {
                    currentCapacity = currentCapacity + items[index].totalQuantity;
                    profit = profit + items[index].totalValue;
                }
            }
        }

        System.out.println("Knapsack Problem, Profit at weight capacity " + maxCapacity + " is " + profit);
    }

    public class ProductItem {

        Double costOfAnItem;
        int totalValue;
        int totalQuantity;

        public ProductItem(int totalValue, int totalQuantity) {
            this.totalValue = totalValue;
            this.totalQuantity = totalQuantity;
            costOfAnItem = (double) (totalValue / totalQuantity);
        }
    }
}
