Run the unit tests to execute the code. For example, 

```kotlin
 @Test
 fun `create StarFighter Success`() {
   val cylonFighter = StarFighterFactory.createStarFighter(CylonFleet())?.shipModelName
   val colonialFighter = StarFighterFactory.createStarFighter(ColonialFleet())?.shipModelName
   
   assertEquals(cylonFighter, "Raider")
   assertEquals(colonialFighter, "Viper")
 }
