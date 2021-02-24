package com.mypham.ultis;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUlti {
	@SuppressWarnings("deprecation")
	public static <T> T toModel(Class<T> tClass, HttpServletRequest req) {
		T object = null;
		try {
			object = tClass.newInstance();
			BeanUtils.populate(object, req.getParameterMap());
			return object;
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
