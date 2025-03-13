package structural.decorator

abstract class ViperDecorator(private val viper: Viper) : Viper by viper

/* alt implementation sans "by" keyword might be easier to understand:
abstract class ViperDecorator(private val viper: Viper) : Viper {
    override fun getDescription(): String = viper.getDescription()
    override fun attack(): Int = viper.attack()
}
*/