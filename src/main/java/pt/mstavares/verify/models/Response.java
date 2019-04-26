package pt.mstavares.verify.models;

public class Response {

    private boolean verificationSuccessful;
    private String reason;

    public Response() {}

    public Response(boolean verificationSuccessful) {
        this.setVerificationSuccessful(verificationSuccessful);
    }

    public Response(boolean verificationSuccessful, String reason) {
        this.setVerificationSuccessful(verificationSuccessful);
        this.setReason(reason);
    }


    public boolean isVerificationSuccessful() {
        return verificationSuccessful;
    }

    public void setVerificationSuccessful(boolean verificationSuccessful) {
        this.verificationSuccessful = verificationSuccessful;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
