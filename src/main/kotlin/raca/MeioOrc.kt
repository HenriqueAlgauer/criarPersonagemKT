package raca

class MeioOrc : Raca(deslocamentoBase = 10, idiomaInicial = "orc") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "forca" to 2,
            "constituicao" to 1,
        )
    }
}
