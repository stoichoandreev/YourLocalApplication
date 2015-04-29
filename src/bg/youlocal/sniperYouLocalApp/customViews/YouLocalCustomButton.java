package bg.youlocal.sniperYouLocalApp.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import bg.youlocal.sniperYouLocalApp.R;

import java.util.HashMap;
import java.util.Map;

public class YouLocalCustomButton extends Button {

	public static Map<String, Typeface> typefaceCache = new HashMap<String, Typeface>();

	public YouLocalCustomButton(Context context) {
		super(context);
	}

	public YouLocalCustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public YouLocalCustomButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public static void setTypeface(AttributeSet attrs, Button button) {
		Context context = button.getContext();

		TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.YouLocalCustomButton);
		String typefaceName = values.getString(R.styleable.YouLocalCustomButton_button_typeface);

		if (typefaceCache.containsKey(typefaceName)) {
            button.setTypeface(typefaceCache.get(typefaceName));
		} else {
			Typeface typeface;
			try {
				typeface = Typeface.createFromAsset(button.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + typefaceName);
			} catch (Exception e) {
				Log.v(context.getString(R.string.app_name), String.format("font not found", typefaceName));
				return;
			}

			typefaceCache.put(typefaceName, typeface);
            button.setTypeface(typeface);
		}

		values.recycle();
	}
}