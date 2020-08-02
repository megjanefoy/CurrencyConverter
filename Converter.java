import javax.swing.JOptionPane;
/** 
 * Title: Assignment 7 
 * Semester: COP3337 – Fall 2019
 * @author Megan Jane Thompson
 *
 * This program calculates the conversion between
 * U.S. dollars (USD), euros (EUR), and British 
 * pounds (GBP).
 */
public class Converter {
	
	/**
	   * This method takes in the amount to be converted 
	   * as a double, the convert from type as a String
	   * and the convert to type as a String. It checks 
	   * which conversion is being made and applies the 
	   * correct equation. 
	   * 
	   * @param userAmount, being a double of the user's input amount to be converted.
	   * @param fromType, being a String for the convert from currency type.
	   * @param toType, being a String for the convert to currency type.
	   * @return calcAmount, being an String for the calculated amount 
	   *                     formulated to two decimal places.
	  */  
	public String conversionCalc(double userAmount, String fromType, String toType){
		double amount = 0.0;
		String calcAmount = "";
		
		if (fromType.equals("GBP")) {                 //checks if convert from type is British Pound
			if (toType.equals("GBP")) {               //displays error message if convert to type is also British Pound
				JOptionPane.showMessageDialog(null, "Please Select Two Different Converter Types.");
			}
			else if(toType.equals("EUR")) {           //calculates if convert to type is Euro
				amount = userAmount * 1.13;
			}
			else if(toType.equals("USD")) {           //calculates if convert to type if U.S. Dollar
				amount = userAmount * 1.64;
			}
		}
		else if(fromType.equals("EUR")) {             //checks if convert from type is Euro
			if (toType.equals("EUR")) {               //displays error message if convert to type is also Euro
				JOptionPane.showMessageDialog(null, "Please Select Two Different Converter Types.");
			}
			else if(toType.equals("GBP")) {           //calculates if convert to type is British Pound
				amount = userAmount / 1.13;
			}
			else if(toType.equals("USD")) {           //calculates if convert to type is U.S. Dollar
				amount = userAmount * 1.42;
			}
		}
		else if(fromType.equals("USD")) {             //checks if convert from type is U.S. Dollar
			if (toType.equals("USD")) {               //displays error message if convert to type is also U.S. Dollar
				JOptionPane.showMessageDialog(null, "Please Select Two Different Converter Types.");
			}
			else if(toType.equals("GBP")) {           //calculates if convert to type is British Pound
				amount = userAmount / 1.64;
			}
			else if(toType.equals("EUR")) {           //calculates if convert to type is Euro
				amount = userAmount / 1.42;
			}
		}
		
		calcAmount = String.format("%.2f", amount);   //formats double calculation to String with two decimals
		return calcAmount;                            //returns String of calculated conversion amount
	}

}
