package au.gov.api

import au.gov.api.asset.AssetService
import au.gov.api.asset.Space
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URLDecoder


@Controller
class Controller {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var assetService: AssetService


    @RequestMapping("/")
    fun index(model:MutableMap<String, Any?>): String{
        return "landing"
    }

    @RequestMapping("/space/{space}")
    fun space(@PathVariable space:String, model:MutableMap<String, Any?>): String{

        val theSpace = assetService.getSpace(space)
        model["popularArticles"] = assetService.getArticlesForSpace(theSpace)

        return "space"
    }
}
