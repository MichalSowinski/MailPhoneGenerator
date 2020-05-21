package pl.sowinski.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private List<String> listOfEmails = new ArrayList<String>();
	private List<String> listOfPhones = new ArrayList<String>();

	public List<String> getListOfEmails() {
		return listOfEmails;
	}

	public void setListOfEmails(List<String> listOfEmails) {
		this.listOfEmails = listOfEmails;
	}

	public List<String> getListOfPhones() {
		return listOfPhones;
	}

	public void setListOfPhones(List<String> listOfPhones) {
		this.listOfPhones = listOfPhones;
	}

}
