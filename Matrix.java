public class Matrix {
    private int r;
    private int c;
    public int[][] t;

    public Matrix(int r, int c)
    {
        this.r = r;
        this.c = c;
        this.t = new int[r][c];
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
                t[i][j] = 0;
        }
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}
