import javax.swing.*;

public class Main {

    public static void main(String[] argc)
    {
        NFrame frame = new NFrame(0,0,1010,1010);
        Screen window = new Screen(50,50,500,500);
        Matrix matrix = new Matrix(250, 250);
        frame.add(window);


        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 100,15);
        slider.setVisible(true);
        slider.setBounds(window.getX(), window.getY() + window.getHeight() + (int)0.1 * window.getHeight(), window.getWidth(), 50);
        frame.add(slider);

        StartStop ss = new StartStop(5, 11000, window, matrix, slider);
        frame.add(ss);
        ss.setBounds(window.getX() +  window.getWidth() + window.getWidth()/4, window.getY(), window.getWidth()/4, window.getWidth()/4);
        ss.setVisible(true);


    }
}
