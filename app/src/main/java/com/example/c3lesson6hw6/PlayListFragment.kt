package com.example.c3lesson6hw6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.c3lesson6hw6.databinding.FragmentPlayListBinding

class PlayListFragment : Fragment() {

    private lateinit var binding: FragmentPlayListBinding
    private val playList = arrayListOf(
        PlayList(1, "Blank Space", "Taylor Swift", "3:22"),
        PlayList(2, "Watch Me", "Silento", "5:36"),
        PlayList(3, "Earned It", "The Weekend", "4:51"),
        PlayList(4, "The Hills", "The Weekend", "3:41"),
        PlayList(5, "Writing's On The Wall", "Sam Smith", "4:36"),
        PlayList(6, "Dance The Night", "Dua Lipa", "2:56"),
        PlayList(7, "Flowers", "Miley Cyrus", "3:20"),
        PlayList(8, "Curtains", "Ed Sheeran", "3:44"),
        PlayList(9, "Karma", "Taylor Swift", "3:24"),
        PlayList(10, "Say Yes To Heaven", "Lana Del Rey", "3:29"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PlayListAdapter(playList, this::onClick)
        binding.rvPlaylist.adapter = adapter
    }


    private fun onClick(play: PlayList) {
        val bundle = Bundle()
            bundle.putSerializable("play", play)
        val fragment = DetailFragment()
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.top_container, fragment)
            .addToBackStack(null)
            .commit()
    }


}