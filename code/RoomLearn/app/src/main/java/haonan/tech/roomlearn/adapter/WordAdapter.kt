package haonan.tech.roomlearn.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import haonan.tech.roomlearn.R
import haonan.tech.roomlearn.entity.Word
import kotlinx.android.synthetic.main.cell_normal.view.*




class WordAdapter(val WordList: LiveData<List<Word>>): RecyclerView.Adapter<WordAdapter.MyViewHolder>() {

    var allWords :List<Word> = ArrayList<Word>()

    fun setAllWords( abc : ArrayList<Word>){
        allWords =  abc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView:View = layoutInflater.inflate(R.layout.cell_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val word: Word = allWords.get(position)
        holder.textViewNumber.text = word.id.toString()
        holder.textViewChinese.text = word.chineseMeaning
        holder.textViewEnglish.text = word.word
    }



    override fun getItemCount(): Int {
        return  allWords.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textViewNumber:TextView = itemView.findViewById(R.id.textView_number)
        var textViewEnglish:TextView = itemView.findViewById(R.id.textView_englishWord)
        var textViewChinese:TextView = itemView.findViewById(R.id.textView_chineseWord)
    }
}