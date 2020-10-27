package com.astontech.bo;

public class EntityType extends BaseBO{
    //Params
    private int EntityTypeId;
    private String EntityTypeName;

    //Constructors
    public EntityType() {}
    public EntityType(String entityTypeName) {
        this.EntityTypeName = entityTypeName;
    }

    //Setters and Getters
    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return EntityTypeName;
    }

    public void setEntityTypeValue(String entityTypeName) {
        EntityTypeName = entityTypeName;
    }
}
