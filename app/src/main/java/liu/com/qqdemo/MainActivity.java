package liu.com.qqdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import liu.com.qqdemo.activity.BaseActivity;
import liu.com.qqdemo.fragment.ContactFragment;
import liu.com.qqdemo.fragment.ConversionFragment;
import liu.com.qqdemo.fragment.DongtaiFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_tab_contact;
    private ImageView iv_tab_conversion;
    private ImageView iv_tab_dongtai;
    private TextView tv_title;
    private int currentSelectId;
    private DongtaiFragment dongtaiFragment;
    private ContactFragment contactFragment;
    private ConversionFragment conversionFragment;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        iv_tab_contact = (ImageView) findViewById(R.id.iv_tab_contact);
        iv_tab_conversion = (ImageView) findViewById(R.id.iv_tab_conversion);
        iv_tab_dongtai = (ImageView) findViewById(R.id.iv_tab_dongtai);
        tv_title = (TextView) findViewById(R.id.tv_title);

        iv_tab_contact.setOnClickListener(this);
        iv_tab_conversion.setOnClickListener(this);
        iv_tab_dongtai.setOnClickListener(this);

    }
    @Override
    protected void initData() {
        dongtaiFragment = new DongtaiFragment();
        contactFragment = new ContactFragment();
        conversionFragment = new ConversionFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.fl_content, dongtaiFragment);
        beginTransaction.commit();
        iv_tab_dongtai.setSelected(true);
        tv_title.setText("动态");
        currentSelectId = R.id.iv_tab_dongtai;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==currentSelectId) {
            return;
        }
        currentSelectId = v.getId();
        iv_tab_contact.setSelected(v.getId()==R.id.iv_tab_contact);
        iv_tab_conversion.setSelected(v.getId()==R.id.iv_tab_conversion);
        iv_tab_dongtai.setSelected(v.getId()==R.id.iv_tab_dongtai);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.iv_tab_conversion:
                beginTransaction.replace(R.id.fl_content, conversionFragment);
                tv_title.setText("消息");
                break;
            case R.id.iv_tab_contact:
                beginTransaction.replace(R.id.fl_content, contactFragment);
                tv_title.setText("联系人");
                break;
            case R.id.iv_tab_dongtai:
                beginTransaction.replace(R.id.fl_content, dongtaiFragment);
                tv_title.setText("动态");
                break;

            default:
                break;
        }
        beginTransaction.commit();
    }



}
