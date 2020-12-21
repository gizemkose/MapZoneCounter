package gizem.kip;

/** This class is created by implementing MapInterface class.
 * ClearBorder(int x, int y), GetSize(Dimension dim) methods are never used because they were not the best fit to solution approaches.
 * We used getDimension() method instead of GetSize(Dimension dim) method.

 * **/
public class MapInterfaceImpl implements MapInterface {
    private Dimension dimension;
    private int[][] adjacency_matrix;

    public MapInterfaceImpl() {
    }

    @Override
    public void SetSize(Dimension dim) {
        this.dimension = dim;
        this.adjacency_matrix = new int[dimension.height][dimension.width];
    }

    // not used
    @Override
    public void GetSize(Dimension dim) {

    }

    @Override
    public void SetBorder(int x, int y) {
        if (this.dimension.CheckWithin(x, y)) {
            adjacency_matrix[y][x] = 1;
        }
    }
    //not used
    @Override
    public void ClearBorder(int x, int y) {
        if (this.dimension.CheckWithin(x, y)) {
            adjacency_matrix[y][x] = 0;
        }
    }

    @Override
    public boolean IsBorder(int x, int y) {
        return this.dimension.CheckWithin(x, y) && adjacency_matrix[y][x] == 1;
    }

    @Override
    public void Show() {

        for (int i = 0; i < dimension.height; i++) {
            for (int j = 0; j < dimension.width; j++) {
                System.out.print(adjacency_matrix[i][j]);
            }
            System.out.println("");
        }
    }

    public Dimension getDimension() {
        return dimension;
    }
}
