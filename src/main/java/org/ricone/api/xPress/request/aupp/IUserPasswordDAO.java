package org.ricone.api.xPress.request.aupp;

import org.ricone.api.core.model.Staff;
import org.ricone.api.core.model.Student;
import org.ricone.api.core.model.UserPassword;
import org.ricone.authentication.MetaData;

import java.util.HashMap;
import java.util.List;

/**
 * @project: ricone
 * @author: Dan on 10/29/2017.
 */
public interface IUserPasswordDAO {

    void provisionStaffsBySchool(MetaData metaData, HashMap<String, String> kv, List<Staff> staffs) throws Exception;

    void provisionStudentsBySchool(MetaData metaData, HashMap<String, String> kv, List<Student> students) throws Exception;

    void updateStaffsLastRetrievedBySchool(MetaData metaData, String refId) throws Exception;

    void updateStudentsLastRetrievedBySchool(MetaData metaData, String refId) throws Exception;

    List<UserPassword> findStaffsBySchool(MetaData metaData, String refId) throws Exception;

    List<UserPassword> findStudentsBySchool(MetaData metaData, String refId) throws Exception;

    void deleteStaffsBySchool(MetaData metaData, String refId) throws Exception;

    void deleteStudentsBySchool(MetaData metaData, String refId) throws Exception;

    void save(UserPassword instance);

    void update(UserPassword instance);

    void delete(UserPassword instance);
}
