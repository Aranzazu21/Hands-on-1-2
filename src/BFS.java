import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends SearchAlgorithm<State> {

    @Override
    public List<State> search(State initial) {
        List<State> path = new ArrayList<>();
        Queue<List<State>> queue = new LinkedList<>();
        List<State> initialPath = new ArrayList<>();
        initialPath.add(initial);
        queue.add(initialPath);

        while(!queue.isEmpty()) {
            List<State> currentPath = queue.poll();
            State lastState = currentPath.get(currentPath.size()-1);

            if(lastState.isGoal()) {
                printPath(currentPath);
                return currentPath;
            }

            for(State neighbor : lastState.getNeighbors()) {
                if(!currentPath.contains(neighbor)) {
                    List<State> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }

        return Collections.emptyList();
    }
}
