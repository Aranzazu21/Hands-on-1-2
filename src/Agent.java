import java.util.List;

public class Agent {
    private final SearchAlgorithm<State> strategy;
    private State currentPosition;
    private List<State> path;


    public Agent(SearchAlgorithm<State> searchStrategy, State initialPosition) {
        this.strategy = searchStrategy;
        this.currentPosition = initialPosition;
    }


    public void solve() {
        System.out.println("\nINICIANDO BUSQUEDA CON  " + strategy.getClass().getSimpleName());
        this.path = strategy.search(currentPosition);
        executePath();
    }


    private void executePath() {
        if (path == null || path.isEmpty()) {
            System.out.println("NO SE ENCONTRO LA SOLUCION.");
            return;
        }

        System.out.println("\nEL AGENTE COMIENZA EN : " + currentPosition.getId());
        for (State state : path) {
            currentPosition = state;
            System.out.println("MOVIENDOSE A : " + state.getId());


            if (state instanceof WumpusState) {
                System.out.println(((WumpusState) state).getPercepts());
            }

            if (state.isGoal()) {
                System.out.println("ORO ENCONTRADO SIN PELIGRO ");
                return;
            }
        }
        System.out.println("SE LLEGO AL FINAL SIN ENCONTRAR LA SOLUCION COMPLETA .");
    }


    public List<State> getPath() {
        return path;
    }


    public void reset(State newInitialPosition) {
        this.currentPosition = newInitialPosition;
        this.path = null;
    }
}
