package com.wahyouwebid.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    var baseBinding: VB? = null
    val binding get() = baseBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return onCreateView(inflater, container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    abstract fun onCreateView(inflater: LayoutInflater, container: ViewGroup?): View?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupData()
        setupView()
        setupObserveViewModel()
    }

    abstract fun setupData()

    abstract fun setupToolbar()

    abstract fun setupView()

    abstract fun setupViewModel()

    abstract fun setupObserveViewModel()

    open fun setupListener() {}

    override fun onDestroyView() {
        super.onDestroyView()
        baseBinding = null
    }
}