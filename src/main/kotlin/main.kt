import raca.*
import personagem.Personagem
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Bem-vindo ao criador de personagens!")

    print("Digite o nome do personagem: ")
    val nome = scanner.nextLine()

    var raca: Raca? = null
    while (raca == null) {
        println("Escolha a raça do personagem:")
        println("[1]. Alto Elfo || [2].Anão || [3]. Anão da Colina || [4]. Anão da Montanha || [5]. Draconato || [6]. Drow")
        println("[7]. Elfo || [8]. Elfo da Floresta || [9]. Gnomo || [10]. Gnomo da Floresta || [11]. Gnomo das Rochas || [12]. Halfling")
        println("[13]. Halfling pés-leves || [14]. Halfling Robusto || [15]. Humano || [16]. Meio-elfo || [17]. Meio-orc || [18]. Tiefling")

        print("Digite o número correspondente à raça: ")

        val racaEscolha = scanner.nextInt()

        raca = when (racaEscolha) {
            1 -> AltoElfo()
            2 -> Anao()
            3 -> AnaoDaColina()
            4 -> AnaoDaMontanha()
            5 -> Draconato()
            6 -> Drow()
            7 -> Elfo()
            8 -> ElfoDaFloresta()
            9 -> Gnomo()
            10 -> GnomoDaFloresta()
            11 -> GnomoDasRochas()
            12 -> Halfling()
            13 -> HalflingPesLeves()
            14 -> HalflingRobusto()
            15 -> Humano()
            16 -> MeioElfo()
            17 -> MeioOrc()
            18 -> Tiefling()
            else -> {
                println("Opção inválida. Por favor, tente novamente.")
                null
            }
        }
    }

    val personagem = Personagem(nome, raca)
    personagem.distribuirPontos()
    personagem.exibirDetalhes()
}