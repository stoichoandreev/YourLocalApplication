package bg.youlocal.sniperYouLocalApp.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;
import bg.youlocal.sniperYouLocalApp.R;

import java.util.HashMap;
import java.util.Map;

public class YouLocalCustomEditText extends EditText {

	public static Map<String, Typeface> typefaceCache = new HashMap<String, Typeface>();

	public YouLocalCustomEditText(Context context) {
		super(context);
	}

	public YouLocalCustomEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public YouLocalCustomEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public static void setTypeface(AttributeSet attrs, EditText editText) {
		Context context = editText.getContext();

		TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.YouLocalCustomEditText);
		String typefaceName = values.getString(R.styleable.YouLocalCustomEditText_edit_text_typeface);
		if (typefaceCache.containsKey(typefaceName)) {
			editText.setTypeface(typefaceCache.get(typefaceName));
		} else {
			Typeface typeface;
			try {
				typeface = Typeface.createFromAsset(editText.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + typefaceName);
			} catch (Exception e) {
				Log.v(context.getString(R.string.app_name), String.format("font not found", typefaceName));
				return;
			}

			typefaceCache.put(typefaceName, typeface);
			editText.setTypeface(typeface);
		}

		values.recycle();
	}
}