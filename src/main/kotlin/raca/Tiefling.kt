package raca
import personagem.Personagem

class Tiefling: Raca(deslocamentoBase = 10, idiomaInicial = "tiefling") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "inteligencia" to 1,
            "carisma" to 2
        )
    }
}
