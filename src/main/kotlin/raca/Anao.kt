package raca
import personagem.Personagem

class Anao : Raca(deslocamentoBase = 10, idiomaInicial = "Anão") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "constituicao" to 2,
        )
    }
}
