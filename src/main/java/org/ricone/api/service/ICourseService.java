package org.ricone.api.service;

import org.ricone.api.controller.extension.MetaData;
import org.ricone.api.model.core.Course;

import java.util.List;

/**
 * @project: ricone
 * @author: Dan on 9/12/2017.
 */
public interface ICourseService
{
    List<Course> findAll(MetaData metaData) throws Exception;

    List<Course> findAllByLea(MetaData metaData, String refId) throws Exception;

    List<Course> findAllBySchool(MetaData metaData, String refId) throws Exception;

    List<Course> findAllByRoster(MetaData metaData, String refId) throws Exception;

    Course findByRefId(MetaData metaData, String refId) throws Exception;

    void save(Course instance);

    void update(Course instance);

    void delete(Course instance);
}
