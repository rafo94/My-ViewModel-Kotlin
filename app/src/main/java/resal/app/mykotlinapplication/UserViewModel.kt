package resal.app.mykotlinapplication

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    var userList: MutableLiveData<List<User>> = MutableLiveData()

    init {
        userList.value = UserData.getUsers()
    }

    fun getListUsers() = userList

    fun updateListUsers() {
        userList.value = UserData.getAnotherUsers()
    }
}