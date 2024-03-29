fun main() {
    println("Bem-vindo à calculadora de IMC!")
    println("Por favor, informe seu gênero (M para masculino, F para feminino): ")
    val genero = readLine()?.uppercase()

    println("Informe sua altura em metros: ")
    val altura = readLine()?.toDoubleOrNull()

    println("Informe seu peso em quilogramas: ")
    val peso = readLine()?.toDoubleOrNull()

    if (genero != "M" && genero != "F" || altura == null || peso == null || altura <= 0 || peso <= 0) {
        println("Entrada inválida. Certifique-se de inserir um gênero válido (M ou F) e valores positivos para altura e peso.")
        return
    }

    val imc = peso / (altura * altura)
    val resultado = when {
        genero == "M" && imc < 20.7 -> "Abaixo do peso"
        genero == "M" && imc < 26.4 -> "Normal"
        genero == "M" && imc < 27.8 -> "Sobrepeso"
        genero == "M" && imc < 31.1 -> "Obesidade"
        else -> "Obesidade Mórbida"
    }

    println("Seu IMC é %.2f".format(imc))
    println("Resultado: $resultado")
}
