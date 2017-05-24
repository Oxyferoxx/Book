package pl.akademiakodu.book;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.frameFragment)
    FrameLayout frame;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();

        // dodanie fragmentu początkowego
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frameFragment, new MyBookFragment());
        transaction.commit();
    }

    @OnClick(R.id.buttonMyBooks)
    public void myBooks() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameFragment, new MyBookFragment());
        transaction.commit();
    }

    @OnClick(R.id.buttonLibrary)
    public void openLibrary() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameFragment, new LibraryFragment());
        transaction.commit();
    }

    @OnClick(R.id.buttonUsers)
    public void openAnotherUsers() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameFragment, new UsersFragment());
        transaction.commit();
    }
    @OnClick(R.id.buttonLogout)
    public void logoutButton(){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    @OnLongClick(R.id.buttonLogout)
    public boolean longClickOnLogout() {
        Utils.createSimpleDialog(this, "Informacja", "Jest to aplikacja napisana pod kurs w AkademiKodu! Wersja: " + Utils.VERSION + ".");
        return true;
    }
}
