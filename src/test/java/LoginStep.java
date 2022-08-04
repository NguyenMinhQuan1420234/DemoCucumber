import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
    @Given("the user is in Login Page")
    public void theUserIsInLoginPage() {
    }

    @When("the user input {string} into Username textbox")
    public void theUserInputIntoUsernameTextbox(String arg0) {
    }

    @And("the user input {string} into Password textbox")
    public void theUserInputIntoPasswordTextbox(String arg0) {
    }

    @And("the user click Login button")
    public void theUserClickLoginButton() {
    }

    @Then("the UserName {string} is show correctly")
    public void theUserNameIsShowCorrectly(String arg0) {
    }

    @And("When the user input {string} into aaa textbox")
    public void whenTheUserInputIntoAaaTextbox(String arg0) {
    }
}
