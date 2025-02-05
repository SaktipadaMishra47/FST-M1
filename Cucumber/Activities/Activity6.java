package stepDefinitions;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Activity6 {

    private String username;
    private String password;
    private String expectedMessage;
    private String actualMessage;

    @Given("the user is on the login page")
    public void givenUserIsOnLoginPage() {
        // Simulate opening the login page
        System.out.println("Opening login page...");
    }

    @When("the user enters the following credentials")
    public void whenUserEntersCredentials(DataTable table) {
        // Convert the DataTable into a list of rows (List<List<String>>)
        List<List<String>> rows = table.asLists(String.class);
        
        // Iterate through the rows and get credentials and message
        for (int i = 1; i < rows.size(); i++) {  // Start from 1 to skip header
            username = rows.get(i).get(0); // First column: username
            password = rows.get(i).get(1); // Second column: password
            expectedMessage = rows.get(i).get(2); // Third column: message

            // Simulate entering the username and password
            System.out.println("Entering username: " + username + " and password: " + password);
        }
    }

    @When("clicks the submit button")
    public void whenUserClicksSubmitButton() {
        // Simulate clicking the submit button
        System.out.println("Clicking the submit button...");
    }

    @Then("get the confirmation text and verify the message as")
    public void thenVerifyConfirmationMessage(DataTable table) {
        // Convert the DataTable into a list of rows (List<List<String>>)
        List<List<String>> rows = table.asLists(String.class);
        
        for (int i = 1; i < rows.size(); i++) {  // Start from 1 to skip header
            // The expected message from the feature file
            String expectedMessageFromTable = rows.get(i).get(0);

            // Simulate getting the actual confirmation message
            this.actualMessage = "Welcome Back, " + username;

            // Verify the message
            Assertions.assertEquals(expectedMessage, actualMessage);
        }
    }
}
