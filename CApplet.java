//exmple programn for applet
import java.awt.*;
import java.applet.*;

/*
<applet code="CApplet.class" width="400" height="400">
</applet>
*/


public class CApplet extends Applet {
    int x, y;
    String str = "";

    public void init() {
        x = 40;
        y = 60;
        str = "inside init method";
    }

    public void paint(Graphics g) {
        g.drawString(str, x, y);
    }
}
