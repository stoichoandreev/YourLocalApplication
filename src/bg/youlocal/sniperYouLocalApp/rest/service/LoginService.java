package bg.youlocal.sniperYouLocalApp.rest.service;

import bg.youlocal.sniperYouLocalApp.calls.constants.CallsConstants;
import bg.youlocal.sniperYouLocalApp.rest.model.ApiResponse;
import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Query;

public interface LoginService
{
    @POST("api/oauth2/2.0/signin")
    public void getSignin(@Query(CallsConstants.EMAIL) String email,@Query(CallsConstants.PASSWORD) String password, Callback<ApiResponse> callback);
}
