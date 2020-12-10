package haonan.tech.experiment2.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import haonan.tech.experiment2.R
import haonan.tech.experiment2.entity.Fruit

class FruitAdapter(activity: Activity,val resourceId:Int,data:List<Fruit>):
    ArrayAdapter<Fruit>(activity, resourceId, data){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view:View
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)
        }else
           view = convertView

        val fruitImage:ImageView = view.findViewById(R.id.fruitImage)
        val fruitName:TextView = view.findViewById(R.id.fruitName)
        val fruit = getItem(position)

        if(fruit != null){
            fruitImage.setImageResource(fruit.imageId)
            fruitName.text = fruit.fruitName
        }
        return view
    }

}