package com.astontech.bo;

public class EntityType extends BaseBO{
    //Params
    private int EntityTypeId;
    private int EntityTypeValue;
    private int EntityId;

    //Constructors
    public EntityType() {}
    public EntityType(int entityTypeId, int entityTypeValue, int entityId) {
        this.setEntityTypeId(entityTypeId);
        this.setEntityTypeValue(entityTypeValue);
        this.setEntityId(entityId);
    }

    //Setters and Getters
    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getEntityTypeValue() {
        return EntityTypeValue;
    }

    public void setEntityTypeValue(int entityTypeValue) {
        EntityTypeValue = entityTypeValue;
    }

    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        EntityId = entityId;
    }
}
