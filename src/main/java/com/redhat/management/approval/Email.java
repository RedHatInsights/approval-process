package com.redhat.management.approval;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Email implements Serializable {

    static final long serialVersionUID = 1L;

    private String subject;
    private String bodyType;
    private String body;
    private List<String> recipients;

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSubject(String requestID, String requestName) {
        this.subject = "Catalog:Approval Order " + requestID + ": " + requestName;
    }

    public String getBodyType() {
        return this.bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public void setBody(Request request, Approver approver, Group group, List<Stage> stages) {
        EmailBody body = new EmailBody(request, approver, group, stages);
        this.body = body.toString();
    }


    public List<String> getRecipients() {
        return this.recipients;
    }

    public void setRecipents(List<String> recipients) {
        this.recipients = recipients;
    }

    public Email(List<String> recipients) {
        this.subject = "Catalog : Approval Order ";
        this.bodyType = "html";
        this.body = "";
        this.recipients = recipients;
    }

}
