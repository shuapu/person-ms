package com.apurv.test.util;

public interface EntityDtoMapper<E,D,K> {
    /**
     * Method helps in converting request DTO to entity DTO
     * @param d requestDTO
     * @return E entity
     */
    E convertToEntity(D d);
    K convertToDto(E e);
}
