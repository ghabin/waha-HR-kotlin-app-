package firebase.wahaoil.com.ly
import android.app.Application
import android.widget.EditText
import kotlinx.android.synthetic.main.layoutreportxdeptonrv.view.*
internal class MyApplication: Application()
{
    companion object {
     //   var globalVarTxt:EditText=R.id.filterTxt as EditText
        //   records=ArrayList<EmpCalc>() as ArrayList<Any>

        var globalVarTxt:String?=null
        var globalArray=ArrayList<EmpCalc>()


        }
        override fun onCreate() {
        super.onCreate()
         // initialization code here
    }
}
