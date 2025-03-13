package behavioral.strategy

// Concrete Strategies
class SemiAutomaticFire : WeaponSystem {
    override fun fire(target: String?) {
        try {
            println("Firing 3-round burst from KEW cannons at $target")
        }  catch (e: RuntimeException) {
            println("Error: Failed to engage target $target. Reason: ${e.message}")
        }
    }
}

class FullyAutomaticFire : WeaponSystem {
    override fun fire(target: String?) {
        try {
            println("Sustained barrage from rotating autocannons at $target")
        }  catch (e: RuntimeException) {
            println("Error: Failed to engage target $target. Reason: ${e.message}")
        }
    }
}

class MissileFire : WeaponSystem {
    override fun fire(target: String?) {
        try {
            println("Launching Viper Mark VII missile salvo at $target")
        }  catch (e: RuntimeException) {
            println("Error: Failed to engage target $target. Reason: ${e.message}")
        }
    }
}

// Context or user of our strategy
class Viper(private var weaponStrategy: WeaponSystem) {

    fun attack(target: String?) = weaponStrategy.fire(target)

    fun changeWeaponType(newStrategy: WeaponSystem) {
        weaponStrategy = newStrategy
        println("Tactical computer: Weapon system reconfigured")
    }
}
