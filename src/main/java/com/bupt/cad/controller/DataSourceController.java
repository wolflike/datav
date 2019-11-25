package com.bupt.cad.controller;


import com.bupt.cad.service.impl.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DataSourceController {
    @Autowired
    private DataSourceService dataSourceService;
}
