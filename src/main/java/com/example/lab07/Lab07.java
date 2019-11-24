package com.example.lab07;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Lab07 extends Activity {

    public ArrayList<Journee> sem;

    class JourneeAdapter extends ArrayAdapter<Journee> {

        JourneeAdapter() {
            super(Lab07.this, R.layout.row, R.id.textViewJour, sem);

        }
        //ListeJour est l’activity principale et listeJournee mon ArrayList de Journee

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            JourneeWrapper wrapper;

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.row, null);
                wrapper = new JourneeWrapper(convertView);
                convertView.setTag(wrapper);
            } else
                wrapper = (JourneeWrapper) convertView.getTag();

            wrapper.setJournee(getItem(position));

            return convertView;
        }
    }



    class JourneeWrapper {
        private TextView name = null;
        private ImageView face = null;
        private View row = null;
        JourneeWrapper(View row) {
            this.row = row;
        }

        public TextView getName() {
            if (name == null)  name = (TextView) row.findViewById(R.id.textViewJour);
            return name;
        }

        public ImageView getFace() {
            if (face == null)  face = (ImageView) row.findViewById(R.id.imageViewJour);
            return face;
        }

        public void setJournee(Journee j) {
            getName().setText(j.getNom());
            getFace().setImageResource(j.getImage());
        }
    }



    private ListView listJournee ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_lab07);

        // Find the ListView resource.
        listJournee = (ListView) findViewById( R.id.listJournee );

        sem = new ArrayList<Journee>();
        sem.add(new Journee("lundi", R.drawable.happyface, "Lundi, je fais du C"));
        sem.add(new Journee("mardi", R.drawable.happyface, "Jaime les mardis"));

        listJournee.setAdapter(new JourneeAdapter());

    }

}
