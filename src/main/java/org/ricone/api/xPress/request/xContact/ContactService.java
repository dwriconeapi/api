package org.ricone.api.xPress.request.xContact;

import org.ricone.api.core.model.StudentContact;
import org.ricone.api.core.model.wrapper.StudentContactWrapper;
import org.ricone.authentication.MetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("ContactService")
@Transactional
public class ContactService implements IContactService {
    @Autowired
    private IContactDAO dao;

    @Override
    public List<StudentContactWrapper> findAll(MetaData metaData) throws Exception {
        return dao.findAll(metaData);
    }

    @Override
    public List<StudentContactWrapper> findAllByLea(MetaData metaData, String refId) throws Exception {
        return dao.findAllByLeaRefId(metaData, refId);
    }

    @Override
    public List<StudentContactWrapper> findAllBySchool(MetaData metaData, String refId) throws Exception {
        return dao.findAllBySchoolRefId(metaData, refId);
    }

    @Override
    public List<StudentContactWrapper> findAllByStudent(MetaData metaData, String refId) throws Exception {
        return dao.findAllByStudentRefId(metaData, refId);
    }

    @Override
    public StudentContactWrapper findByRefId(MetaData metaData, String refId) throws Exception {
        return dao.findByRefId(metaData, refId);
    }

    @Override
    public void save(StudentContact instance) {
        dao.save(instance);
    }

    @Override
    public void update(StudentContact instance) {
        dao.update(instance);
    }

    @Override
    public void delete(StudentContact instance) {
        dao.delete(instance);
    }
}
