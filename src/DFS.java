import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS extends SearchAlgorithm<State> {
    private Set<State> visited = new HashSet<>();

    @Override
    public List<State> search(State initial) {
        visited.clear();
        List<State> path = new ArrayList<>();
        if (dfsUtil(initial, path)) {
            printPath(path);
            return path;
        }
        System.out.println("NO SE ENCONTRO LA SOLUCION CON DFS.");
        return Collections.emptyList();
    }

    private boolean dfsUtil(State current, List<State> path) {
        visited.add(current);
        path.add(current);

        if (current.isGoal()) {
            return true;
        }

        for (State neighbor : current.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                if (dfsUtil(neighbor, path)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
