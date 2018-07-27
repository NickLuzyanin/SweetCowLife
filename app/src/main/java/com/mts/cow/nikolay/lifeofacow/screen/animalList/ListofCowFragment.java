package com.mts.cow.nikolay.lifeofacow.screen.animalList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.models.Cows;
import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;
import com.mts.cow.nikolay.lifeofacow.screen.cowpassport.AddCowPassportActivity;



import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


@ActivityScoped
public class ListofCowFragment extends DaggerFragment implements ListofCowContract.View {


    public interface RvClickListener{

        void OnClick(View view, int position, boolean isLongClick);

    }

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
        mCowadapter = new CowAdapter(cows,getContext());
        listCows.setAdapter(mCowadapter);


    }

    private void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingCowsError() {
        showMessage(getString(R.string.loading_cows_error));
    }


    private class CowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 1;



        private List<Cows> Listcows;
        Context context;





        public CowAdapter(List<Cows> cows, Context context) {

            this.Listcows = cows;
            this.context = context;


        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            if(viewType == TYPE_HEADER)
            {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listofcow_item, parent, false);
                return  new VHHeader(v);
            }else if(viewType == TYPE_ITEM){
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listofcow_item, parent, false);
                return new VHolderItem(v);
            }

            throw new RuntimeException("Такой тип " + viewType + " отсутствует");

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


            if(holder instanceof VHHeader)
            {
                VHHeader VHheader = (VHHeader)holder;
                VHheader.сow_numberL.setText("#Коровы");
                VHheader.сow_porodaL.setText("Порода");
                VHheader.сow_birthdayL.setText("Масть");
                VHheader.сow_SuitLL.setText("Возраст");
            }
            else if(holder instanceof VHolderItem){

                Cows listcows = getItem(position-1);
                //Костыль обыкновенный - быстрый)
                int birthDay =Integer.parseInt(listcows.getBirthDay());
                int Agen = 2018 - birthDay;
                String Age = Integer.toString(Agen);

                ((VHolderItem) holder).mCowNumber.setText(listcows.getCowNumber());
                ((VHolderItem) holder).mCowBreed.setText(listcows.getBreed());
                ((VHolderItem) holder).mCowSuit.setText(listcows.getSuit());
                ((VHolderItem) holder).mCowBirthDay.setText(Age);
                ((VHolderItem) holder).cv.setOnClickListener(v -> {

                    String[]arrayListCow = new String[]{
                            listcows.getCowNumber(),
                            listcows.getBreed(),
                            listcows.getSuit(),
                            listcows.getBirthDay(),
                            listcows.getFather(),
                            listcows.getMother()};

                    Intent intent = new Intent(context, AddCowPassportActivity.class);
                    intent.putExtra("ArrayCowList", arrayListCow);
                    context.startActivity(intent);
                    //finish();

                });
            }

        }

        private Cows getItem(int position)
        {
            return Listcows.get(position);
        }

        @Override
        public int getItemViewType(int position) {
            if(isPositionHeader(position))
                return TYPE_HEADER;
            return TYPE_ITEM;
        }


        private boolean isPositionHeader(int position)
        {
            return position == 0;
        }

        @Override
        public int getItemCount() {
            return Listcows.size()+1;
        }

        class VHHeader extends RecyclerView.ViewHolder{
            TextView сow_numberL;
            TextView сow_porodaL;
            TextView сow_birthdayL;
            TextView сow_SuitLL;

            public VHHeader(View itemView) {
                super(itemView);
                this.сow_numberL = (TextView)itemView.findViewById(R.id.textView_сow_numberLL);
                this.сow_porodaL = (TextView)itemView.findViewById(R.id.textView_сow_BreedLL);
                this.сow_SuitLL = (TextView)itemView.findViewById(R.id.textView_сow_SuitLL);
                this.сow_birthdayL = (TextView)itemView.findViewById(R.id.textView_сow_age);

            }
        }



        public class VHolderItem extends RecyclerView.ViewHolder {

            private CardView cv;
            TextView mCowNumber;
            TextView mCowBreed;
            TextView mCowSuit;
            TextView mCowBirthDay;


            VHolderItem(View itemView) {
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
