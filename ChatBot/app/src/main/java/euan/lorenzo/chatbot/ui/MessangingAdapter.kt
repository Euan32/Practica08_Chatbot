package euan.lorenzo.chatbot.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import euan.lorenzo.chatbot.R
import euan.lorenzo.chatbot.data.Message
import euan.lorenzo.chatbot.utils.Constans.RECEIVE_ID
import euan.lorenzo.chatbot.utils.Constans.SEND_ID
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.message_item.view.*
import org.w3c.dom.Text



class MessangingAdapter:RecyclerView.Adapter<MessangingAdapter.MessageViewHolder>() {
    var messagelist= mutableListOf<Message>()

    inner class MessageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item,parent,false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage=messagelist[position]
        when(currentMessage.id){
            SEND_ID->{
                holder.itemView.tv_message.apply{
                    text=currentMessage.message
                    visibility=View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility=View.GONE
            }
            RECEIVE_ID->{
                holder.itemView.tv_bot_message.apply{
                    text=currentMessage.message
                    visibility=View.VISIBLE
                }
                holder.itemView.tv_message.visibility=View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return messagelist.size
    }
    fun insertMessage(message:Message){
        this.messagelist.add(message)
        notifyItemInserted(messagelist.size)
        notifyDataSetChanged()
    }

}