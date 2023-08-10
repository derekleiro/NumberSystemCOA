import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;

public class NumberSystem extends JFrame {
    ArrayList<Integer> data = new ArrayList<Integer>(22);

    public NumberSystem(){
        super("Assignment 2 COA");

        for(int i = 0; i < 18; i++){
            data.add(i);
        }
        data.add(31);
        data.add(100);
        data.add(255);
        data.add(256);

        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(data.size(),3,3,3));

        generateFields(data, panel);

        add(panel);
        setVisible(true);
    }

    private void generateFields(ArrayList<Integer> data, JPanel panel){
        Converter converter = new Converter();
        for (Integer datum : data) {
            int decimal = datum;
            String binary = converter.toBinary(decimal);
            String hex = converter.toHex(decimal);

            JPanel newPanel = new JPanel();
            newPanel.setLayout(new GridLayout(1,3,3,3));

            JTextField newDecimalField = new JTextField("Decimal: " + decimal);
            JTextField newBinaryField = new JTextField("Binary: " + binary);
            JTextField newHexField = new JTextField("Hex: " + hex);

            newPanel.add(newDecimalField);
            newPanel.add(newBinaryField);
            newPanel.add(newHexField);

            panel.add(newPanel);
        }
    }
}
