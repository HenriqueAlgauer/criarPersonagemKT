import raca.*
import personagem.Personagem

// Lista de raças disponíveis
val listaDeRacas = listOf(
    "Alto Elfo",
    "Anão",
    "Anão da Colina",
    "Anão da Montanha",
    "Draconato",
    "Drow",
    "Elfo",
    "Elfo da Floresta",
    "Gnomo",
    "Gnomo da Floresta",
    "Gnomo das Rochas",
    "Halfling",
    "Halfling Pés-Leves",
    "Halfling Robusto",
    "Humano",
    "Meio-Elfo",
    "Meio-Orc",
    "Tiefling"
)

// Função para obter o objeto Raca a partir do nome
fun obterRacaPorNome(nome: String): Raca? {
    return when (nome) {
        "Alto Elfo" -> AltoElfo()
        "Anão" -> Anao()
        "Anão da Colina" -> AnaoDaColina()
        "Anão da Montanha" -> AnaoDaMontanha()
        "Draconato" -> Draconato()
        "Drow" -> Drow()
        "Elfo" -> Elfo()
        "Elfo da Floresta" -> ElfoDaFloresta()
        "Gnomo" -> Gnomo()
        "Gnomo da Floresta" -> GnomoDaFloresta()
        "Gnomo das Rochas" -> GnomoDasRochas()
        "Halfling" -> Halfling()
        "Halfling Pés-Leves" -> HalflingPesLeves()
        "Halfling Robusto" -> HalflingRobusto()
        "Humano" -> Humano()
        "Meio-Elfo" -> MeioElfo()
        "Meio-Orc" -> MeioOrc()
        "Tiefling" -> Tiefling()
        else -> null
    }
}

// Função para criar um personagem com os parâmetros fornecidos
fun criarPersonagem(
    nome: String,
    nomeRaca: String,
    atributos: Map<String, Int>
): Personagem? {
    val raca = obterRacaPorNome(nomeRaca)
    return if (raca != null) {
        Personagem(
            nome = nome,
            raca = raca,
            forca = atributos["forca"] ?: 8,
            destreza = atributos["destreza"] ?: 8,
            constituicao = atributos["constituicao"] ?: 8,
            inteligencia = atributos["inteligencia"] ?: 8,
            sabedoria = atributos["sabedoria"] ?: 8,
            carisma = atributos["carisma"] ?: 8
        )
    } else {
        null
    }
}
