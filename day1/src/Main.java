import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> left = null;
        ArrayList<Integer> right = null;
        try {
            DataLoader loader = new DataLoader("day1/data/input.txt", 1000);
            loader.loadData();
            left = loader.getLeftList();
            right = loader.getRightList();
        } catch (FileNotFoundException exc) {
            System.out.println(exc.getMessage());
        }

        DistanceCalculator calculator = new DistanceCalculator(left, right);
        int total = calculator.getTotalDistance();
        System.out.println(total);
    }
}
