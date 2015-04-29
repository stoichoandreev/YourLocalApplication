package bg.youlocal.sniperYouLocalApp.calls.interfaces;

import bg.youlocal.sniperYouLocalApp.calls.models.LoginModel;

/**
 * Created by sniper on 12/29/14.
 */
public interface OnLoginListener {
    void onLoginSuccess(LoginModel model);
    void onLoginFailure(String error);
}
