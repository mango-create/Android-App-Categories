package com.example.inclass05;

import static com.example.inclass05.DataServices.getAppCategories;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class AppCategories extends Fragment {
    ArrayList<String> catList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;

    public AppCategories() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_categories, container, false);
        getActivity().setTitle("App Categories");

        listView = view.findViewById(R.id.listView);
        catList = getAppCategories();
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, catList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                iAppCategories.onCatClick(catList.get(position));
            }
        });
        return view;
    }

    IAppCategories iAppCategories;
    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof IAppCategories) {
            iAppCategories = (IAppCategories) context;
        } else {
            throw new RuntimeException("Interface Error!");
        }
        super.onAttach(context);
    }
}

interface IAppCategories {
    void onCatClick(String appName);
}