package firebase.wahaoil.com.ly
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.frag_search_layout.*
import kotlinx.android.synthetic.main.frag_search_layout.view.*


class FragSearch : Fragment() {

    //val ordersRef =  myRef.child("orders").orderByChild("phonenumber").equalTo("salah")
    // var map = HashMap<String, String>()

  //  var arraylistEmp = ArrayList<FillArray>()

    @RequiresApi(Build.VERSION_CODES.N)
  //  var years=Calendar.getInstance().get(Calendar.YEAR)

    val db = FirebaseDatabase.getInstance()
    val myRef = db.getReference("Emp").child("gender").orderByPriority().equalTo("male")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

          //     val  btn = view!!.findViewById(R.id.btnReadData) as Button
        // Inflate the layout for this fragment

val view=inflater.inflate(R.layout.frag_search_layout, container, false)
  //  var  mybtn =   view.btnReadData
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  val  btn = view!!.findViewById(R.id.btnSave) as Button
        var value:String?=null
        /* val myRef = database.getReference("Employees") */
        btnSave2.setOnClickListener({
            val db = FirebaseDatabase.getInstance()
            val myRef = db.getReference("ename")
            myRef.push().child("ename").setValue("pok6")
            myRef.push().child("ename").setValue("pok7")
            myRef.push().child("ename").setValue("pok8")
            //    myRef.setValue("saved")
        })

view.fabClear.setOnClickListener{
    ClearObjs()
}
     view.fab.setOnClickListener {

       //   val  ed_Search = view!!.findViewById(R.id.ed_search) as EditText
          var mSearch= ed_search.text.toString()
          val db = FirebaseDatabase.getInstance()
          val myRef = db.getReference("Emp").orderByKey().equalTo( mSearch.trim())
          myRef.addValueEventListener(object : ValueEventListener {
                   override fun onCancelled(p0: DatabaseError) {
                   }
                @RequiresApi(Build.VERSION_CODES.N)

                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.getValue() != null) {
                        try {
                        //    var values:String? = p0.getValue(String()::class.java)
                         //   ed_id.text = values.toString()
                                 var values = p0.value as HashMap<String,Any>
                                for (k in values.keys) {
                                    var getdata  = values[k] as HashMap<String,Any>
                                    ed_Aname.text= getdata["aname"]  as String
                                    ed_Ename.text= getdata["ename"]  as String
                          var myDate = getdata["bdate"]  as Any
                          var m=myDate.toString().substring(1,10)
                          ed_bdate.text=m.toString()
                          ed_Dept.text= getdata["deptName"]  as String
                          ed_Grade.text=getdata["grade"]  as String
                          ed_assignCat.text=getdata["assignCat"]  as String
                     //    var myYears2 =Calendar.getInstance()
                     //    ed_bdate.text=myYearsyears.toString()
                       var x:Any = getdata["empno"]  as Any
                  if(!getdata.containsValue("x")  ){var c=10 }
                     //    ed_id!!.text=x
                      // gives all values at once  var x=p0.getValue()
                //   ed_id!!.text=getdata.values.toString()
                     //    ed_id!!.text=getdata.keys.toString()
                     }
                        } catch (e: Exception) {

                            Toast.makeText(context,e.toString(),Toast.LENGTH_LONG).show()
                        }

                    } else {
                        Toast.makeText(context,"null pointer",Toast.LENGTH_LONG).show()
                        }

                } }  )
            }
// //////////////////////////////////////////////////////////////////////////
      }
    fun ClearObjs ( ){
        ed_search.text.clear()
        ed_Ename.text=""
        ed_Aname.text=""
        ed_assignCat.text=""
        ed_Grade.text=""
        ed_bdate.text=""
        ed_Dept.text=""



    }


}




//    Toast.makeText(context  ,p0.message,Toast.LENGTH_LONG).show()

//        val getdata  = p0!!.child("empno").getValue(String::class.java)
//         ed_id!!.text= getdata.toString()
//
//                    if(p0!=null && p0.exists())
//                    {
//                        var values = p0!!.value as HashMap<String, String>
//
//                      for (k in values.keys) {
//
//                           var getdata = values[k] as HashMap<String, String>
//                          ed_id!!.text=  getdata["empno"] as String
//                          ed_id!!.text="ssssssssssss"
//  if( getdata["ename"] as String=="ali"){ arraylistEmp.add(FillArray( getdata["empno"] as String, getdata["ename"] as String))
//
//                                }
//                    }
//                    else{ ed_id!!.text="no data in po"  }


//way to read data
//    for(h in p0!!.children){
//    var fillArray =h.getValue(FillArray::class.java)
//   var x=h.key
//      var y=p0.value
//       ed_id!!.text=y.toString()
//          arraylistEmp.add(fillArray!!)


//         //if( getdata["ename"] as String=="ali"){ arraylistEmp.add(FillArray( getdata["empno"] as String, getdata["ename"] as String))