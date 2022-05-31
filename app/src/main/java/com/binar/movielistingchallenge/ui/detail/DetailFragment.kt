package com.binar.movielistingchallenge.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.binar.movielistingchallenge.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = args.movieDetails.title
        val date = args.movieDetails.date
        val overview = args.movieDetails.overview
        val image = args.movieDetails.poster

        binding.tvTitle.text = title
        binding.tvDate.text = date
        binding.tvOverview.text = overview

        Glide.with(requireContext())
            .load("https://image.tmdb.org/t/p/w780/$image")
            .into(binding.ivMovie)

        binding.btnFavourite.setOnClickListener {
            viewModel.addToFavourites(title, date, overview, image)
        }
    }
}