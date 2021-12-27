package com.company.controller;

import com.company.model.Methods;
import com.company.view.ViewFactory;

public abstract class BaseController {

    protected ViewFactory viewFactory;
    protected String fxmlName;
    private Methods methods;

    public BaseController(ViewFactory viewFactory, String fxmlName, Methods methods) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
        this.methods = methods;
    }

    public String getFxmlName() {
        return fxmlName;
    }


}
