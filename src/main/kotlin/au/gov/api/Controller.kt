package au.gov.api

import au.gov.api.asset.AssetService
import au.gov.api.asset.Space
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
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
        model["space"] = theSpace
        model["articlesTagString"] = toQueryParam("tag", theSpace.metadata.tags) 
        model["popularArticles"] = assetService.getArticlesForSpace(theSpace).take(2)
        return "space"
    }


    @RequestMapping("/article/{id}")
    fun article(@PathVariable id:String, model:MutableMap<String, Any?>): String{
        model["article"] = assetService.getArticle(id)
        return "article"
    }

    @RequestMapping("/articles")
    fun article(@RequestParam tag:List<String>, model:MutableMap<String, Any?>): String{
        model["articles"] = assetService.getArticlesForTags(tag)
        return "articles"
    }


    private fun toQueryParam(tagName:String, theList:List<String>) = theList.map { "${tagName}=${it}" }.joinToString("&")

}
