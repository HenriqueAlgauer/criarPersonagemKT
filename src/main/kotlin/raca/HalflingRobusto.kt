package raca
import personagem.Personagem

class HalflingRobusto : Raca(deslocamentoBase = 10, idiomaInicial = "halfing") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "constituicao" to 1,
        )
    }
}
