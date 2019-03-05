package au.gov.api.test.asset

import au.gov.api.asset.Article
import au.gov.api.asset.Metadata
import au.gov.api.asset.Space
import au.gov.api.asset.AssetService
import au.gov.api.asset.AssetRepository
import org.junit.Assert
import org.junit.Test

class SpaceTests {
    @Test
    fun can_get_space_from_service(){
        val space1 = Space(Metadata( id = "space1" ))
        val space2 = Space(Metadata( id = "space2" ))


        val assetRepo = AssetRepository()
        val assetService = AssetService(assetRepo)


        assetRepo.load(space1)
        assetRepo.load(space2)


        val theSpace1 = assetService.getSpace(space1.metadata.id)
        Assert.assertEquals(space1, theSpace1)

        val theSpace2 = assetService.getSpace(space2.metadata.id)
        Assert.assertEquals(space2, theSpace2)

    }
}
