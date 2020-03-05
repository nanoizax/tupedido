package com.izax.devs.wrap.Items;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.izax.devs.wrap.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by reale on 13/07/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {
    Activity activity;
    ArrayList<String> images = new ArrayList<String>();
    ArrayList<String> texto = new ArrayList<String>();
    LayoutInflater inflater;

    public ViewPagerAdapter(Activity activity, ArrayList images, ArrayList linkImagen) {
        this.activity = activity;
        this.images = images;
        this.texto = linkImagen;

    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater)activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item,container,false);

        ImageView image;
        image = (ImageView)itemView.findViewById(R.id.imageView);
        DisplayMetrics dis = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dis);
        int height = dis.heightPixels;
        int width = dis.widthPixels;
        image.setMinimumHeight(height);
        image.setMinimumWidth(width);

        try{
            Picasso.with(activity.getApplicationContext())
                    .load(images.get(position))
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(image);
        }
        catch (Exception ex){

        }

        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /*Uri uri = Uri.parse(texto.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(intent);*/

            }
        });

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View)object);
    }
}
