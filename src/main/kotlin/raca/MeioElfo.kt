package raca
import personagem.Personagem

class MeioElfo: Raca(deslocamentoBase = 10, idiomaInicial = "Elfico") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "carisma" to 2
        )
    }
}
