package br.com.zup.desafirickmorth.ui.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.desafirickmorth.databinding.PersonItemBinding
import br.com.zup.desafirickmorth.domain.Person

class HomeAdapter(
    private var listPerson: MutableList<Person>,
    private var clickDetallPerson: (person: Person) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val person = listPerson[position]
        holder.displayCharacterInformation(person)
        holder.itemView.setOnClickListener {
            clickDetallPerson(person)
        }
    }

    override fun getItemCount() = listPerson.size

    class ViewHolder(val binding: PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun displayCharacterInformation(person: Person) {
            binding.personImage.setImageResource(person.image)
            binding.ivPersonName.text = person.name
        }
    }
}