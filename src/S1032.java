import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1032 {
    private static final char WILD_CARD = '?';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());

        String[] fileNames = new String[caseCount];
        for (int i = 0; i < caseCount; i++) {
            fileNames[i] = bufferedReader.readLine();
        }

        System.out.println(getAnswer(fileNames));
    }

    private static String getAnswer(String[] names) {
        StringBuilder stringBuilder = new StringBuilder(names[0]);
        for (int i = 0; i < names[0].length(); i++) {
            for (String name : names) {
                if (stringBuilder.charAt(i) != name.charAt(i)) {
                    stringBuilder.setCharAt(i, WILD_CARD);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}
