package pl.sowinski.frontendmethods;

import java.io.File;
import java.util.List;
import javafx.scene.control.RadioButton;
import pl.sowinski.databaseoperations.DatabaseOperation;
import pl.sowinski.excelsettings.ExcelSettings;
import pl.sowinski.model.Customer;

public class ApplicationMet {
	Customer customer = new Customer();

	File file;

	public void menuOptions(RadioButton checkbox1, RadioButton checkbox2, RadioButton checkbox3) {

		if (checkbox1.isSelected()) {
			List<String> createMail = DatabaseOperation.createMailQuery(customer.getListOfEmails(),
					DatabaseOperation.mailQuery());

			ExcelSettings.generateExcel(createMail, "test", 12, "Emails", "Emails");

		}

		if (checkbox2.isSelected()) {
			List<String> generatePhone = DatabaseOperation.createPhoneQuery(customer.getListOfPhones(),
					DatabaseOperation.phoneQuery());
			ExcelSettings.generateExcel(generatePhone, "test", 12, "Phons", "Phones");

		}

	}

}
