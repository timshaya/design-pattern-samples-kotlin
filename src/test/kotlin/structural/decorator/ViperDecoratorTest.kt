package structural.decorator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ViperDecoratorTest {

 @Test
 fun `make a basic Viper`() {
  val viper: Viper = MarkIIViper()
  assertEquals("Mark II Viper starfighter", viper.getDescription())
  assertEquals(50, viper.attack())
 }

 @Test
 fun `use MissileSystemDecorator to create Viper with missiles`() {
  val viper: Viper = MissileSystemDecorator(MarkIIViper())
  assertEquals("Mark II Viper starfighter with Typhoon Missile System", viper.getDescription())
  assertEquals(75, viper.attack())
 }

 @Test
 fun `use RailgunDecorator to make Viper with Railgun`() {
  val viper: Viper = RailgunDecorator(MarkIIViper())
  assertEquals("Mark II Viper starfighter and KEW Railgun", viper.getDescription())
  assertEquals(90, viper.attack())
 }

 @Test
 fun `use ECMDecorator to make a Viper with advanced DRADIS navigation system`() {
  val viper: Viper = ECMDecorator(MarkIIViper())
  assertEquals("Mark II Viper starfighter + DRADIS ECM Suite", viper.getDescription())
  assertEquals(50, viper.attack()) // ECM doesn't affect attack value
 }

 @Test
 fun `use multiple Decorators to make a Viper with full combat package`() {
  val viper: Viper = RailgunDecorator(MissileSystemDecorator(ECMDecorator(MarkIIViper())))
  println("viper.getDescription(): " + viper.getDescription())
  assertEquals("Mark II Viper starfighter + DRADIS ECM Suite with Typhoon Missile System and KEW Railgun", viper.getDescription())
  assertEquals(115, viper.attack())
 }

}