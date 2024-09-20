package raca
import personagem.Personagem

class Humano : Raca(deslocamentoBase = 10, idiomaInicial = "Comum") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "forca" to 1,
            "destreza" to 1,
            "constituicao" to 1,
            "inteligencia" to 1,
            "sabedoria" to 1,
            "carisma" to 1
        )
    }
}