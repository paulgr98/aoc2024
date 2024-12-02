import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {
    private final ArrayList<Integer> leftList;
    private final ArrayList<Integer> rightList;
    private final BufferedReader reader;

    public DataLoader(String fileName, int expectedDataSize) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
        leftList = new ArrayList<>(expectedDataSize);
        rightList = new ArrayList<>(expectedDataSize);
    }

    public void loadData() {
        try {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] tokens = this.tokenizeLine(line);
                int[] parsedLine = this.parseTokenizeLine(tokens);
                leftList.add(parsedLine[0]);
                rightList.add(parsedLine[1]);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private String[] tokenizeLine(String line) {
        return line.split("\\s+");
    }

    private int[] parseTokenizeLine(String[] tokenizedLine) {
        int[] result = new int[tokenizedLine.length];
        for (int i = 0; i < tokenizedLine.length; i++) {
            result[i] = Integer.parseInt(tokenizedLine[i]);
        }
        return result;
    }

    public ArrayList<Integer> getLeftList() {
        return leftList;
    }

    public ArrayList<Integer> getRightList() {
        return rightList;
    }
}
