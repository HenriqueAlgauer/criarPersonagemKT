package raca
import personagem.Personagem

class Draconato : Raca(deslocamentoBase = 10, idiomaInicial = "Draconato") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "forca" to 2,
            "carisma" to 1,
        )
    }
}
