package behavioral.strategy

// Strategy Interface
interface WeaponSystem { fun fire(target: String) }

// Concrete Strategies
class SemiAutomaticFire : WeaponSystem {
    override fun fire(target: String) {
        println("Firing 3-round burst from KEW cannons at $target")
    }
}

class FullyAutomaticFire : WeaponSystem {
    override fun fire(target: String) {
        println("Sustained barrage from rotating autocannons at $target")
    }
}

class MissileFire : WeaponSystem {
    override fun fire(target: String) {
        println("Launching Viper Mark VII missile salvo at $target")
    }
}

// Context or user of our strategy
class Viper(private var weaponStrategy: WeaponSystem) {
    fun attack(target: String) = weaponStrategy.fire(target)

    fun changeWeaponType(newStrategy: WeaponSystem) {
        weaponStrategy = newStrategy
        println("Tactical computer: Weapon system reconfigured")
    }
}


//// Usage
//fun main() {
//    val viper = Viper(SemiAutomaticFire())
//
//    viper.attack("Cylon Raider")  // Firing 3-round burst from KEW cannons at Cylon Raider
//
//    viper.changeWeaponType(MissileFire())
//    viper.attack("Basestar weak point")  // Launching Viper Mark VII missile salvo at Basestar weak point
//
//    viper.changeWeaponType(FullyAutomaticFire())
//    viper.attack("Nuclear warhead barrage")  // Sustained barrage from rotating autocannons at Nuclear warhead barrage fired by Cylon Basestar
//}
