fun main() {
    val listaDeCompras = mutableListOf<String>()

    while (true) {
        println("Menu:")
        println("1. Mostrar lista")
        println("2. Adicionar item")
        println("3. Remover item")
        println("0. Sair")

        print("Escolha uma opção: ")
        when (readLine()?.toIntOrNull()) {
            1 -> mostrarLista(listaDeCompras)
            2 -> adicionarItem(listaDeCompras)
            3 -> removerItem(listaDeCompras)
            0 -> return
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun mostrarLista(lista: List<String>) {
    if (lista.isEmpty()) {
        println("A lista de compras está vazia.")
    } else {
        println("Lista de Compras:")
        lista.forEachIndexed { index, item ->
            println("${index + 1}. $item")
        }
    }
}

fun adicionarItem(lista: MutableList<String>) {
    print("Digite o item a ser adicionado: ")
    val item = readLine()?.trim()
    if (item.isNullOrBlank()) {
        println("Item inválido. Não foi adicionado à lista.")
    } else if (lista.contains(item)) {
        println("Este item já está na lista.")
    } else {
        lista.add(item)
        println("Item adicionado à lista.")
        mostrarLista(lista)
    }
}

fun removerItem(lista: MutableList<String>) {
    if (lista.isEmpty()) {
        println("A lista de compras está vazia.")
        return
    }

    mostrarLista(lista)
    print("Digite o número do item a ser removido: ")
    val indice = readLine()?.toIntOrNull()
    if (indice != null && indice in 1..lista.size) {
        val itemRemovido = lista.removeAt(indice - 1)
        println("'$itemRemovido' foi removido da lista.")
    } else {
        println("Índice inválido. Nenhum item foi removido.")
    }
}
