package br.com.zup.desafirickmorth.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.desafirickmorth.R
import br.com.zup.desafirickmorth.constants.PERSONAGENS
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.databinding.FragmentHomeBinding
import br.com.zup.desafirickmorth.ui.home.viewmodel.PersonViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val personAdapter by lazy {
        HomeAdapter(arrayListOf(), this::clickPersonDetall)
    }
    private val viewModel: PersonViewModel by lazy {
        ViewModelProvider(this)[PersonViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        showRecyclerView()
        viewModel.getAllPeson()
        initViewPerson()
    }

    private fun clickPersonDetall(person: PersonResult) {
        val bundle = bundleOf(PERSONAGENS to person)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_homeFragment_to_detallFragment, bundle)
    }

    private fun showRecyclerView() {
        binding.rvListPerson.adapter = personAdapter
        binding.rvListPerson.layoutManager = GridLayoutManager(context, 2)
    }

    private fun initViewPerson() {
        viewModel.personResponse.observe(this.viewLifecycleOwner) {
            personAdapter.updatePerson(it as MutableList<PersonResult>)
        }
    }
}