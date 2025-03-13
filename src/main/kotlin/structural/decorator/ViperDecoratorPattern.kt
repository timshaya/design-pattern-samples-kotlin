package structural.decorator

class MarkIIViper : Viper {
    override fun attack() = 50
    override fun getDescription() = "Mark II Viper starfighter"
}

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
