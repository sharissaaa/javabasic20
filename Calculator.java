//calculator
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calc extends JFrame implements ActionListener {

JTextField t;
JButton [] nb;
JButton pb, sb, mb, db, eb,cb;
JPanel p, p1, p2, p3;
int n1, n2, res, op;

public Calc() {
super("Calculator");
setSize(700, 700);
setLayout(new GridLayout(5, 1));

t = new JTextField(10);
t.setEditable(false);

nb = new JButton[10];
for(int i = 0; i < 10; i++) {
nb[i] = new JButton(String.valueOf(i));
nb[i].addActionListener(this);
}

  cb = new JButton("C");
pb = new JButton("+");
sb = new JButton("-");
mb = new JButton("*");
db = new JButton("/");
eb = new JButton("=");

cb.addActionListener(this);
pb.addActionListener(this);
sb.addActionListener(this);
mb.addActionListener(this);
db.addActionListener(this);
eb.addActionListener(this);

p = new JPanel();
p.setLayout(new GridLayout(1, 4));
p.add(nb[7]);
p.add(nb[8]);
p.add(nb[9]);
p.add(cb);

p1 = new JPanel();
p1.setLayout(new GridLayout(1, 4));
p1.add(nb[4]);
p1.add(nb[5]);
p1.add(nb[6]);
p1.add(pb);

p2 = new JPanel();
p2.setLayout(new GridLayout(1, 4));
p2.add(nb[1]);
p2.add(nb[2]);
p2.add(nb[3]);
p2.add(sb);

p3 = new JPanel();
p3.setLayout(new GridLayout(1, 4));
p3.add(mb);
p3.add(nb[0]);
p3.add(db);
p3.add(eb);

add(t, BorderLayout.NORTH);
add(p);
add(p1);
add(p2);
add(p3);
       
setVisible(true);
    }
   
public void actionPerformed(ActionEvent e) {
for (int i = 0; i < 10; i++) {
if (e.getSource() == nb[i]) {
t.setText(t.getText().concat(String.valueOf(i)));
}
}

if (e.getSource() == pb) {
n1 = Integer.parseInt(t.getText());
op = 1;
t.setText("");
}

if (e.getSource() == sb) {
n1 = Integer.parseInt(t.getText());
op = 2;
t.setText("");
}

if (e.getSource() == mb) {
n1 = Integer.parseInt(t.getText());
op = 3;
t.setText("");
}

if (e.getSource() == db) {
n1 = Integer.parseInt(t.getText());
op = 4;
t.setText("");
}

if (e.getSource() == eb) {
n2 = Integer.parseInt(t.getText());

switch (op) {
case 1:
res = n1 + n2;
break;
case 2:
res = n1 - n2;
break;
case 3:
res = n1 * n2;
break;
case 4:
if (n2 != 0)
res = n1 / n2;
else
t.setText("Cannot divide by zero");
break;
}

t.setText(String.valueOf(res));
n1 = res;
}
if (e.getSource() == cb) {
            t.setText("");
        }
}

public static void main(String[] args) {
new Calc();
}
}
