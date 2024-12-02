import java.util.ArrayList;

public class DistanceCalculator {

    private final ArrayList<Integer> leftList;
    private final ArrayList<Integer> rightList;

    public DistanceCalculator(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        this.leftList = leftList;
        this.rightList = rightList;
    }

    int getTotalDistance() {
        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);

        if (leftList.size() != rightList.size()) {
            throw new IllegalArgumentException("leftList and rightList must have the same size");
        }

        int totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }
        return totalDistance;
    }

}
