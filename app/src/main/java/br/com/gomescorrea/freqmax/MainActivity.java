package br.com.gomescorrea.freqmax;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText inputName;
    EditText inputAge;
    Button btnAddCalc;
    ListView listAthletes;
    List<Athlete> athletes = new ArrayList<>();
    AthleteAdapter adapter;

    View.OnClickListener btnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Log.d("EVT", "EVT Click on button!");
            processClickAddCal(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        inputAge = findViewById(R.id.inputAge);

        btnAddCalc = findViewById(R.id.btnAddCalc);
        btnAddCalc.setOnClickListener(btnClickListener);

        listAthletes = findViewById(R.id.listAthletes);
        adapter = new AthleteAdapter(athletes, getBaseContext());
        listAthletes.setAdapter(adapter);
    }

    public void processClickAddCal(View v){
        Athlete a = new Athlete();
        a.setName(inputName.getText().toString());
        a.setAge(Integer.parseInt(inputAge.getText().toString()));
        athletes.add(a);

        //Sort descending athlete by FCM
        Collections.sort(athletes, Athlete.AthleteFCMDescendingComparator);

        Toast.makeText(getBaseContext(), a.toString(), Toast.LENGTH_LONG).show();
        adapter.notifyDataSetChanged();
    }
}