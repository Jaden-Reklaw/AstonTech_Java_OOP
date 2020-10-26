package com.astontech.bo;

public class Entity extends BaseBO{
    //Params
    private int EntityId;
    private String EntityName;

    //Constructors
    public Entity() {}
    public Entity(String entityName) {
        this.setEntityName(entityName);
    }

    //Setters and Getters
    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        EntityId = entityId;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        EntityName = entityName;
    }
}
