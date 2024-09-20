package raca

class Elfo : Raca(deslocamentoBase = 10, idiomaInicial = "Elfico") {
    override fun calculaBonus(): Map<String, Int> {
        return mapOf(
            "destreza" to 2,
        )
    }
}