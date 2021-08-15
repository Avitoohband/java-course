package app.core.com.company.responses;

import org.springframework.http.HttpStatus;

public class CompanySystemResponse {

    private String msg;
    private HttpStatus status;

    public CompanySystemResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}


