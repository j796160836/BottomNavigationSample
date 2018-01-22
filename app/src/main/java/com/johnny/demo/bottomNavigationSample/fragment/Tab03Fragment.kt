package com.johnny.demo.bottomNavigationSample.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.johnny.demo.bottomNavigationSample.R

/**
 * Created by johnny on 22/01/2018.
 */
class Tab03Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tab03, container, false)
        ButterKnife.bind(this, view)

        return view
    }
}