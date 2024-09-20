package raca
import personagem.Personagem

class GnomoDasRochas : Raca(deslocamentoBase = 10, idiomaInicial = "gnomo") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "constituicao" to 1,
        )
    }
}
