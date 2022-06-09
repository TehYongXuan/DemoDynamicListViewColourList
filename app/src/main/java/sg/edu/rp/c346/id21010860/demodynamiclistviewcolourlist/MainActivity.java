package sg.edu.rp.c346.id21010860.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAdditem);
        btnRemove = findViewById(R.id.buttonRemoveitem);
        btnUpdate = findViewById(R.id.buttonUpdateitem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();   //no need verify size
        alColours.add("Red");
        alColours.add("Orange");


        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);  //link array list with array adapter

        lvColour.setAdapter(aaColour);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newColour = etElement.getText().toString();

                //alColours.add(newColour);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, newColour);


                aaColour.notifyDataSetChanged();

            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newColour = etElement.getText().toString();


                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);

                aaColour.notifyDataSetChanged();

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newColour = etElement.getText().toString();


                int pos = Integer.parseInt(etIndexElement.getText().toString());

                alColours.set(pos,newColour);

                aaColour.notifyDataSetChanged();

            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        Toast.makeText(MainActivity.this,alColours.get(position), Toast.LENGTH_LONG).show();
                    }
                });
            }

}