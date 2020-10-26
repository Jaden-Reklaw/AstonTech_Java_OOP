package com.astontech.bo;

public class ClientContact extends BaseBO{
    //Params
    private int ClientContactId;
    private int ClientId;
    private int EntityTypeId;

    //Constructor
    public ClientContact() {}
    public ClientContact(int clientContactId, int clientId, int entityTypeId) {
        this.setClientContactId(clientContactId);
        this.setClientId(clientId);
        this.setEntityTypeId(entityTypeId);
    }

    //Setters and Getters
    public int getClientContactId() {
        return ClientContactId;
    }

    public void setClientContactId(int clientContactId) {
        ClientContactId = clientContactId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }
}
