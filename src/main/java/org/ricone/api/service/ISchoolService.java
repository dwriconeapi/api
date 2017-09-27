package org.ricone.api.service;

import org.ricone.api.exception.NotFoundException;
import org.ricone.api.model.core.School;

import java.util.List;

/**
 * @project: ricone
 * @author: Dan on 9/12/2017.
 */
public interface ISchoolService
{
    List<School> findAll() throws Exception;

    School findByRefId(String refId) throws Exception;

    School findByLocalId(String localId) throws Exception;

    void save(School instance);

    void update(School instance);

    void delete(School instance);

    void deleteByRefId(String refId);
}