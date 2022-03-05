package array.AverageSalaryExcludingtheMinimumandMaximumSalary1491;

public class Solution {

    public double average(int[] salary) {
        int len = salary.length;
        double sum = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n: salary) {
            sum += n;
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        return (double)((sum - max - min)/ (double) (len - 2));
    }

}
