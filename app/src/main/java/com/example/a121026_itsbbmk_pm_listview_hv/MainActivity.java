package com.example.a121026_itsbbmk_pm_listview_hv;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    String idk [] = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
    String idk1 [] = {"Album 1","Album 2","Album 3","Album 4","Album 5","Album 6","Album 7","Album 8","Album 9","Album 10"};
    int idk2[] = {R.drawable.img1, R.drawable.img2, R.drawable.img10, R.drawable.img4,R.drawable.img5, R.drawable.img6,R.drawable.img7, R.drawable.img8,R.drawable.img9, R.drawable.img10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Adaptador ---->

        Adaptador adp1 = new Adaptador(this, idk, idk1, idk2);
        recyclerView.setAdapter(adp1);

        adp1.setOnItemClickListener(position ->
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show()
        );
    }
}