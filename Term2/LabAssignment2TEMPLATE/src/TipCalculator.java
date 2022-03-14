import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TipCalculator extends JFrame implements ActionListener {

    //Declare JLabel and JTextField GUI Components
    JLabel priceLabel, tipLabel, peopleLabel, tipCalculate;
    JTextField priceTextField , tipTextField, peopleTextField;

    //Constructor
    TipCalculator(){
        //Set minimum Frame size
        this.setMinimumSize(new Dimension(280, 280));
        //set Default Frame Size
        this.setSize(280, 400);
        //Set Frame Title
        this.setTitle("Meal splitter");
        //Set the frame Layout
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add Jpanel to the frame
        JPanel contentPanel = new JPanel();
        //Set Padding
        Border padding = BorderFactory.createEmptyBorder(20, 40, 20, 40);
        //add Padding
        contentPanel.setBorder(padding);
        this.setContentPane(contentPanel);

        //Price Label and TextField
        priceLabel = new JLabel("Price");
        priceTextField = new JTextField(10);

        //Tip Label and TextField
        tipLabel  = new JLabel("tip (%)");
        tipTextField = new JTextField(10);

        //People Label and TextField
        peopleLabel = new JLabel("people");
        peopleTextField = new JTextField(10);

        //Button for calculate share
        JButton button = new JButton("Calculate");

        //Add components to the frame
        this.add(priceLabel);
        this.add(priceTextField);
        this.add(tipLabel);
        this.add(tipTextField);
        this.add(peopleLabel);
        this.add(peopleTextField);
        this.add(button);

        //add the Action listener on button
        button.addActionListener(this);

        //set label tip display shares
        tipCalculate = new JLabel("");
        this.add(tipCalculate);

        this.setVisible(true);
    }

    // Action Listener Method
    @Override
    public void actionPerformed(ActionEvent e) {
        double price = 0.0,  tip = 0.0;
        int people = 0;
        try{
            //Check textfield
            if(priceTextField.getText().isEmpty() || priceTextField.getText().isBlank()){
                JOptionPane.showMessageDialog(this,"Price Field are empty");
            }else if(tipTextField.getText().isBlank() || tipTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"Tip Field are empty");
            }else if(peopleTextField.getText().isBlank() || peopleTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"People Field are empty");
            }else {
                //Set up the decimal format
                DecimalFormat df = new DecimalFormat("0.00");
                price = Double.parseDouble(priceTextField.getText());
                tip = Double.parseDouble(tipTextField.getText());
                if(peopleTextField.getText().contains(".")){
                    double peoples = Double.parseDouble(peopleTextField.getText());
                    JOptionPane.showMessageDialog(this,"Peoples Can't be in Double");
                    people  =  (int) peoples;
                    peopleTextField.setText(""+people);
                }
                people = Integer.parseInt(peopleTextField.getText());

                //Calculate the tip and to calculate shares
                double shares = (((tip*price)/100) + price)/people;
                tipCalculate.setText("Each person should pay £"+ df.format(shares));
            }
        }catch (NumberFormatException numberFormatException){
            //Display the wrong input format
            JOptionPane.showMessageDialog(this,"Input Format is wrong");
            priceTextField.setText("");
            tipTextField.setText("");
            peopleTextField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TipCalculator();
            }
        });
    }
}
