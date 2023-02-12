package stepDef;

import Utilities.RequestBodyService;
import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Social_NetworkingStepDef extends BaseStep{
    Response getServiceResponse;
    Response getCommentResponse, getPostResponse;
    DocumentContext requestBody;
    RequestBodyService  requestBodyService;

    @Given("jsonplaceholder service is up and running")
    public void jsonplaceholder_service_is_up_and_running()  {
        setHeaders_ContentTypeApplicationJson();
        setEndpointPath(serviceURL);
        getServiceResponse = getCall();
        assertThat(getServiceResponse.statusCode(), equalTo(200));
    }

    @When("I search for comment with {string} with a GET method")
    public void i_search_for_comment_with_with_a_get_method(String id) {
        setHeaders_ContentTypeApplicationJson();
        setEndpointPath(commentEndPoint + id);
        getCommentResponse = getCall();

    }

    @Then("I should get status code of {int} and {string}, {string} and {string}")
    public void i_should_get_status_code_of_and_and(Integer sCode, String id, String name, String email) {
        assertThat(getCommentResponse.statusCode(), equalTo(sCode));
        assertThat(getCommentResponse.body().jsonPath().get("id"), equalTo(Integer.parseInt(id)));
        assertThat(getCommentResponse.body().jsonPath().get("name"), equalTo(name));
        assertThat(getCommentResponse.body().jsonPath().get("email"), equalTo(email));
    }
    @When("I create a new comment with details {string}, {string}, {string} and {string} using post method")
    public void i_create_a_new_comment_with_details_and_using_post_method(String postId, String name, String email, String body) {
        setHeaders_ContentTypeApplicationJson();
        setEndpointPath(commentEndPoint);
        requestBody = loadJsonTemplate(commentPayload);
        requestBodyService= new RequestBodyService();
        requestBodyService.setRequestBodyForComment(requestBody, postId, name, email, body);
        getCommentResponse = postCall();

    }
    @Then("I should get status code of {int} and {string}, {string}, {string} and {string}")
    public void i_should_get_status_code_of_and_and(Integer sCode, String postId, String name, String email, String body) {
        assertThat(getCommentResponse.statusCode(), equalTo(sCode));
        assertThat(getCommentResponse.body().jsonPath().get("postId"), equalTo(postId));
        assertThat(getCommentResponse.body().jsonPath().get("name"), equalTo(name));
        assertThat(getCommentResponse.body().jsonPath().get("email"), equalTo(email));
        assertThat(getCommentResponse.body().jsonPath().get("body"), equalTo(body));

    }
}

