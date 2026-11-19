package solutions.season2015;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day14b implements Solution {
    
    private static Long bestDistance = 0L;

    private class Deer {
        String name;
        int speed;
        int staminaBase;
        int restBase;

        long score = 0;
        long distance = 0;
        boolean isRunning = true;
        int stamina = staminaBase;
        int rest = 0;

        public void tick() {
            if (isRunning) {
                distance += speed;
                bestDistance = Math.max(distance, bestDistance);
                stamina--;

                if (stamina == 0) {
                    isRunning = false;
                    rest = restBase;
                }
            } else {
                rest--;

                if (rest == 0) {
                    isRunning = true;
                    stamina = staminaBase;
                }
            }
        }
    }

    @Override
    public String solve(Scanner sc) {

        List<Deer> deers = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");

            Deer deer = new Deer();
            deer.name = words[0];
            deer.speed = Integer.parseInt(words[3]);
            deer.staminaBase = Integer.parseInt(words[6]);
            deer.restBase = Integer.parseInt(words[13]);

            deer.isRunning = true;
            deer.stamina = deer.staminaBase;

            deers.add(deer);
        }

        for (int i = 0; i < 2503; ++i) {
            deers.forEach(Deer::tick);
            for (Deer d : deers) {
                if (d.distance == bestDistance) {
                    d.score++;
                }
            }
        }

        long bestScore = 0;
        for (Deer d : deers) {
            bestScore = Math.max(bestScore, d.score);
        }

        return bestScore + "";
    }
}
