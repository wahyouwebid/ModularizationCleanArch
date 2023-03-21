package com.wahyouwebid.news.presentation.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wahyouwebid.core.Constants.DATA_PARCELABLE
import com.wahyouwebid.core.base.BaseFragment
import com.wahyouwebid.core.R
import com.wahyouwebid.core.utils.extension.loadImage
import com.wahyouwebid.core.utils.extension.parcelable
import com.wahyouwebid.news.databinding.FragmentNewsDetailBinding
import com.wahyouwebid.news.domain.model.Article
import com.wahyouwebid.news.presentation.navigation.NewsNavigationFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {

    @Inject
    lateinit var navigationFactory: NewsNavigationFactory

    private val navigation by lazy { navigationFactory.create(activity) }

    private var data: Article? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?): View {
        baseBinding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupData() {
        data = arguments?.parcelable(DATA_PARCELABLE)
    }

    override fun setupToolbar(){
        with(binding) {
            toolbar.setToolbar(getString(R.string.title_news_detail))
            toolbar.setBack { navigation.goToPrevious() }
        }
    }

    override fun setupView() = with(binding){
        ivBanner.loadImage(data?.urlToImage)
        tvTitle.text = data?.title
        tvContent.text = data?.content
    }

    override fun setupViewModel() {}

    override fun setupObserveViewModel() {}

    override fun setupListener() {}
}