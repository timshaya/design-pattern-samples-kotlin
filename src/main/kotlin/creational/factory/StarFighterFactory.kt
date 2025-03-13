package creational.factory

data class ColonialFleet(var name: String? = "Colonial Fleet"): Fleet
data class CylonFleet(var name: String? = "Caprica BaseStars"): Fleet

class StarFighter(modelName: String) { var shipModelName = modelName }

object StarFighterFactory {
    fun createStarFighter(fleet: Fleet?): StarFighter? {
        try {
            when (fleet) {
                is ColonialFleet -> return StarFighter("Viper")
                is CylonFleet -> return StarFighter("Raider")
                else -> {
                    println("No fleet specified")
                }
            }
        } catch(e: RuntimeException){
            println("Error: createStarFighter() requires a Fleet")
        }
        return null
    }
}