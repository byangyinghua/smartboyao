package com.guinong.lib_utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

public class ImageUtil {

    public static InputStream getRequest(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        if (conn.getResponseCode() == 200) {
            return conn.getInputStream();
        }
        return null;
    }

    public static Bitmap getBitmapFromFile(String path) {
        //Log.e("jjyuan", "getBitmapFromFile path:" + path);
        return BitmapFactory.decodeFile(path);
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }

    public static Drawable loadImageFromUrl(String url) {
        URL m;
        InputStream i = null;
        try {
            m = new URL(url);
            i = (InputStream) m.getContent();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream(i, "src");
        return d;
    }

    public static Drawable getDrawableFromUrl(String url) throws Exception {
        return Drawable.createFromStream(getRequest(url), null);
    }

    public static Bitmap getBitmapFromUrl(String url) throws Exception {
        byte[] bytes = getBytesFromUrl(url);
        return byteToBitmap(bytes);
    }

    public static Bitmap getRoundBitmapFromUrl(String url, int pixels)
            throws Exception {
        byte[] bytes = getBytesFromUrl(url);
        Bitmap bitmap = byteToBitmap(bytes);
        return toRoundCorner(bitmap, pixels);
    }

    public static Drawable geRoundDrawableFromUrl(String url, int pixels)
            throws Exception {
        byte[] bytes = getBytesFromUrl(url);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) byteToDrawable(bytes);
        return toRoundCorner(bitmapDrawable, pixels);
    }

    public static byte[] getBytesFromUrl(String url) throws Exception {
        return readInputStream(getRequest(url));
    }

