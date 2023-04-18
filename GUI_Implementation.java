import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class miniproject {
  miniproject() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
      list.add((int) (Math.random() * 100));
    }
    JFrame f = new JFrame("Project");
    JTextField t1 = new JTextField();
    JRadioButton r1 = new JRadioButton("Stack");
    JRadioButton r2 = new JRadioButton("Queue");
    JButton b1 = new JButton("Push");
    JButton b2 = new JButton("Pop");
    JButton b3 = new JButton("Add");
    JButton b4 = new JButton("Delete");
    ButtonGroup bg = new ButtonGroup();

    t1.setBounds(50, 30, 300, 30);
    r1.setBounds(50, 75, 80, 30);
    r2.setBounds(50, 100, 80, 30);
    b1.setBounds(50, 150, 80, 30);
    b2.setBounds(50, 200, 80, 30);
    b3.setBounds(200, 150, 80, 30);
    b4.setBounds(200, 200, 80, 30);
    t1.setText(list.toString());
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(r1);
    buttonGroup.add(r2);
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);

    // Add action listeners to the radio buttons
    r1.addActionListener(
      new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          b1.setEnabled(true);
          b2.setEnabled(true);
          b3.setEnabled(false);
          b4.setEnabled(false);
        }
      }
    );
    r2.addActionListener(
      new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          b1.setEnabled(false);
          b2.setEnabled(false);
          b3.setEnabled(true);
          b4.setEnabled(true);
        }
      }
    );

    b1.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          Stack<Integer> stack = new Stack<>();
          stack.addAll(list);
          list.clear();
          list.add((int) (Math.random() * 100));
          list.addAll(stack);
          t1.setText(list.toString());
        }
      }
    );
    b2.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          if (list.isEmpty()) {
            return;
          }
          list.removeFirst();
          t1.setText(list.toString());
        }
      }
    );

    b3.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          list.add((int) (Math.random() * 100));
          t1.setText(list.toString());
        }
      }
    );

    b4.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          if (list.isEmpty()) {
            return;
          }
          list.removeFirst();
          t1.setText(list.toString());
        }
      }
    );

    f.add(b1);
    f.add(b2);
    f.add(b3);
    f.add(b4);
    f.add(r1);
    f.add(r2);
    f.add(t1);
    f.setSize(400, 400);
    f.setLayout(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    miniproject obj = new miniproject();
  }
}
