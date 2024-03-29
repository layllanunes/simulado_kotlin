import java.util.Scanner

data class Cliente(
    val id: Int,
    var nome: String,
    var dataNascimento: String,
    var sexo: Char,
    var email: String,
    var whatsapp: String,
    var profissao: String
)

class CadastroClientes {
    private val clientes = mutableListOf<Cliente>()
    private var proximoId = 1

    fun mostrarClientes() {
        println("| ID | Nome           | Dt. Nasc.  | Sexo | Email            | Whatsapp       | Profissão     |")
        clientes.forEach {
            println("| ${it.id}  | ${it.nome.padEnd(15)} | ${it.dataNascimento} | ${it.sexo}    | ${it.email.padEnd(15)} | ${it.whatsapp} | ${it.profissao}")
        }
    }

    fun cadastrarCliente() {
        val scanner = Scanner(System.`in`)

        print("Nome: ")
        val nome = scanner.nextLine()
        print("Data de Nascimento (DD/MM/AAAA): ")
        val dataNascimento = scanner.nextLine()
        print("Sexo (M/F): ")
        val sexo = scanner.nextLine()[0].toUpperCase()
        print("Email: ")
        val email = scanner.nextLine()
        print("Whatsapp: ")
        val whatsapp = scanner.nextLine()
        print("Profissão: ")
        val profissao = scanner.nextLine()

        val cliente = Cliente(proximoId++, nome, dataNascimento, sexo, email, whatsapp, profissao)
        clientes.add(cliente)
        println("Cliente cadastrado com sucesso!")
    }

    fun excluirCliente() {
        val scanner = Scanner(System.`in`)

        print("ID do cliente a ser excluído: ")
        val id = scanner.nextInt()
        val cliente = clientes.find { it.id == id }
        if (cliente != null) {
            clientes.remove(cliente)
            println("Cliente excluído com sucesso!")
        } else {
            println("Cliente não encontrado.")
        }
    }

    fun alterarCliente() {
        val scanner = Scanner(System.`in`)

        print("ID do cliente a ser alterado: ")
        val id = scanner.nextInt()
        val cliente = clientes.find { it.id == id }
        if (cliente != null) {
            println("Escolha o campo a ser alterado:")
            println("1 - Nome")
            println("2 - Data de Nascimento")
            println("3 - Sexo")
            println("4 - Email")
            println("5 - Whatsapp")
            println("6 - Profissão")
            print("Opção: ")
            val opcao = scanner.nextInt()
            scanner.nextLine() // Limpar o buffer

            when (opcao) {
                1 -> {
                    print("Novo nome: ")
                    cliente.nome = scanner.nextLine()
                }
                2 -> {
                    print("Nova data de nascimento (DD/MM/AAAA): ")
                    cliente.dataNascimento = scanner.nextLine()
                }
                3 -> {
                    print("Novo sexo (M/F): ")
                    cliente.sexo = scanner.nextLine()[0].toUpperCase()
                }
                4 -> {
                    print("Novo email: ")
                    cliente.email = scanner.nextLine()
                }
                5 -> {
                    print("Novo whatsapp: ")
                    cliente.whatsapp = scanner.nextLine()
                }
                6 -> {
                    print("Nova profissão: ")
                    cliente.profissao = scanner.nextLine()
                }
                else -> println("Opção inválida.")
            }
            println("Cliente alterado com sucesso!")
        } else {
            println("Cliente não encontrado.")
        }
    }
}

fun main() {
    val cadastro = CadastroClientes()
    val scanner = Scanner(System.`in`)

    var opcao: Int
    do {
        println("layout: Cadastro de Clientes")
        println("1- Mostrar clientes")
        println("2- Cadastrar cliente")
        println("3- Excluir cliente")
        println("4- Alterar cliente")
        println("0 - Sair")
        print("Opção: ")
        opcao = scanner.nextInt()

        when (opcao) {
            1 -> cadastro.mostrarClientes()
            2 -> cadastro.cadastrarCliente()
            3 -> cadastro.excluirCliente()
            4 -> cadastro.alterarCliente()
            0 -> println("Bye")
            else -> println("Opção inválida.")
        }
    } while (opcao != 0)
}
