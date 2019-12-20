package com.hivetech.thymeleafservlet.config;

import org.thymeleaf.TemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class TemplateEngineUtil {

    private static final Logger LOGGER = Logger.getLogger(TemplateEngineUtil.class.getName());
    private static final String TEMPLATE_ENGINE_ATTR = "com.thymeleafexamples.thymeleaf3.TemplateEngineInstance";

    public static void storeTemplateEngine(ServletContext context, TemplateEngine engine) {
        context.setAttribute(TEMPLATE_ENGINE_ATTR, engine);
        LOGGER.info("storeTemplateEngine");
    }

    public static TemplateEngine getTemplateEngine(ServletContext context) {
        LOGGER.info("getTemplateEngine");
        return (TemplateEngine) context.getAttribute(TEMPLATE_ENGINE_ATTR);
    }
}
