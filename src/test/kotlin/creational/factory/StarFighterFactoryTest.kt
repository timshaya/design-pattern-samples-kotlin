package creational.factory

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull

class StarFighterFactoryTest {

 @Test
 fun `create StarFighter Success`() {
   val cylonFighter = StarFighterFactory.createStarFighter(CylonFleet())?.shipModelName
   val colonialFighter = StarFighterFactory.createStarFighter(ColonialFleet())?.shipModelName
   assertEquals(cylonFighter, "Raider")
   assertEquals(colonialFighter, "Viper")
 }

 @Test
 fun `create StarFighter Fleet null`() {
   val cylonFleet = StarFighterFactory.createStarFighter(null)?.shipModelName

   assertNull(cylonFleet)

 }

}