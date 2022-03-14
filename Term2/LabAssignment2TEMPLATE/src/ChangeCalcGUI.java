import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

public class ChangeCalcGUI {

    private final JFrame frame;
    private final JLabel changeCalculate;
    private final JTextField priceTextField;
    private final JTextField paidTextField;

    // ChangeCalGUI constructor
    ChangeCalcGUI(){
        //Create the Frame
        frame = new JFrame();
        //Set Minimum size of Frame
        frame.setMinimumSize(new Dimension(280, 280));
        //set Default Frame Size
        frame.setSize(280, 400);
        //Set Frame Title
        frame.setTitle("Change Calculate");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setup the Padding to the Panel
        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(20, 40, 20, 40);
        contentPanel.setBorder(padding);

        frame.setContentPane(contentPanel);


        //Declare JLabel and JTextField GUI Components
        JLabel priceLabel = new JLabel("Price");
        priceTextField = new JTextField(10);


        JLabel paidLabel = new JLabel("Paid");
        paidTextField = new JTextField(10);

        JButton button = new JButton("Calculate");

        changeCalculate = new JLabel("");

        //Add action listener on the button+
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCalculate.setText(calculateChange());
            }
        });

        //Add the Components on Frame
        frame.add(priceLabel);
        frame.add(priceTextField);
        frame.add(paidLabel);
        frame.add(paidTextField);
        frame.add(button);
        frame.add(changeCalculate);

        frame.setVisible(true);

    }

    String calculateChange(){
        String change = "The change is  :\n";
        try{
            //Validate the textFiled
            if((priceTextField.getText().isBlank() || priceTextField.getText().isEmpty()) && (paidTextField.getText().isBlank() || paidTextField.getText().isEmpty())){
                JOptionPane.showMessageDialog(frame,"Price field and Paid field is Empty");
                return "";
            }else if(priceTextField.getText().isBlank() || priceTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"Price field is empty");
                return "";
            }else if(paidTextField.getText().isBlank() || paidTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"Paid field is empty");
                return "";
            }

            double price = Double.parseDouble(priceTextField.getText());
            double paid = Double.parseDouble(paidTextField.getText());

            // Check if if is paid enough or not
            if(price > paid){
               return  "You haven't paid enough!";
            }

            //Check if the money is enough
            if(price == paid){
                return  "There is no need to return change";
            }

            //Call to calculate change from the MainChange Class
            TreeMap<NotesAndCoins, Integer> changeComposition = MainChange.calcChange(price, paid);

            for(NotesAndCoins n: changeComposition.keySet()){
                if(changeComposition.get(n) != 0){
                    change += n.getName() + ":" + changeComposition.get(n)+" , ";
                }
            }
            return change;
        }catch (NumberFormatException numberFormatException){
            //Handle the wrong input exception
            priceTextField.setText("");
            paidTextField.setText("");
            JOptionPane.showMessageDialog(frame,"Input Format is wrong");
        }
        return null;
    }
    public static void main(String[] args) {
        new ChangeCalcGUI();
    }
}
