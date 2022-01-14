package com.one.testnotifications

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment(R.layout.fragment_main) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("-->", "fragment onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("-->", "fragment onCreate() - ${savedInstanceState?.getString("KEY_MAIN")}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("-->", "fragment onCreateView() - ${savedInstanceState?.getString("KEY_MAIN")}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("-->", "fragment onViewCreated()")

        btn1.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame, SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("-->", "fragment onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("-->", "fragment onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("-->", "fragment onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("-->", "fragment onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("-->", "fragment onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("-->", "fragment onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("-->", "fragment onDetach()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val string = "saved string from MainFragment"
        outState.putString("KEY_MAIN", string)
        Log.d("-->", "fragment onSavedInstanceState() $string")
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("-->", "fragment onViewStateRestored() - ${savedInstanceState?.getString("KEY_MAIN")}")
    }
}