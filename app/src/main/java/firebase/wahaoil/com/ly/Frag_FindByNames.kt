package firebase.wahaoil.com.ly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.frag_find_by_names.*
//import kotlinx.android.synthetic.main.frag_search_layout.* //call another fragment entierly

class Frag_FindByNames : Fragment() {
    var arrNames=ArrayList<String>()
//    val db = FirebaseDatabase.getInstance()
 //   val myRef = db.getReference("Emp").child("ename").orderByPriority().startAt("salah")
    //    .equalTo("male")
//val db = FirebaseDatabase.getInstance()
//    val myRef = db.getReference("Emp").child("gender").orderByPriority().equalTo("male")
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val  view =inflater.inflate(R.layout.frag_find_by_names, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabNames.setOnClickListener {
            getNames()

        }
    }//viewCreated

    fun getNames () {
        arrNames.clear()
        val db = FirebaseDatabase.getInstance()
        val myRef2 = db.getReference("Emp")
        myRef2.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {}
            override fun onDataChange(p0: DataSnapshot) {

                if (p0.getValue() != null) {
                    var values = p0.value as HashMap<String, Any>

                    for (k in values.keys) {
                        var getdata = values[k] as HashMap<String, Any>
                        var dataChk:String = getdata["aname"] as String
                        if (dataChk.startsWith(findNames.text.toString().trim()))
                        {
                            arrNames.add(dataChk)
                        } }

   val myArrayAdapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, arrNames)
                        myList.adapter = myArrayAdapter

                    //    Toast.makeText(context, p0.toString(), Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(context, p0.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })

    }//function getNames

              }//frag
//    ed_Ename.text = getdata["gender"] as String



