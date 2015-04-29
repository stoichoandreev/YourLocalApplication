package bg.youlocal.sniperYouLocalApp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bg.youlocal.sniperYouLocalApp.activities.YourLocalBaseActivity;

/**
 * Created by sniper on 29/12/14.
 */
public class YouLocalBaseFragment extends Fragment{
    private View rootView;
    private int mLayoutRecourse;
    protected YourLocalBaseActivity mActivity;

    public YouLocalBaseFragment(){}
    public YouLocalBaseFragment(Bundle bundle){
        setArguments(bundle);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = (YourLocalBaseActivity)getActivity();
        rootView = inflater.inflate(mLayoutRecourse,container,false);

        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        mActivity.hideSoftKeyBoard();
    }
    public void setLayoutRecourse(int res){
        mLayoutRecourse = res;
    }
    public View getRootView(){
        return rootView;
    }
}