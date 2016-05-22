package liu.com.qqdemo.activity;

import android.widget.EditText;

import liu.com.qqdemo.R;

public class LoginActivity extends BaseActivity {

    private EditText et_name;
    private EditText et_pwd;
   // private XmppConnectionManager manager;
    @Override
    public void initView() {

        setContentView(R.layout.activity_login);
        et_name= (EditText) findViewById(R.id.et_name);
        et_pwd=(EditText) findViewById(R.id.et_pwd);
    }
    protected void initData(){


    }
}
