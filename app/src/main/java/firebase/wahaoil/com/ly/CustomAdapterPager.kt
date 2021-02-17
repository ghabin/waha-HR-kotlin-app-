package firebase.wahaoil.com.ly

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
//val intent = Intent (this@FragReport, MainActivity::class.java)
class CustomAdapterPager(fm:FragmentManager):FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
     var    title:String?=null
        when(position){
            0-> title="EmployeeID"
            1->title="Name"
            2->title="Section"
            3->title="Dept"}
        return title

    }

    override fun getItem(position: Int): Fragment {
        var fragment:Fragment?=null
        when (position){

            0-> {fragment= FragSearch() }
            1-> { fragment= Frag_FindByNames()}
            2-> { fragment= FragReport()}
            3-> {fragment= Frag_ShowRv()}
            4-> {fragment= Frag_About()}

   //  val intent = Intent (this@FragReport.context, ReportxActivity::class.java)
            //                   startActivity(intent)}

                   }
        return fragment!!
    }

    override fun getCount(): Int {
return 5
    }
}
