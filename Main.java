import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] argc)
    {
        NFrame frame = new NFrame(0,0,1000,500);
        Screen window = new Screen(50,50,400,400);
        Matrix matrix = new Matrix(200, 200);
        frame.add(window);
        Random rand = new Random();

        window.InitColors(30);

        List<Ant> ants = new ArrayList<>();

        for(int i = 0; i < 5; i++)
        {
            ants.add(new Ant(rand.nextInt(matrix.getC()), rand.nextInt(matrix.getR()), rand.nextInt(4), i+1));
        }

        for(int k = 0; k < 11000; k++) {

            for(Ant ant: ants)
                ant.MakeMove(matrix);
            window.setIcon(window.CreateContent(matrix));

            try{Thread.sleep(10);}
            catch(InterruptedException e) {System.out.println(e);}
        }
    }
}
