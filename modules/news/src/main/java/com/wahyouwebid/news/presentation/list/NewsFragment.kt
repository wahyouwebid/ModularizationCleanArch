package com.wahyouwebid.news.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.wahyouwebid.core.base.BaseFragment
import com.wahyouwebid.core.utils.extension.hide
import com.wahyouwebid.core.utils.extension.show
import com.wahyouwebid.core.R
import com.wahyouwebid.news.databinding.FragmentNewsBinding
import com.wahyouwebid.news.domain.model.Article
import com.wahyouwebid.news.domain.state.NewsState
import com.wahyouwebid.news.presentation.adapter.NewsAdapter
import com.wahyouwebid.news.presentation.navigation.NewsNavigationFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment: BaseFragment<FragmentNewsBinding>() {

    private val viewModel: NewsViewModel by viewModels()

    @Inject
    lateinit var navigationFactory: NewsNavigationFactory

    private val navigation by lazy { navigationFactory.create(activity) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?): View {
        baseBinding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupToolbar() {
        with(binding) {
            toolbar.setToolbar(getString(R.string.app_name))
        }
    }

    override fun setupViewModel() {
        viewModel.getNewsArticles()
    }

    override fun setupObserveViewModel() {
        viewModel.article.observe(viewLifecycleOwner) {
            when(it) {
                is NewsState.Loading -> onLoading(true)
                is NewsState.Success -> onSuccess(it.data)
                is NewsState.Error -> onFailed(it.error)
            }
        }
    }

    private fun onLoading(isLoading: Boolean){
        with(binding) {
            if (isLoading) loading.show() else loading.hide()
        }
    }

    private fun onSuccess(data: List<Article>) {
        with(binding) {
            val adapter = NewsAdapter {article ->
                navigation.fromNewsListToNewsDetail(article)
            }
            rvLearning.also { recyclerView ->
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(context)
            }
            adapter.setData(data)
            onLoading(false)
        }
    }

    private fun onFailed(error: Throwable?) {
        Toast.makeText(context, error?.message.toString(), Toast.LENGTH_SHORT).show()
        onLoading(false)
    }

    override fun setupView() {}
    override fun setupData() {}
    override fun setupListener() {}
}