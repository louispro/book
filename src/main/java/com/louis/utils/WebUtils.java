package com.louis.utils;

import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class WebUtils {

    public static <T> T copyParamsToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Integer parseInt(String param,int defaultValue){
        if(param==null)
            return defaultValue;
        return Integer.parseInt(param);
    }
}
