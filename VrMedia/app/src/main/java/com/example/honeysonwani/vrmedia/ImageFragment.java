package com.example.honeysonwani.vrmedia;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.logging.nano.Vr;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {
    VrPanoramaView vrPanoramaView;
    private ImageTaskLoader backgroundimageTaskLoader;
    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_image, container, false);
//        backgroundimageTaskLoader = new ImageTaskLoader();
        vrPanoramaView = v.findViewById(R.id.pano_view);
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        vrPanoramaView.pauseRendering();
    }

    @Override
    public void onResume() {
        super.onResume();
        vrPanoramaView.resumeRendering();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vrPanoramaView.shutdown();
    }

    private synchronized void loadVrImage(){
        ImageTaskLoader task = backgroundimageTaskLoader;
        if(task != null && !task.isCancelled()){
            task.cancel(true);
        }
        VrPanoramaView.Options loadview = new VrPanoramaView.Options();
        loadview.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
        String name = "sample_converted.jpg";

        task = new ImageTaskLoader(vrPanoramaView,loadview,name);
        task.execute(getActivity().getAssets());
        backgroundimageTaskLoader = task;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadVrImage();
    }
}