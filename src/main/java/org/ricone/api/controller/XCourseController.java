package org.ricone.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ricone.api.mapping.xPress.XCalendarMapper;
import org.ricone.api.mapping.xPress.XCourseMapper;
import org.ricone.api.model.core.Course;
import org.ricone.api.model.core.SchoolCalendar;
import org.ricone.api.model.xpress.*;
import org.ricone.api.service.ICalendarService;
import org.ricone.api.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Api(value = "xCourses", description = "REST API for xCourses", tags = { "xCourses" })
public class XCourseController extends AbstractController
{
	@Autowired
    ICourseService service;

    @Autowired
    XCourseMapper mapper;

    @ResponseBody
    @ApiOperation(value="Return xCourse by refId", tags = { "xCourses" })
    @RequestMapping(value= "/requests/xCourses/{refId}", method = RequestMethod.GET)
    public XCourseResponse getXCourse(HttpServletResponse response, @PathVariable(value="refId") String refId) throws Exception
    {
        Course instance = service.findByRefId(refId);
        return mapper.convert(instance);
    }

    @ResponseBody
    @ApiOperation(value="Return all xCourses", tags = { "xCourses" })
    @RequestMapping(value = "/requests/xCourses", method = RequestMethod.GET)
    public XCoursesResponse getXCourses(HttpServletResponse response, Pageable pageRequest) throws Exception
    {
        List<Course> instance = service.findAll(getPaging(pageRequest));
        return mapper.convert(instance);
    }


    @ResponseBody
    @ApiOperation(value="Return all xCourses by xLea refId", tags = { "xCourses" })
    @RequestMapping(value= "/requests/xLeas/{refId}/xCourses", method = RequestMethod.GET)
    public XCoursesResponse getXCoursesByLea(HttpServletResponse response, Pageable pageRequest, @PathVariable(value="refId") String refId) throws Exception
    {
        List<Course> instance = service.findAllByLea(getPaging(pageRequest), refId);
        return mapper.convert(instance);
    }

    @ResponseBody
    @ApiOperation(value="Return all xCourses by xSchool refId", tags = { "xCourses" })
    @RequestMapping(value= "/requests/xSchools/{refId}/xCourses", method = RequestMethod.GET)
    public XCoursesResponse getXCoursesBySchool(HttpServletResponse response, Pageable pageRequest, @PathVariable(value="refId") String refId) throws Exception
    {
        List<Course> instance = service.findAllBySchool(getPaging(pageRequest), refId);
        return mapper.convert(instance);
    }

    @ResponseBody
    @ApiOperation(value="Return all xCourses by xRoster refId", tags = { "xCourses" })
    @RequestMapping(value= "/requests/xRosters/{refId}/xCourses", method = RequestMethod.GET)
    public XCoursesResponse getXCoursesByRoster(HttpServletResponse response, Pageable pageRequest, @PathVariable(value="refId") String refId) throws Exception
    {
        List<Course> instance = service.findAllByRoster(getPaging(pageRequest), refId);
        return mapper.convert(instance);
    }
}