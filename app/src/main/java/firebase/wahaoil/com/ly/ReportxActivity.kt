package firebase.wahaoil.com.ly
import firebase.wahaoil.com.ly.MyApplication.Companion.globalArray
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_reportx.*
import kotlinx.android.synthetic.main.activity_reportx.view.*
import kotlinx.android.synthetic.main.frag_report.*


lateinit var rv:RecyclerView
val db=DatabaseHelper()

class ReportxActivity : AppCompatActivity(), TextWatcher {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportx)
        filterTxt.addTextChangedListener(this)
     //   records=ArrayList<EmpCalc>() as ArrayList<Any>

        fill_view.setOnClickListener{
  //var  rvx= it.rv
    rv.layoutManager=LinearLayoutManager(this ,RecyclerView.VERTICAL ,false)
  //  rvx.vsetHasFixedSize(true)
    MainActivity.db.ctx=this
    MainActivity.db.getEmpCalc(rv)
        }
  }
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
       // if (globalArray.isNotEmpty()){}

    var t2= globalArray.size
        var copyArraylst =ArrayList<EmpCalc>()
        copyArraylst.clear()
        copyArraylst.size
        var filterStr: String? = filterTxt.text.toString().trim().toLowerCase()
        globalArray.forEach() {
            if(it.deptName.toLowerCase().startsWith( filterStr.toString(),0,false))
            {    copyArraylst.add(it)    }
          var t=  copyArraylst.size
        //    globalArray.clear()//to not allow to add the data twice
        }
        rv.layoutManager=LinearLayoutManager(this ,RecyclerView.VERTICAL ,false)
        val myAdapter = EmpApdapter(copyArraylst)
        rv.adapter = myAdapter
        myAdapter.notifyDataSetChanged()

        }

        }

      //  globalVarTxt = filterTxt.text.toString()

     //   val recordsNew = ArrayList<EmpCalc>()

      //  recordsNew.clear()

//        var filterStr: String? = filterTxt.text.toString().trim()
//      //  var recordsCopy = ArrayList<EmpCalc>()
//var x1=db.records.size
//        var x2=x1
//

//
//   if( it.deptName.contains(filterStr.toString()))
//    recordsNew.add(it)
//   }
//        recordsNew.size
//        val myAdapter = EmpApdapter(recordsNew)
//        rv.adapter = myAdapter
//        myAdapter.notifyDataSetChanged()
//
//
//    }

  //  }
