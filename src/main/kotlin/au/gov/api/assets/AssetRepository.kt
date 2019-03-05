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
        load(Space(Metadata(id = "ato", tags = listOf("ato")),
                name = "Australian Taxation Office",
                overview = "The ATO is the government's principal revenue collection agency with a large number of API-enabled services available and is bringing more online regularly. They are also responsible for managing the superannuation system and business registrations."
        ))
                 
        load(Article(metadata = Metadata(id = "Article1", tags = listOf("ato", "dhs")),
            title = "The Operating Framework is coming", 
            date = "01/01/1970",
            summary = "Here are the things you need to be doing now to remain compliant")
        )
        load(Article(metadata = Metadata(id = "Article2", tags = listOf("ato")),
            title = "Single Touch Payroll information sessions", 
            date = "02/01/1970",
            summary = "Learn about what employers will need to do, and what your software can do to help them")
        )



        load(Space(Metadata(id = "dhs", tags = listOf("dhs")),
                name = "Department Of Human Services",
                overview = "DHS delivers welfare services to the Australian public, with many API-enabled services that help doctors and other health providers lodge claims on behalf of their patients."
        ))
                 
        load(Article(metadata = Metadata(id = "Article3", tags = listOf("dhs")),
            title = "WPIT, and what it means for software providers", 
            date = "03/01/1970",
            summary = "WPIT is nearly live, and it's now time to start thinking about how your businesses can take part")
        )

    }

    fun getArticlesForTags(tags:List<String>): List<Article> {
        return articles.filter { it.metadata.matchesTags(tags) }
    }



    fun load(space:Space) = this.spaces.add(space)
    fun load(article:Article) = this.articles.add(article)

    fun getSpace(id:String) = spaces.first { it.metadata.id == id }
    fun getArticle(id:String) = articles.first { it.metadata.id == id }

}
