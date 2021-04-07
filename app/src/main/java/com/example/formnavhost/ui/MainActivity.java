package com.example.formnavhost.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.example.formnavhost.R;
import com.example.formnavhost.ui.main.MainViewModel;
import com.example.formnavhost.ui.main.NameFragment;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Navigation.findNavController(this, R.id.form_nav_host_fragment)
                .setGraph(R.navigation.form_nav_graph);

    }
}