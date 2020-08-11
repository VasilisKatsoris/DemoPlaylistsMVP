package spotify.playlists.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import spotify.playlists.R;

public class BaseActivity extends AppCompatActivity {


    public Fragment getCurrentFragment(){
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    public void loadFragment(Fragment fragment, String tag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int stackLevel = getSupportFragmentManager().getBackStackEntryCount() - 1;
        if(stackLevel>=0) {
            //first fragment loaded instantly and the rest with animation
            transaction.setCustomAnimations(R.anim.fragment_enter_from_right, R.anim.fragment_exit_to_left,
                    R.anim.fragment_enter_from_left, R.anim.fragment_exit_to_right);
        }
        transaction.addToBackStack(tag).replace(R.id.fragment_container, fragment, tag).commit();
    }

    public int getFragmentsCount() {
        FragmentManager fm = getSupportFragmentManager();
        return fm.getBackStackEntryCount() - 1;
    }

}
