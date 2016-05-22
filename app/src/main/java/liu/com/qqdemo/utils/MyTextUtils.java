package liu.com.qqdemo.utils;

import android.text.TextUtils;

/**
 * Created by Administrator on 2016/5/22.
 */
public class MyTextUtils {

    public  static boolean isEmpty(String... params){

        for (String str:params){

            if (TextUtils.isEmpty(str)){
                return true;
            }

        }
        return false;
    }
}
