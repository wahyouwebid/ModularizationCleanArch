package com.wahyouwebid.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected abstract val binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView(savedInstanceState)
        setupViewModel()
        setupObserveViewModel()
    }

    abstract fun setupView(savedInstanceState: Bundle?)

    abstract fun setupViewModel()

    abstract fun setupObserveViewModel()
}