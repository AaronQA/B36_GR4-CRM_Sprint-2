package com.crm.step_definitions;

import com.crm.pages.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfilePageStepDefs {

    ProfilePage profilePage = new ProfilePage();

    @When("user clicks on the profile icon")
    public void user_clicks_on_the_profile_icon() {
        profilePage.clickProfileIcon();
    }

    @When("user selects {string} from the dropdown")
    public void user_selects_from_the_dropdown(String myProfile) {
        profilePage.myProfileButton.click();
    }

    @Then("user should be redirected to the {string} page")
    public void user_should_be_redirected_to_the_page(String string) {
        // Write code to verify the page title
    }

    @Then("user should see the following tabs:")
    public void user_should_see_the_following_tabs(io.cucumber.datatable.DataTable dataTable) {

    }

//    @Then("the {string} under the General tab should match the {string}")
//    public void the_under_the_general_tab_should_match_the(String string, String string2) {
//
//    }


}
