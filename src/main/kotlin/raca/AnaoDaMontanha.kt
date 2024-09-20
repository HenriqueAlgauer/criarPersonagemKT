package raca
import personagem.Personagem

class AnaoDaMontanha : Raca(deslocamentoBase = 10, idiomaInicial = "Anão") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "forca" to 2,
        )
    }
}
