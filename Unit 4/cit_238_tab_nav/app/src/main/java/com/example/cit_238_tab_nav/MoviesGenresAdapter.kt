package com.example.cit_238_tab_nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//    Scrollabe menu
val TAB_GENRES_SCROLLABLE = listOf(
    R.string.action,
    R.string.action,
    R.string.comedy,
    R.string.drama,
    R.string.sci_fi,
    R.string.family,
    R.string.crime,
    R.string.history,
)

//    Fixed menu
val TAB_GENRES_FIXED = listOf(
    R.string.action, R.string.comedy, R.string.drama
)

class MoviesGenresAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
       FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return MoviesFragment()
    }

    override fun getItemCount(): Int {
//        Uncomment if you want a fixed menu
//        return TAB_GENRES_FIXED.size
//       Uncomment if you want a scrollable menu
        return TAB_GENRES_SCROLLABLE.size
    }

}