package com.example.honeysonwani.vrmedia;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/**
 * Created by honeysonwani on 4/20/2018.
 */

public class ImageTaskLoader extends AsyncTask<AssetManager,Void,Bitmap> {
    public static final String TAG = "ImageLoaderTask";
    String assetname;
    VrPanoramaView.Options viewoptions;
    WeakReference<VrPanoramaView> viewRefereance;
    static WeakReference<Bitmap> lastBitmap = new WeakReference<Bitmap>(null);
    static String lastName;

    public ImageTaskLoader(VrPanoramaView view, VrPanoramaView.Options viewOptions, String assetName) {
        viewRefereance = new WeakReference<>(view);
        this.viewoptions = viewOptions;
        this.assetname = assetName;
    }

    @Override
    protected Bitmap doInBackground(AssetManager... assetManagers) {
        AssetManager assetManager = assetManagers[0];
        if(assetname.equalsIgnoreCase(lastName) && lastBitmap.get() !=null){
            return lastBitmap.get();
        }
        try(InputStream str = assetManager.open(assetname)){
            Bitmap b = BitmapFactory.decodeStream(str);
            lastBitmap = new WeakReference<>(b);
            lastName = assetname;
            return b;

        } catch (IOException e) {
            Log.e(TAG, "Could not decode default bitmap: " + e);
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
//        super.onPostExecute(bitmap);
        final VrPanoramaView vr = viewRefereance.get();
        if(vr !=null && bitmap != null){
            vr.loadImageFromBitmap(bitmap,viewoptions);
        }
    }
}
