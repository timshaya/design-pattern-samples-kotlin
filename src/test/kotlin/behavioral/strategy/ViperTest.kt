package behavioral.strategy

import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

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
  // Arrange
  val newFutureWeapon =  mockk<WeaponSystem>()
  every { newFutureWeapon.fire(any()) } just Runs

  // Act
  viper.changeWeaponType(newFutureWeapon)
  viper.attack("Test Target")

  // Assert
  verify { newFutureWeapon.fire("Test Target") }
  confirmVerified(newFutureWeapon)
 }

 @Test
 fun `changing Viper weapon to MissileFire should update strategy`() {
  // Arrange
  val missileWeapon =  MissileFire()

  // Act
  viper.changeWeaponType(missileWeapon)
  viper.attack("Basestar bridge")


  // TODO: Assert another way - missileWeapon is not a Mockk here, so can't call verify {} on it in this case:...
  //verify { missileWeapon.fire("Basestar bridge") }
  //confirmVerified(missileWeapon)

 }

 @ParameterizedTest
 @MethodSource("weaponProvider")
 fun `should execute different weapon strategies`(strategy: WeaponSystem) {
  // Arrange
  val viper = Viper(strategy)
  val target = "Basestar"

  // Act/Assert
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