package com.premiumshopcarbackend.services;
import javax.transaction.Transactional;
import java.util.List;

public interface BaseResourceService <T, DTO>{
    public List<T> findAll();

    public T findById(Integer id);

    @Transactional
    public T save (DTO dto);

    public T update (DTO dto);

    public void delete(Integer id);

}
