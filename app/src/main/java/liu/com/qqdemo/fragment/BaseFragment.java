package liu.com.qqdemo.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import liu.com.qqdemo.Const;

/**
 * Created by Administrator on 2016/5/22.
 */
public class BaseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=initView();
        initData();
        return view;
    }

    private void initData() {

    }

    private View initView() {

        TextView textView=new TextView(getActivity());

        textView.setText(this.getClass().getSimpleName());

        return textView;
    }

    protected String getSPData(){

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences(Const.SP_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(Const.SP_KEY_NAME,null);
    }
}
