package raca

class Halfling : Raca(deslocamentoBase = 10, idiomaInicial = "Halfing") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "destreza" to 2,
        )
    }
}