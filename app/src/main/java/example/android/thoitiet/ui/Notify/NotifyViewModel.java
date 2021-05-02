package example.android.thoitiet.ui.Notify;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotifyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotifyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notify fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}