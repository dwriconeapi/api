package org.ricone.api.dao;

import org.ricone.api.model.core.SchoolCalendar;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 * @project: ricone
 * @author: Dan on 9/12/2017.
 */
public interface ICalendarDAO
{
    List<SchoolCalendar> findAll(Pageable pageRequest) throws Exception;

    List<SchoolCalendar> findAllByLeaRefId(Pageable pageRequest, String refId) throws Exception;

    List<SchoolCalendar> findAllBySchoolRefId(Pageable pageRequest, String refId) throws Exception;

    List<SchoolCalendar> findByRefIds(Set<String> refIds) throws Exception;

    SchoolCalendar findByRefId(String refId) throws Exception;

    void save(SchoolCalendar instance);

    void update(SchoolCalendar instance);

    void delete(SchoolCalendar instance);

    void deleteByRefId(String refId);
}
