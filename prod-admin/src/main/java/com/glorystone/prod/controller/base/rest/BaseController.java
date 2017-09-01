package com.glorystone.prod.controller.base.rest;

import cn.com.yintongkaxinyue.amlrs.utils.DateUtils;
import cn.com.yintongkaxinyue.amlrs.utils.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wangwei on 2017/8/22.
 */
public class BaseController {

    protected static final String CONTENT_TYPE_JSON_UTF8 = "application/json; charset=UTF-8";

    /**
     * 管理基础路径
     */
    @Value("${wwwPath}")
    protected String wwwPath;


    /**
     * 参数绑定异常
     */
    @ExceptionHandler({BindException.class, ConstraintViolationException.class, ValidationException.class})
    public String bindException() {
        return "error/400";
    }

    /**
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }
            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });

        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }





    /** 基于@ExceptionHandler异常处理 */
    @ExceptionHandler
    public String exp(HttpServletRequest request, Exception ex) {

        request.setAttribute("ex", ex);

        // 根据不同错误转向不同页面
        /*if(ex instanceof BusinessException) {
            return "error-business";
        }else if(ex instanceof ParameterException) {
            return "error-parameter";
        } else {
            return "error";
        }*/
        return "error/400";
    }
}
