import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartStop extends JButton{
    private int steps;
    private int state;
    private JSlider slider;
    private Screen screen;
    private Matrix matrix;
    private List<Ant> ants;

    Timer timer = new Timer(0, new OnclickListener());


    public StartStop(int amountOfAnts, int steps, Screen screen, Matrix matrix, JSlider slider)
    {
        this.steps = steps;
        this.slider = slider;
        this.screen = screen;
        this.matrix = matrix;
        this.ants = new ArrayList<>();
        this.state = 0; /*off, showing play button*/
        setText("Start");

        this.screen.InitColors(amountOfAnts);

        Random rand = new Random();

        for(int i = 0; i < amountOfAnts; i++)
        {
            this.ants.add(new Ant(rand.nextInt(this.matrix.getC()), rand.nextInt(this.matrix.getR()), rand.nextInt(4), i+1));
            System.out.println(i);
        }

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(state == 0) {
                    state = 1;
                    setText("Stop");
                    timer.setDelay(10);
                    timer.start();
                }
                else
                {
                    state = 0;
                    setText("Start");
                    timer.stop();
                }
            }
        });


    }
    class OnclickListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
                timer.setDelay(slider.getMaximum() + 1 - slider.getValue());
                System.out.println(timer.getDelay());
                if (steps-- > 0)
                    ProcessAutomata();
                else {
                    timer.stop();
                    state = 0;
                    setText("Koniec");
                }


        }
    }

    public void ProcessAutomata()
    {
        for(Ant ant: this.ants)
                ant.MakeMove(matrix);
            screen.setIcon(screen.CreateContent(matrix));



            try {Thread.sleep(0,0);}
            catch (InterruptedException e) {System.out.println(e);}


    }

}
