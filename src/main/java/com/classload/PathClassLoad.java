package com.classload;

import java.io.*;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/22
 */
public class PathClassLoad extends ClassLoader {
    private String classPath;

    public PathClassLoad(String classPath){
        this.classPath = classPath;
    }

    private byte[] getData(String className){
        String path = classPath + File.separator + className.replace(".",File.separator) + ".class";
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while((num = is.read(buffer)) != -1){
                stream.write(buffer,0,num);
            }
            return stream.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        byte[] classData = getData(name);
        if(classData == null){
            throw new ClassNotFoundException();
        }else{
            return defineClass(name,classData,0,classData.length);
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator\\Desktop";
        PathClassLoad pathClassLoad = new PathClassLoad(path);
    }
}
