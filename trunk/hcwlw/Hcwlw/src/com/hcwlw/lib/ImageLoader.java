package com.hcwlw.lib;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;  
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
  
/** 
 * 对图片进行管理的工具类。 
 *  
 * @author Tony 
 */  
public class ImageLoader {  
  
    /** 
     * 图片缓存技术的核心类，用于缓存所有下载好的图片，在程序内存达到设定值时会将最少最近使用的图片移除掉。 
     */  
    private static LruCache<String, Bitmap> mMemoryCache;  
  
    /** 
     * ImageLoader的实例。 
     */  
    private static ImageLoader mImageLoader;  
      
    /** 
     * 所有图片url 
     */  
    public final static String[] imageUrls = new String[] {  
    	"http://www.linuxidc.com/upload/2013_09/1378037235_3453.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037235_7476.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037235_9280.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037234_3539.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037234_6318.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037194_2965.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037193_1687.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037193_1286.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037192_8379.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037178_9374.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037177_1254.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037177_6203.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037152_6352.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037151_9565.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037151_7904.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037148_7104.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037129_8825.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037128_5291.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037128_3531.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037127_1085.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037095_7515.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037094_8001.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037093_7168.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1378037091_4950.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949643_6410.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949642_6939.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949630_4505.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949630_4593.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949629_7309.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949629_8247.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949615_1986.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949614_8482.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949614_3743.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949614_4199.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949599_3416.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949599_5269.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949598_7858.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949598_9982.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949578_2770.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949578_8744.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949577_5210.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949577_1998.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949482_8813.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949481_6577.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949480_4490.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949455_6792.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949455_6345.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949442_4553.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949441_8987.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949441_5454.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949454_6367.jpg",
    	   "http://www.linuxidc.com/upload/2013_09/1377949442_4562.jpg" };  
      
	private ImageLoader() {  
        // 获取应用程序最大可用内存  
        int maxMemory = (int) Runtime.getRuntime().maxMemory();  
        int cacheSize = maxMemory / 8;  
        // 设置图片缓存大小为程序最大可用内存的1/8  
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {  
            @Override  
            protected int sizeOf(String key, Bitmap bitmap) {  
            	return bitmap.getRowBytes()*bitmap.getHeight();
                //return bitmap.getByteCount();  
            }  
        };  
    }  
  
    /** 
     * 获取ImageLoader的实例。 
     *  
     * @return ImageLoader的实例。 
     */  
    public static ImageLoader getInstance() {  
        if (mImageLoader == null) {  
            mImageLoader = new ImageLoader();  
        }  
        return mImageLoader;  
    }  
  
    /** 
     * 将一张图片存储到LruCache中。 
     *  
     * @param key 
     *            LruCache的键，这里传入图片的URL地址。 
     * @param bitmap 
     *            LruCache的键，这里传入从网络上下载的Bitmap对象。 
     */  
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {  
        if (getBitmapFromMemoryCache(key) == null) {  
            mMemoryCache.put(key, bitmap);  
        }  
    }  
  
    /** 
     * 从LruCache中获取一张图片，如果不存在就返回null。 
     *  
     * @param key 
     *            LruCache的键，这里传入图片的URL地址。 
     * @return 对应传入键的Bitmap对象，或者null。 
     */  
	public Bitmap getBitmapFromMemoryCache(String key) {  
        return mMemoryCache.get(key);  
    }  
  
    public static int calculateInSampleSize(BitmapFactory.Options options,  
            int reqWidth) {  
        // 源图片的宽度  
        final int width = options.outWidth;  
        int inSampleSize = 1;  
        if (width > reqWidth) {  
            // 计算出实际宽度和目标宽度的比率  
            final int widthRatio = Math.round((float) width / (float) reqWidth);  
            inSampleSize = widthRatio;  
        }  
        return inSampleSize;  
    }  
  
    public static Bitmap decodeSampledBitmapFromResource(String pathName,  
            int reqWidth) {  
        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小  
        final BitmapFactory.Options options = new BitmapFactory.Options();  
        options.inJustDecodeBounds = true;  
        BitmapFactory.decodeFile(pathName, options);  
        // 调用上面定义的方法计算inSampleSize值  
        options.inSampleSize = calculateInSampleSize(options, reqWidth);  
        // 使用获取到的inSampleSize值再次解析图片  
        options.inJustDecodeBounds = false;  
        return BitmapFactory.decodeFile(pathName, options);  
    }  
  
}  
