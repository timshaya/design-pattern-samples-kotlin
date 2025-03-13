package structural.decorator

// Concrete component
class MarkIIViper : Viper {
    override fun attack() = 50
    override fun getDescription() = "Mark II Viper starfighter"
}

// Concrete decorators
class MissileSystemDecorator(viper: Viper) : ViperDecorator(viper) {
    override fun attack() = super.attack() + 25
    override fun getDescription() = "${super.getDescription()} with Typhoon Missile System"
}

class RailgunDecorator(viper: Viper) : ViperDecorator(viper) {
    override fun attack() = super.attack() + 40
    override fun getDescription() = "${super.getDescription()} and KEW Railgun"
}

class ECMDecorator(viper: Viper) : ViperDecorator(viper) {
    override fun getDescription() = "${super.getDescription()} + DRADIS ECM Suite"
}

//
//// Usage
//fun main() {
//    val viper: Viper = MarkIIViper()
//    println("Base viper: ${viper.getDescription()} | Attack: ${viper.attack()}")
//
//    val missileViper = MissileSystemDecorator(viper)
//    println("Enhanced: ${missileViper.getDescription()} | Attack: ${missileViper.attack()}")
//
//    val fullCombatViper = RailgunDecorator(ECMDecorator(missileViper))
//    println("Full combat package: ${fullCombatViper.getDescription()} | Attack: ${fullCombatViper.attack()}")
//}
