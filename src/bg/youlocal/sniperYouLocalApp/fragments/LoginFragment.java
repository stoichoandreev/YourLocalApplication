package bg.youlocal.sniperYouLocalApp.fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import bg.youlocal.sniperYouLocalApp.R;
import bg.youlocal.sniperYouLocalApp.calls.LoginCall;
import bg.youlocal.sniperYouLocalApp.calls.constants.CallsConstants;
import bg.youlocal.sniperYouLocalApp.calls.interfaces.OnLoginListener;
import bg.youlocal.sniperYouLocalApp.calls.models.LoginModel;
import bg.youlocal.sniperYouLocalApp.customViews.YouLocalCustomButton;
import bg.youlocal.sniperYouLocalApp.customViews.YouLocalCustomEditText;
import bg.youlocal.sniperYouLocalApp.dialogs.WelcomeDialog;

/**
 * Created by sniper on 12/29/14.
 */
public class LoginFragment extends YouLocalBaseFragment implements View.OnClickListener,OnLoginListener{
    private YouLocalCustomEditText email;
    private YouLocalCustomEditText password;
    public LoginFragment(){}
    public LoginFragment(Bundle bundle) {
        super(bundle);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.login_fragment_layout);
        super.onCreateView(inflater, container, savedInstanceState);

        email = (YouLocalCustomEditText)getRootView().findViewById(R.id.email_edit_text);
        password = (YouLocalCustomEditText)getRootView().findViewById(R.id.password_edit_text);
        YouLocalCustomButton loginButton = (YouLocalCustomButton)getRootView().findViewById(R.id.login_button);
        YouLocalCustomButton forgotPasswordButton = (YouLocalCustomButton)getRootView().findViewById(R.id.forgot_password_button);
        LinearLayout emailContainer = (LinearLayout)getRootView().findViewById(R.id.email_container);
        LinearLayout passwordContainer = (LinearLayout)getRootView().findViewById(R.id.password_container);
        loginButton.setOnClickListener(this);
        forgotPasswordButton.setOnClickListener(this);
        emailContainer.setOnClickListener(this);
        passwordContainer.setOnClickListener(this);

        return getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                if(verifyForm(email.getText().toString(),password.getText().toString())) {
                    tryLogin(email.getText().toString(),password.getText().toString());
                }
                break;
            case R.id.forgot_password_button:
                ForgotPasswordFragment frag = new ForgotPasswordFragment(new Bundle());
                mActivity.addFragment(frag);
                break;
            case R.id.email_container:
                YouLocalCustomEditText emailEditText = (YouLocalCustomEditText)v.findViewById(R.id.email_edit_text);
                mActivity.showSoftKeyBoard(emailEditText);
                break;
            case R.id.password_container:
                YouLocalCustomEditText passwordEditText = (YouLocalCustomEditText)v.findViewById(R.id.password_edit_text);
                mActivity.showSoftKeyBoard(passwordEditText);
                break;
        }
    }
    private boolean verifyForm(String email,String password) {
        String error = null;
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            error = getResources().getString(R.string.valid_email);
        }else if(password.trim().length() < CallsConstants.PASSWORD_MIN_SYMBOLS){
            error = getResources().getString(R.string.symbol_minimum);
        }

        if (error != null){
            showValidationWarning(error);
            return false;
        }else{
            return true;
        }
    }
    private void showValidationWarning(String error) {
        Toast.makeText(mActivity,error,Toast.LENGTH_LONG).show();
    }
    private void tryLogin(final String email, final String password) {
        new LoginCall(this,email,password).execute();

//        YouLocalApp.getRestClient().getLoginService().getSignin(email, password, new Callback<ApiResponse>() {
//            @Override
//            public void success(ApiResponse apiResponse, Response response) {
//                Toast.makeText(mActivity,"Successful Login",Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Toast.makeText(mActivity,("Error : " + error.getMessage()),Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public void onLoginSuccess(LoginModel model) {
        showWelcomeDialog(getString(R.string.welcome_text)+model.getFullName());
    }

    @Override
    public void onLoginFailure(String error) {
        showWelcomeDialog(error);
    }
    private void showWelcomeDialog(String text){
        WelcomeDialog dialog = null;
        Bundle bundle  = new Bundle();
        bundle.putString(CallsConstants.MESSAGE, text);
        dialog = new WelcomeDialog(mActivity,bundle);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.createDialog();
    }
}
