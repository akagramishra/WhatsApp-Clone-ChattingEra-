package ml.techzgamecoding.chattingera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ml.techzgamecoding.chattingera.Adapters.FragmentsAdapter;
import ml.techzgamecoding.chattingera.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello World");
        auth = FirebaseAuth.getInstance();


        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewPager);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.Logout:
                auth.signOut();
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                break;

            case R.id.settings:
                Intent it = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(it);
                break;

            case R.id.groupchat:
                Intent i = new Intent(MainActivity.this, GroupChatActivity.class);
                startActivity(i);
                break;


        }
        return true;
    }
}