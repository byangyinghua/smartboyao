package com.guinong.lib_commom.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20.
 */
public class AddressDataUtil {
    private static String dirPath= Environment.getExternalStorageDirectory().getAbsolutePath();
    private static String filename= "addressData";

    public static boolean creatDir() {
        if (null != dirPath) {
            File path = new File(dirPath);
            if (path.exists()) {
                return true;
            }
            if (true == path.mkdirs() ) {
                return true;
            }
        }
        return false;
    }

    public static void creatFile() {
        if (null != filename) {
            File file = new File(dirPath, filename);
            if (false == file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * @Title: writeObject
     * @Description: Write a object to a file.
     * @return void
     * @throws
     */
    public static void writeObject(List<Object> data) {
        creatDir();
        creatFile();
        File file = new File(dirPath, filename);
        if (false == file.isFile()) {
            return ;
        }

        try {
            // The value "false" for FileOutputStream means that overwrite this file,
            // if it is "true",append the new data to this file.
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file,false));
            oos.writeObject(data);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Title: readObject
     * @Description: Read a object from a file.
     * @return LinkedList<TestMessage>
     * @throws
     */
    @SuppressWarnings("unchecked")
    public static List<Object> readObject() {
        creatDir();
        creatFile();
        File file = new File(dirPath, filename);
        ObjectInputStream ois = null;
        List<Object> msgAll = null;

        try {
            InputStream inputStream=new FileInputStream(file);
            if(inputStream.available() == 0){
                return null;
            }
            ois = new ObjectInputStream(inputStream);
            try {
                msgAll = (List<Object>)ois.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return msgAll;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return msgAll;
        } catch (IOException e) {
            e.printStackTrace();
            return msgAll;
        } finally {
            try {
                if (ois!=null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
                return msgAll;
            }
            return msgAll;
        }


    }
//    public interface ReadAddressResult{
//        void.
//
//    }
}




