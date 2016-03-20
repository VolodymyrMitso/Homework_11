package mitso.v.homework_11;

import android.content.Context;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    protected MainActivity mMainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }
}

