package com.example.inclass05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class appListAdapter extends ArrayAdapter<DataServices.App> {
    public appListAdapter(@NonNull Context context, int resource, @NonNull List<DataServices.App> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.apps_list_row_item, parent, false);
        }
        TextView appName = convertView.findViewById(R.id.app_name);
        TextView artistName = convertView.findViewById(R.id.artist_name);
        TextView releaseDate = convertView.findViewById(R.id.release_date);

        DataServices.App app = getItem(position);
        appName.setText(app.name);
        artistName.setText(app.artistName);
        releaseDate.setText(app.releaseDate);
        return convertView;
    }
}
