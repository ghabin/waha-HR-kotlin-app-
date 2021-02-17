package firebase.wahaoil.com.ly


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ActionMode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import firebase.wahaoil.com.ly.rv
import kotlinx.android.synthetic.main.activity_reportx.*
import kotlinx.android.synthetic.main.frag_report.*
import kotlinx.android.synthetic.main.frag_search_layout.*

/**
 * A simple [Fragment] subclass.
 */
class FragReport : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_report, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var rvTest:RecyclerView


       btnCall.setOnClickListener{
         val intent = Intent (this@FragReport.context, ReportxActivity::class.java)
           startActivity(intent)
   }

        button14.setOnClickListener {
            Toast.makeText(context, "You clicked me.", Toast.LENGTH_SHORT).show()

        }
//        btnCall.setOnClickListener{
//
//         //   var x= context!!.applicationContext.toString()
//                //var  rvx= it.rv
//            //rvTest.layoutManager = LinearLayoutManager(context)
//              rvTest.layoutManager= LinearLayoutManager( context, RecyclerView.VERTICAL ,false)
//                //  rvx.vsetHasFixedSize(true)
//                MainActivity.db.ctx= context!!
//                MainActivity.db.getEmpCalc(rvTest )
//
//
//
//
//        }

    }

}

