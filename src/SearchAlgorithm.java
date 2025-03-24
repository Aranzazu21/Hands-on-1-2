import java.util.List;

public abstract class SearchAlgorithm<T extends State> {
    public abstract List<T> search(T initial);

    protected boolean isGoal(T state) {
        return state.isGoal();
    }

    protected void printPath(List<T> path) {
        System.out.println("RUTA ENCONTRADA(" + path.size() + " PASOS ):");
        path.forEach(s -> System.out.print(s.getId() + " -> "));
        System.out.println("FIN\n");
    }
}
