package creational.factory

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import creational.factory.*

class StarFighterFactoryTest {

 @Test
 fun `create StarFighter Success`() {
   //Arrange, Act
   val cylonFighter = StarFighterFactory.createStarFighter(CylonFleet())?.shipModelName
   val colonialFighter = StarFighterFactory.createStarFighter(ColonialFleet())?.shipModelName

   //Assert
   assertEquals(cylonFighter, "Raider")
   assertEquals(colonialFighter, "Viper")
 }

 @Test
 fun `create StarFighter Fleet null`() {
   //Arrange, Act
   val cylonFleet = StarFighterFactory.createStarFighter(null)?.shipModelName

   //Assert
   assertNull(cylonFleet)

 }

}