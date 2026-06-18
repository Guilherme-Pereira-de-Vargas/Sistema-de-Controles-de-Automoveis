// GitHub: https://github.com/Guilherme-Pereira-de-Vargas/Sistema-de-Controles-de-Automoveis.git

import java.util.Scanner;

class Pessoa {
    protected String nome;
    protected String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }
}

class Cliente extends Pessoa {
    private String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        super(nome, cpf);
        this.telefone = telefone;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Telefone: " + telefone);
    }
}

class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, String cpf, String cargo) {
        super(nome, cpf);
        this.cargo = cargo;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Cargo: " + cargo);
    }
}

class Veiculo {
    protected String marca;
    protected String modelo;
    protected double preco;

    public Veiculo(String marca, String modelo, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Preço: R$ " + preco);
    }
}

class Carro extends Veiculo {
    private int portas;

    public Carro(String marca, String modelo, double preco, int portas) {
        super(marca, modelo, preco);
        this.portas = portas;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Portas: " + portas);
    }
}

class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, double preco, int cilindradas) {
        super(marca, modelo, preco);
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Cilindradas: " + cilindradas);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Cliente[] clientes = new Cliente[50];
        Funcionario[] funcionarios = new Funcionario[50];
        Veiculo[] veiculos = new Veiculo[100];

        int qtdClientes = 0;
        int qtdFuncionarios = 0;
        int qtdVeiculos = 0;

        int opcaoPrincipal;

