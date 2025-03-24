import java.util.List;

public abstract class Environment {
    protected State initialState;
    protected List<? extends State> objectives;

    public abstract void configure();
    public abstract void display();

    public State getInitialState() {
        return initialState;
    }

    public boolean isObjective(State state) {
        return objectives.contains(state);
    }
}
