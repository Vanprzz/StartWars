package com.gs.startwars.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Person : Serializable{
    var id:Int = 0
    var name: String = ""
    var height: Number = 0
    var mass: Number = 0
    var gender: String = ""
    var species: String =""
    var wiki: String=""
    var image: String=""
    @SerializedName("class") var clas: String=""
    var sensorColor: String=""
    var platingColor: String=""
    var affiliations: ArrayList<String> = ArrayList()
    var eyeColor: String =""
    var formerAffiliations: ArrayList<String> = ArrayList()
}
