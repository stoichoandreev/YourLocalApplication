package bg.youlocal.sniperYouLocalApp.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import bg.youlocal.sniperYouLocalApp.R;
import bg.youlocal.sniperYouLocalApp.calls.constants.CallsConstants;
import bg.youlocal.sniperYouLocalApp.customViews.YouLocalCustomButton;
import bg.youlocal.sniperYouLocalApp.customViews.YouLocalCustomTextView;

/**
 * Created by sniper on 12/29/14.
 */
public class WelcomeDialog extends Dialog implements View.OnClickListener {

    private String message;

    public WelcomeDialog(Context context, Bundle args){
        super(context);
        message = args.getString(CallsConstants.MESSAGE);
    }

    public void createDialog(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome_dialog_layout);
        YouLocalCustomButton okButton = (YouLocalCustomButton)findViewById(R.id.ok_button);
        YouLocalCustomTextView dialogText = (YouLocalCustomTextView)findViewById(R.id.dialog_text);
        dialogText.setText(message);
        okButton.setOnClickListener(this);
        setCancelable(false);
        show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok_button:
                dismiss();
                break;
        }
    }
}
