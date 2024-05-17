import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Backend extends Frame implements ActionListener{
	//Creating instance
	String operator = "";
	String temp = "";
	String modifiedString;
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Label label1 = new Label("Enter Value 1");
	Label label2 = new Label("Enter Value 2");
	Label label3 = new Label("Result");
	Label label4 = new Label(operator);
	TextField textField1 = new TextField("");
	TextField textField2 = new TextField("");
	TextField textField3 = new TextField("");
	Button plusBtn, minusBtn, mulBtn, divBtn, modBtn;
	Button[] numBtn = new Button[10];
	Button[] funcBtn = new Button[7];
	Button clearBtn, equBtn;
	Button darkMode, exitBtn;
	//Computation Variables
	double num1 = 0, num2 = 0, result = 0;
	//Boolean
	boolean emptyField1 = true;
	boolean emptyField2 = true;
	boolean emptyBoth = true;
	boolean done = false;
	boolean toggleDarkMode = false;
	boolean maxLengthReached = false;
	//Limit
	int maxLength = 11;
	
	
	Backend(){
		
		//Operator and Functions
		plusBtn = new Button("+");
		minusBtn = new Button("-");
		mulBtn = new Button("×");
		divBtn = new Button("÷");
		equBtn = new Button("=");
		clearBtn = new Button("AC");
		modBtn = new Button("%");
		exitBtn = new Button("X");
		
		//add buttons to array
		funcBtn[0] = plusBtn;
		funcBtn[1] = minusBtn;
		funcBtn[2] = mulBtn;
		funcBtn[3] = divBtn;
		funcBtn[4] = equBtn;
		funcBtn[5] = clearBtn;
		funcBtn[6] = modBtn;
		
		for(int i = 0; i < 7; i++) {
			funcBtn[i].addActionListener(this);
			funcBtn[i].setFocusable(false);
			funcBtn[i].setFont(new Font("Serif", Font.PLAIN, 18));
			funcBtn[i].setBackground(new Color(160, 222, 255));
		}

		funcBtn[4].setBackground(new Color(90, 178, 255));
		funcBtn[5].setBackground(new Color(202, 244, 255));
		funcBtn[6].setBackground(new Color(160, 222, 255));
		exitBtn.setBackground(new Color(0xF4796B));
		
		//Button 
		for(int i = 0; i < 10; i++) {
			numBtn[i] = new Button(String.valueOf(i));
			numBtn[i].addActionListener(this);
			numBtn[i].setFocusable(false);
			numBtn[i].setFont(new Font("Serif", Font.PLAIN, 18));
			numBtn[i].setBackground(new Color(255, 249, 208));
		}

		//TextField
		textField1.setBackground(new Color(0xF0F6F6));
		textField2.setBackground(new Color(0xF0F6F6));
		textField3.setBackground(new Color(0xF0F6F6));
		textField1.setForeground(new Color(0x171614));
		textField2.setForeground(new Color(0x171614));
		textField3.setForeground(new Color(0x171614));
		
		textField1.setFont(new Font("Serif", Font.PLAIN, 36));
		textField2.setFont(new Font("Serif", Font.PLAIN, 36));
		textField3.setFont(new Font("Serif", Font.PLAIN, 36));
		textField1.setEditable(false);
		textField2.setEditable(false);
		textField3.setEditable(false);
		
		//Label
		label1.setForeground(new Color(0x171614));
		label1.setBackground(new Color(253, 228, 158));
		label1.setFont(new Font("Serif", Font.PLAIN, 36));
		label2.setForeground(new Color(0x171614));
		label2.setBackground(new Color(253, 228, 158));
		label2.setFont(new Font("Serif", Font.PLAIN, 36));
		label3.setForeground(new Color(0x171614));
		label3.setBackground(new Color(253, 228, 158));
		label3.setFont(new Font("Serif", Font.PLAIN, 36));
		label4.setForeground(new Color(0x171614));
		label4.setBackground(new Color(253, 228, 158));
		label4.setFont(new Font("Serif", Font.PLAIN, 32));
		

		label1.setBounds(25, 80, 200, 30);
		label2.setBounds(280, 80, 200, 30);
		label3.setBounds(200, 250, 100, 30);
		label4.setBounds(238, 130, 30, 50);
		textField1.setBounds(15, 130, 210, 50);
		textField2.setBounds(278, 130, 210,50);
		textField3.setBounds(150, 190, 210, 50);

		darkMode = new Button("■");
		darkMode.addActionListener(this);
		darkMode.setFocusable(false);
		darkMode.setFont(new Font("Serif", Font.PLAIN, 10));
		darkMode.setBackground(new Color(160, 222, 255));

		
		exitBtn.addActionListener(this);
		
		panel1.setBackground(new Color(253, 228, 158));
		panel1.setBounds(0, 0, 500, 300); 
		
		numBtn[7].setBounds(0, 300, 125, 50);
		numBtn[8].setBounds(125, 300, 125, 50);
		numBtn[9].setBounds(250, 300, 125, 50);
		divBtn.setBounds(375, 300, 125, 50);

		numBtn[4].setBounds(0, 350, 125, 50);
		numBtn[5].setBounds(125, 350, 125, 50);
		numBtn[6].setBounds(250, 350, 125, 50);
		mulBtn.setBounds(375, 350, 125, 50);

		numBtn[1].setBounds(0, 400, 125, 50);
		numBtn[2].setBounds(125, 400, 125, 50);
		numBtn[3].setBounds(250, 400, 125, 50);
		minusBtn.setBounds(375, 400, 125, 50);

		clearBtn.setBounds(0, 450, 125, 100);
		numBtn[0].setBounds(125, 450, 125, 100);
		equBtn.setBounds(250, 450, 125, 100);
		plusBtn.setBounds(375, 450, 125, 50);
		modBtn.setBounds(375, 500, 125, 50);

		darkMode.setBounds(470, 32, 30, 30);
		exitBtn.setBounds(10, 32, 30, 30);

		//Frame
		add(label1);add(label2);add(label4);add(textField1);add(textField2);add(label3);add(textField3);add(numBtn[7]);add(numBtn[8]);add(numBtn[9]);add(divBtn);add(modBtn);add(numBtn[4]);add(numBtn[5]);add(numBtn[6]);add(mulBtn);add(numBtn[1]);add(numBtn[2]);add(numBtn[3]);add(minusBtn);add(clearBtn);add(numBtn[0]);add(equBtn);add(plusBtn);add(darkMode);add(exitBtn);add(panel1);

		
		setResizable(false);
		setSize(510, 550);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(0xF0F6F6));
		setTitle("Calculator");
		setLocationRelativeTo(null);
	
	}
	//Action Listener
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i < 10; i++) {
			if(!done) { //First solve
				if(emptyField1 && e.getSource() == numBtn[i]) { //If the first number is empty
						textField1.setText(limitNum(textField1.getText().concat(String.valueOf(i))));
				}
				else if (e.getSource() == numBtn[i]){ //If the first number is occupied, move to next field
						textField2.setText(limitNum(textField2.getText().concat(String.valueOf(i))));
				}
				
			}
			else { //IF DONE WITH THE FIRST EQUATION
				if(emptyField1 && e.getSource() == numBtn[i]) {
						textField1.setText("");
						textField2.setText("");
						done = false;
						num2 = 0;
						textField1.setText(limitNum(textField1.getText().concat(String.valueOf(i))));
				}
				else if(e.getSource() == numBtn[i]){
					textField2.setText(limitNum(textField2.getText().concat(String.valueOf(i))));
				}
			}
		}
		
		if(!toggleDarkMode && e.getSource() == darkMode) toggleDarkMethod();
		else if(e.getSource() == darkMode) toggleLightMethod();
		
		if(e.getSource() == exitBtn) {
			System.exit(0);
		}
		//PLUS
		if(e.getSource() == plusBtn) {
			operator = "+";
			checkField(num1);
			label4.setText(operator);
			if(done) num1 = changeNum(num1, num2, result);
		}
		//MINUS
		if(e.getSource() == minusBtn) {
			operator = "-";
			checkField(num1);
			label4.setText(operator);
			if(done) num1 = changeNum(num1, num2, result);
		}
		//MULTIPLY
		if(e.getSource() == mulBtn) {
			operator = "×";
			checkField(num1);
			label4.setText(operator);
			if(done) num1 = changeNum(num1, num2, result);
		}
		//DIVIDE
		if(e.getSource() == divBtn) {
			operator = "÷";
			checkField(num1);
			label4.setText(operator);
			if(done) num1 = changeNum(num1, num2, result);
		}
		if(e.getSource() == modBtn) {
			operator = "%";
			checkField(num1);
			label4.setText(operator);
			if(done) num1 = changeNum(num1, num2, result);
		}
		
		//CLEAR
		if(e.getSource() == clearBtn) {
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			num1 = 0;
			num2 = 0;
			result = 0;
			emptyField1 = true;
			emptyField2 = true;
			emptyBoth = true;
			done = false;
			operator = "";
			label4.setText(operator);
		}
		//EQUAL
		if(e.getSource() == equBtn) {
			checkField(num2);
			
			switch(operator) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "×":
				result = num1 * num2;
				break;
			case "÷":
				result = num1 / num2;
				break;
			case "%":
				result = num1 % num2;
				break;
			default:
				break;
			}
			//RESULTS
			if (emptyBoth) {
				textField3.setText("");
			}
			else if(emptyField2){
				textField3.setText(limitNum(String.valueOf(num1)));
				emptyField1 = true;
				textField1.setText("");
				done = false;
				operator = "";
				label4.setText(operator);
			}
			else if (!emptyBoth && !emptyField1&& !emptyField2) {
				emptyField1 = true;
				emptyField2 = true;
				done = true;
				textField3.setText(limitNum(String.valueOf(result)));
				num1 = 0;
				num2 = 0;
			}
		}
	}


	
	public double checkField(double num) {
		if(!textField1.getText().isEmpty()) { //if the text field 1 is not empty
			num1 = Double.parseDouble(textField1.getText()); // Assign the value to num1
			emptyField1 = false;
			emptyBoth = false;
		}
		else { //if the text field 1 is empty
			emptyField1 = true;
			emptyBoth = true;
			operator = "";
			JOptionPane.showMessageDialog(null, "Complete the equation first.", 
                    "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		if(!textField2.getText().isEmpty()) { // If text field 2 is not empty
			num2 = Double.parseDouble(textField2.getText()); //Assign the value to num2
			emptyField2 = false;
		}
		return num;
	}

	private double changeNum(double num1,double num2, double result2) { //Move the result to textField 1
		num1 = result;
		num2 = 0;
		textField1.setText(String.valueOf(result));
		textField2.setText("");
		return num1;
	}
	
	private String limitNum(String number) {
	
		int length = number.length();
		String lastThreeCharacters = "";
		
		if (length >= 3) lastThreeCharacters = number.substring(length - 3); //get the last three characters
	
		if(number == "Infinity") return number; //If the result is infinity
		
		
		if(length >= maxLength && number.contains("E")) { //If the maxLength was reached and number contains an E 
			number = number.substring(0, 1) + number.substring(1 + 1);
			number = number.substring(0, maxLength - 3) + lastThreeCharacters;
			return number;
		}
		else if(length > maxLength && Double.parseDouble(number) > 999999999){
			return number.substring(0, maxLength);
		}
		if (length >= maxLength) number = number.substring(0, maxLength - 3) + lastThreeCharacters;
		
		return number;
	}
	
	private void toggleDarkMethod() {
		panel1.setBackground(new Color(7, 15, 43));setForeground(new Color(255, 255, 255));
		label1.setBackground(new Color(7, 15, 43));
		label1.setForeground(new Color(255, 255, 255));
		label2.setBackground(new Color(7, 15, 43));
		label2.setForeground(new Color(255, 255, 255));
		label3.setBackground(new Color(7, 15, 43));
		label3.setForeground(new Color(255, 255, 255));
		label4.setBackground(new Color(7, 15, 43));
		label4.setForeground(new Color(255, 255, 255));
		
		darkMode.setBackground(new Color(174, 236, 239));
		
		for (int i = 0; i < 10; i++) {
			numBtn[i].setBackground(new Color(146, 144, 195));
		}
		for(int i = 0; i < 6; i++) {
			funcBtn[i].setBackground(new Color(27, 26, 85));
			funcBtn[i].setForeground(new Color(255, 255, 255));
		}
		funcBtn[4].setBackground(new Color(83, 92, 145));
		funcBtn[5].setBackground(new Color(83, 92, 145));
		toggleDarkMode = !toggleDarkMode;
	}
	private void toggleLightMethod() {
		textField1.setBackground(new Color(0xF0F6F6));
		textField2.setBackground(new Color(0xF0F6F6));
		textField3.setBackground(new Color(0xF0F6F6));
		textField1.setForeground(new Color(0x171614));
		textField2.setForeground(new Color(0x171614));
		textField3.setForeground(new Color(0x171614));
		
		label1.setForeground(new Color(0x171614));
		label1.setBackground(new Color(253, 228, 158));
		label2.setForeground(new Color(0x171614));
		label2.setBackground(new Color(253, 228, 158));
		label3.setForeground(new Color(0x171614));
		label3.setBackground(new Color(253, 228, 158));
		label4.setForeground(new Color(0x171614));
		label4.setBackground(new Color(253, 228, 158));
		panel1.setBackground(new Color(253, 228, 158));
		
		darkMode.setBackground(new Color(160, 222, 255));
		
		toggleDarkMode = !toggleDarkMode;
		
		for(int i = 0; i < 10; i++) {
			numBtn[i].setBackground(new Color(255, 249, 208));
		}
		for(int i = 0; i < 6; i++) {
			funcBtn[i].setBackground(new Color(160, 222, 255));
			funcBtn[i].setForeground(new Color(0x171614));
		}
		funcBtn[4].setBackground(new Color(90, 178, 255));
		funcBtn[5].setBackground(new Color(202, 244, 255));
		
	}
	
}

