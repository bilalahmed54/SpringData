package com.vd.spring.hibernate.jpa.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

@NoRepositoryBean
public class VRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements IVRepository<T, ID> {

    @SuppressWarnings("unused")
    private final EntityManager entityManager;

    public VRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
    }
}