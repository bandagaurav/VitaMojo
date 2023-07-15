package pojo;

import java.util.HashMap;

public class RequestParams {

    private String body;
    private HashMap pathParams;
    private HashMap queryParams;

    private String endPointURL;

    private HashMap headers;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HashMap getPathParams() {
        return pathParams;
    }

    public void setPathParams(HashMap pathParams) {
        this.pathParams = pathParams;
    }

    public HashMap getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(HashMap queryParams) {
        this.queryParams = queryParams;
    }

    public String getEndPointURL() {
        return endPointURL;
    }

    public void setEndPointURL(String endPointURL) {
        this.endPointURL = endPointURL;
    }

    public HashMap getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap headers) {
        this.headers = headers;
    }
}
