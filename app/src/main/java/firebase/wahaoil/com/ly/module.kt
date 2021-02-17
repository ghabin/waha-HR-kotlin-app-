package firebase.wahaoil.com.ly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layoutreportxdeptonrv.view.*

data class EmpCalc(var tot: String, var gender:String, var deptName:String)

 class EmpApdapter(var employeesArrLst:ArrayList<EmpCalc>):RecyclerView.Adapter<EmpApdapter.ViewHolder>(){


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    //  casting operation  for test var tvTot = itemView.findViewById(R.id.tvTot) as TextView
    var tvTot=itemView.tvTot
        var tvGender = itemView.tvGender
        var tvdept = itemView.tvDept
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v=LayoutInflater.from(p0.context).inflate(R.layout.layoutreportxdeptonrv,p0,false)

   return ViewHolder(v)
    }

    override fun getItemCount(): Int {

  return employeesArrLst.size
    }

    override fun onBindViewHolder(holder:ViewHolder, p1: Int) {
var empcalc=employeesArrLst[p1]
        holder.tvTot.text=empcalc.tot
        holder.tvGender.text=empcalc.gender
        holder.tvdept.text=empcalc.deptName

           }


 }
