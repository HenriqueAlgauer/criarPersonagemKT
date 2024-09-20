package raca

class AltoElfo: Raca(deslocamentoBase = 10, idiomaInicial = "Elfico") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "inteligencia" to 1,
        )
    }
}
