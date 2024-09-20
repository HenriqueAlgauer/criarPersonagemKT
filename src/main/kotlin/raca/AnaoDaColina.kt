package raca

class AnaoDaColina: Raca(deslocamentoBase = 10, idiomaInicial = "anao") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "sabedoria" to 1,
        )
    }
}