        do {

            System.out.println("\n===== REVENDA DE VEÍCULOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Pesquisar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcaoPrincipal = entrada.nextInt();
            entrada.nextLine();

            switch (opcaoPrincipal) {

                case 1:

                    int opcaoCadastro;

                    do {

                        System.out.println("\n--- CADASTRAR ---");
                        System.out.println("1 - Cliente");
                        System.out.println("2 - Funcionário");
                        System.out.println("3 - Veículo");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");

                        opcaoCadastro = entrada.nextInt();
                        entrada.nextLine();

                        switch (opcaoCadastro) {

                            case 1:

                                System.out.print("Nome: ");
                                String nomeCli = entrada.nextLine();

                                System.out.print("CPF: ");
                                String cpfCli = entrada.nextLine();

                                System.out.print("Telefone: ");
                                String telefone = entrada.nextLine();

                                clientes[qtdClientes] = new Cliente(nomeCli, cpfCli, telefone);

                                qtdClientes++;

                                System.out.println("Cliente cadastrado!");
                                break;

                            case 2:

                                System.out.print("Nome: ");
                                String nomeFun = entrada.nextLine();

                                System.out.print("CPF: ");
                                String cpfFun = entrada.nextLine();

                                System.out.print("Cargo: ");
                                String cargo = entrada.nextLine();

                                funcionarios[qtdFuncionarios] = new Funcionario(nomeFun, cpfFun, cargo);

                                qtdFuncionarios++;

                                System.out.println("Funcionário cadastrado!");
                                break;

                            case 3:

                                System.out.println("1 - Carro");
                                System.out.println("2 - Moto");
                                System.out.print("Tipo: ");
                                int tipo = entrada.nextInt();
                                entrada.nextLine();

                                System.out.print("Marca: ");
                                String marca = entrada.nextLine();

                                System.out.print("Modelo: ");
                                String modelo = entrada.nextLine();

                                System.out.print("Preço: ");
                                double preco = entrada.nextDouble();

                                if (tipo == 1) {

                                    System.out.print("Portas: ");
                                    int portas = entrada.nextInt();

                                    veiculos[qtdVeiculos] = new Carro(
                                            marca,
                                            modelo,
                                            preco,
                                            portas);

                                } else if (tipo == 2) {

                                    System.out.print("Cilindradas: ");
                                    int cilindradas = entrada.nextInt();

                                    veiculos[qtdVeiculos] = new Moto(
                                            marca,
                                            modelo,
                                            preco,
                                            cilindradas);
                                }

                                entrada.nextLine();

                                qtdVeiculos++;

                                System.out.println("Veículo cadastrado!");
                                break;
                        }

                    } while (opcaoCadastro != 0);

                    break;

                case 2:

                    int opcaoPesquisa;

                    do {

                        System.out.println("\n--- PESQUISAR ---");
                        System.out.println("1 - Clientes");
                        System.out.println("2 - Funcionários");
                        System.out.println("3 - Veículos");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");

                        opcaoPesquisa = entrada.nextInt();
                        entrada.nextLine();

                        switch (opcaoPesquisa) {

                            case 1:

                                System.out.println("\n1 - Pesquisar por ID");
                                System.out.println("2 - Pesquisar por Nome");
                                System.out.println("3 - Listar Todos");
                                System.out.print("Opção: ");

                                int buscaCliente = entrada.nextInt();
                                entrada.nextLine();

                                if (buscaCliente == 1) {

                                    System.out.print("ID do cliente: ");
                                    int id = entrada.nextInt();

                                    if (id >= 0 && id < qtdClientes) {
                                        clientes[id].exibirInformacoes();
                                    } else {
                                        System.out.println("Cliente não encontrado.");
                                    }

                                } else if (buscaCliente == 2) {

                                    System.out.print("Nome: ");
                                    String nomeBusca = entrada.nextLine();

                                    boolean encontrou = false;

                                    for (int i = 0; i < qtdClientes; i++) {

                                        if (clientes[i].nome.equalsIgnoreCase(nomeBusca)) {

                                            System.out.println("\nID: " + i);
                                            clientes[i].exibirInformacoes();

                                            encontrou = true;
                                        }
                                    }

                                    if (!encontrou) {
                                        System.out.println("Cliente não encontrado.");
                                    }

                                } else if (buscaCliente == 3) {

                                    for (int i = 0; i < qtdClientes; i++) {

                                        System.out.println("\nID: " + i);
                                        clientes[i].exibirInformacoes();
                                    }
                                }

                                break;

                            case 2:

                                System.out.println("\n1 - Pesquisar por ID");
                                System.out.println("2 - Pesquisar por Nome");
                                System.out.println("3 - Listar Todos");
                                System.out.print("Opção: ");

                                int buscaFuncionario = entrada.nextInt();
                                entrada.nextLine();

                                if (buscaFuncionario == 1) {

                                    System.out.print("ID do funcionário: ");
                                    int id = entrada.nextInt();

                                    if (id >= 0 && id < qtdFuncionarios) {
                                        funcionarios[id].exibirInformacoes();
                                    } else {
                                        System.out.println("Funcionário não encontrado.");
                                    }

                                } else if (buscaFuncionario == 2) {

                                    System.out.print("Nome: ");
                                    String nomeBusca = entrada.nextLine();

                                    boolean encontrou = false;

                                    for (int i = 0; i < qtdFuncionarios; i++) {

                                        if (funcionarios[i].nome.equalsIgnoreCase(nomeBusca)) {

                                            System.out.println("\nID: " + i);
                                            funcionarios[i].exibirInformacoes();

                                            encontrou = true;
                                        }
                                    }

                                    if (!encontrou) {
                                        System.out.println("Funcionário não encontrado.");
                                    }

                                } else if (buscaFuncionario == 3) {

                                    for (int i = 0; i < qtdFuncionarios; i++) {

                                        System.out.println("\nID: " + i);
                                        funcionarios[i].exibirInformacoes();
                                    }
                                }

                                break;

                            case 3:

                                System.out.println("\n1 - Pesquisar por ID");
                                System.out.println("2 - Pesquisar por Marca");
                                System.out.println("3 - Listar Todos");
                                System.out.print("Opção: ");

                                int buscaVeiculo = entrada.nextInt();
                                entrada.nextLine();

                                if (buscaVeiculo == 1) {

                                    System.out.print("ID do veículo: ");
                                    int id = entrada.nextInt();

                                    if (id >= 0 && id < qtdVeiculos) {
                                        veiculos[id].exibirInformacoes();
                                    } else {
                                        System.out.println("Veículo não encontrado.");
                                    }

                                } else if (buscaVeiculo == 2) {

                                    System.out.print("Marca: ");
                                    String marcaBusca = entrada.nextLine();

                                    boolean encontrou = false;

                                    for (int i = 0; i < qtdVeiculos; i++) {

                                        if (veiculos[i].marca.equalsIgnoreCase(marcaBusca)) {

                                            System.out.println("\nID: " + i);
                                            veiculos[i].exibirInformacoes();

                                            encontrou = true;
                                        }
                                    }

                                    if (!encontrou) {
                                        System.out.println("Veículo não encontrado.");
                                    }

                                } else if (buscaVeiculo == 3) {

                                    for (int i = 0; i < qtdVeiculos; i++) {

                                        System.out.println("\nID: " + i);
                                        veiculos[i].exibirInformacoes();
                                    }
                                }

                                break;
                        }

                    } while (opcaoPesquisa != 0);

                    break;

                case 3:

                    int opcaoAlterar;

                    do {

                        System.out.println("\n--- ALTERAR ---");
                        System.out.println("1 - Cliente");
                        System.out.println("2 - Funcionário");
                        System.out.println("3 - Veículo");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");

                        opcaoAlterar = entrada.nextInt();
                        entrada.nextLine();

                        switch (opcaoAlterar) {

                            case 1:

                                for (int i = 0; i < qtdClientes; i++) {
                                    System.out.println(i + " - " + clientes[i].nome);
                                }

                                System.out.print("Código: ");
                                int codCliente = entrada.nextInt();
                                entrada.nextLine();

                                System.out.print("Novo nome: ");
                                String nomeCli = entrada.nextLine();

                                System.out.print("Novo CPF: ");
                                String cpfCli = entrada.nextLine();

                                System.out.print("Novo telefone: ");
                                String telefone = entrada.nextLine();

                                clientes[codCliente] = new Cliente(nomeCli, cpfCli, telefone);

                                System.out.println("Cliente alterado!");
                                break;

                            case 2:

                                for (int i = 0; i < qtdFuncionarios; i++) {
                                    System.out.println(i + " - " + funcionarios[i].nome);
                                }

                                System.out.print("Código: ");
                                int codFunc = entrada.nextInt();
                                entrada.nextLine();

                                System.out.print("Novo nome: ");
                                String nomeFun = entrada.nextLine();

                                System.out.print("Novo CPF: ");
                                String cpfFun = entrada.nextLine();

                                System.out.print("Novo cargo: ");
                                String cargo = entrada.nextLine();

                                funcionarios[codFunc] = new Funcionario(nomeFun, cpfFun, cargo);

                                System.out.println("Funcionário alterado!");
                                break;

                            case 3:

                                for (int i = 0; i < qtdVeiculos; i++) {
                                    System.out.println(i + " - Veículo");
                                }

                                System.out.print("Código: ");
                                int codVeiculo = entrada.nextInt();
                                entrada.nextLine();

                                System.out.println("1 - Carro");
                                System.out.println("2 - Moto");
                                System.out.print("Tipo: ");
                                int tipo = entrada.nextInt();
                                entrada.nextLine();

                                System.out.print("Marca: ");
                                String marca = entrada.nextLine();

                                System.out.print("Modelo: ");
                                String modelo = entrada.nextLine();

                                System.out.print("Preço: ");
                                double preco = entrada.nextDouble();

                                if (tipo == 1) {

                                    System.out.print("Portas: ");
                                    int portas = entrada.nextInt();

                                    veiculos[codVeiculo] = new Carro(
                                            marca,
                                            modelo,
                                            preco,
                                            portas);

                                } else {

                                    System.out.print("Cilindradas: ");
                                    int cilindradas = entrada.nextInt();

                                    veiculos[codVeiculo] = new Moto(
                                            marca,
                                            modelo,
                                            preco,
                                            cilindradas);
                                }

                                entrada.nextLine();

                                System.out.println("Veículo alterado!");
                                break;
                        }

                    } while (opcaoAlterar != 0);

                    break;

                case 4:

                    int opcaoExcluir;

                    do {

                        System.out.println("\n--- EXCLUIR ---");
                        System.out.println("1 - Cliente");
                        System.out.println("2 - Funcionário");
                        System.out.println("3 - Veículo");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");

                        opcaoExcluir = entrada.nextInt();
                        entrada.nextLine();

                        switch (opcaoExcluir) {

                            case 1:

                                for (int i = 0; i < qtdClientes; i++) {
                                    System.out.println(i + " - " + clientes[i].nome);
                                }

                                System.out.print("Código: ");
                                int excluirCliente = entrada.nextInt();

                                for (int i = excluirCliente; i < qtdClientes - 1; i++) {
                                    clientes[i] = clientes[i + 1];
                                }

                                qtdClientes--;

                                System.out.println("Cliente removido!");
                                break;

                            case 2:

                                for (int i = 0; i < qtdFuncionarios; i++) {
                                    System.out.println(i + " - " + funcionarios[i].nome);
                                }

                                System.out.print("Código: ");
                                int excluirFuncionario = entrada.nextInt();

                                for (int i = excluirFuncionario; i < qtdFuncionarios - 1; i++) {
                                    funcionarios[i] = funcionarios[i + 1];
                                }

                                qtdFuncionarios--;

                                System.out.println("Funcionário removido!");
                                break;

                            case 3:

                                for (int i = 0; i < qtdVeiculos; i++) {
                                    System.out.println(i + " - Veículo");
                                }

                                System.out.print("Código: ");
                                int excluirVeiculo = entrada.nextInt();

                                for (int i = excluirVeiculo; i < qtdVeiculos - 1; i++) {
                                    veiculos[i] = veiculos[i + 1];
                                }

                                qtdVeiculos--;

                                System.out.println("Veículo removido!");
                                break;
                        }

                    } while (opcaoExcluir != 0);

                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcaoPrincipal != 0);

        entrada.close();
    }
}