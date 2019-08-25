package com.song2.pracmvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<Integer> count = new MutableLiveData<>();

    public MainViewModel(){
        count.setValue(0);
    }

    public void increase(){
        count.setValue(count.getValue()+ 1);
    }

    public void decrease(){
        count.setValue(count.getValue()- 1);
    }

}
