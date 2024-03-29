import kotlin.random.Random

fun main() {
    println("Informe o tamanho da senha (quantidade de caracteres):")
    val tamanhoSenha = readLine()?.toIntOrNull() ?: return
    val senha = gerarSenhaSegura(tamanhoSenha)
    println("Senha gerada: $senha")
}

fun gerarSenhaSegura(tamanho: Int): String {
    val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+"
    val senha = StringBuilder()
    val random = Random(System.currentTimeMillis())

    repeat(tamanho) {
        val index = random.nextInt(caracteres.length)
        senha.append(caracteres[index])
    }

    return senha.toString()
}
