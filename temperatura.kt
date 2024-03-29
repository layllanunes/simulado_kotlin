fun main() {
    println("Conversor de Temperatura")
    println("Informe a unidade inicial (C para Celsius ou F para Fahrenheit): ")
    val unidadeInicial = readLine()
    println("Informe a temperatura (°): ")
    val temperatura = readLine()?.toDoubleOrNull()

    if (unidadeInicial != null && temperatura != null) {
        val temperaturaConvertida = when (unidadeInicial.uppercase()) {
            "C" -> celsiusParaFahrenheit(temperatura)
            "F" -> fahrenheitParaCelsius(temperatura)
            else -> {
                println("Unidade inicial inválida.")
                return
            }
        }
        println("$temperatura° ${unidadeInicial.uppercase()} --> $temperaturaConvertida° ${outraUnidade(unidadeInicial)}")
    } else {
        println("Entrada inválida.")
    }
}

fun celsiusParaFahrenheit(celsius: Double): Double {
    return celsius * 9 / 5 + 32
}

fun fahrenheitParaCelsius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5 / 9
}

fun outraUnidade(unidadeInicial: String): String {
    return if (unidadeInicial.uppercase() == "C") "F" else "C"
}
