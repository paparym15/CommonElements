package com.one.testnotifications

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SecondFragment: Fragment(R.layout.fragment_second) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("-->", "fragment 2 onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("-->", "fragment 2 onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("-->", "fragment 2 onCreateView()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("-->", "fragment 2 onViewCreated()")
    }

    override fun onStart() {
        super.onStart()
        Log.d("-->", "fragment 2 onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("-->", "fragment 2 onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("-->", "fragment 2 onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("-->", "fragment 2 onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("-->", "fragment 2 onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("-->", "fragment 2 onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("-->", "fragment 2 onDetach()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val string = "saved string from SecondFragment"
        outState.putString("KEY_MAIN", string)
        Log.d("-->", "fragment 2 onSavedInstanceState() $string")
        super.onSaveInstanceState(outState)
    }
}