package org.ricone.api.xPress.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SwaggerController
{
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model)
    {
        return "index";
    }
}