package com.mokhtar.robustatask.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.mokhtar.robustatask.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //region variables
    private lateinit var navController: NavController
    private lateinit var navHost: NavHostFragment
    private val viewModel: HomeViewModel by viewModels()

    //endregion

    //region events
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.findNavController()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        menu?.let { setSearchView(it) }
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    //endregion

    //region helper functions
    private fun setSearchView(menu: Menu) {
        val searchItem = menu.findItem(R.id.action_search)

        (searchItem.actionView as SearchView).apply {
            // Set hint text
            queryHint = getString(R.string.search_hint)

            // Set listener for user actions
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    viewModel.setQuery(newText)
                    return true
                }
            })
        }
    }
    //endregion


}