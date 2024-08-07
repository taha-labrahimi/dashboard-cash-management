package com.sorec.dashboardcashmanagement.mapper;



import java.util.List;


public interface EntityMapper <E,D>{
    D toDto(E entity);
    List<D> toDtos(List<E> entities);
    E toEntity(D dto);
    List<E> toEntities(List<D> dtos);
}
