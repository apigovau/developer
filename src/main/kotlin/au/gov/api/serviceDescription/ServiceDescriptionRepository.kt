package au.gov.api.serviceDescription

import com.beust.klaxon.*
import org.springframework.stereotype.Component


@Component
class ServiceDescriptionRepository() {


    fun get(id:String) : ServiceDescription
    {
        return ServiceDescription()
    }

}
