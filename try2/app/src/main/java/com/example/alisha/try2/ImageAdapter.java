package com.example.alisha.try2;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.util.Log;
import android.widget.RelativeLayout;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        Log.d("MyTagGoesHere", "This is my log message at the debug level here");
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

            // Set the layout parameters for TextView widget
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
            );
            imageView.setLayoutParams(lp);

            // Get the TextView LayoutParams
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            System.out.write(Integer.parseInt("3"));
            // Set the width of TextView widget (item of GridView)
            params.width = 200;

            // Set the TextView height (GridView item/row equal height)
            params.height = 200;

            // Set the TextView layout parameters
            imageView.setLayoutParams(params);

        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            //2,3,4,5,6,7,8,9
            R.drawable.uber_logo, R.drawable.facebook_logo, R.drawable.tinder_logo,
            R.drawable.gopuff_logo, R.drawable.snapchat_logo, R.drawable.spotify_logo,
            R.drawable.slack_logo, R.drawable.airbnb_logo, R.drawable.bbc_logo,
            R.drawable.youtube_logo, R.drawable.tumblr_logo, R.drawable.skype_logo
    };
}