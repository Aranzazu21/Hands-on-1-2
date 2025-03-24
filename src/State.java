import java.util.List;

public interface State {
    List<State> getNeighbors();
    boolean isGoal();
    String getId();
    void addNeighbor(State neighbor, double cost);
}
