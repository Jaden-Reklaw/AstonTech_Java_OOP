package com.astontech.bo;

import java.util.Date;

public class Client extends BaseBO{
    //Params
    private int ClientId;
    private String ClientName;
    private Date CreateDate;

    //Constructors
    public Client() {}
    public Client(String clientName, Date createDate) {
        this.setClientName(clientName);
        this.setCreateDate(createDate);
    }

    //Setters and Getters
    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
