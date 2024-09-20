package personagem
import java.util.Scanner
import raca.*

open class Personagem(val nome: String , val raca: Raca) {
    var vida: Int = 10
    var nivel: Int = 1
    var forca: Int = 8
    var destreza: Int = 8
    var constituicao: Int = 8
    var inteligencia: Int = 8
    var sabedoria: Int = 8
    var carisma: Int = 8

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

    fun distribuirPontos() {
        val scanner = Scanner(System.`in`)
        val custoPorNivel = mapOf(
            9 to 1,
            10 to 2,
            11 to 3,
            12 to 4,
            13 to 5,
            14 to 7,
            15 to 9
        )

        var pontosRestantes = 27
        var distribuirNovamente: Boolean

        do {
            pontosRestantes = 27
            forca = 8
            destreza = 8
            constituicao = 8
            inteligencia = 8
            sabedoria = 8
            carisma = 8

            fun exibirStatusAtual() {
                println("Status atual:")
                println("Força: $forca")
                println("Destreza: $destreza")
                println("Constituição: $constituicao")
                println("Inteligência: $inteligencia")
                println("Sabedoria: $sabedoria")
                println("Carisma: $carisma")
                println("Pontos restantes: $pontosRestantes")
            }

            fun calcularCusto(nivelAtual: Int, nivelDesejado: Int): Int {
                return if (nivelDesejado in 9..15) {
                    custoPorNivel[nivelDesejado] ?: 0
                } else {
                    0
                }
            }

            fun aumentarAtributo(atributo: String, nivelDesejado: Int): Boolean {
                var nivelAtual = when (atributo) {
                    "forca" -> forca
                    "destreza" -> destreza
                    "constituicao" -> constituicao
                    "inteligencia" -> inteligencia
                    "sabedoria" -> sabedoria
                    "carisma" -> carisma
                    else -> return false
                }

                if (nivelDesejado > 15) {
                    println("O nível máximo é 15. Escolha um nível válido.")
                    return false
                }

                if (nivelDesejado <= nivelAtual) {
                    println("$atributo já está no nível $nivelAtual ou maior.")
                    return false
                }

                val custo = calcularCusto(nivelAtual, nivelDesejado)

                if (pontosRestantes >= custo) {
                    pontosRestantes -= custo
                    when (atributo) {
                        "forca" -> forca = nivelDesejado
                        "destreza" -> destreza = nivelDesejado
                        "constituicao" -> constituicao = nivelDesejado
                        "inteligencia" -> inteligencia = nivelDesejado
                        "sabedoria" -> sabedoria = nivelDesejado
                        "carisma" -> carisma = nivelDesejado
                    }
                    println("Atributo $atributo aumentado para $nivelDesejado. Custo total: $custo pontos.")
                    return true
                } else {
                    println("Pontos insuficientes para aumentar $atributo para o nível $nivelDesejado. Custo: $custo pontos.")
                    return false
                }
            }

            val atributos = listOf("forca", "destreza", "constituicao", "inteligencia", "sabedoria", "carisma")

            for (atributo in atributos) {
                if (pontosRestantes == 0) break
                exibirStatusAtual()
                println("Quantos níveis deseja para $atributo? (Nível atual: 8, escolha entre 9 e 15)")
                val nivelDesejado = scanner.nextInt()

                aumentarAtributo(atributo, nivelDesejado)
            }

            exibirStatusAtual()

            if (pontosRestantes > 0) {
                println("Você ainda tem pontos restantes. Deseja finalizar a distribuição ou redistribuir os pontos?")
                println("1. Finalizar")
                println("2. Redistribuir")
                val escolha = scanner.nextInt()
                distribuirNovamente = escolha == 2
            } else {
                distribuirNovamente = false
            }
        } while (distribuirNovamente)
    }

    fun exibirDetalhes() {
        println("Nome: $nome")
        println("Raça: ${raca::class.simpleName}")
        println("Nível: $nivel")
        val vida = calcularVida()
        println("Vida: $vida")

        val forcaModificador = calcularModificador(forca) + (bonusRacial["forca"] ?: 0)
        val destrezaModificador = calcularModificador(destreza) + (bonusRacial["destreza"] ?: 0)
        val constituicaoModificador = calcularModificador(constituicao) + (bonusRacial["constituicao"] ?: 0)
        val inteligenciaModificador = calcularModificador(inteligencia) + (bonusRacial["inteligencia"] ?: 0)
        val sabedoriaModificador = calcularModificador(sabedoria) + (bonusRacial["sabedoria"] ?: 0)
        val carismaModificador = calcularModificador(carisma) + (bonusRacial["carisma"] ?: 0)

        println("Força: $forca +($forcaModificador)")
        println("Destreza: $destreza +($destrezaModificador)")
        println("Constituição: $constituicao +($constituicaoModificador)")
        println("Inteligência: $inteligencia +($inteligenciaModificador)")
        println("Sabedoria: $sabedoria +($sabedoriaModificador)")
        println("Carisma: $carisma +($carismaModificador)")

        println("Deslocamento Base: ${raca.deslocamentoBase}")
        println("Idioma Inicial: ${raca.idiomaInicial}")
    }
}