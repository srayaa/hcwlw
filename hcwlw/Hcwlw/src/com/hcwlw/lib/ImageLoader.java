package com.hcwlw.lib;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;  
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
  
/** 
 * ��ͼƬ���й���Ĺ����ࡣ 
 *  
 * @author Tony 
 */  
public class ImageLoader {  
  
    /** 
     * ͼƬ���漼���ĺ����࣬���ڻ����������غõ�ͼƬ���ڳ����ڴ�ﵽ�趨ֵʱ�Ὣ�������ʹ�õ�ͼƬ�Ƴ����� 
     */  
    private static LruCache<String, Bitmap> mMemoryCache;  
  
    /** 
     * ImageLoader��ʵ���� 
     */  
    private static ImageLoader mImageLoader;  
      
    /** 
     * ����ͼƬurl 
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
        // ��ȡӦ�ó����������ڴ�  
        int maxMemory = (int) Runtime.getRuntime().maxMemory();  
        int cacheSize = maxMemory / 8;  
        // ����ͼƬ�����СΪ�����������ڴ��1/8  
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {  
            @Override  
            protected int sizeOf(String key, Bitmap bitmap) {  
            	return bitmap.getRowBytes()*bitmap.getHeight();
                //return bitmap.getByteCount();  
            }  
        };  
    }  
  
    /** 
     * ��ȡImageLoader��ʵ���� 
     *  
     * @return ImageLoader��ʵ���� 
     */  
    public static ImageLoader getInstance() {  
        if (mImageLoader == null) {  
            mImageLoader = new ImageLoader();  
        }  
        return mImageLoader;  
    }  
  
    /** 
     * ��һ��ͼƬ�洢��LruCache�С� 
     *  
     * @param key 
     *            LruCache�ļ������ﴫ��ͼƬ��URL��ַ�� 
     * @param bitmap 
     *            LruCache�ļ������ﴫ������������ص�Bitmap���� 
     */  
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {  
        if (getBitmapFromMemoryCache(key) == null) {  
            mMemoryCache.put(key, bitmap);  
        }  
    }  
  
    /** 
     * ��LruCache�л�ȡһ��ͼƬ����������ھͷ���null�� 
     *  
     * @param key 
     *            LruCache�ļ������ﴫ��ͼƬ��URL��ַ�� 
     * @return ��Ӧ�������Bitmap���󣬻���null�� 
     */  
	public Bitmap getBitmapFromMemoryCache(String key) {  
        return mMemoryCache.get(key);  
    }  
  
    public static int calculateInSampleSize(BitmapFactory.Options options,  
            int reqWidth) {  
        // ԴͼƬ�Ŀ��  
        final int width = options.outWidth;  
        int inSampleSize = 1;  
        if (width > reqWidth) {  
            // �����ʵ�ʿ�Ⱥ�Ŀ���ȵı���  
            final int widthRatio = Math.round((float) width / (float) reqWidth);  
            inSampleSize = widthRatio;  
        }  
        return inSampleSize;  
    }  
  
    public static Bitmap decodeSampledBitmapFromResource(String pathName,  
            int reqWidth) {  
        // ��һ�ν�����inJustDecodeBounds����Ϊtrue������ȡͼƬ��С  
        final BitmapFactory.Options options = new BitmapFactory.Options();  
        options.inJustDecodeBounds = true;  
        BitmapFactory.decodeFile(pathName, options);  
        // �������涨��ķ�������inSampleSizeֵ  
        options.inSampleSize = calculateInSampleSize(options, reqWidth);  
        // ʹ�û�ȡ����inSampleSizeֵ�ٴν���ͼƬ  
        options.inJustDecodeBounds = false;  
        return BitmapFactory.decodeFile(pathName, options);  
    }  
  
}  
