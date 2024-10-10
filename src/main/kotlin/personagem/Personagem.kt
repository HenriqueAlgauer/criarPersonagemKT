package personagem
import raca.Raca

open class Personagem(
    val nome: String,
    val raca: Raca,
    var forca: Int = 8,
    var destreza: Int = 8,
    var constituicao: Int = 8,
    var inteligencia: Int = 8,
    var sabedoria: Int = 8,
    var carisma: Int = 8
) {
    var vida: Int = 10
    var nivel: Int = 1

    private val bonusRacial = raca.calculaBonus()

    private fun calcularVida(): Int {
        val constituicaoTotal = constituicao + (bonusRacial["constituição"] ?: 0)
        val constituicaoModificador = calcularModificador(constituicaoTotal)
        return vida + constituicaoModificador
    }

    private fun calcularModificador(valorTotal: Int): Int {
        return when (valorTotal) {
            1 -> -5
            2, 3 -> -4
            4, 5 -> -3
            6, 7 -> -2
            8, 9 -> -1
            10, 11 -> 0
            12, 13 -> 1
            14, 15 -> 2
            16, 17 -> 3
            18, 19 -> 4
            20, 21 -> 5
            22, 23 -> 6
            24, 25 -> 7
            26, 27 -> 8
            28, 29 -> 9
            30 -> 10
            else -> 0
        }
    }

    fun calcularModificadores(): Map<String, Int> {
        return mapOf(
            "forca" to calcularModificador(forca) + (bonusRacial["forca"] ?: 0),
            "destreza" to calcularModificador(destreza) + (bonusRacial["destreza"] ?: 0),
            "constituicao" to calcularModificador(constituicao) + (bonusRacial["constituicao"] ?: 0),
            "inteligencia" to calcularModificador(inteligencia) + (bonusRacial["inteligencia"] ?: 0),
            "sabedoria" to calcularModificador(sabedoria) + (bonusRacial["sabedoria"] ?: 0),
            "carisma" to calcularModificador(carisma) + (bonusRacial["carisma"] ?: 0)
        )
    }

    fun getVidaTotal(): Int {
        return calcularVida()
    }

    fun getDetalhes(): String {
        val modificadores = calcularModificadores()
        val detalhes = StringBuilder()
        detalhes.append("Nome: $nome\n")
        detalhes.append("Raça: ${raca::class.simpleName}\n")
        detalhes.append("Nível: $nivel\n")
        detalhes.append("Vida: ${getVidaTotal()}\n")
        detalhes.append("Força: $forca (${modificadores["forca"]})\n")
        detalhes.append("Destreza: $destreza (${modificadores["destreza"]})\n")
        detalhes.append("Constituição: $constituicao (${modificadores["constituicao"]})\n")
        detalhes.append("Inteligência: $inteligencia (${modificadores["inteligencia"]})\n")
        detalhes.append("Sabedoria: $sabedoria (${modificadores["sabedoria"]})\n")
        detalhes.append("Carisma: $carisma (${modificadores["carisma"]})\n")
        detalhes.append("Deslocamento Base: ${raca.deslocamentoBase}\n")
        detalhes.append("Idioma Inicial: ${raca.idiomaInicial}\n")
        return detalhes.toString()
    }
}
