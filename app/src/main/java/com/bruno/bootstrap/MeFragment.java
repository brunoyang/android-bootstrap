package com.bruno.bootstrap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MeFragment extends Fragment implements View.OnClickListener {
    PreferenceUtils preferenceUtils;
    public MeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_me, container, false);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.hello_text);
        Button logoutBtn = (Button) relativeLayout.findViewById(R.id.logout_btn);
        logoutBtn.setOnClickListener(this);

        preferenceUtils = new PreferenceUtils(getContext());
        String helloStr = preferenceUtils.getStringParam("name");

        textView.setText(helloStr);

        return relativeLayout;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logout_btn: {
                preferenceUtils.saveParam("name", null);
                preferenceUtils.saveParam("pwd", null);
                System.out.println(preferenceUtils.getStringParam("name"));
                startActivity(new Intent(getContext(), UIActivity.class));
                break;
            }
        }
    }
}
