package raca
import personagem.Personagem

class Gnomo: Raca(deslocamentoBase = 10, idiomaInicial = "gnomo") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "inteligencia" to 2,
        )
    }
}
