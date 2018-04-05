import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Screen extends JButton {

    private List<Integer> list;

    public Screen(int x, int y, int w, int h)
    {
        this.setBackground(Color.WHITE);
        this.setBounds(x, y, w, h);
        this.setBorderPainted(false);
    }

    public void InitColors(int n)
    {
        list = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < n; i++)
        {

            list.add(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)).getRGB());
        }

    }

    public ImageIcon CreateContent(Matrix matrix)
    {
        Random rand = new Random();
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

