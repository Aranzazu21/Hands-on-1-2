import java.util.List;

public class WumpusWorld extends Environment {
    private WumpusState[][] cave;

    public WumpusWorld(int size) {
        cave = new WumpusState[size][size];
    }

    @Override
    public void configure() {

        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                boolean gold = (i == 2 && j == 1);
                boolean pit = (i == 1 && j == 3) || (i == 3 && j == 1);
                boolean wumpus = (i == 2 && j == 2);

                cave[i][j] = new WumpusState(
                        "("+i+","+j+")",
                        gold,
                        pit,
                        wumpus
                );
            }
        }

        // Conectar celdas adyacentes (CORREGIDO)
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(i > 0) cave[i][j].addNeighbor(cave[i-1][j], 1);
                if(j > 0) cave[i][j].addNeighbor(cave[i][j-1], 1);
                if(i < 3) cave[i][j].addNeighbor(cave[i+1][j], 1);
                if(j < 3) cave[i][j].addNeighbor(cave[i][j+1], 1);
            }
        }

        initialState = cave[0][0];
        objectives = List.of(cave[2][1]);
    }

    @Override
    public void display() {
        System.out.println("\nMAPA DE LA CUEVA DE WUMPUS :");
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                String cell = cave[i][j].isGoal() ? "[G]" :
                        cave[i][j].hasPit() ? "[P]" :
                                cave[i][j].hasWumpus() ? "[W]" : "[ ]";
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
