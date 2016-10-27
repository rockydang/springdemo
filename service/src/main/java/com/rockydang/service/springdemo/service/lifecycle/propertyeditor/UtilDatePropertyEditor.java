package com.rockydang.service.springdemo.service.lifecycle.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDatePropertyEditor extends PropertyEditorSupport {
    private String format = "yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        System.out.println("UtilDatePropertyEditor.setAsText() -- text=" + text);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d = sdf.parse(text);
            this.setValue(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setFormat(String format) {
        this.format = format;
    }
}