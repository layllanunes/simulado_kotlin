fun main() {
    println("Informe a quantidade de notas:")
    val quantidadeNotas = readLine()!!.toInt()

    var somaNotas = 0.0
    for (i in 1..quantidadeNotas) {
        println("Informe a nota $i:")
        somaNotas += readLine()!!.toDouble()
    }

    val media = somaNotas / quantidadeNotas
    println("Média: $media")
}
