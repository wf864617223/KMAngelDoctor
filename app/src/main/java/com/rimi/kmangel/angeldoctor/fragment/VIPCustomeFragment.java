package com.rimi.kmangel.angeldoctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.rimi.kmangel.angeldoctor.R;
import com.rimi.kmangel.angeldoctor.activity.MyPatientActivity;
import com.rimi.kmangel.angeldoctor.utils.SPUtils;
import com.rimi.kmangel.angeldoctor.widget.RefreshLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Android on 2016/6/2.
 * 会员用户
 */
public class VIPCustomeFragment extends Fragment {

    @Bind(R.id.listview_frag)
    ListView mListView;
    @Bind(R.id.refresh_layout)
    RefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list,null);
        ButterKnife.bind(this,rootView);
        final MyPatientActivity thisActivity = new MyPatientActivity();
        final String DocCode  = (String) SPUtils.get(getActivity(),"doctor_code","code","");
        thisActivity.loadData("1", mListView, getActivity(),DocCode,null, "20",null);
        refreshLayout.setOnRefreshListener(new RefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                thisActivity.loadData("1", mListView, getActivity(),DocCode,null, "50",refreshLayout);
                refreshLayout.setRefreshing(false);
                Toast.makeText(getActivity(),"刷新成功",Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("result","fragment_ac create");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("result","fragment_resume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("result","fragment_start");
    }
}
