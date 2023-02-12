package Utilities;

import com.jayway.jsonpath.DocumentContext;
import stepDef.BaseStep;

public class RequestBodyService extends BaseStep {

    public void setRequestBodyForComment(DocumentContext requestBody, String postId, String name, String email,   String body){
        requestBody.set("postId", postId);
        requestBody.set("name", name);
        requestBody.set("email", email);
        requestBody.set("body", body);
        setRequestBodyJson(requestBody);

    }
}
