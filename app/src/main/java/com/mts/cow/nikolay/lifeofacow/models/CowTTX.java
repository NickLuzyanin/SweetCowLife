package com.mts.cow.nikolay.lifeofacow.models;

import android.support.annotation.NonNull;

public class CowTTX {



  private String date;

  private String milk_yield;

  private String fat_content;

  private String weight;



  public CowTTX(@NonNull String date,@NonNull String milk_yield, @NonNull String fat_content, @NonNull String weight){


      this.date=date;
      this.milk_yield=milk_yield;
      this.fat_content=fat_content;
      this.weight=weight;

    }


    public String getMilk_yield() {
        return milk_yield;
    }

    public void setMilk_yield(String milk_yield) {
        this.milk_yield = milk_yield;
    }

    public String getFat_content() {
        return fat_content;
    }

    public void setFat_content(String fat_content) {
        this.fat_content = fat_content;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
