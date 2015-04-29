package bg.youlocal.sniperYouLocalApp.rest;

import bg.youlocal.sniperYouLocalApp.rest.service.LoginService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class RestClient
{
    private static final String BASE_URL = "https://www.youlocalapp.com/";
//    private static final String BASE_URL = "https://www.youlocalapp.com/oauth2";
    private LoginService loginService;

    public RestClient()
    {
        Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
            .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        loginService = restAdapter.create(LoginService.class);
    }

    public LoginService getLoginService()
    {
        return loginService;
    }
}
