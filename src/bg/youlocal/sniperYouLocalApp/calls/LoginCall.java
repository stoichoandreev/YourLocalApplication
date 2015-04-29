package bg.youlocal.sniperYouLocalApp.calls;

import android.os.AsyncTask;
import bg.youlocal.sniperYouLocalApp.activities.YourLocalBaseActivity;
import bg.youlocal.sniperYouLocalApp.calls.constants.CallsConstants;
import bg.youlocal.sniperYouLocalApp.calls.interfaces.OnLoginListener;
import bg.youlocal.sniperYouLocalApp.calls.models.LoginModel;
import bg.youlocal.sniperYouLocalApp.fragments.YouLocalBaseFragment;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sniper on 12/30/14.
 */
public class LoginCall extends AsyncTask<String, String, Boolean> {
    private static final String URL = "https://www.youlocalapp.com/oauth2/2.0/signin";
    private String error;
    private LoginModel model;
    private String email;
    private String password;
    private OnLoginListener listener;

    public LoginCall(){}
    public LoginCall(OnLoginListener listener,String email, String password){
        this.listener = listener;
        this.email = email;
        this.password = password;
    }
    @Override
    protected void onPreExecute() {//block UI
        super.onPreExecute();
        ((YourLocalBaseActivity)((YouLocalBaseFragment) listener).getActivity()).getProgressDialog().show();
    }
    @Override
    protected Boolean doInBackground(String... params) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(URL);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair(CallsConstants.EMAIL, email));
            nameValuePairs.add(new BasicNameValuePair(CallsConstants.PASSWORD, password));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

            JSONObject respo;
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String entityAsString = EntityUtils.toString(entity);
                respo = new JSONObject(entityAsString);

                if (respo != null && respo.has(CallsConstants.ERROR)) {
                    error = (respo.get(CallsConstants.ERROR).toString());
                    return false;
                    //error code
                } else if (respo != null && respo.has(CallsConstants.SUCCESS)) {
                    model = new LoginModel(respo);
                    return true;
                    //parse server result
                }
            }
        } catch (JSONException e) {
            return false;
        } catch (ClientProtocolException e) {
            return false;
        } catch (IOException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        //release UI
        ((YourLocalBaseActivity)((YouLocalBaseFragment) listener).getActivity()).getProgressDialog().dismiss();
        if (listener != null) {
            if (result) {
                listener.onLoginSuccess(model);
            } else {
                listener.onLoginFailure(error);
            }
        }
    }
}