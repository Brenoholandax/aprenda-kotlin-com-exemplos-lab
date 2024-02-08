enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação ${nome}.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado à formação ${nome}.")
    }

    fun exibirDetalhes() {
        println("Formação: $nome - Nível: $nivel")
        println("Conteúdos:")
        conteudos.forEach { println("- ${it.nome} (${it.duracao} minutos)") }
        println("Inscritos: ${inscritos.size} usuários")
    }
}

fun main() {
    // Criando usuários
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 30)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 60)

    // Criando formação
    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO)

    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Adicionando conteúdos à formação
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)

    // Exibindo detalhes da formação
    formacaoKotlin.exibirDetalhes()
}
