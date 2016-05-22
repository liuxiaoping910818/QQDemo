package liu.com.qqdemo.activity;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import liu.com.qqdemo.Const;
import liu.com.qqdemo.MainActivity;
import liu.com.qqdemo.utils.ActivityUtils;

public abstract class BaseActivity extends FragmentActivity {

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case Const.MSG_SPLASH:
                    ActivityUtils.startActivity(BaseActivity.this, LoginActivity.class, true);
                    break;
                case Const.MSG_LOGIN_SUCCESS:
                    Toast.makeText(BaseActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    ActivityUtils.startActivity(BaseActivity.this, MainActivity.class, true);
                    break;
                case Const.MSG_LOGIN_ERROR:
                    Toast.makeText(BaseActivity.this, "登录失败" + msg.obj, Toast.LENGTH_SHORT).show();
                    break;
                case Const.MSG_REGIST_SUCCESS:
                    Toast.makeText(BaseActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    ActivityUtils.startActivity(BaseActivity.this, LoginActivity.class, true);
                    break;
                case Const.MSG_REGIST_ERROR:
                    Toast.makeText(BaseActivity.this, "注册失败" + msg.obj, Toast.LENGTH_SHORT).show();
                    break;


                default:
                    break;
            }
        };
    };

    private SharedPreferences sp;

    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences(Const.SP_NAME, MODE_PRIVATE);
        initView();
        initData();
    }

    /**
     * 保存数据到sp文件中
     *
     * @param key
     * @param value
     */
    protected void saveData(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 根据sp中的key获取数据，如果不存在则返回null
     *
     * @param key
     * @return
     */
    protected String getSPData(String key) {
        return sp.getString(key, null);
    }

    /**
     * 初始化数据，在initView之后被主线程调用
     */
    protected void initData() {

    }

    public abstract void initView();
}
