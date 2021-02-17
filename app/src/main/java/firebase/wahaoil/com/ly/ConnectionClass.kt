package firebase.wahaoil.com.ly
import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectionClass{
   // private val ip="165.16.75.167:1433"
    private val ip= "10.0.2.2:1433/"
    private val db="waha"
    private val username="sa"
    private val password="salah"
    private val instance="SQLEXPRESS"
    fun dbConn():Connection{
        val policy=StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn:Connection?=null
var connString:String?=null

try {
    Class.forName("net.sourceforge.jtds.jdbc.Driver")
//    var url2="jdbc:jtds:sqlserver://localhost/waha;instance=SQLEXPRESS;sasalah;"

   val  url ="jdbc:jtds:sqlserver://localhost/instance=SQLEXPRESS;DatabaseName=waha;user=sa;password"
    val url2 =
            "jdbc:jtds:sqlserver://$ip/$db;instance=$instance;user=$username;password=$password"
    //+";"+ TDS                  //
    connString=url2
 //   connString="jdbc:jtds:sqlserver://$ip;instance=$instance;databaseName=$db;user=$username;password=$password;"
    //ssl=require;
    conn=DriverManager.getConnection(connString)
    } catch (ex:SQLException)
{   Log.e("Error" , ex.message) }
        catch (ex1:ClassNotFoundException)
                { Log.e("Error" , ex1.message) }
        catch (ex2:Exception){
        Log.e("Error" , ex2.message)}
        catch (tr: Throwable )
        {  Log.e("Error" , tr.message)}

        return conn!!
    }
    //fundbConn
}
