package temple.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class PaletteActivity extends AppCompatActivity {

    private ArrayList<CustomColor> list = new ArrayList<>();
    private ColorAdapter adapter;
    private boolean first = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        addColor();
         adapter = new ColorAdapter(this, list);
        Spinner spinner= findViewById(R.id.spinner);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (first){
                    first = false;
                    return;
                }
                Intent intent = new Intent(PaletteActivity.this,CanvasActivity.class);
                String color = list.get(i).getColor();
                intent.putExtra("color",color);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void addColor() {
        list.add(new CustomColor(getString(R.string.white),"#FFFFFF"));
        list.add(new CustomColor(getString(R.string.blue),"#0000ff"));
        list.add(new CustomColor(getString(R.string.red),"#ff0000"));
        list.add(new CustomColor(getString(R.string.yellow),"#ffff00"));
        list.add(new CustomColor(getString(R.string.magenta),"#ff00ff"));
        list.add(new CustomColor(getString(R.string.lig),"#cccccc"));
        list.add(new CustomColor(getString(R.string.green),"#00ff00"));
        list.add(new CustomColor(getString(R.string.na),"#FFDEAD"));
        list.add(new CustomColor(getString(R.string.greenyellow),"#ADFF2F"));

    }
}
