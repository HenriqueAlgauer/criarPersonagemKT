package raca
import bonus.Bonus
import personagem.Personagem

open class Raca(val deslocamentoBase: Int, val idiomaInicial: String) : Bonus {
    override fun calculaBonus(): Map<String, Int> {
        return emptyMap()
    }
}