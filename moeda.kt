fun main() {
    val taxaConversao = mapOf(
        Pair("BRL", 1.0),
        Pair("USD", 4.95),
        Pair("EUR", 5.38)
    )

    println("Moedas Existentes:")
    println("BRL - Real R$")
    println("USD - Dólar $")
    println("EUR - Euro")

    print("Informe a moeda origem (Ex: BRL): ")
    val moedaOrigem = readLine().toString()
    print("Informe a moeda destino (Ex: USD): ")
    val moedaDestino = readLine().toString()
    print("Informe a quantia em $moedaOrigem: ")
    val quantia = readLine()!!.toDouble()

    val valorConvertido = if (moedaOrigem == moedaDestino) {
        quantia
    } else {
        val taxaOrigem = taxaConversao[moedaOrigem] ?: error("Moeda de origem inválida")
        val taxaDestino = taxaConversao[moedaDestino] ?: error("Moeda de destino inválida")
        quantia * (taxaDestino / taxaOrigem)
    }

    println("Valor em $moedaDestino = ${"%.2f".format(valorConvertido)}")
}
