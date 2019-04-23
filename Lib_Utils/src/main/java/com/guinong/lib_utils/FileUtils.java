package com.guinong.lib_utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.ImageColumns;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class FileUtils {
	private static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
			+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	private static Random randGen = new Random();
	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/guinong_up/";
	
	public static final String APP_ROOT_DIR_NAME = "guinong_up";
	public static final String APP_DOWN_DIR_NAME = "Down";//歌曲下载
	public static final String APP_RINGDOWN_DIR_NAME = "RingDown";//铃声下载
	public static final String APP_TEMP_DIR_NAME = "Temp";//临时文件
	public static final String APP_IMAGE_DIR_NAME = "Image";//图片
	public static final String APP_RECORD_DIR_NAME = "Record";//录音
	public static final String APP_VIDEO_DIR_NAME = "Video";//录音
	public static final String APP_IMAGECACHE_DIR_NAME = "ImageCache";//图片缓存
	public static final String APP_TEMP_DIR_DOWN = ".DTemp";//边听边下缓存文件
	public static final String APP_LOG_DIR_NAME = "Log";//日志

	//获取SD卡存储路径，创建文件
    public static String getAppDir(){
		String sdPath = getSDPath();
		if(sdPath != null){
			String defaultPath = sdPath+File.separator + APP_ROOT_DIR_NAME;
	        File fdir = new File(defaultPath);
	        if(!fdir.exists()){
	        	fdir.mkdirs();
	        }
			return defaultPath;
		}
		return null;
    }

	//根据存储路径获得打包名？
    public static String getAppUpdatePath(String versionName){
    	String path = FileUtils.getAppDir();
    	if(path != null){
    		path += File.separator + "guiNong_up"+versionName+".apk";
    	}
    	return path;
    }

    /**
	 * 获取下载路劲
	 * @return
     */
    public static String getDownLoadDir(){
		String appPath = getAppDir();
		if(appPath != null){
			String downDir = appPath+File.separator + APP_DOWN_DIR_NAME;
	        File fdir = new File(downDir);
	        if(!fdir.exists()){
	        	fdir.mkdirs();
	        }
			return downDir;
		}
		return null;
    }
    
    public static String getDownTempDir(){
		String appPath = getAppDir();
		if(appPath != null){
			String downDir = appPath+File.separator + APP_TEMP_DIR_DOWN;
	        File fdir = new File(downDir);
	        if(!fdir.exists()){
	        	fdir.mkdirs();
	        }
			return downDir;
		}
		return null;
    }
    
    
    public static String getRingDownLoadDir(){
		String appPath = getAppDir();
		if(appPath != null){
			String downDir = appPath+File.separator + APP_RINGDOWN_DIR_NAME;
	        File fdir = new File(downDir);
	        if(!fdir.exists()){
	        	fdir.mkdirs();
	        }
			return downDir;
		}
		return null;
    }
    
    public static String getTempDir(){
		String appPath = getAppDir();
		if(appPath != null){
			String downDir = appPath+File.separator + APP_TEMP_DIR_NAME;
	        File fdir = new File(downDir);
	        if(!fdir.exists()){
	        	fdir.mkdirs();
	        }
			return downDir;
		}
		return null;
    }

    /**
	 * 获取图片下载路劲
	 * @return
     */
    public static String getImageDir(){
		String appPath = getAppDir();
		if(appPath != null){
			String downDir = appPath+File.separator + APP_IMAGE_DIR_NAME;
	        File fdir = new File(downDir);
	        if(!fdir.exists()){
	        	fdir.mkdirs();
	        }
			return downDir;
		}
		return null;
    }
    
    
    public static String getLogDir(){
		String appPath = getAppDir();
		if(appPath != null){
			String downDir = appPath+File.separator + APP_LOG_DIR_NAME;
	        File fdir = new File(downDir);
	        if(!fdir.exists()){
	        	fdir.mkdirs();
	        }
			return downDir;
		}
		return null;
    }
    
    
    public static String getLogFilePath(String logName){
		String logPath = getLogDir();
		if(logPath != null){
			logPath += File.separator + logName;
			return logPath;
		}
		return null;
    }

    /**
	 * 获取语音路劲
	 * @return
     */
    public static String getRecordDir(){
		String appPath = getAppDir();
		if(appPath != null){
			String downDir = appPath+File.separator + APP_RECORD_DIR_NAME;
	        File fdir = new File(downDir);
	        if(!fdir.exists() || !fdir.isDirectory()){
	        	fdir.mkdirs();
	        }
			return downDir;
		}
		return null;
    }
    
    public static String getRecordPath(String fileName){
    	String dir = getRecordDir();
    	if(dir != null){
    		dir += File.separator + fileName;
    	}
    	return dir;
    }
    
    
    public static String createNewRecordPath(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    	String fileName = dateFormat.format(new Date()) + ".amr";
    	return getRecordPath(fileName);
    }

	public static String createNewImageName(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = dateFormat.format(new Date()) + ".jpg";
		return fileName;
	}

	public static String getVideoDir(){
		String appPath = getAppDir();
		if(appPath != null){
			String downDir = appPath+File.separator + APP_VIDEO_DIR_NAME;
			File fdir = new File(downDir);
			if(!fdir.exists() || !fdir.isDirectory()){
				fdir.mkdirs();
			}
			return downDir;
		}
		return null;
	}


	public static String getVideoPath(String fileName){
		String dir = getVideoDir();
		if(dir != null){
			dir += File.separator + fileName;
		}
		return dir;
	}


	public static String createNewVideoPath(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = dateFormat.format(new Date()) + ".mp4";
		return getVideoPath(fileName);
	}
    
    public static File createTempFile(String name){
		String path = getTempDir();
		if(path != null){
			path += File.separator+name;
			File f = new File(name);
			if(f.exists()){
				f.delete();
			}
			return f;
		}
		return null;
    }
    
    public static String getImagePath(String name){
		String path = getImageDir();
		if(path != null){
			path += File.separator+name;
		}
		return path;
    }
    
    public static String getTempPath(String name){
		String path = getTempDir();
		if(path != null){
			path += File.separator+name;
		}
		return path;
    }
    
    public static String getDownLoadPath(String fileName){
		String dir = getDownLoadDir();
		if(dir != null){
			return dir + File.separator + fileName;
		}
		return null;
    }
    
    public static String getRingDownLoadPath(String fileName){
		String dir = getRingDownLoadDir();
		if(dir != null){
			return dir + File.separator + fileName;
		}
		return null;
    }
	public static String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);//判断SD卡是否可用
		if (sdCardExist) {
			//如果SD卡可用     我们获取到他的根目录
			sdDir = Environment.getExternalStorageDirectory();
		}
		if(sdDir == null){
			return null;
		}
		if(!sdDir.canWrite()){
			return null;
		}
		return sdDir.toString();       
	} 
    
    public static String randomFileName(int length) {
    	
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String filename = sfd.format(new Date());
    	if(length < 14){
    		return filename;
    	}
    	filename += randomString(length - 14);
		
        return filename;
    }
    public static String randomFileName() {
		SimpleDateFormat sfd = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String filename = sfd.format(new Date());		
        return filename;
    }
    
	public static File createDownTempFile(int threadId) throws IOException {
		String path = getTempDir();
		if (path != null) {
			path += File.separator + randomString(10);
			path += ".tmp";
			int i = 0;
			while (i < 50) {
				File f = new File(path);
				if (!f.exists()) {
					f.createNewFile();
					return f;
				}
				i++;
			}
		}
		return null;
	}

	public static String randomString(int length) {
		if (length < 1) {
			return null;
		}
		// Create a char buffer to put random letters and numbers in.
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}
	
	public static String getRealFilePath( final Context context, final Uri uri ) {
	    if ( null == uri ) return null;
	    final String scheme = uri.getScheme();
	    String data = null;
	    if ( scheme == null )
	        data = uri.getPath();
	    else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
	        data = uri.getPath();
	    } else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
	        Cursor cursor = context.getContentResolver().query( uri, new String[] { ImageColumns.DATA }, null, null, null );
	        if ( null != cursor ) {
	            if ( cursor.moveToFirst() ) {
	                int index = cursor.getColumnIndex( ImageColumns.DATA );
	                if ( index > -1 ) {
	                    data = cursor.getString( index );
	                }
	            }
	            cursor.close();
	        }
	    }
	    return data;
	}

	public static int saveBitmap(Bitmap bm) {
//		Log.e("", "保存图片");
		try {
			if (!isFileExist("")) {
				File tempf = createSDDir("");
			}
			String fileName = FileUtils.randomFileName() + ".jpg";
			File f = new File(getImageDir() + File.separator + fileName);
			if (f.exists()) {
				f.delete();
			}
			FileOutputStream out = new FileOutputStream(f);
			bm.compress(Bitmap.CompressFormat.JPEG, 90, out);
			out.flush();
			out.close();
//			Log.e("", "已经保存");
			return 0;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static String saveVideoBitmap(Bitmap bm){
		String fileName = null;
//		Log.e("", "保存图片");
		try {
			if (!isFileExist("")) {
				File tempf = createSDDir("");
			}
			fileName = FileUtils.randomFileName() + ".jpg";
			File f = new File(getImageDir() + File.separator + fileName);
			if (f.exists()) {
				f.delete();
			}
			FileOutputStream out = new FileOutputStream(f);
			bm.compress(Bitmap.CompressFormat.JPEG, 90, out);
			out.flush();
			out.close();
//			Log.e("", "已经保存");
			return f.getPath();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static File createSDDir(String dirName) throws IOException {
		File dir = new File(SDPATH + dirName);
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {

			System.out.println("createSDDir:" + dir.getAbsolutePath());
			System.out.println("createSDDir:" + dir.mkdir());
		}
		return dir;
	}

	public static boolean isFileExist(String fileName) {
		File file = new File(SDPATH + fileName);
		file.isFile();
		return file.exists();
	}

	public static void delFile(String fileName){
		File file = new File(SDPATH + fileName);
		if(file.isFile()){
			file.delete();
		}
		file.exists();
	}

	public static void deleteDir() {
		File dir = new File(SDPATH);
		if (dir == null || !dir.exists() || !dir.isDirectory())
			return;

		for (File file : dir.listFiles()) {
			if (file.isFile())
				file.delete(); // 删除所有文件
			else if (file.isDirectory())
				deleteDir(); // 递规的方式删除文件夹
		}
		dir.delete();// 删除目录本身
	}

	public static boolean fileIsExists(String path) {
		try {
			File f = new File(path);
			if (!f.exists()) {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
		return true;
	}

	public static boolean DeleteFileOrDirectory(File FileOrDirectory) {
		if (FileOrDirectory.exists()) {
			if (FileOrDirectory.isFile()) {
				FileOrDirectory.delete();
			} else if (FileOrDirectory.isDirectory()) {
				File files[] = FileOrDirectory.listFiles();
				for (int i = 0; i < files.length; i++) {
					DeleteFileOrDirectory(files[i]);
				}
			}
		}
		return FileOrDirectory.exists();
	}

	public static long getFileSizes(File f) throws Exception {
		long s = 0;
		if (f.exists()) {
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			s = fis.available();
			fis.close();
		} else {
			f.createNewFile();
			System.out.println("文件夹不存在");
		}
		return s;
	}

	public static String getRealPathFromURI(Context context, Uri contentURI) {
		String result;
		Cursor cursor = context.getContentResolver().query(contentURI, null, null, null, null);
		if (cursor == null) { // Source is Dropbox or other similar local file path
			result = contentURI.getPath();
		} else {
			cursor.moveToFirst();
			int idx = cursor.getColumnIndex(ImageColumns.DATA);
			result = cursor.getString(idx);
			cursor.close();
		}
		return result;
	}
}
