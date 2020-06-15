package com.example.netflix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseUser currentUser;//used to store current user of account
    FirebaseAuth mAuth;//Used for firebase authentication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
            Handles the options menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    /*
        To handle the click of option menu items
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutItem:
                aboutItemClicked();
                break;
            case R.id.feedbackItem:
                feedbackItemClicked();
                break;
            case R.id.logoutItem:
                logoutItemClick();
                break;
            case R.id.closeItem:
                closeApplication();
                break;
        }
        return true;
    }
    /*
        Closes the enitre application
     */
    private void closeApplication() {
        finishAffinity();
        System.exit(0);
    }

    /*
        To Logout from the application and not Close.
     */
    private void logoutItemClick() {
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        sendToLoginActivity();
    }
    /*
        To send user to the login page.
     */
    private void sendToLoginActivity() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    /*
        Send user to the feedback page.
     */
    private void feedbackItemClicked() {
        Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
        startActivity(intent);
    }
    /*
        Show the team details to the user.
     */
    private void aboutItemClicked() {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);

    }
}