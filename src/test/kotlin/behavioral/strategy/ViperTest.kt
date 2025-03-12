package behavioral.strategy

import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertFailsWith
import com.github.stefanbirkner.systemlambda.SystemLambda
import behavioral.strategy.*

class ViperTest {

 private val mockWeapon = mockk<WeaponSystem>()
 private val viper = Viper(mockWeapon)

 @Test
 fun `attack via current weapon strategy success`() {
  // Arrange
  val target = "Cylon Raider"
  every { mockWeapon.fire(target) } just Runs

  // Act
  viper.attack(target)

  // Assert
  verify(exactly = 1) { mockWeapon.fire(target) }
 }

 @Test
 fun `changing Viper weapon to future one of type WeponSystem should update strategy`() {
  val newFutureWeapon =  mockk<WeaponSystem>()
  every { newFutureWeapon.fire(any()) } just Runs

  viper.changeWeaponType(newFutureWeapon)
  viper.attack("Test Target")

  verify { newFutureWeapon.fire("Test Target") }
  confirmVerified(newFutureWeapon)
 }

 @Test
 fun `attack propagates WeaponSystem exceptions`() {
  val mockWeapon = mockk<WeaponSystem>()
  val viper = Viper(mockWeapon)
  val expectedException = RuntimeException("Weapon malfunction")

  every { mockWeapon.fire(any()) } throws expectedException

  val exception = assertFailsWith<RuntimeException> {
   viper.attack("Cylon Basestar")
  }

  assertEquals("Weapon malfunction", exception.message)
  verify(exactly = 1) { mockWeapon.fire("Cylon Basestar") }
 }

 @Test
 fun `attack uses newly configured MissileFire weapon`() {

  val viper = Viper(SemiAutomaticFire()) // Initial weapon
  val missileWeapon = spyk(MissileFire()) // Spy on concrete strategy

  viper.changeWeaponType(missileWeapon)
  viper.attack("Basestar bridge")

  verify { missileWeapon.fire("Basestar bridge") }
  confirmVerified(missileWeapon) // Verify no extra interactions
 }

 @Test
 fun `attack shows correct missile launch message`() {
  val viper = Viper(MissileFire())
  val target = "Basestar bridge"

  val output = SystemLambda.tapSystemOut {
   viper.attack(target)
  }

  assertTrue(output.contains("Launching Viper Mark VII missile salvo at $target"))
 }


 @ParameterizedTest
 @MethodSource("weaponProvider")
 fun `should execute different weapon strategies`(strategy: WeaponSystem) {
  val viper = Viper(strategy)
  val target = "Basestar"

  assertDoesNotThrow { viper.attack(target) }
 }

 companion object {
  @JvmStatic
  fun weaponProvider() = listOf(
   FullyAutomaticFire(),
   SemiAutomaticFire(),
   MissileFire()
  )
 }

}