package firebase.wahaoil.com.ly
import firebase.wahaoil.com.ly.MyApplication.Companion.globalVarTxt
import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import firebase.wahaoil.com.ly.MyApplication.Companion.globalArray
import java.io.PrintWriter
import java.io.StringWriter

class DatabaseHelper {
    lateinit var ctx: Context
    private var isDone = false
    private lateinit var rv: RecyclerView
    private lateinit var query: String
    private lateinit var adapterArrlst: RecyclerView.Adapter<*>
    private var recordcount: Int = 0
    private var functionType: Int = 0
     lateinit var records: ArrayList<EmpCalc>
    lateinit var connectionclass: ConnectionClass
    @Suppress("DEPRECATION")
     inner class SyncData() : AsyncTask<String, String, String>() {

        private var message = "no connection or windows firewall"
        lateinit var prog: ProgressDialog
        override fun onPreExecute() {
            records.clear()
            recordcount = 0
            prog = ProgressDialog.show(ctx, "reading Data", "loading ....please wait", true)
        }

        var recordsNew= ArrayList<EmpCalc>()
            override fun doInBackground(vararg params: String?): String  {
                try {
                    var myConn = connectionclass.dbConn()
                    if (myConn == null) { isDone = false}
                     else {
                        var statement = myConn!!.createStatement()
                         var cursor = statement.executeQuery(query)
                        if (cursor != null) {
                            var x=   cursor.metaData.columnCount
                            var y=cursor.metaData.getColumnName(1)
                            var z=cursor.metaData.getColumnName(2)
                            var z1=cursor.metaData.getColumnName(3)
                          //    var z4=cursor.getDate(1)
                      //       var x2:String= globalVarTxt.toString()
                            globalArray.clear()
                                while (cursor!!.next()) {
                                try {
  //          records=ArrayList<EmpCalc>() as ArrayList<Any>
                          //          var m3=cursor.getString("deptName")
                                    when (functionType) {
                                             1 -> records.add(EmpCalc(cursor.getString("tot"),
                                                 cursor.getString("gender"),
                                                cursor.getString("deptName") ))

                                            2->   "if you have more than one query use this line "
                                       }
                                    recordcount++

                                }
                                catch (ex: Exception) {  ex.printStackTrace()}
                            }
                            message = "No of records found...$recordcount"
                            isDone = true
                            // useless recordsNew.addAll(records.orEmpty().filterNotNull())

                            globalArray.addAll(records)
                 //          records.forEach() {it. }

                        }else  // inner if  and need else
                    { message = "no data found"}
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                    val writer=StringWriter()
                    ex.printStackTrace(PrintWriter(writer))
                    message=writer.toString()
                        isDone = false
                }
                return message
            }
        override fun onPostExecute(result: String?) {
        prog.dismiss()
            if (isDone==false)
            { Toast.makeText(ctx , message,Toast.LENGTH_LONG).show()}
            else{
                try {
                     rv.adapter=adapterArrlst
                }    catch (ex:Exception){}
            }
          }
        }

        fun getEmpCalc(rv:RecyclerView ){
            this.rv=rv
            query="select * from Empcalc"
            records=ArrayList<EmpCalc>() as ArrayList<EmpCalc>
            adapterArrlst=EmpApdapter(records  as ArrayList<EmpCalc>)
            functionType=1
            SyncData().execute(""  )
        }
}











