package au.gov.api.asset

import com.beust.klaxon.*
import org.springframework.stereotype.Component
import org.springframework.context.event.EventListener
import org.springframework.boot.context.event.ApplicationReadyEvent


@Component
class AssetRepository() {

    private val spaces:MutableList<Space> = mutableListOf()
    private val articles:MutableList<Article> = mutableListOf()


    @EventListener(ApplicationReadyEvent::class)
    fun insertContentOnStartup(){
        load(Space(Metadata(id = "ato", tags = listOf("ato"))))
                 
        load(Article(metadata = Metadata(id = "Article1", tags = listOf("ato")), title = "The Operating Framework is coming", date = "01/01/1970", summary = "Come and learn about the framework"))
    }

    fun getArticlesForTags(tags:List<String>): List<Article> {
        return articles.filter { it.metadata.matchesTags(tags) }
    }



    fun load(space:Space) = this.spaces.add(space)
    fun load(article:Article) = this.articles.add(article)

    fun getSpace(id:String) = spaces.first { it.metadata.id == id }
    fun getArticle(id:String) = articles.first { it.metadata.id == id }

}
