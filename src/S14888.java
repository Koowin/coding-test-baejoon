import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class S14888 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.readLine();
        int[] numbers = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operations = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Calculator calculator = new Calculator(numbers);
        calculator.recursion(numbers[0], 1, operations);

        System.out.println(calculator.maxNumber);
        System.out.println(calculator.minNumber);
    }

    static class Calculator {
        private int maxNumber = Integer.MIN_VALUE;
        private int minNumber = Integer.MAX_VALUE;

        private final int[] numbers;

        private Calculator(int[] numbers) {
            this.numbers = numbers;
        }

        private void recursion(int number, int index, int[] operations) {
            if (index == numbers.length) {
                maxNumber = Math.max(maxNumber, number);
                minNumber = Math.min(minNumber, number);
                return;
            }

            for (int i = 0; i < 4; i++) {
                if (operations[i] > 0) {

                    Operation operation = Operation.findById(i);
                    int nextNumber = operation.apply(number, numbers[index]);
                    int[] nextOperations = Arrays.copyOf(operations, 4);
                    nextOperations[i]--;

                    recursion(nextNumber, index+1, nextOperations);
                }
            }
        }
    }

    enum Operation {
        PLUS{
            @Override
            public int apply(int n1, int n2) {
                return n1 + n2;
            }
        },
        MINUS {
            @Override
            public int apply(int n1, int n2) {
                return n1 - n2;
            }
        },
        MULTIPLY {
            @Override
            public int apply(int n1, int n2) {
                return n1 * n2;
            }
        },
        DIVIDE {
            @Override
            public int apply(int n1, int n2) {
                return n1 / n2;
            }
        };

        public abstract int apply(int n1, int n2);

        public static Operation findById(int i) {
            switch (i) {
                case 0:
                    return PLUS;
                case 1:
                    return MINUS;
                case 2:
                    return MULTIPLY;
                default:
                    return DIVIDE;
            }
        }
    }
}
