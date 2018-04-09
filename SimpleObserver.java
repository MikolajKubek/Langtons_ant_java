import java.awt.*;

public class SimpleObserver {
    private StartStop startStop;

    public SimpleObserver(StartStop ss)
    {
        this.startStop = ss;
    }

    public void Notify(Point p)
    {
        startStop.addAnt((int)p.getX(), (int)p.getY());
    }
}