    public static Bitmap byteToBitmap(byte[] byteArray) {
        if (byteArray.length > 0) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            if(bitmap != null){
                return bitmap;
            }
        }
        return null;
    }

    public static Drawable byteToDrawable(byte[] byteArray) {
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }

    public static byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {

        Bitmap bitmap = Bitmap
                .createBitmap(
                        drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight(),
                        drawable.getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_8888
                                : Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 图片去色,返回灰度图片
     *
     * @param bmpOriginal 传入的图片
     * @return 去色后的图片
     */
    public static Bitmap toGrayscale(Bitmap bmpOriginal) {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }

    /**
     * 去色同时加圆角
     *
     * @param bmpOriginal 原图
     * @param pixels      圆角弧度
     * @return 修改后的图片
     */
    public static Bitmap toGrayscale(Bitmap bmpOriginal, int pixels) {
        return toRoundCorner(toGrayscale(bmpOriginal), pixels);
    }

    /**
     * 把图片变成圆角
     *
     * @param bitmap 需要修改的图片
     * @param pixels 圆角的弧度
     * @return 圆角图片
     */
    public static Bitmap toRoundCorner(Bitmap bitmap, float pixels) {

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    /**
     * 根据原图和变长绘制圆形图片
     *
     * @param source
     * @param min
     * @return
     */
    public static Bitmap createCircleImage(Bitmap source, int min) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        /**
         * 产生一个同样大小的画布
         */
        Canvas canvas = new Canvas(target);
        /**
         * 首先绘制圆形
         */
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        /**
         * 使用SRC_IN，参考上面的说明
         */
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        /**
         * 绘制图片
         */
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }

    /**
     * 使圆角功能支持BitampDrawable
     *
     * @param bitmapDrawable
     * @param pixels
     * @return
     */
    @SuppressWarnings("deprecation")
    public static BitmapDrawable toRoundCorner(BitmapDrawable bitmapDrawable, float pixels) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        bitmapDrawable = new BitmapDrawable(toRoundCorner(bitmap, pixels));
        return bitmapDrawable;
    }

    /*
     * 返回文件的大小，0存储失败
     */
    public static long saveBitmapToFile(String path, Bitmap bmp) {
        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(path);
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.close();
                return file.length();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static long saveBitmapsys(String path, Bitmap bmp,String fileName,Context context){
        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(path);
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.close();
                MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
                // 最后通知图库更新
                context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
                return file.length();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return -1;
    }

    /**
     * 从服务器取图片
     *
     * @param url
     * @return
     */
    public static Bitmap getHttpBitmap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) myFileUrl
                    .openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestMethod("GET");
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static Bitmap revitionImageSize(Uri path, int size, Context c)
            throws IOException {
        // 取得图片
        InputStream temp = c.getContentResolver().openInputStream(path);
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 这个参数代表，不为bitmap分配内存空间，只记录一些该图片的信息（例如图片大小），说白了就是为了内存优化
        options.inJustDecodeBounds = true;
        // 通过创建图片的方式，取得options的内容（这里就是利用了java的地址传递来赋值）
        BitmapFactory.decodeStream(temp, null, options);
        // 关闭流
        temp.close();
        // 生成压缩的图片
        int i = 0;
        Bitmap bitmap = null;
        while (true) {
            // 这一步是根据要设置的大小，使宽和高都能满足
            if ((options.outWidth >> i <= size)
                    && (options.outHeight >> i <= size)) {
                // 重新取得流，注意：这里一定要再次加载，不能二次使用之前的流！
                temp = c.getContentResolver().openInputStream(path);
                // 这个参数表示 新生成的图片为原始图片的几分之一。
                options.inSampleSize = (int) Math.pow(2.0D, i);
                // 这里之前设置为了true，所以要改为false，否则就创建不出图片
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeStream(temp, null, options);
                break;
            }
            i += 1;
        }
        return bitmap;
    }

    public static Bitmap revitionImageSize2(Uri path, int size, Context c) throws IOException {
        Bitmap bitmap = null;
        // 取得图片
        InputStream temp = c.getContentResolver().openInputStream(path);
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 这个参数代表，不为bitmap分配内存空间，只记录一些该图片的信息（例如图片大小），说白了就是为了内存优化
        options.inJustDecodeBounds = true;
        // 通过创建图片的方式，取得options的内容（这里就是利用了java的地址传递来赋值）
        BitmapFactory.decodeStream(temp, null, options);
        // 关闭流
        temp.close();

        //对最大值在30%的范围上，且小于1300，针对进行再一次的压缩
        double sizedoubletemp = ((double) size) * 1.3;
        int sizetemp = (int) Math.ceil(sizedoubletemp);

        // 生成压缩的图片
        int i = 0;
        while (true) {
            // 这一步是根据要设置的大小，使宽和高都能满足
            if ((options.outWidth >> i <= size) && (options.outHeight >> i <= size)) {
                // 重新取得流，注意：这里一定要再次加载，不能二次使用之前的流！
                temp = c.getContentResolver().openInputStream(path);
                // 这个参数表示 新生成的图片为原始图片的几分之一。
                options.inSampleSize = (int) Math.pow(2.0D, i);
                // 这里之前设置为了true，所以要改为false，否则就创建不出图片
                options.inJustDecodeBounds = false;

                bitmap = BitmapFactory.decodeStream(temp, null, options);
                break;
            }

            int nowwidth = options.outWidth >> i;
            int nowheight = options.outHeight >> i;

            //超过一定像素的，不再处理。
            if (size <= 1000 && sizetemp <= 1310) {
                int maxnum = nowwidth > nowheight ? nowwidth : nowheight;
                if (maxnum < sizetemp && maxnum >= size) {//在这个范围，不用再进行下一次二分之一压缩
                    // 重新取得流，注意：这里一定要再次加载，不能二次使用之前的流！
                    temp = c.getContentResolver().openInputStream(path);
                    // 这个参数表示 新生成的图片为原始图片的几分之一。
                    options.inSampleSize = (int) Math.pow(2.0D, i);
                    // 这里之前设置为了true，所以要改为false，否则就创建不出图片
                    options.inJustDecodeBounds = false;
                    bitmap = BitmapFactory.decodeStream(temp, null, options);
                    int x = bitmap.getWidth();
                    int y = bitmap.getHeight();
                    int tempint = x > y ? x : y;
                    //压缩到输入大小的50%
                    double scaledoubletemp = ((double) size) * 0.9;
                    int scaletemp = (int) Math.ceil(scaledoubletemp);
                    //直接压缩到指定比例
                    float scale = (float) scaletemp / tempint;
                    Matrix matrix = new Matrix();
                    matrix.postScale(scale, scale);//缩放比例
                    Bitmap lastbitmap = Bitmap.createBitmap(bitmap, 0, 0, x, y, matrix, true);
                    return lastbitmap;
                }
            }
            i += 1;
        }

        return bitmap;
    }


    public static Bitmap compressImage(Uri uri, Context context) {
        Bitmap photo = null;
        try {
            ContentResolver resolver = context.getContentResolver();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(resolver.openInputStream(uri), null, options);
            if (options.outHeight >= 2400 || options.outWidth > 2400) {
                BitmapFactory.Options options1 = new BitmapFactory.Options();
                options1.inSampleSize = 3;//图片大小，设置越大，图片越不清晰，占用空间越小
                try {
                    photo = BitmapFactory.decodeStream(resolver.openInputStream(uri), null, options1);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    System.gc();
                }

            } else if (options.outHeight >= 1200 || options.outWidth > 1600) {
                BitmapFactory.Options options1 = new BitmapFactory.Options();
                options1.inSampleSize = 2;//图片大小，设置越大，图片越不清晰，占用空间越小
                try {
                    photo = BitmapFactory.decodeStream(resolver.openInputStream(uri), null, options1);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    System.gc();
                }

            } else {
                BitmapFactory.Options options1 = new BitmapFactory.Options();
                try {
                    photo = BitmapFactory.decodeStream(resolver.openInputStream(uri), null, options1);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    System.gc();
                }
            }
            return photo;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static Bitmap compress(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 80, baos);
        if(image==null||baos.toByteArray().length / 1024 <= 100){
            return image;//如果图片本身的大小已经小于这个大小了，就没必要进行压缩
        }
        int options = 80;
        while (baos.toByteArray().length / 1024 > 200) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            options -= 20;//每次都减少10
            baos.reset();//重置baos即清空baos
            if(options <= 0){
                break;
            }
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
        }
        ByteArrayInputStream isBm =  new  ByteArrayInputStream(baos.toByteArray()); // 把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(isBm,  null ,  null ); // 把ByteArrayInputStream数据生成图片
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
        }
        return bitmap;//压缩好比例大小后再进行质量压缩
    }

    /**
     * 生成视频缩略图
     * @param videoPath
     * @param width
     * @param height
     * @param kind
     * @return
     */
    public static Bitmap getVideoThumbnail(String videoPath, int width, int height, int kind) {
        Bitmap bitmap = null;
        try {
            // 获取视频的缩略图
            bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, kind);
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
            return bitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
            bitmap = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap decodeSampleFromSD(String path){
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeFile(path, options);
        //options.inSampleSize=calculateInSampleSize(options, sdwidth, sdheight);
        options.inJustDecodeBounds=false;
        options.inDither=false;
        options.inPreferredConfig= Config.ARGB_8888;
        return BitmapFactory.decodeFile(path, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,  int reqWidth, int reqHeight) {
        // 源图片的高度和宽度
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高           // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId) {
        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        // 调用上面定义的方法计算inSampleSize值
        int reqWidth = 480;
        int reqHeight = 512;
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // 使用获取到的inSampleSize值再次解析图片
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    public static Bitmap decodeSampledBitmapFromPath(String path ,int with,int hight) {
        // 获得图片的宽和高，并不把图片加载到内存中
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inSampleSize = ImageSizeUtil.caculateInSampleSize(options, with, hight);
        // 使用获得到的InSampleSize再次解析图片
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        return bitmap;
    }


    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }

    public static Bitmap getSdkBitmapByStream(String path){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            Bitmap bitmap=BitmapFactory.decodeStream(fis);
            return bitmap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap resizeImage(Bitmap bitmap, int w, int h) {
        Bitmap BitmapOrg = bitmap;
        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        int newWidth = w;
        int newHeight = h;

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = null;
        try {
            resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if(resizedBitmap != null && !resizedBitmap.isRecycled()){
                resizedBitmap.recycle();
                resizedBitmap = null;
                System.gc();
            }
        }
        return resizedBitmap;
    }

    public static int[] adjustImageSize(int theimgwidth, int theimgheight, int defwidth, int defheight) {
        int[] size = { 0, 0 };
        if(defwidth > 0 && defheight > 0){
            double dstscale = (double)defwidth / defheight;
            double srcscale = (double)theimgwidth / theimgheight ;
            if(srcscale > dstscale){//长图片，以最小高度算。
                // 新生成的缩略图像的长度
                size[0] = (int) Math.round(defheight * theimgwidth / theimgheight);
                // 新生成的缩略图像的宽度
                size[1] = defheight;
            }else{
                // 新生成的缩略图像的长度
                size[0] = defwidth;
                // 新生成的缩略图像的宽度
                size[1] = Math.round(defwidth * theimgheight / theimgwidth);
            }
        } else if(defheight > 0){
            // 新生成的缩略图像的长度
            size[0] = (int) Math.round(defheight * theimgwidth / theimgheight);
            // 新生成的缩略图像的宽度
            size[1] = defheight;
        } else if(defwidth > 0){
            // 新生成的缩略图像的长度
            size[0] = defwidth;
            // 新生成的缩略图像的宽度
            size[1] = Math.round(defwidth * theimgheight / theimgwidth);
        }
        return size;
    }

    /**
     * 相片按相框的比例动态缩放
     * @param context
     * @param width 模板宽度
     * @param height 模板高度
     * @return
     */
    public static Bitmap upImageSize(Context context,Bitmap bmp, int width,int height) {
        if(bmp==null){
            return null;
        }
        // 计算比例
        float scaleX = (float)width / bmp.getWidth();// 宽的比例
        float scaleY = (float)height / bmp.getHeight();// 高的比例
        //新的宽高
        int newW = 0;
        int newH = 0;
        if(scaleX > scaleY){
            newW = (int) (bmp.getWidth() * scaleX);
            newH = (int) (bmp.getHeight() * scaleX);
        }else if(scaleX <= scaleY){
            newW = (int) (bmp.getWidth() * scaleY);
            newH = (int) (bmp.getHeight() * scaleY);
        }
        return Bitmap.createScaledBitmap(bmp, newW, newH, true);
    }


    public static String getPicNameFromPath(String picturePath){
        String temp[] = picturePath.replaceAll("\\\\","/").split("/");
        String fileName = "";
        if(temp.length > 1){
            fileName = temp[temp.length - 1];
        }
        return fileName;
    }

    /**
     * @Description 得到文件所在路径（即全路径去掉完整文件名）
     * @param filepath 文件全路径名称，like mnt/sda/XX.xx
     * @return 根路径，like mnt/sda
     */
    public static String getPathFromFilepath(final String filepath) {
        int pos = filepath.lastIndexOf('/');
        if (pos != -1) {
            return filepath.substring(0, pos);
        }
        return "";
    }

    /**
     * @Description 重新整合路径，将路径一和路径二通过'/'连接起来得到新路径
     * @param path1 路径一
     * @param path2 路径二
     * @return 新路径
     */
    public static String makePath(final String path1, final String path2) {
        if (path1.endsWith(File.separator)) {
            return path1 + path2;
        }
        return path1 + File.separator + path2;
    }

    /**
     *  @Description 对文件进行重新命名
     *  @return 是否修改成功
     */
    public static boolean rename(String oldPath, String newPath,String fileName,Context mContext) {
        //1.判断参数阈值
        if (oldPath == null || newPath == null) {
            return false;
        }
        //4.比较是否变更了名称
        if (oldPath.endsWith(newPath)) { //和原来名称一样，不需要改变
            return true;
        }
        try {
            //5.根据新路径得到File类型数据
            File newFile = new File(newPath);
            //6.判断是否已经存在同样名称的文件（即出现重名）
            if (newFile.exists()) { //出现重命名且不允许生成副本名
                return false; //重命名失败
            }
            //8.得到原文件File类型数据
            File file = new File(oldPath);
            //9.调用固有方法去重命名
            boolean ret = file.renameTo(newFile);
            if (ret) {
                //FIXME:这里通过更改形参来改变实参，是不好的写法，不建议这样写！
                try {
                    MediaStore.Images.Media.insertImage(mContext.getContentResolver(), file.getAbsolutePath(), fileName, null);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                // 最后通知图库更新
                mContext.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + newPath)));
                mContext.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + oldPath)));
            }
            return ret;
        } catch (SecurityException e) {
        }
        return false;
    }


    public static final int SIZETYPE_B = 1;// 获取文件大小单位为B的double值
    public static final int SIZETYPE_KB = 2;// 获取文件大小单位为KB的double值
    public static final int SIZETYPE_MB = 3;// 获取文件大小单位为MB的double值
    public static final int SIZETYPE_GB = 4;// 获取文件大小单位为GB的double值
    /**
     * 获取文件指定文件的指定单位的大小
     *
     * @param filePath
     *            文件路径
     *            获取大小的类型1为B、2为KB、3为MB、4为GB
     * @return double值的大小
     */
    public static String getFileOrFilesSize(String filePath) {
        File file = new File(filePath);
        long blockSize = 0;
        try {
            if (file.isDirectory()) {
                blockSize = getFileSizes(file);
            } else {
                blockSize = getFileSize(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("获取文件大小", "获取失败!");
        }
        return formatFileSize(blockSize);
    }
    /**
     * 调用此方法自动计算指定文件或指定文件夹的大小
     *
     * @param filePath
     *            文件路径
     * @return 计算好的带B、KB、MB、GB的字符串
     */
    public static String getAutoFileOrFilesSize(String filePath) {
        File file = new File(filePath);
        long blockSize = 0;
        try {
            if (file.isDirectory()) {
                blockSize = getFileSizes(file);
            } else {
                blockSize = getFileSize(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("获取文件大小", "获取失败!");
        }
        return formatFileSize(blockSize);
    }
    /**
     * 获取指定文件大小
     *
     * @param
     * @return
     * @throws Exception
     */
    private static long getFileSize(File file) throws Exception {
        long size = 0;
        if (file.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        } else {
            file.createNewFile();
            Log.e("获取文件大小", "文件不存在!");
        }
        return size;
    }
    /**
     * 获取指定文件夹
     *
     * @param f
     * @return
     * @throws Exception
     */
    private static long getFileSizes(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSizes(flist[i]);
            } else {
                size = size + getFileSize(flist[i]);
            }
        }
        return size;
    }
    /**
     * 转换文件大小
     *
     * @param fileS
     * @return
     */
    private static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize = "0B";
        if (fileS == 0) {
            return wrongSize;
        }
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }
    /**
     * 转换文件大小,指定转换的类型
     *
     * @param fileS
     * @return
     */
    private static String formatFileSize(long fileS)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize="0B";
        if(fileS==0){
            return wrongSize;
        }
        if (fileS < 1024){
            fileSizeString = df.format((double) fileS) + "B";
        }
        else if (fileS < 1048576){
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        }
        else if (fileS < 1073741824){
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        }
        else{
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }

        if (fileS < 1048576*2) { // 限制图片大小不能大于2MB
            return fileSizeString;
        }
        return null;

    }

}
