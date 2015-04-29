package bg.youlocal.sniperYouLocalApp.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import bg.youlocal.sniperYouLocalApp.R;

import java.util.HashMap;
import java.util.Map;

public class YouLocalCustomTextView extends TextView {

	public static Map<String, Typeface> typefaceCache = new HashMap<String, Typeface>();

	public YouLocalCustomTextView(Context context) {
		super(context);
	}

	public YouLocalCustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public YouLocalCustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public static void setTypeface(AttributeSet attrs, TextView textView) {
		Context context = textView.getContext();

		TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.YouLocalCustomTextView);
		String typefaceName = values.getString(R.styleable.YouLocalCustomTextView_text_view_typeface);
		if (typefaceCache.containsKey(typefaceName)) {
			textView.setTypeface(typefaceCache.get(typefaceName));
		} else {
			Typeface typeface;
			try {
				typeface = Typeface.createFromAsset(textView.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + typefaceName);
			} catch (Exception e) {
				Log.v(context.getString(R.string.app_name), String.format("font not found", typefaceName));
				return;
			}

			typefaceCache.put(typefaceName, typeface);
			textView.setTypeface(typeface);
		}

		values.recycle();
	}
}