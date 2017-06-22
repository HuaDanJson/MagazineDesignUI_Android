package com.syc.a36_50ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContentFragment extends Fragment {

    //创建Fragment的方法
    public static Fragment newInstance(String msg) {
        Fragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("msg", msg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg);
        RecyclerView mRecyer = (RecyclerView) view.findViewById(R.id.recycler_view);

        //显示TextView的文本
        Bundle bundle = getArguments();
        String msg;
        if (bundle != null) {
            msg = bundle.getString("msg");
        } else {
            msg = "数据为空!";
        }
        tvMsg.setText(msg);

        //构建数据源
        String[] logos = new String[]{"p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"};
        final List<Map<String, String>> mList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Map<String, String> map = new HashMap<>();
            if (i < 10) {
                map.put("name", "美女0" + i);
            } else {
                map.put("name", "美女" + i);
            }
            map.put("logo", logos[i % logos.length]);
            mList.add(map);
        }

        //处理RecyclerView
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyer.setLayoutManager(manager);

        RecyclerAdapter adapter = new RecyclerAdapter(mList, getActivity());
        mRecyer.setAdapter(adapter);

        //处理点击事件
        adapter.setOnRecylcerItemClickListener(new RecyclerAdapter.OnRecylcerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent=new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("name",mList.get(position).get("name"));
                //Intent传递数据是由大小限制的.
                intent.putExtra("logo",mList.get(position).get("logo"));
                startActivity(intent);
            }
        });
    }
}
