package firebase.wahaoil.com.ly


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_reportx.*

/**
 * A simple [Fragment] subclass.
 */
class Frag_ShowRv : Fragment() {
    val db=DatabaseHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.showrv_frag, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        //   records=ArrayList<EmpCalc>() as ArrayList<Any>

     fill_view.setOnClickListener {
            //var  rvx= it.rv
            rv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//            //  rvx.vsetHasFixedSize(true)
           MainActivity.db.ctx = context!!
        MainActivity.db.getEmpCalc(rv)
        }


       // Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()

    }


    }


