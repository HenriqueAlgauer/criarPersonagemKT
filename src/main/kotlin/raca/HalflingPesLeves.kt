package raca
import personagem.Personagem

class HalflingPesLeves: Raca(deslocamentoBase = 10, idiomaInicial = "Halfing") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "carisma" to 1
        )
    }
}
