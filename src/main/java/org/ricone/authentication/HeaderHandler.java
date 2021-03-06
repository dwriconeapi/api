package org.ricone.authentication;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderHandler extends HandlerInterceptorAdapter {
    private static final String pageNum = "page";
    private static final String pageSize = "size";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("HeaderHandler - preHandle ");
        response.setStatus(response.getStatus());
        setPaging(request, response);
        setAdditionalHeaders(request, response);
        return super.preHandle(request, response, handler);
    }

    private void setAdditionalHeaders(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("ServicePath", request.getRequestURI());
        response.setHeader("Cache-Control", "no-cache, no-store");

        response.setHeader("X-FRAME-OPTIONS", "allow-from: DOMAIN");
        response.setHeader("X-XSS-Protection", "1; mode=block");
        response.setHeader("X-Content-Type-Options", "nosniff");
        response.setHeader("X-Download-Options", "noopen");

        response.setHeader("RecordCount", "0");
    }

    //Return proper paging headers based on request.
    private void setPaging(HttpServletRequest request, HttpServletResponse response) {
        boolean pagingNumHeader = StringUtils.isNotBlank(request.getHeader(pageNum));
        boolean pagingSizeHeader = StringUtils.isNotBlank(request.getHeader(pageSize));
        boolean pagingNumParam = StringUtils.isNotBlank(request.getParameter(pageNum));
        boolean pagingSizeParam = StringUtils.isNotBlank(request.getParameter(pageSize));

        if(pagingNumHeader && pagingSizeHeader) {
            response.setHeader(pageNum, request.getHeader(pageNum));
            response.setHeader(pageSize, request.getHeader(pageSize));
        }
        else if(pagingNumParam && pagingSizeParam) {
            response.setHeader(pageNum, request.getParameter(pageNum));
            response.setHeader(pageSize, request.getParameter(pageSize));
        }
    }
}