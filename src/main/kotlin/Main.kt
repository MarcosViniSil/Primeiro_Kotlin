enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(var nome: String)

data class ConteudoEducacional(var nome: String, val nivel: Int = 1)//nivel de dificuldade em ordem ascendente

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        val isMatriculado: Boolean = inscritos.add(usuario)
        if (isMatriculado) {
            println("Matricula do aluno ${usuario.nome} realizada com sucesso!!")
        } else {
            println("Falha na matricula")
        }
    }

    fun listarAlunos() {
        println("Alunos da formação $nome ")
        inscritos.forEach { e -> println(e.nome) }
    }

    fun listarConteudos() {
        println("Conteudos da formação")
        conteudos.forEach { e -> println("nome: ${e.nome} nivel: ${e.nivel}") }
    }
}

fun main() {
    val usuario1 = Usuario("pessoa1")
    val usuario2 = Usuario("pessoa2")

    val conteudo1 = ConteudoEducacional("Java modulo 1", 1)
    val conteudo2 = ConteudoEducacional("Kotlin modulo 1", 2)

    val listaConteudo = mutableListOf(conteudo1, conteudo2)

    val formacao = Formacao("Kotlin + Java básico", listaConteudo)

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.listarAlunos()

    formacao.listarConteudos()
}

