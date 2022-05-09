package com.example.countermvvm.data.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    MutableLiveData<CounterModel> getCounter = new MutableLiveData<>();
    CounterModel counterModel = new CounterModel();

    public LiveData<CounterModel> getNumber(){

        return getCounter;
    }

    public void increment(){
        int number = counterModel.getCounter()+1;
        counterModel.setCounter(number);
        getCounter.setValue(counterModel);
    }

    public void decrement(){
        int number = counterModel.getCounter()-1;
        counterModel.setCounter(number);
        getCounter.setValue(counterModel);
    }
}
