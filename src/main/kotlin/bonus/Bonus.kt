package bonus
import personagem.Personagem

interface Bonus {
    fun calculaBonus(): Map<String, Int>
}