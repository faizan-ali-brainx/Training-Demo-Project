package com.example.trainingdemoapp.fragments

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingdemoapp.activities.ActivitiesAndTipsActivity
import com.example.trainingdemoapp.adpaters.TipsVideoAdapter
import com.example.trainingdemoapp.base.BaseFragment
import com.example.trainingdemoapp.databinding.FragmentTipsBinding
import com.example.trainingdemoapp.models.VideosModel
import com.example.trainingdemoapp.utils.Constants.ONE
import com.example.trainingdemoapp.utils.Constants.TWO
import com.example.trainingdemoapp.viewHolders.VideoViewHolder
import com.example.trainingdemoapp.viewModels.TipsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TipsFragment : BaseFragment<TipsViewModel, FragmentTipsBinding>(),
    VideoViewHolder.VideoClickListener {

    // region private properties
    private var videoList = ArrayList<VideosModel>()
    private lateinit var requiredActivity: ActivitiesAndTipsActivity
    private lateinit var videoLayoutManager: LinearLayoutManager
    private lateinit var videoAdapter: TipsVideoAdapter
    // end region

    // region lifeCycle methods
    override val mViewModel: TipsViewModel by viewModels()

    override fun getViewBinding() = FragmentTipsBinding.inflate(layoutInflater)

    override fun customOnViewCreated(savedInstanceState: Bundle?) {
        requiredActivity = requireActivity() as ActivitiesAndTipsActivity
        videoAdapter = TipsVideoAdapter(this@TipsFragment)
        setViewModelObserver()
        getTipsVideo()
        setTipsObservable()
        setTrainingVideoListObservable()
        setRecyclerView()
    }
    // end region

    // region private functions
    private fun setViewModelObserver() {
        mViewModel.apply {
            vmLoadingObserver.observe(requireActivity(), getLoadingObserver())
            vmMessageObserver.observe(requireActivity(), getErrorObserver())
        }
    }

    private fun getTipsVideo() {
        mViewModel.getTips(ONE)
    }

    private fun setTipsObservable() {
        mViewModel.apply {
            tips.observe(requiredActivity, {
                if (!it.tips.isEmpty()) {
                    videoList.addAll(it.tips)
                    tipsVideosList.postValue(videoList)
                }
            })
        }
    }

    private fun setTrainingVideoListObservable() {
        mViewModel.apply {
            tipsVideosList.observe(requiredActivity, {
                videoAdapter.setData(it)
            })
        }
    }

    private fun setRecyclerView() {
        mViewBinding.tipsRecyclerView.apply {
            videoAdapter.setData(ArrayList<VideosModel>())
            adapter = videoAdapter
            videoLayoutManager = GridLayoutManager(activity, TWO)
            layoutManager = videoLayoutManager
        }

    }
    // end region

    // region public functions
    // end region

    // region listeners
    // end region

    // region override methods
    override fun onVideoItemClicked(video: VideosModel) {

    }
    // end region

}