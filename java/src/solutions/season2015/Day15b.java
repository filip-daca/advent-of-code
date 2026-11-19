package solutions.season2015;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day15b implements Solution {

    private static final Integer propertiesCount = 5;

    public List<List<Integer>> distribute(int total, int parts) {
        List<List<Integer>> distributions = new ArrayList<>();
        if (parts == 1) {
            List<Integer> distribution = new ArrayList<>();
            distribution.add(total);
            distributions.add(distribution);
        } else {
            for (int i = 1; i < total; ++i) {
                for (List<Integer> distribution : distribute(total - i, parts - 1)) {
                    distribution.addFirst(i);
                    distributions.add(distribution);
                }
            }
        }
        return distributions;
    }

    @Override
    public String solve(Scanner sc) {

        List<List<Integer>> ingridients = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");

            List<Integer> ingredient = new ArrayList<>();
            ingredient.add(Integer.parseInt(words[2].substring(0, words[2].length() - 1)));
            ingredient.add(Integer.parseInt(words[4].substring(0, words[4].length() - 1)));
            ingredient.add(Integer.parseInt(words[6].substring(0, words[6].length() - 1)));
            ingredient.add(Integer.parseInt(words[8].substring(0, words[8].length() - 1)));
            ingredient.add(Integer.parseInt(words[10]));

            ingridients.add(ingredient);
        }

        List<List<Integer>> distributions = distribute(100, ingridients.size());

        long maxScore = 0;
        for (List<Integer> distribution : distributions) {
            Long distributionScore = null;

            long[] propertiesScore = new long[propertiesCount];
            for (int i = 0; i < propertiesCount; ++i) {
                for (int j = 0; j < distribution.size(); ++j) {
                    propertiesScore[i] += (long) distribution.get(j) * ingridients.get(j).get(i);
                }
                if (propertiesScore[i] < 0) {
                    propertiesScore[i] = 0;
                }
                if (i == 4 && propertiesScore[i] != 500) {
                    distributionScore = 0L;
                } else if (i != 4) {
                    distributionScore = distributionScore == null ? propertiesScore[i] : distributionScore * propertiesScore[i];
                }
            }

            if (distributionScore > maxScore) {
                maxScore = distributionScore;
            }
        }

        return maxScore + "";
    }
}
