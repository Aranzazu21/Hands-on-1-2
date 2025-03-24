public class Main {
    public static void main(String[] args) {

        Environment wumpusWorld = new WumpusWorld(4);
        wumpusWorld.configure();

        Agent dfsAgent = new Agent(new DFS(), wumpusWorld.getInitialState());
        Agent bfsAgent = new Agent(new BFS(), wumpusWorld.getInitialState());


        System.out.println("_________ DFS SIMULATION_____________");
        wumpusWorld.display();
        dfsAgent.solve();

        System.out.println("\n___________BFS SIMULATION______________");
        bfsAgent.solve();
    }
}
