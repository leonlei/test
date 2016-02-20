package com.leon.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/1
 */
public class ReflectUtil {
    /**
     * ���÷����ȡָ�������ָ������
     *
     * @param obj
     *            Ŀ�����
     * @param fieldName
     *            Ŀ������
     * @return Ŀ�����Ե�ֵ
     */
    public static Object getFieldValue(Object obj, String fieldName)
    {
        Object result = null;
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null)
        {
            field.setAccessible(true);
            try
            {
                result = field.get(obj);
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * ���÷����ȡָ�����������ָ������
     *
     * @param obj
     *            Ŀ�����
     * @param fieldName
     *            Ŀ������
     * @return Ŀ���ֶ�
     */
    private static Field getField(Object obj, String fieldName)
    {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass())
        {
            try
            {
                field = clazz.getDeclaredField(fieldName);
                break;
            }
            catch (NoSuchFieldException e)
            {
            }
        }
        return field;
    }

    /**
     * ���÷�������ָ�������ָ������Ϊָ����ֵ
     *
     * @param obj
     *            Ŀ�����
     * @param fieldName
     *            Ŀ������
     * @param fieldValue
     *            Ŀ��ֵ
     */
    public static void setFieldValue(Object obj, String fieldName, String fieldValue)
    {
        Field field = ReflectUtil.getField(obj, fieldName);
        if (field != null)
        {
            try
            {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * ����Getter����.
     */
    public static Object invokeGetterMethod(Object target, String propertyName)
    {
        String getterMethodName = "get" + StringUtils.capitalize(propertyName);
        return invokeMethod(target, getterMethodName, new Class[] {}, new Object[] {});
    }

    /**
     * ����Setter����.ʹ��value��Class������Setter����.
     */
    public static void invokeSetterMethod(Object target, String propertyName, Object value)
    {
        invokeSetterMethod(target, propertyName, value, null);
    }

    /**
     * ����Setter����.
     *
     * @param propertyType
     *            ���ڲ���Setter����,Ϊ��ʱʹ��value��Class���.
     */
    public static void invokeSetterMethod(Object target, String propertyName, Object value, Class<?> propertyType)
    {
        Class<?> type = propertyType != null ? propertyType : value.getClass();
        String setterMethodName = "set" + StringUtils.capitalize(propertyName);
        invokeMethod(target, setterMethodName, new Class[] { type }, new Object[] { value });
    }

    /**
     * ֱ�ӵ��ö��󷽷�, ����private/protected���η�.
     */
    public static Object invokeMethod(final Object object, final String methodName, final Class<?>[] parameterTypes,
                                      final Object[] parameters)
    {
        Method method = getDeclaredMethod(object, methodName, parameterTypes);
        if (method == null)
        {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] parameterType "
                    + parameterTypes + " on target [" + object + "]");
        }

        method.setAccessible(true);

        try
        {
            return method.invoke(object, parameters);
        }
        catch (Exception e)
        {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * ѭ������ת��, ��ȡ�����DeclaredMethod. ������ת�͵�Object���޷��ҵ�, ����null.
     */
    protected static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes)
    {
        Assert.notNull(object, "object����Ϊ��");

        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
                .getSuperclass())
        {
            try
            {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            }
            catch (NoSuchMethodException e)
            {// NOSONAR
                // Method���ڵ�ǰ�ඨ��,��������ת��
            }
        }
        return null;
    }

    /**
     * ������ʱ��checked exceptionת��Ϊunchecked exception.
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e)
    {
        return convertReflectionExceptionToUnchecked(null, e);
    }

    public static RuntimeException convertReflectionExceptionToUnchecked(String desc, Exception e)
    {
        desc = (desc == null) ? "Unexpected Checked Exception." : desc;
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
                || e instanceof NoSuchMethodException)
        {
            return new IllegalArgumentException(desc, e);
        }
        else if (e instanceof InvocationTargetException)
        {
            return new RuntimeException(desc, ((InvocationTargetException) e).getTargetException());
        }
        else if (e instanceof RuntimeException)
        {
            return (RuntimeException) e;
        }
        return new RuntimeException(desc, e);
    }
}
