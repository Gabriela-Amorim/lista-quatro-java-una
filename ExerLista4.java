import java.util.Scanner;

public class ExerLista4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\tIdentificação de Pessoas");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();

        String cartaoVacina = "", sintomas = "", sintomasGripe = "", viagem = "", orientacaoMedica = "";
        int contador = 0;
        boolean numeroTentativas = false;

        System.out.println("\n\tPerguntas de Diagnóstico (Sim/Nao)");
        do {
            System.out.print("Seu cartão de vacina está em dia?\nR:");
            cartaoVacina = sc.next();
            if (cartaoVacina.equalsIgnoreCase("Sim") || cartaoVacina.equalsIgnoreCase("Nao")) {
                break;
            } else {
                contador++;
                System.out.println("\nDigito inválido! Digite Sim ou Nao.");

                if (contador == 3) {
                    numeroTentativas = true;
                    System.out.println(
                            "Não foi possível realizar o diagnóstico. Gentileza procurar ajuda médica caso apareça algum sintoma.");
                    break;
                }
            }
        } while (true);
        if (numeroTentativas == false) {
            do {
                System.out.print(
                        "Teve algum dos sintomas recentemente?(dor de cabeça, febre, náusea, dor articular, gripe)\nR:");
                sintomas = sc.next();
                if (sintomas.equalsIgnoreCase("Sim") || sintomas.equalsIgnoreCase("Nao")) {
                    break;
                } else {
                    contador++;
                    System.out.println("\nDigito inválido! Digite Sim ou Nao. ");
                    if (contador == 3) {
                        numeroTentativas = true;
                        System.out.println(
                                "Não foi possível realizar o diagnóstico. Gentileza procurar ajuda médica caso apareça algum sintoma.");
                        break;
                    }
                }
            } while (true);
        }
        if (numeroTentativas == false) {
            do {
                System.out.print("Teve contato com pessoas com sintomas gripais nos últimos dias?\nR:");
                sintomasGripe = sc.next();
                if (sintomasGripe.equalsIgnoreCase("Sim") || sintomasGripe.equalsIgnoreCase("Nao")) {
                    break;
                } else {
                    contador++;
                    System.out.println("\nDigito inválido! Digite Sim ou Nao. ");
                    if (contador == 3) {
                        numeroTentativas = true;
                        System.out.println(
                                "Não foi possível realizar o diagnóstico. Gentileza procurar ajuda médica caso apareça algum sintoma.");
                        break;
                    }
                }
            } while (true);
        }
        if (numeroTentativas == false) {
            do {
                System.out.print("Está retornando de viagem realizada no exterior?\nR:");
                viagem = sc.next();
                if (viagem.equalsIgnoreCase("Sim") || viagem.equalsIgnoreCase("Nao")) {
                    break;
                } else {
                    contador++;
                    System.out.println("\nDigito inválido! Digite Sim ou Nao. ");
                    if (contador == 3) {
                        numeroTentativas = true;
                        System.out.println(
                                "Não foi possível realizar o diagnóstico. Gentileza procurar ajuda médica caso apareça algum sintoma.");
                        break;
                    }
                }
            } while (true);
        }

        double probabilidadeInfeccao = 0;
        boolean retornoViagem = false;

        if (cartaoVacina.equalsIgnoreCase("Nao")) {
            probabilidadeInfeccao += 10;
        }
        if (sintomas.equalsIgnoreCase("Sim")) {
            probabilidadeInfeccao += 30;
        }
        if (sintomasGripe.equalsIgnoreCase("Sim")) {
            probabilidadeInfeccao += 30;
        }
        if (viagem.equalsIgnoreCase("Sim")) {
            probabilidadeInfeccao += 30;
            retornoViagem = true;
        }

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Seu cartão de vacina está em dia: " + cartaoVacina);
        System.out.println("Apresentou algum sintoma: " + sintomas);
        System.out.println("Teve contato com pessoas com sintomas: " + sintomasGripe);
        System.out.println("Retornou de viagem recentemente: " + viagem);
        System.out.println("Probabilidade de infecção: " + probabilidadeInfeccao);
        System.out.println("Orientação médica: " + orientacaoMedica);

        if (retornoViagem == true) {
            System.out.print("Você ficará sob observação por 05 dias.");
            orientacaoMedica = sc.nextLine();
        } else {
            if (probabilidadeInfeccao <= 30) {
                System.out.print(
                        "Paciente sob observação. Caso adquirido algum sintoma, gentileza buscar assistência médica.");
                orientacaoMedica = sc.nextLine();
            } else if (probabilidadeInfeccao <= 60) {
                System.out.print(
                        "Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.");
                orientacaoMedica = sc.nextLine();
            } else if (probabilidadeInfeccao >= 90) {
                System.out
                        .print("Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado.");
                orientacaoMedica = sc.nextLine();
            }
        }

        sc.close();

    }
}
