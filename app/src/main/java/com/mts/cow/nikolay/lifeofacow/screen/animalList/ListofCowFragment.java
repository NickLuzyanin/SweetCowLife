package com.mts.cow.nikolay.lifeofacow.screen.animalList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.data.Cows;
import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;
import com.mts.cow.nikolay.lifeofacow.screen.cowpassport.AddCowPassportActivity;


import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


@ActivityScoped
public class ListofCowFragment extends DaggerFragment implements ListofCowContract.View {

    @Inject
    ListofCowContract.Presenter mPresenter;



    private RecyclerView listCows;
    private CowAdapter mCowadapter;





    @Inject
    public ListofCowFragment() {
        // Requires empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        mPresenter.loadCowList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.result(requestCode, resultCode);
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cowlist_frag, container, false);

       listCows = (RecyclerView)root.findViewById(R.id.listOfCows);
       listCows.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Set up floating action button
        FloatingActionButton fab = getActivity().findViewById(R.id.fab_add_cow_pass);

        fab.setImageResource(R.drawable.ic_addpass);
        fab.setOnClickListener(v -> mPresenter.addNewCowPassport());

        setHasOptionsMenu(true);

        return root;
    }



    @Override
    public void showCowPassport() {
        Intent intent = new Intent(getContext(),AddCowPassportActivity.class);
        startActivityForResult(intent, AddCowPassportActivity.REQUEST_ADD_COW);
    }

    @Override
    public void showSuccessfullySavedMessage() {
        showMessage(getString(R.string.successfully_saved_cow));
    }

    @Override
    public void showCowsFromLocalDB(List<Cows> cows) {

        //Сюда прилетит лист объектов Cow из нашей базы "cows"
        mCowadapter = new CowAdapter(cows);
        listCows.setAdapter(mCowadapter);


    }

    private void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingCowsError() {
        showMessage(getString(R.string.loading_cows_error));
    }


    private class CowAdapter extends RecyclerView.Adapter<CowAdapter.ViewHolder>{


        private List<Cows> Listcows;





        public CowAdapter(List<Cows> cows) {

            this.Listcows = cows;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.listofcow_item,parent,false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CowAdapter.ViewHolder holder, int position) {
            Cows listcows = Listcows.get(position);

            //Костыль обыкновенный - быстрый)
            int birthDay =Integer.parseInt(listcows.getBirthDay());
            int Agen = 2018 - birthDay;
            String Age = Integer.toString(Agen);


            holder.mCowNumber.setText(listcows.getCowNumber());
            holder.mCowBreed.setText(listcows.getBreed());
            holder.mCowSuit.setText(listcows.getSuit());


            holder.mCowBirthDay.setText(Age);


        }

        @Override
        public int getItemCount() {
            return Listcows.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private CardView cv;
            TextView mCowNumber;
            TextView mCowBreed;
            TextView mCowSuit;
            TextView mCowBirthDay;


            ViewHolder(View itemView) {
                super(itemView);
                cv = itemView.findViewById(R.id.card_view);
                mCowNumber = itemView.findViewById(R.id.textView_сow_numberLL);
                mCowBreed = itemView.findViewById(R.id.textView_сow_BreedLL);
                mCowSuit = itemView.findViewById(R.id.textView_сow_SuitLL);
                mCowBirthDay = itemView.findViewById(R.id.textView_сow_age);


            }





        }



    }


}
