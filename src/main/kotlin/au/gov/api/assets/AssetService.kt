package au.gov.api.asset

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import au.gov.api.asset.Metadata
import au.gov.api.asset.Article

data class Article(val metadata:Metadata = Metadata(), val title:String = "", val date:String = "", val summary:String = "")


@Service
class AssetService {

    constructor(theRepo:AssetRepository){
        repo = theRepo
    }

    @Autowired
    lateinit var repo: AssetRepository

    fun getArticlesForTags(tags:List<String>): List<Article> = repo.getArticlesForTags(tags)
    fun getArticlesForSpace(space:Space): List<Article> = repo.getArticlesForTags(space.metadata.tags)
    fun getSpace(id:String):Space = repo.getSpace(id)
    fun getArticle(id:String):Article = repo.getArticle(id)

}

