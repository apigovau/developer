package au.gov.api.serviceDescription

import com.beust.klaxon.Json

class ServiceDescription(val name:String = "", val description:String = "", val tags:List<String> = listOf("")) {
    init{
    }
}
