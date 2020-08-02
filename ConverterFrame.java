import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Color;

/** 
 * Title: Assignment 7 
 * Semester: COP3337 – Fall 2019
 * @author Megan Jane Thompson
 *
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 * 
 * This program creates the graphical interface 
 * and extends Converter, which calculates the conversion 
 * between U.S. dollars (USD), euros (EUR), and British 
 * pounds (GBP).
 */

public class ConverterFrame extends Converter{

	private JFrame convertMoneyFrame;
	private JTextField enterAmountField;
	private JTextField convertedAmountField;

	/**
	 * This method launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterFrame window = new ConverterFrame();
					window.convertMoneyFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * This method creates the application.
	 */
	public ConverterFrame() {
		initialize();
	}

	/**
	 * This method initializes the contents of the frame.
	 */
	private void initialize() {
		//creates the JFrame for "Money Conversion Calculator"
		convertMoneyFrame = new JFrame();      
		convertMoneyFrame.setTitle("Money Conversion Calculator");
		convertMoneyFrame.setBounds(100, 100, 450, 300);
		convertMoneyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		convertMoneyFrame.getContentPane().setLayout(null);
		
		//creates the JLabel "Enter Amount:" for the user's text input
		JLabel enterAmountLabel = new JLabel("Enter Amount:                  $");
		enterAmountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		enterAmountLabel.setBounds(10, 45, 140, 14);
		convertMoneyFrame.getContentPane().add(enterAmountLabel);
		
		//creates the JLabel "Convert From:" for user's combo selection
		JLabel convertFromLabel = new JLabel("Convert From:");
		convertFromLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		convertFromLabel.setBounds(10, 93, 83, 15);
		convertMoneyFrame.getContentPane().add(convertFromLabel);
		
		//creates the JLabel "Convert To:" for user's combo selection
		JLabel convertToLabel = new JLabel("Convert To:");
		convertToLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		convertToLabel.setBounds(149, 93, 66, 15);
		convertMoneyFrame.getContentPane().add(convertToLabel);
		
		//creates the JLabel "Converted Amount:" for text display of converted amount
		JLabel convertedAmountLabel = new JLabel("Converted Amount:         $");
		convertedAmountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		convertedAmountLabel.setBounds(10, 188, 140, 24);
		convertMoneyFrame.getContentPane().add(convertedAmountLabel);
		
		//creates the JTextField for "Enter Amount" label for user to input original amount
		enterAmountField = new JTextField();
		enterAmountField.setFont(new Font("Arial", Font.PLAIN, 12));
		enterAmountField.setBounds(149, 36, 119, 34);
		convertMoneyFrame.getContentPane().add(enterAmountField);
		enterAmountField.setColumns(10);
		
		//creates the JComboBox for "Convert From" label for user to select option
		JComboBox convertFromCombo = new JComboBox();
		convertFromCombo.setBackground(Color.WHITE);
		convertFromCombo.setFont(new Font("Arial", Font.PLAIN, 12));
		convertFromCombo.setBounds(10, 119, 83, 20);
		convertMoneyFrame.getContentPane().add(convertFromCombo);
		convertFromCombo.addItem("GBP");      //adds British Pound to convertFromCombo
		convertFromCombo.addItem("EUR");      //adds Euro to convertFromCombo
		convertFromCombo.addItem("USD");      //adds U.S. Dollar to convertFromCombo
		convertFromCombo.setSelectedItem(null);
		
		//creates the JComboBox for "Convert To" label for user to select option
		JComboBox convertToCombo = new JComboBox();
		convertToCombo.setBackground(Color.WHITE);
		convertToCombo.setFont(new Font("Arial", Font.PLAIN, 12));
		convertToCombo.setBounds(149, 118, 83, 20);
		convertMoneyFrame.getContentPane().add(convertToCombo);
		convertToCombo.addItem("GBP");        //adds British Pound to convertToCombo
		convertToCombo.addItem("EUR");        //adds Euro to convertToCombo
		convertToCombo.addItem("USD");        //adds U.S. Dollar to convertToCombo
		convertToCombo.setSelectedItem(null);
		
		//creates the JTextField for "Converted Amount" label to display calculated amount
		convertedAmountField = new JTextField();
		convertedAmountField.setBackground(SystemColor.text);
		convertedAmountField.setEditable(false);   //calculated amount display is not editable
		convertedAmountField.setFont(new Font("Arial", Font.PLAIN, 12));
		convertedAmountField.setBounds(149, 184, 119, 34);
		convertMoneyFrame.getContentPane().add(convertedAmountField);
		convertedAmountField.setColumns(10);
		
		//creates the JButton for "Convert" and initiates conversion calculation
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {    
			public void actionPerformed(ActionEvent event) {
				double userAmount;
				String convAmount;
				String fromType;
				String toType;
				
				try {           //obtains user's input and selections then calls conversionCal()
					userAmount = Double.parseDouble(enterAmountField.getText());
					fromType = (String) convertFromCombo.getSelectedItem();
					toType = (String) convertToCombo.getSelectedItem();
					convAmount = conversionCalc(userAmount, fromType, toType);
					convertedAmountField.setText(convAmount);   //displays calculated amount	
				}catch (NumberFormatException except) {         //catch if user's text input is invalid
					JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
				}catch (NullPointerException except) {          //catch if user's selection is null
					JOptionPane.showMessageDialog(null, "Please Select Converter Types.");
				}
			}
		});
		convertButton.setFont(new Font("Arial", Font.BOLD, 13));
		convertButton.setBounds(289, 106, 119, 45);
		convertMoneyFrame.getContentPane().add(convertButton);
	}
}
