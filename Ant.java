public class Ant {
    private int x;
    private int y;
    private int pos;
    private int val;

    public Ant(int x, int y, int pos, int val)
    {
        this.x = x;
        this.y = y;
        this.pos = pos;
        this.val = val;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY() { return this.y; }

    public int getPos()
    {
        return this.pos;
    }

    public void MakeMove(Matrix matrix)
    {
        this.Mirror(matrix);
        if(matrix.t[this.x][this.y] == 0){
            matrix.t[this.x][this.y] = this.val;
            this.TurnLeft();
        }
        else{
            matrix.t[this.x][this.y] = 0;
            this.TurnRight();
        }


    }

    private void Mirror(Matrix matrix) {
        if(this.x > (matrix.getC()-1))
            this.x = 0;
        else if(this.x < 0)
            this.x = matrix.getC()-1;

        if(this.y > (matrix.getR()-1))
            this.y = 0;
        else if(this.y < 0)
            this.y = matrix.getR()-1;
    }

    private void TurnRight() {
        if(this.pos == 0)
        {
            this.x++;
            this.pos = 1;
        }
        else if(this.pos == 1)
        {
            this.y++;
            this.pos = 2;
        }
        else if(this.pos == 2)
        {
            this.x--;
            this.pos = 3;
        }
        else if(this.pos == 3)
        {
            this.y--;
            this.pos = 0;
        }
        else System.out.println("Invalid ant direction "+this.pos);
    }

    private void TurnLeft() {
        if(this.pos == 0)
        {
            this.x--;
            this.pos = 3;
        }
        else if(this.pos == 1)
        {
            this.y--;
            this.pos = 0;
        }
        else if(this.pos == 2)
        {
            this.x++;
            this.pos = 1;
        }
        else if(this.pos == 3)
        {
            this.y++;
            this.pos = 2;
        }
        else System.out.println("Invalid ant direction "+this.pos);
    }

}
