package au.gov.api.asset

class Space(val metadata:Metadata = Metadata(), val name:String = "", val overview:String = ""){
    fun popularArticles():List<Article> = listOf()
}

