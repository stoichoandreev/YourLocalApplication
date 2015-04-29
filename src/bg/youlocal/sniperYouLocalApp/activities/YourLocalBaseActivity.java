package bg.youlocal.sniperYouLocalApp.activities;

import android.app.*;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import bg.youlocal.sniperYouLocalApp.R;
import bg.youlocal.sniperYouLocalApp.YouLocalApp;

public class YourLocalBaseActivity extends Activity implements FragmentManager.OnBackStackChangedListener {

    protected ProgressDialog progressDialog;
    protected YouLocalApp mApplication;
    protected boolean mIsActivityStartForFirstTime;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mIsActivityStartForFirstTime = true;
        mApplication = (YouLocalApp)getApplication();
        setUpActionBar();
    }
    public void addFragment(Fragment fragment) {
        FragmentTransaction t = getFragmentManager().beginTransaction();
        t.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);

        String fragmentClassName = ((Object) fragment).getClass().getSimpleName();
        t.replace(R.id.root_fragment_container, fragment, fragmentClassName);
        t.addToBackStack(fragmentClassName);
        t.commit();
    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().popBackStack();
            super.onBackPressed();
        }
    }
    private void setUpActionBar(){
        getActionBar().setHomeButtonEnabled(true);
        getFragmentManager().addOnBackStackChangedListener(this);
        //Handle when activity is recreated like on orientation Change. But we don't need it now
//        shouldDisplayHomeUp();
        getActionBar().setDisplayShowTitleEnabled(false);
    }
    public void showSoftKeyBoard(View view){
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }
    public void hideSoftKeyBoard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null){
            imm.hideSoftInputFromWindow(null, 0);
        }
    }
    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }
    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canBack = getFragmentManager().getBackStackEntryCount() > 1;
        getActionBar().setDisplayHomeAsUpEnabled(canBack);
    }
//  Should be used in oldest Android API
//    @Override
//    public boolean onSupportNavigateUp() {
//        //This method is called when the up button is pressed. Just the pop back stack.
//        getFragmentManager().popBackStack();
//        return true;
//    }

    @Override
    public boolean onNavigateUp() {
        if(getFragmentManager().getBackStackEntryCount() > 1){
            onBackPressed();
            return true;
        }
        else return super.onNavigateUp();
    }
    public ProgressDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(getString(R.string.loading));
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        return progressDialog;
    }
}
