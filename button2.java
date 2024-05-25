import java.io.*;
import java.awt.*;
import java.awt.event.*;
class CBD_Demo extends Frame implements ActionListener
{
    Button b1;
    public CBD_Demo()
    {
        b1=new Button("ok");
        add(b1);
        setSize(500,500);
        setLayout(new FlowLayout());
        setVisible(true);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            System.out.println("pressed ok");
        }
    }
}
class button2
{
    public static void main(String args[])
    {
        CBD_Demo obj=new CBD_Demo();
    }
}