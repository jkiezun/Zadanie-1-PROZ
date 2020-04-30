package calc;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/*
 * Helper class with all the calculations and utility
 * methods for my calculator.
 * 
 * Operation ids:
 *
 * 1 - plus 
 * 2 - minus 
 * 3 - mul 
 * 4 - div 
 * 5 - factorial 
 * 6 - square 
 * 7 - square root
 */

public class Calculations {
	
	/*
	 * Method return factorial of an integer.
	 * @param1 integer to get factorial of
	 */
	int factorial(int n) {
		if (n <= 1)
			return 1;
		else
			return n * factorial(n - 1);
	}
	/*
	 * method that resolves which arithmetical operation is currently "in the queue"
	 * @param1 operationName string of the operation e.g. "+", "-", "*"
	 */
	public int getOperation(String operationName) {
		int operation = -1;
		switch (operationName) {
		case "+":
			operation = 1;
			break;
		case "-":
			operation = 2;
			break;
		case "*":
			operation = 3;
			break;
		case "/":
			operation = 4;
			break;
		case "!":
			operation = 5;
			break;
		case "^2":
			operation = 6;
			break;
		case "√x":
			operation = 7;
			break;
		}
		return operation;
	}
	/*
	 * method to perform the calculation for single element operations like factorial or square root.
	 * @param1 leftProduct value of the element
	 * @param2 operationType id of the operation (see ids at the top of the file)
	 */
	public float calculate(float leftProduct, int operationType) {
		float result = 0;
		switch (operationType) {
		case 5:
			result = factorial((int) (Math.round(leftProduct)));
			break;
		case 6:
			result = leftProduct * leftProduct;
			break;
		case 7:
			result = (float) Math.sqrt(leftProduct);
			break;
		}
		return result;
	}
	/*
	 * overloaded calculate method to perform the calculation for two elements operations like addition or multiplication.
	 * @param1 leftProduct value of the left side element
	 * @param2 operationType id of the operation (see ids at the top of the file)
	 * @param3 rightProduct value of the right side element
	 */
	public float calculate(float leftProduct, int operationType, float rightProduct) {
		float result = 0;
		switch (operationType) {
		case 1:
			result = leftProduct + rightProduct;
			break;
		case 2:
			result = leftProduct - rightProduct;
			break;
		case 3:
			result = leftProduct * rightProduct;
			break;
		case 4:
			if (rightProduct == 0)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle(AlertType.ERROR.name());
				alert.setContentText("NIE DZIEL PRZEZ 0!!!");
				alert.showAndWait();
				result = leftProduct;
			} else
				result = leftProduct / rightProduct;
			break;
		}

		return result;
	}

}
