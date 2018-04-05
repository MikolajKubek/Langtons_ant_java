public class Matrix {
    private int r;
    private int c;
    public int[][] t;

    public Matrix(int r, int c)
    {
        this.r = r;
        this.c = c;
        this.t = new int[c][r];
        for(int i = 0; i < c; i++)
        {
            for(int j = 0; j < r; j++)
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
