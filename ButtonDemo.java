//deligation model example
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class CBD extends Frame implements ActionListener {
    Button b1, b2, b3;

    public CBD() {
        super("Button Demo.....");
        b1 = new Button("button1");
        b2 = new Button("button2");
        b3 = new Button("button3");
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        setSize(500, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            System.out.println("button 1 pressed");
        } else if (ae.getSource() == b2) {
            System.out.println("Button 2 pressed");
        } else {
            System.exit(0);
        }
    }
}

class ButtonDemo {
    public static void main(String args[]) {
        CBD obj = new CBD();
    }
}
