package com.vd.spring.hibernate.jpa.repository.Interface.CustomisedRepoInterface;

import com.vd.spring.hibernate.jpa.model.core.Project;

public interface IProjectCustomizedRepository {

    public Project findFirstByName(String name);
}