package com.example.honeysonwani.threepanefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CrimeListFragment extends Fragment{
    RecyclerView mCrimeRecyclerView;
    public CrimeAdapter madapter;
    @Nullable
    @Override
    //inflating recycler view
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crimelist,container,false);
        mCrimeRecyclerView = v.findViewById(R.id.crime_recyclerview);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }
    //view holder
    private class CrimeHolder extends RecyclerView.ViewHolder{
        public TextView titleTextview;
        public CrimeHolder(View itemView) {
            super(itemView);
            titleTextview = (TextView) itemView;
        }
    }
    //adapter
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> list_of_crimes;

        public CrimeAdapter(List<Crime> list_of_crimes) {
            this.list_of_crimes = list_of_crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = list_of_crimes.get(position);
            holder.titleTextview.setText(crime.getMtitle());
        }

        @Override
        public int getItemCount() {
            return list_of_crimes.size();
        }

    }
    private void updateUI(){
        CrimeLab crimelab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimelab.getCrimes();
        madapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(madapter);
    }
}
