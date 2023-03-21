package com.wahyouwebid.news.presentation.navigation

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.wahyouwebid.core.CoreId
import com.wahyouwebid.news.R
import com.wahyouwebid.news.domain.model.Article
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class NewsNavigationImpl @AssistedInject constructor(
    @param:Assisted private val activity: FragmentActivity?,
) : NewsNavigation {

    val nav: NavController? by lazy {
        activity?.findNavController(CoreId.nav_main)
    }

    override fun goToPrevious() {
        nav?.navigateUp()
    }

    override fun fromNewsListToNewsDetail(article: Article) {
        runCatching {
            nav?.navigate(
                R.id.action_newsFragment_to_newsDetailFragment,
                bundleOf("data" to article)
            )
        }.onFailure {
            it.printStackTrace()
        }
    }
}