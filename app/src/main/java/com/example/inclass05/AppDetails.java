package com.example.inclass05;

import static com.example.inclass05.DataServices.getAppCategories;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class AppDetails extends Fragment {
    private static final String ARG_PARAM1 = "pos";
    DataServices.App app;
    TextView appName, artistName, releaseDate;
    ListView listViewDetails;
    ArrayList<String> genre;
    ArrayAdapter<String> adapterDetails;

    public AppDetails() {}

    public static AppDetails newInstance(DataServices.App app) {
        AppDetails fragment = new AppDetails();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, app);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            app = (DataServices.App) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_details, container, false);
        getActivity().setTitle("App Details");

        listViewDetails = view.findViewById(R.id.listView_details);
        appName = view.findViewById(R.id.Details_app_name);
        artistName = view.findViewById(R.id.Details_artist_name);
        releaseDate = view.findViewById(R.id.Details_release_date);

        appName.setText(app.name);
        artistName.setText(app.artistName);
        releaseDate.setText(app.releaseDate);

        genre = app.genres;
        adapterDetails = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, genre);
        listViewDetails.setAdapter(adapterDetails);

        return view;
    }
}