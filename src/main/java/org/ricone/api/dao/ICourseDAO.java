package org.ricone.api.dao;

import org.ricone.api.model.core.Course;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 * @project: ricone
 * @author: Dan on 9/12/2017.
 */
public interface ICourseDAO
{
    List<Course> findAll(Pageable pageRequest) throws Exception;

    List<Course> findAllByLeaRefId(Pageable pageRequest, String refId) throws Exception;

    List<Course> findAllBySchoolRefId(Pageable pageRequest, String refId) throws Exception;

    List<Course> findAllByRosterRefId(Pageable pageRequest, String refId) throws Exception;

    List<Course> findByRefIds(Set<String> refIds) throws Exception;

    Course findByRefId(String refId) throws Exception;

    void save(Course instance);

    void update(Course instance);

    void delete(Course instance);

    void deleteByRefId(String refId);
}
