import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Screen extends JButton {

    private List<Integer> list;
    private SimpleObserver observer;
    private int scaleX;
    private int scaleY;

    public Screen(int x, int y, int w, int h, int matrix_w, int matrix_h)
    {
        list = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.setBounds(x, y, w, h);
        this.setBorderPainted(false);
        this.scaleX = w/matrix_w;
        this.scaleY = h/matrix_h;

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                point.x -= getLocationOnScreen().getX();
                point.y -= getLocationOnScreen().getY();

                point.x/=scaleX;
                point.y/=scaleY;
                System.out.println(point);

                observer.Notify(point);

            }
        });
    }

    public void InitColors()
    {

        Random rand = new Random();

            list.add(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)).getRGB());


    }

    public void addObserver(SimpleObserver ss)
    {
        this.observer = ss;
    }

    public ImageIcon CreateContent(Matrix matrix)
    {
        BufferedImage b = new BufferedImage(matrix.getC(), matrix.getR(), BufferedImage.TYPE_INT_ARGB);
        for(int i = 0; i < matrix.getC(); i++){
            for(int j = 0; j < matrix.getR(); j++) {
                if(matrix.t[i][j] == 0)
                    b.setRGB(i, j, Color.white.getRGB());
                else
                    b.setRGB(i, j, list.get(matrix.t[i][j]-1));
            }
        }
        Image image = (Image) b;
        ImageIcon ii = new ImageIcon(image);
        return new ImageIcon(ii.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
    }
}

