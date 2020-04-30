package calc;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CalculatorController implements Initializable {
	Calculations calculations = new Calculations();
	float data = 0f;
	float memoryData = 0f;
	int operation = -1;
	boolean afterEquals = false;
	/*
	 * 1 - plus 2 - minus 3 - mul 4 - div 5 - factorial 6 - square 7 - square root
	 */

	@FXML
	private Button minusButton;

	@FXML
	private Button nineButton;

	@FXML
	private Button sixButton;

	@FXML
	private Button mulButton;

	@FXML
	private Button oneButton;

	@FXML
	private Button clrButton;

	@FXML
	private Button allClrButton;

	@FXML
	private Button sqrtButton;

	@FXML
	private Button squareButton;

	@FXML
	private Button factorialButton;

	@FXML
	private Button fourButton;

	@FXML
	private Label labelButton;

	@FXML
	private Button twoButton;

	@FXML
	private Button threeButton;

	@FXML
	private Button plusButton;

	@FXML
	private Button eightButton;

	@FXML
	private Button zeroButton;

	@FXML
	private Button divButton;

	@FXML
	private Button sevenButton;

	@FXML
	private Button equalsButton;

	@FXML
	private Button fiveButton;

	@FXML
	private TextField display;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Button[] numButtons = { oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
				eightButton, nineButton, zeroButton };
		Arrays.stream(numButtons).forEach(button -> {
			button.setOnAction(event -> {
				if (data == 0f)
					display.setText("");
				if (afterEquals) {
					display.setText("");
					afterEquals = false;
					data = 0;
				}
				display.setText(display.getText() + ((Button) event.getSource()).getText());
				data = Float.parseFloat(display.getText());
			});
		});
		Button[] opTwoButtons = { plusButton, minusButton, mulButton, divButton };
		Button[] opOneButtons = { factorialButton, squareButton, sqrtButton };
		for (Button btn : opTwoButtons) {
			btn.setOnAction(event -> {
				if (memoryData != 0) {
					memoryData = calculations.calculate(memoryData, operation, data);
					afterEquals = true;
				} else {
					memoryData = data;
					data = 0;
					
				}
				operation = calculations.getOperation(btn.getText());
				display.setText("");
			});
		}
		for (Button btn : opOneButtons) {
			btn.setOnAction(event -> {
				if (memoryData != 0) {
					memoryData = calculations.calculate(memoryData, operation, data);
				} else {
					memoryData = data;
					data = 0;
				}
				operation = calculations.getOperation(btn.getText());

				data = calculations.calculate(memoryData, operation);
				memoryData = 0;
				display.setText(String.valueOf(data));
				afterEquals = true;
			});
		}

		equalsButton.setOnAction(event -> {

			data = calculations.calculate(memoryData, operation, data);
			memoryData = 0;
			display.setText(String.valueOf(data));
			afterEquals = true;
		});
		clrButton.setOnAction(event -> {
			display.setText("");
			data = 0;
		});
		allClrButton.setOnAction(event -> {
			display.setText("");
			data = 0;
			memoryData = 0;
		});
	}

}