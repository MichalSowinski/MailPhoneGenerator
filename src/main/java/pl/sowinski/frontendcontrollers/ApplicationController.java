package pl.sowinski.frontendcontrollers;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import pl.sowinski.frontendmethods.ApplicationMet;

public class ApplicationController {

	@FXML
	private RadioButton phoneButton;

	@FXML
	private RadioButton emailButton;

	@FXML
	private RadioButton phoneAndEmailButton;

	ApplicationMet applicationMet = new ApplicationMet();

	@FXML
	public void generate() {
		applicationMet.menuOptions(emailButton, phoneButton, phoneAndEmailButton);

	}

}
