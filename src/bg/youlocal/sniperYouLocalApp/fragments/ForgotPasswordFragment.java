package bg.youlocal.sniperYouLocalApp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import bg.youlocal.sniperYouLocalApp.R;
import bg.youlocal.sniperYouLocalApp.customViews.YouLocalCustomButton;
import bg.youlocal.sniperYouLocalApp.customViews.YouLocalCustomEditText;

/**
 * Created by sniper on 12/29/14.
 */
public class ForgotPasswordFragment extends YouLocalBaseFragment implements View.OnClickListener {

    public ForgotPasswordFragment(){}
    public ForgotPasswordFragment(Bundle bundle) {
        super(bundle);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.login_fragment_layout);
        super.onCreateView(inflater, container, savedInstanceState);

        LinearLayout emailContainer = (LinearLayout)getRootView().findViewById(R.id.email_container);
        YouLocalCustomButton loginButton = (YouLocalCustomButton)getRootView().findViewById(R.id.login_button);
        YouLocalCustomButton forgotPasswordButton = (YouLocalCustomButton)getRootView().findViewById(R.id.forgot_password_button);
        LinearLayout passwordContainer = (LinearLayout)getRootView().findViewById(R.id.password_container);
        passwordContainer.setVisibility(View.GONE);
        loginButton.setText(getResources().getString(R.string.reset_label));
        forgotPasswordButton.setText(getResources().getString(R.string.back_to_login_label));

        loginButton.setOnClickListener(this);
        forgotPasswordButton.setOnClickListener(this);
        emailContainer.setOnClickListener(this);

        return getRootView();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                Toast.makeText(mActivity,getString(R.string.reset_password),Toast.LENGTH_LONG).show();
                break;
            case R.id.forgot_password_button:
                mActivity.onBackPressed();
                break;
            case R.id.email_container:
                YouLocalCustomEditText emailEditText = (YouLocalCustomEditText)v.findViewById(R.id.email_edit_text);
                mActivity.showSoftKeyBoard(emailEditText);
                break;
        }
    }
}
