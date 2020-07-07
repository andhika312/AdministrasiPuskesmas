package id.ac.umy.tugasakhir.ui.pendaftaran;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PendaftaranViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PendaftaranViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pendaftaran fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}