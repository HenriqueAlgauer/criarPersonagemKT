package raca
import personagem.Personagem

class Drow: Raca(deslocamentoBase = 10, idiomaInicial = "drow") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "carisma" to 1
        )
    }
}
