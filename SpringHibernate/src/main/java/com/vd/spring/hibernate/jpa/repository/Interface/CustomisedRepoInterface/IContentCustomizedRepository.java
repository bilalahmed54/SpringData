package com.vd.spring.hibernate.jpa.repository.Interface.CustomisedRepoInterface;

import java.util.List;
import com.vd.spring.hibernate.jpa.model.core.User;
import org.springframework.data.jpa.repository.Query;
import com.vd.spring.hibernate.jpa.model.core.Project;
import com.vd.spring.hibernate.jpa.model.core.Content;

public interface IContentCustomizedRepository {

    public Content findFirstByName(String name);

    @Query("from Content where isPublic = true")
    public List<Content> publicContents();

    public List<Content> findByProject(Project project);
}