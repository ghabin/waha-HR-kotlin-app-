package firebase.wahaoil.com.ly
import firebase.wahaoil.com.ly.MyApplication.Companion.globalVarTxt
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import javax.xml.transform.Transformer
import com.google.firebase.database.*
//var x=MyApplication.globalVarTxt

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    companion object{
        val db= DatabaseHelper()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// this way to add fragment to main page directly
//        var frag_Search =Frag_Search()
//        var trans= supportFragmentManager.beginTransaction()
//        trans.replace(R.id.Main_Fram ,frag_Search )
//        trans.commit()
        myNavigationView.setNavigationItemSelectedListener (this) // to listen to the click on nav items
        db.connectionclass=ConnectionClass()
      setSupportActionBar(toolbar)
      supportActionBar?.title  ="xxx company"

        val myActionDrawerToggle=ActionBarDrawerToggle(this,myDrawer,toolbar,R.string.drawer_open,R.string.drawer_close)
        myDrawer.addDrawerListener(myActionDrawerToggle)
        myActionDrawerToggle.syncState()

        // this way to add many fragments to view pager adapter
        val myAdapterPager= CustomAdapterPager(this.supportFragmentManager)
        Main_pager.adapter=myAdapterPager
        myTabs.setupWithViewPager( Main_pager)
        myTabs.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#004D40"))
          }
    override fun onBackPressed() {
        if(myDrawer.isDrawerOpen(GravityCompat.START)  )
        {myDrawer.closeDrawer(GravityCompat.START)}
        else
            super.onBackPressed()

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
            R.id.About->  {  //Toast.makeText(this, "okkkkkkkkkk", Toast.LENGTH_LONG).show()
                myTabs.getTabAt(4)?.isSelected
               this.supportFragmentManager.beginTransaction ()
                  .add(R.id.Fram_Layout ,Frag_About())
                 //  .replace(R.id.Main_pager, Frag_About())
              //     .replace(R.id.Fram_Layout , Frag_About())

                  .commitNow()
                myDrawer.closeDrawer(GravityCompat.START)
            }}

        //   .replace( R.id.Main_pager ,Frag_FindByNames())

        return true
    }//fun navigation
}
