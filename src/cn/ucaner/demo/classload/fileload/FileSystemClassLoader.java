package cn.ucaner.demo.classload.fileload;  
  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.ByteArrayOutputStream;  

// 文件系统类加载器  
public class FileSystemClassLoader extends ClassLoader {  
  
    private String rootDir;  
  
    public FileSystemClassLoader(String rootDir) {  
        this.rootDir = rootDir;  
    }  
  
    // 获取类的字节码  
    @Override  
    protected Class<?> findClass(String name) throws ClassNotFoundException {  
        byte[] classData = getClassData(name);  // 获取类的字节数组  
        if (classData == null) {  
            throw new ClassNotFoundException();  
        } else {  
            return defineClass(name, classData, 0, classData.length);  
        }  
    }  
  
    private byte[] getClassData(String className) {  
        // 读取类文件的字节  
        String path = classNameToPath(className);  
        try {  
            InputStream ins = new FileInputStream(path);  
            ByteArrayOutputStream baos = new ByteArrayOutputStream();  
            int bufferSize = 4096;  
            byte[] buffer = new byte[bufferSize];  
            int bytesNumRead = 0;  
            // 读取类文件的字节码  
            while ((bytesNumRead = ins.read(buffer)) != -1) {  
                baos.write(buffer, 0, bytesNumRead);  
            }  
            return baos.toByteArray();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    private String classNameToPath(String className) {  
        // 得到类文件的完全路径  
        return rootDir + File.separatorChar  
                + className.replace('.', File.separatorChar) + ".class";  
    }  
}  