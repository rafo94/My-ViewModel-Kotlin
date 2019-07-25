package resal.app.mykotlinapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    private var users: List<User> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UserAdapter.UserHolder {
        return UserHolder(
            LayoutInflater.from(p0.context)
                .inflate(R.layout.user_item, p0, false)
        )
    }

    override fun onBindViewHolder(p0: UserHolder, p1: Int) {
        p0.bind(users[p1])
    }

    override fun getItemCount() = users.size


    fun refreshUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) = with(itemView) {
            user_name.text = user.name
            user_description.text = user.description
        }
    }

}