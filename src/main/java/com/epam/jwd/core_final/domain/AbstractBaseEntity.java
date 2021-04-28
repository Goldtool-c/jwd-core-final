package com.epam.jwd.core_final.domain;


public abstract class AbstractBaseEntity implements BaseEntity {

    long id;
    String name;
    @Override
    public Long getId() {
        // todo
        return null;
    }
    public void  setId(int id)
    {
        this.id=id;
    }
    @Override
    public String getName() {
        return name;
    }
}
