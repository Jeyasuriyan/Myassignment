package stepsdefinitions;

import baseUtils.Base;
import io.cucumber.java.en.When;
import pages.Singuppage;

public class Signupstepwithscenariooutline extends Base {
    private final Base base;
    Singuppage sP;

    public Signupstepwithscenariooutline(Base base) {
        this.base = base;
    }

    @When("user enter the {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void userEnterTheAnd
            (String FirstName, String LastName, String Address, String City,
             String State, String Zipcode, String PhoneNo, String SSN, String UserName,
             String Password, String Confirm) {

        sP = new Singuppage(base.driver);

        sP.signUp
                (FirstName, LastName, Address, City, State, Zipcode, PhoneNo, SSN, UserName, Password, Confirm);
    }
}
