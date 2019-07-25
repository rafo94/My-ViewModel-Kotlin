package resal.app.mykotlinapplication

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val userViewModel by lazy { ViewModelProviders.of(this).get(UserViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = UserAdapter()
        user_list.layoutManager = LinearLayoutManager(this)
        user_list.adapter = adapter

        userViewModel.getListUsers().observe(this, Observer {
            it?.let { adapter.refreshUsers(it) }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.refresh -> {
                userViewModel.updateListUsers()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}