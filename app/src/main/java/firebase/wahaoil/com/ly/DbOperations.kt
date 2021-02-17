//package firebase.wahaoil.com.ly
//
//
//var map = HashMap<String, String>()
////       var listx = ArrayList<String>()
//
//val database = FirebaseDatabase.getInstance()
//val myRef = database.getReference("db").child("card")
//
//
//saveBtn.setOnClickListener {
//    for (i in 1..3) {
//        val name: String = edname.text.toString()
//        val id: String = edId.text.toString()
//        map.put("name", name)
//        map.put("Id", id)
//        myRef.push().setValue(map)
//
//        // method to deal with getkey()
////          val mykey=  myRef.push().key
////                if (mykey != null) {
////                    myRef.child(mykey).setValue(map)
////                    myRef.push().setValue(map)
////                }
//    }
//}
//
//btnQuery.setOnClickListener {
//    //            val database = FirebaseDatabase.getInstance()
////            val myRef = database.getReference()
//
//    val database = FirebaseDatabase.getInstance()
//    //      val myRef = database.getReference("db").child("card").child("name").child("id")
//    val myRef = database.getReference("db").child("card")
//    //    myRef.equalTo("salah2")
//    myRef.addValueEventListener(object : ValueEventListener {
//        override fun onCancelled(p0: DatabaseError) {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//
//        override fun onDataChange(p0: DataSnapshot) {
//
//            //   if(!p0!!.hasChild("name")){
//            //     tvRead!!.text=p0!!.key.toString()
//            //       tvRead!!.text=p0!!.getValue(String::class.java)
//
//            //    }
//            // bring all data at oonce means all records as bulk
//            // val getdata3 = p0.value
//
////   the best way to get all the objects
//            var values = p0!!.value as HashMap<String, Any>
//
//            for (k in values.keys) {
//                var data = values[k] as HashMap<String, Any>
//                myArraylist.add(FillArray( data["name"] as String , data["id"] as String))
//                //      tvRead!!.text= data["name"] as String
//            }
////Toast.makeText(applicationContext,myArraylist[1].name,Toast.LENGTH_LONG).show()
//        }
//    })
//}
////        val x= arrayOf("a","b","c","d")
////        val myAdapter = ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1,x )
////        myListView.adapter=myAdapter
//
//
//}
//}
//
//
////this method to retrive data as single line but sofar not working for all object
////                 val getdata  = p0.getValue(String::class.java)
////            try to do it     val getdata  = p0!!.child("name")getValue(String::class.java)
////                  tvRead!!.text= getdata.toString()
///////////////////////////////////////////////////////
//
////   for(FillArray in myArraylist)
////  println(FillArray)
////  println(myArraylist[2].name)
//
////==========================
////           val data1 = hashMapOf(
////                "name" to "San Francisco",
////                "state" to "CA",
////                "country" to "USA",
////                "capital" to false,
////                "population" to 860000,
////                "regions" to listOf("west_coast", "norcal"))
////                myRef.push().setValue(data1)
////        }
////       myRef.child("id").push().setValue("TRIPOLI")
////  myRef.child("ID").push().setValue(id)
