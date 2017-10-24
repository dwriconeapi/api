package org.ricone.api.service;

import org.ricone.api.exception.NotFoundException;
import org.ricone.api.model.core.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService
{
    List<Student> findAll(Pageable pageRequest) throws Exception;

    Student findByRefId(String refId) throws Exception;

    Student findByLocalId(String localId) throws Exception;

    void save(Student instance);

    void update(Student instance);

    void delete(Student instance);

    void deleteByRefId(String refId);
}
