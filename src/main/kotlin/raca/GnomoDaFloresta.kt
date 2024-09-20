package raca
import personagem.Personagem

class GnomoDaFloresta : Raca(deslocamentoBase = 10, idiomaInicial = "gnomo") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "destreza" to 1,
        )
    }
}
