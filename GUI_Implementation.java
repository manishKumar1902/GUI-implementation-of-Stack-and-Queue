import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class LinkedListGUI extends JFrame implements ActionListener {
    private static final int NUM_VALUES = 10;
    private LinkedList <Integer> list;
    private JRadioButton stackRadio, queueRadio;
    private JButton pushButton, popButton, addButton, deleteButton;
    private JTextArea textArea;
    
    public LinkedListGUI() {
        list = new LinkedList<>();
        for (int i = 0; i < NUM_VALUES; i++) {
            list.add((int) (Math.random() * 100));
        }
        
        setTitle("LinkedList GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());
        
        JPanel radioPanel = new JPanel(new FlowLayout());
        stackRadio = new JRadioButton("Stack");
        queueRadio = new JRadioButton("Queue");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(stackRadio);
        radioGroup.add(queueRadio);
        radioPanel.add(stackRadio);
        radioPanel.add(queueRadio);
        add(radioPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        pushButton = new JButton("Push");
        pushButton.addActionListener(this);
        popButton = new JButton("Pop");
        popButton.addActionListener(this);
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        buttonPanel.add(pushButton);
        buttonPanel.add(popButton);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        updateTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
    
    private void updateTextArea() {
        textArea.setText(list.toString());
    }
    
    public void actionPerformed(ActionEvent e) {
        if (stackRadio.isSelected()) {
            if (e.getSource() == pushButton) {
                int value = (int) (Math.random() * 100);
                list.addFirst(value);
                updateTextArea();
            } else if (e.getSource() == popButton) {
                if (!list.isEmpty()) {
                    list.removeFirst();
                    updateTextArea();
                }
            }
        } else if (queueRadio.isSelected()) {
            if (e.getSource() == addButton) {
                int value = (int) (Math.random() * 100);
                list.addLast(value);
                updateTextArea();
            } else if (e.getSource() == deleteButton) {
                if (!list.isEmpty()) {
                    list.removeFirst();
                    updateTextArea();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        LinkedListGUI gui = new LinkedListGUI();
        gui.setVisible(true);
    }
}
