import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1655 {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());

        S1655 s = new S1655();
        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            s.addNumber(n);
        }
        System.out.print(s.stringBuilder);
    }

    private void addNumber(int n) {
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.offer(n);
        } else {
            minHeap.offer(n);
        }
        if (!minHeap.isEmpty()) {
            if (minHeap.peek() < maxHeap.peek()) {
                Integer temp = minHeap.poll();
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(temp);
            }
        }
        stringBuilder.append(maxHeap.peek()).append("\n");
    }
}