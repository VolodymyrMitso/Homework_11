package mitso.v.homework_11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        updateFragment(new MovableViewsFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_sun_switch:
                if (getSupportFragmentManager().findFragmentById(R.id.fl_FragmentContainer_AM) instanceof MovableViewsFragment)
                    updateFragment(new SimplePaintFragment());
                else
                    updateFragment(new MovableViewsFragment());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateFragment(BaseFragment baseFragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_FragmentContainer_AM, baseFragment)
                .commitAllowingStateLoss();
    }
}
