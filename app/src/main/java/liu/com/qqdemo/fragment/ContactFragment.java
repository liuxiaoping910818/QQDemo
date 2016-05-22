package liu.com.qqdemo.fragment;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import liu.com.qqdemo.R;

/**
 * Created by Administrator on 2016/5/22.
 */
public class ContactFragment extends BaseFragment {

    private LinearLayout ll_new_group;
    private LinearLayout ll_new_frient;
    private ExpandableListView listView;

    protected View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_contact, null);
        listView = (ExpandableListView) view.findViewById(R.id.lv_contact);
        ll_new_frient = (LinearLayout) view.findViewById(R.id.ll_new_frined);
        ll_new_group = (LinearLayout) view.findViewById(R.id.ll_new_group);

        return view;
    }
    protected void initData() {

    }
}

