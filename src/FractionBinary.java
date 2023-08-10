import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FractionBinary extends JFrame {
    public FractionBinary(){
        super("Assignment COA Q.2B");
        ArrayList<Float> data = generateNumbers();
        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(data.size(),3,3,3));

        generateFields(data, panel);

        add(panel);
        setVisible(true);
    }

    private ArrayList<Float> generateNumbers(){
        ArrayList<Float> generatedNumbers = new ArrayList<Float>(30);
        for(int i = 0; i < 30; i++){
            double randomNumber = (int) ((Math.random() * 900) + 1000) / 100.0;
            generatedNumbers.add((float) randomNumber);
        }

        return generatedNumbers;
    }

    private void generateFields(ArrayList<Float> data, JPanel panel){
        Converter converter = new Converter();
        for (Float datum : data) {
            String[] binary = converter.toBinary(datum);

            JPanel fPanel = new JPanel();
            fPanel.setLayout(new GridLayout(1,3,3,3));

            JTextField decimalField = new JTextField("Decimal Number: " + datum);
            JTextField binaryField = new JTextField("Binary Number: " + binary[0]);
            JTextField remarkField = new JTextField("Remarks: " + binary[1]);

            fPanel.add(decimalField);
            fPanel.add(binaryField);
            fPanel.add(remarkField);

            panel.add(fPanel);
        }
    }
}
