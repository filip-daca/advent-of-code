package solutions.season2015;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Day7b implements Solution {

    private class Wire {
        Wire input1;
        Wire input2;
        Integer value;
        String operation;
        String name;

        public Wire(String name) {
            this.name = name;
            if (name.matches("-?\\d+")) {
                this.value = Integer.parseInt(name);
            }
        }

        public Integer getValue() {
            if (value == null) {
                if (operation == null) {
                    value = input1.getValue();
                } else switch (operation) {
                    case "NOT" -> value = ~(input1.getValue());
                    case "AND" -> value = (input1.getValue() & input2.getValue());
                    case "OR" -> value = (input1.getValue() | input2.getValue());
                    case "LSHIFT" -> value = (input1.getValue() << input2.getValue());
                    case "RSHIFT" -> value = (input1.getValue() >> input2.getValue());
                }
            }
            return value & 0xffff;
        }

        public void reset() {
            if (input1 != null) {
                value = null;
            }
        }
    }

    @Override
    public String solve(Scanner sc) {
        Map<String, Wire> wires = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");

            String name = words[words.length - 1];
            Wire wire = wires.computeIfAbsent(name, Wire::new);

            if (words.length == 3) {
                wire.input1 = wires.computeIfAbsent(words[0], Wire::new);
            } else if (words.length == 4) {
                wire.operation = "NOT";
                wire.input1 = wires.computeIfAbsent(words[1], Wire::new);
            } else {
                wire.operation = words[1];
                wire.input1 = wires.computeIfAbsent(words[0], Wire::new);
                wire.input2 = wires.computeIfAbsent(words[2], Wire::new);
            }
        }

        Integer prevA = wires.get("a").getValue();

        wires.values().forEach(Wire::reset);

        wires.get("b").value = prevA;
        return Integer.toUnsignedString(wires.get("a").getValue());
    }
}
