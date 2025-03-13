This is a Maven project written in Kotlin. 

Run the unit tests to execute the code. For example, 

see the relevant /test files for the Decorator pattern
```kotlin
 @Test
 fun `use multiple Decorators to make a Viper with full combat package`() {
  val viper: Viper = RailgunDecorator(MissileSystemDecorator(ECMDecorator(MarkIIViper())))
  println("viper.getDescription(): " + viper.getDescription())
  assertEquals("Mark II Viper starfighter + DRADIS ECM Suite with Typhoon Missile System and KEW Railgun", viper.getDescription())
  assertEquals(115, viper.attack())
 }
```
and this for the Factory pattern:

```kotlin
 @Test
 fun `create StarFighter Success`() {
   val cylonFighter = StarFighterFactory.createStarFighter(CylonFleet())?.shipModelName
   val colonialFighter = StarFighterFactory.createStarFighter(ColonialFleet())?.shipModelName
   
   assertEquals(cylonFighter, "Raider")
   assertEquals(colonialFighter, "Viper")
 }
```
