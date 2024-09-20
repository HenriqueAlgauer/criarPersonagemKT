package raca
import personagem.Personagem

class ElfoDaFloresta: Raca(deslocamentoBase = 10, idiomaInicial = "Elfico") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "sabedoria" to 1,
        )
    }
}
