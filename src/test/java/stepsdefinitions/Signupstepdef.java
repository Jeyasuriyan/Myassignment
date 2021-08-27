package stepsdefinitions;

import baseUtils.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.Loginpage;
import pages.Singuppage;
import pages.Welcomepage;

import java.util.List;

public class Signupstepdef extends Base {

    private final Base base;
    Singuppage sP;
    Loginpage lP;
    Welcomepage wP;

    public Signupstepdef(Base base) {
        this.base = base;
    }

    @Given("user click register link from the Homepage")
    public void user_click_register_link_from_the_homepage() {
        lP = new Loginpage(base.driver);
        lP.clkRegister();
    }

    @When("user enter the FirstName, LastName, Address, City, State, Zipcode, PhoneNo, SSN, UserName, Password, Confirm")
    public void
    user_enter_the_first_name_last_name_address_city_state_zipcode_phone_ssn_user_name_password_confirm
            (DataTable dataTable) {

        // Data table without header we can use asList
        List<String> registerData = dataTable.asList();

        sP = new Singuppage(base.driver);

        sP.signUp(registerData.get(0), registerData.get(1),
                registerData.get(2), registerData.get(3),
                registerData.get(4), registerData.get(5),
                registerData.get(6), registerData.get(7),
                registerData.get(8), registerData.get(9),
                registerData.get(10));
    }

    @When("user enter the FirstName, LastName, Address, City, State, Zipcode, PhoneNo, SSN, UserName, Password, Confirm with multi row")
    public void userEnterTheFirstNameLastNameAddressCityStateZipcodePhoneNoSSNUserNamePasswordConfirmWithMultiRow
            (DataTable dataTable) {
        // Data table without header we can use asList
        List<List<String>> registerData = dataTable.asLists();


        sP = new Singuppage(base.driver);

        for (List<String> e : registerData) {

            System.out.println("Just to check the Values ==> " + e.get(0));

            sP.signUp(e.get(0), e.get(1), e.get(2), e.get(3), e.get(4), e.get(5), e.get(6), e.get(7), e.get(8),
                    e.get(9), e.get(10));
        }

    }

    @When("click on register button")
    public void click_on_register_button() {
        sP = new Singuppage(base.driver);
        sP.submitRegister();
    }

//    @Then("message {string} should be displayed in welcome page")
//    public void message_should_be_displayed_in_welcome_page(String message) {
//        wP = new Welcomepage(base.driver);
//        wP.successRegisteredMsg(message, );
//    }

    @Then("message {string} should be displayed in welcome page")
    public void messageShouldBeDisplayedInWelcomePage(String message) {
        wP = new Welcomepage(base.driver);
        wP.successRegisteredMsg(message);
    }


}
