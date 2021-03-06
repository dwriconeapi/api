package org.ricone.api.xPress.request.xStaff;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ricone.api.AbstractController;
import org.ricone.api.core.model.wrapper.StaffWrapper;
import org.ricone.api.xPress.model.XStaffResponse;
import org.ricone.api.xPress.model.XStaffsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Api(value = "xStaffs", description = "REST API for xStaffs", tags = {"xStaffs"})
public class XStaffController extends AbstractController {
    @Autowired
    private IStaffService service;

    @Autowired
    private XStaffMapper mapper;


    @ResponseBody
    @ApiOperation(value = "Return xStaff by refId", tags = {"xStaffs"})
    @RequestMapping(value = "/requests/xStaffs/{refId}", method = RequestMethod.GET)
    public XStaffResponse getXStaff(HttpServletResponse response, Pageable pageRequest, @PathVariable(value = "refId") String refId) throws Exception {
        StaffWrapper instance = service.findById(getMetaData(pageRequest), refId);
        return mapper.convert(instance);
    }

    @ResponseBody
    @ApiOperation(value = "Return all xStaffs", tags = {"xStaffs"})
    @RequestMapping(value = "/requests/xStaffs", method = RequestMethod.GET)
    public XStaffsResponse getXStaffs(HttpServletResponse response, Pageable pageRequest) throws Exception {
        List<StaffWrapper> instance = service.findAll(getMetaData(pageRequest));
        return mapper.convert(instance);
    }


    @ResponseBody
    @ApiOperation(value = "Return all xStaffs by xLea refId", tags = {"xStaffs"})
    @RequestMapping(value = "/requests/xLeas/{refId}/xStaffs", method = RequestMethod.GET)
    public XStaffsResponse getXStaffsByLea(HttpServletResponse response, Pageable pageRequest, @PathVariable(value = "refId") String refId) throws Exception {
        List<StaffWrapper> instance = service.findAllByLea(getMetaData(pageRequest), refId);
        return mapper.convert(instance);
    }

    @ResponseBody
    @ApiOperation(value = "Return all xStaffs by xSchool refId", tags = {"xStaffs"})
    @RequestMapping(value = "/requests/xSchools/{refId}/xStaffs", method = RequestMethod.GET)
    public XStaffsResponse getXStaffsBySchool(HttpServletResponse response, Pageable pageRequest, @PathVariable(value = "refId") String refId) throws Exception {
        List<StaffWrapper> instance = service.findAllBySchool(getMetaData(pageRequest), refId);
        return mapper.convert(instance);
    }

    @ResponseBody
    @ApiOperation(value = "Return all xStaffs by xCourse refId", tags = {"xStaffs"})
    @RequestMapping(value = "/requests/xCourses/{refId}/xStaffs", method = RequestMethod.GET)
    public XStaffsResponse getXStaffsByCourse(HttpServletResponse response, Pageable pageRequest, @PathVariable(value = "refId") String refId) throws Exception {
        List<StaffWrapper> instance = service.findAllByCourse(getMetaData(pageRequest), refId);
        return mapper.convert(instance);
    }

    @ResponseBody
    @ApiOperation(value = "Return all xStaffs by xRoster refId", tags = {"xStaffs"})
    @RequestMapping(value = "/requests/xRosters/{refId}/xStaffs", method = RequestMethod.GET)
    public XStaffsResponse getXStaffsByRoster(HttpServletResponse response, Pageable pageRequest, @PathVariable(value = "refId") String refId) throws Exception {
        List<StaffWrapper> instance = service.findAllByRoster(getMetaData(pageRequest), refId);
        return mapper.convert(instance);
    }

    @ResponseBody
    @ApiOperation(value = "Return all xStaffs by xStudent refId", tags = {"xStaffs"})
    @RequestMapping(value = "/requests/xStudents/{refId}/xStaffs", method = RequestMethod.GET)
    public XStaffsResponse getXStaffsByStudent(HttpServletResponse response, Pageable pageRequest, @PathVariable(value = "refId") String refId) throws Exception {
        List<StaffWrapper> instance = service.findAllByStudent(getMetaData(pageRequest), refId);
        return mapper.convert(instance);
    }
}