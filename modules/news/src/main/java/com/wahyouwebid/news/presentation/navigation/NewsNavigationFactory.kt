package com.wahyouwebid.news.presentation.navigation

import androidx.fragment.app.FragmentActivity
import dagger.assisted.AssistedFactory

@AssistedFactory
interface NewsNavigationFactory {
    fun create(activity: FragmentActivity?): NewsNavigationImpl
}
