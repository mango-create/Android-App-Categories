package com.example.inclass05;

import static com.example.inclass05.DataServices.getAppCategories;
import static com.example.inclass05.DataServices.getAppsByCategory;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class AppsList extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    String param1;
    ArrayList<DataServices.App> appsList;
    appListAdapter adapter;
    ListView listView;

    public AppsList() {}

    public static AppsList newInstance(String appName) {
        AppsList fragment = new AppsList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, appName);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apps_list, container, false);
        getActivity().setTitle(param1);

        listView = view.findViewById(R.id.apps_list_listview);
        appsList = new ArrayList<>(getAppsByCategory(param1));
        adapter = new appListAdapter(getContext(), R.layout.apps_list_row_item, appsList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                iAppsList.onAppClick(adapter.getItem(position));
            }
        });
        return view;
    }

    IAppsList iAppsList;
    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof IAppsList) {
            iAppsList = (IAppsList) context;
        } else {
            throw new RuntimeException("Interface Error!");
        }
        super.onAttach(context);
    }
}

interface IAppsList {
    void onAppClick(DataServices.App app);
}