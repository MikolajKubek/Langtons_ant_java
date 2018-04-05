import javax.swing.*;
import java.awt.*;

public class NFrame extends JFrame {
    public NFrame(int x, int y, int w, int h) {
        this.setVisible(true);
        this.setBounds(x, y, w, h);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
