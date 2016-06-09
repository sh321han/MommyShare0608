package com.sh321han.mommyshare.data;

public class LoginResult {
    private LoginResultResult result;
    private boolean success;
    private String message;

    public LoginResultResult getResult() {
        return this.result;
    }

    public void setResult(LoginResultResult result) {
        this.result = result;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
