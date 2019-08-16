package com.bee.units


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

/** Copyright 2019 Justin Bee
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
**/

class MainActivity : AppCompatActivity(), FragmentDrawer.FragmentDrawerListener {

    private var mToolbar: Toolbar? = null
    private var drawerFragment: FragmentDrawer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolbar = findViewById(R.id.toolbar) as Toolbar

        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        drawerFragment = supportFragmentManager.findFragmentById(R.id.fragment_navigation_drawer) as FragmentDrawer?
        drawerFragment!!.setUp(
            R.id.fragment_navigation_drawer,
            findViewById(R.id.drawer_layout) as DrawerLayout,
            mToolbar!!
        )
        drawerFragment!!.setDrawerListener(this)

        // display the first navigation drawer view on app launch
        displayView(0)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        if (id == R.id.action_search) {
            var fragment: Fragment? = null
            var title = getString(R.string.app_name)
            fragment = home()
            title = getString(R.string.menu_home)
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container_body, fragment!!)
            fragmentTransaction.commit()

            // set the toolbar title
            supportActionBar!!.setTitle(title)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onDrawerItemSelected(view: View, position: Int) {
        displayView(position)
    }

    private fun displayView(position: Int) {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (position) {
            0 -> {
                fragment = home()
                title = getString(R.string.menu_home)
            }
            1 -> {
                fragment = Cooking()
                title = getString(R.string.cooking)
            }
            2 -> {
                fragment = Data()
                title = getString(R.string.data)
            }
            3 -> {
                fragment = Energy()
                title = getString(R.string.energy)
            }
            4 -> {
                fragment = Length()
                title = getString(R.string.length)
            }
            5 -> {
                fragment = Temperature()
                title = getString(R.string.temp)
            }
            6 -> {
                fragment = Weight()
                title = getString(R.string.weight)
            }


            else -> {
            }
        }

        if (fragment != null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container_body, fragment)
            fragmentTransaction.commit()

            // set the toolbar title
            supportActionBar!!.setTitle(title)
        }
    }

    companion object {

        private val TAG = MainActivity::class.java.simpleName
    }
}
