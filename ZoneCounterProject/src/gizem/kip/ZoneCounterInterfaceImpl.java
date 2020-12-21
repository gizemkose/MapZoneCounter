package gizem.kip;

/**
 * This class is created by implementing ZoneCounterInterface class.*/
public class ZoneCounterInterfaceImpl implements ZoneCounterInterface {

    public MapInterfaceImpl mapInterfaceImpl;

    // These arrays are used to get row and column
    // numbers of 4 neighbours of a given cell
    public static int[] rowNbr = {-1, 0, 0, 1};
    public static int[] colNbr = {0, -1, 1, 0};

    @Override
    public void Init(MapInterface map) {
        this.mapInterfaceImpl = (MapInterfaceImpl) map;
    }

    @Override
    public int Solve() {
        return countRegion(this.mapInterfaceImpl, this.mapInterfaceImpl.getDimension());
    }

    /**
     * A method to check if a given cell (row, col) can be included in DFS
     *
     * @param mapInterface MapInterfaceImpl class object
     * @param row     harita matrisinin uzunluğu
     * @param col     harita matrisinin genişliği
     * @param visited haritadaki hücrenin gezilme durumu
     * @return hücre gezilebilir ise true, yoksa false
     */
    boolean isSafe(MapInterfaceImpl mapInterface, int row, int col, boolean[][] visited) {
        return (
                (row >= 0) && (row < mapInterfaceImpl.getDimension().height) && (col >= 0)
                        && (col < mapInterfaceImpl.getDimension().width)
                        && (!mapInterface.IsBorder(col,row) && !visited[row][col]));
    }

    /**
     * A utility method to do DFS for the given matrix.
     *
     * @param mapInterface MapInterfaceImpl class object
     * @param row     harita matrisinin uzunluğu
     * @param col     harita matrisinin genişliği
     * @param visited haritadaki hücrenin gezilme durumu
     */
    public void DFS(MapInterfaceImpl mapInterface, int row, int col, boolean[][] visited) {

        visited[row][col] = true;

        for (int k = 0; k < 4; k++) {
            if (isSafe(mapInterface, row + rowNbr[k], col + colNbr[k],
                    visited)) {
                DFS(mapInterface, row + rowNbr[k], col + colNbr[k],
                        visited);
            }
        }
    }

    /**
     * The main method that returns number of zones in a given boolean 2D matrix.
     *
     * @param mapInterface MapInterfaceImpl class object
     * @param dimension * dimension.width, row harita matrisinin uzunluğu
     *                  * dimension.height, col harita matrisinin genişliği
     * @return
     */
    public int countRegion(MapInterfaceImpl mapInterface, Dimension dimension) {
        int regionCount = 0;

        boolean[][] visited = new boolean[dimension.height][dimension.width];

        for (int i = 0; i < dimension.height; i++) {
            for (int j = 0; j < dimension.width; j++) {
                if (!mapInterface.IsBorder(j,i) && !visited[i][j]) {
                    regionCount++;
                    DFS(mapInterface, i, j, visited);
                }
            }
        }
        return regionCount;
    }

}
