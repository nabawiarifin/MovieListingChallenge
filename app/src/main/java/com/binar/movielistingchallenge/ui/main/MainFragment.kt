package com.binar.movielistingchallenge.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.movielistingchallenge.databinding.FragmentMainBinding

//// Binar
//class MainFragment : Fragment() {
//    private lateinit var binding: FragmentMainBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        binding = FragmentMainBinding.inflate(layoutInflater)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        fetchData()
//    }
//
//    private fun fetchData() {
//        MovieApi.retrofitService.getMovies()
//            .enqueue(object : Callback<List<Movies>>{
//                override fun onResponse(
//                    call: Call<List<Movies>>,
//                    response: Response<List<Movies>>
//                ) {
//                    val body = response.body()
//                    val code = response.code()
//                    if (code == 200) {
//                        showList(body)
//                        binding.progressBar.visibility = View.GONE
//                    } else {
//                        binding.progressBar.visibility = View.GONE
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
//                    binding.progressBar.visibility = View.GONE
//                }
//            })
//    }
//
//    private fun showList(data: List<Movies>?) {
//        val adapter = MainAdapter(object: MainAdapter.OnClickListener{
//            override fun onClickItem(data: Movies) {}
//        })
//        adapter.submitData(data)
//        binding.recyclerView.adapter = adapter
//    }
//}
//
//Andre
class MainFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    private val args: MainFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Displays recycler view data
        setupObserver()

        //Gets username from login page using navArgs
        binding.tvUsername.text = args.username

        binding.tvProfile.setOnClickListener {

        }

    }

    private fun setupObserver(){
        viewModel.getMovies().observe(requireActivity()){
            val adapter = MainAdapter(it)
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.layoutManager = layoutManager
            binding.recyclerView.adapter = adapter
        }
    }
}