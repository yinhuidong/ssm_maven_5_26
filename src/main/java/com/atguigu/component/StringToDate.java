package com.atguigu.component;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-20:09
 */
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
