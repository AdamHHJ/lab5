package temple.edu;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        RelativeLayout root =  findViewById(R.id.ll_root);
        String color = getIntent().getStringExtra("color");
        root.setBackgroundColor(Color.parseColor(color));
    }
}
