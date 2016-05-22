package liu.com.qqdemo.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2016/5/22.
 */
public class ActivityUtils {

    /**
     * 打开Activity
     * @param
     * @param clazz
     */
    public static void startActivity(Activity activityA,Class clazz){
        startActivity(activityA,clazz,false);
    };
    /**
     *
     * @param
     * @param isFinish
     */
    public static void startActivity(Activity activityA,Class clazz,boolean isFinish){
        Intent intent = new Intent(activityA, clazz);
        activityA.startActivity(intent);
        if (isFinish) {
            activityA.finish();
        }
    };
}
