package stepsdefinitions;

import baseUtils.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.Singuppage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Signupstepdefwithheader {

    private final Base base;
    Singuppage sP;

    public Signupstepdefwithheader(Base base) {
        this.base = base;
    }

    //Getting the data by using the index inside the get method
    @When("user enter the FirstName, LastName with Header by using index")
    public void userEnterTheFirstNameLastNameWithHeaderByUsingIndex(DataTable dataTable) {
        sP = new Singuppage(base.driver);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // By passing the index (0 = first column and 1 = second column) in get we can change the column of the data table
        sP.signUp(data.get(0).get("FirstName"), data.get(0).get("LastName"),
                data.get(0).get("Address"), data.get(0).get("City"),
                data.get(0).get("State"), data.get(0).get("Zipcode"),
                data.get(0).get("PhoneNo"), data.get(0).get("SSN"),
                data.get(0).get("UserName"), data.get(0).get("Password"),
                data.get(0).get("Confirm"));

    }

    //Executing as a single user
    //Getting the data using the for loop and key word
    @When("user enter the FirstName, LastName with Header and getting the data using for loop and keyword")
    public void userEnterTheFirstNameLastNameWithHeaderAndGettingTheDataUsingForLoopAndKeyword(DataTable dataTable) {

        sP = new Singuppage(base.driver);

        for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
            sP.signUp(data.get("FirstName").toString(), data.get("LastName").toString(),
                    data.get("Address").toString(), data.get("City").toString(),
                    data.get("State").toString(), data.get("Zipcode").toString(),
                    data.get("PhoneNo").toString(), data.get("SSN").toString(),
                    data.get("UserName").toString(), data.get("Password").toString(),
                    data.get("Confirm").toString());
        }
    }

    //Getting the data using class objects
    @When("user enter the FirstName, LastName with Header and getting the data using Class objects")
    public void
    userEnterTheFirstNameLastNameWithHeaderAndGettingTheDataUsingClassObjects(DataTable dataTable) {
        sP = new Singuppage(base.driver);

        List<Userdata> registerData = new ArrayList<Userdata>();

        registerData = dataTable.asList(Userdata.class);

        for (Userdata data : registerData) {
            sP.signUp(data.FirstName, data.LastName,
                    data.Address, data.City,
                    data.State, data.Zipcode,
                    data.PhoneNo, data.SSN,
                    data.UserName, data.Password,
                    data.Confirm);
        }
    }
}

class Userdata {
    public String FirstName;
    public String LastName;
    public String Address;
    public String City;
    public String State;
    public String Zipcode;
    public String PhoneNo;
    public String SSN;
    public String UserName;
    public String Password;
    public String Confirm;

    public Userdata(String firstName, String lastName,
                    String address, String city,
                    String state, String zipcode,
                    String phoneNo, String SSN,
                    String userName, String password,
                    String confirm) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Address = address;
        this.City = city;
        this.State = state;
        this.Zipcode = zipcode;
        this.PhoneNo = phoneNo;
        this.SSN = SSN;
        this.UserName = userName;
        this.Password = password;
        this.Confirm = confirm;
    }
}
