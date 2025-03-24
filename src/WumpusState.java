import java.util.ArrayList;
import java.util.List;

public class WumpusState implements State {
    private final String position;
    private final boolean hasGold;
    private final boolean hasPit;
    private final boolean hasWumpus;
    private final List<State> neighbors;

    public WumpusState(String pos, boolean gold, boolean pit, boolean wumpus) {
        position = pos;
        hasGold = gold;
        hasPit = pit;
        hasWumpus = wumpus;
        neighbors = new ArrayList<>();
    }

    @Override
    public List<State> getNeighbors() {
        return new ArrayList<>(neighbors);
    }

    @Override
    public boolean isGoal() {
        return hasGold && !hasPit && !hasWumpus;
    }

    @Override
    public String getId() {
        return position;
    }

    @Override
    public void addNeighbor(State neighbor, double cost) {
        if(!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }


    public boolean hasPit() { return hasPit; }
    public boolean hasWumpus() { return hasWumpus; }
    public String getPercepts() {
        return "Position: " + position +
                "\nGold: " + hasGold +
                "\nPit: " + hasPit +
                "\nWumpus: " + hasWumpus;
    }
}
