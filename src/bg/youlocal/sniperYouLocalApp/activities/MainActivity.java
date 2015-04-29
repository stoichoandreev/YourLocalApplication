package bg.youlocal.sniperYouLocalApp.activities;

import android.os.Bundle;
import bg.youlocal.sniperYouLocalApp.R;
import bg.youlocal.sniperYouLocalApp.fragments.LoginFragment;
import bg.youlocal.sniperYouLocalApp.fragments.YouLocalBaseFragment;

public class MainActivity extends YourLocalBaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getActionBar().setLogo(R.drawable.img_ab_youlocal_logo);
        initUI();
    }

    private void initUI() {
        if (mIsActivityStartForFirstTime) {
            mIsActivityStartForFirstTime = false;
            Bundle bundle = new Bundle();
            YouLocalBaseFragment startFragment = new LoginFragment(bundle);
            addFragment(startFragment);
        }
    }
}
