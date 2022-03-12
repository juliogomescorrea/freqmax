package br.com.gomescorrea.freqmax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AthleteAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<Athlete> athletes;

    AthleteAdapter(List<Athlete> athletes, Context ctx){
        this.athletes = athletes;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return athletes.size();
    }

    @Override
    public Object getItem(int position) {
        return athletes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.athlete_item, null);
        TextView inputName = v.findViewById(R.id.inputNameItem);
        TextView inputFCM = v.findViewById(R.id.inputFCMItem);

        Athlete a = athletes.get(position);
        inputName.setText(a.getName());
        inputFCM.setText("FCM: " + a.getFcm());
        return v;
    }
}
