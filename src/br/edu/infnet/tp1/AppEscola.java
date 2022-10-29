package br.edu.infnet.tp1;

import java.util.Scanner;

public class AppEscola {

    final static int TAMANHO = 100;
    private static String[] alunos;
    private static float[] av1;
    private static float[] av2;

    public static void main(String[] args) {

        alunos = new String[TAMANHO];
        av1 = new float[TAMANHO];
        av2 = new float[TAMANHO];

        Scanner scan = new Scanner(System.in);

        String opcao;
        int pos = 0;
        do {
            System.out.println("\n\n[1] Registrar as notas de um novo aluno.");
            System.out.println("[2] Consultar boletim de um aluno.");
            System.out.println("[3] Consultar notas da turma.");
            System.out.println("[4] Sair.");

            System.out.print("\n\tInforme a opção desejada: ");
            opcao = scan.next();

            switch (opcao) {
                case "1":
                    if (pos < TAMANHO) {
                        System.out.print("\nInforme o nome do aluno: ");
                        scan.nextLine();
                        alunos[pos] = scan.nextLine();

                        System.out.print("Informa a nota da 1ª avaliação: ");
                        av1[pos] = scan.nextFloat();

                        System.out.print("Informa a nota da 2ª avaliação: ");
                        av2[pos] = scan.nextFloat();

                        exibirCabecalho();
                        imprimir(pos);

                        pos++;
                    } else {
                        System.out.println("Limite máximo! Não é possível cadastrar mais de " + TAMANHO + " alunos.");
                    }
                    break;

                case "2":
                    System.out.print("\n\nInforme a matrícula do aluno: ");
                    int matricula = scan.nextInt();

                    if (matricula >= 0 && matricula < pos) {
                        exibirCabecalho();
                        imprimir(matricula);
                    } else {
                        System.out.println("\n\tA matrícula [" + matricula + "] é inválida!");
                    }
                    break;

                case "3":
                    exibirCabecalho();
                    imprimir();
                    break;

                case "4":
                    System.out.println("\n\tAté logo!");
                    break;

                default:
                    System.out.println("\n\tERRO: Opção inválida!");
                    break;
            }
        } while (!"4".equals(opcao));

        System.out.println("\nProcessamento finalizado!");

        scan.close();
    }

    private static void imprimir(int i) {
        float media = media(i);

        System.out.println(String.format("|%-2s %-15s %6s %6s %7.2f %12s|", i, alunos[i], av1[i], av2[i], media,
                situacaoAluno(media)));
    }

    private static void imprimir() {
        for (int i = 0; i < TAMANHO; i++) {
            if (alunos[i] != null) {
                imprimir(i);
            } else {
                System.out.println("\t\nAinda não há alunos cadastrados!");
                break;
            }
        }
    }

    private static float media(int id) {
        return (av1[id] + av2[id]) / 2;
    }

    private static String situacaoAluno(float media) {
        if (media < 4) {
            return "Reprovado";
        } else if (media < 7) {
            return "Prova Final";
        } else {
            return "Aprovado";
        }
    }

    private static void exibirCabecalho() {
        System.out.println(
                String.format("\n|%-2s %-15s %6s %6s %7s %12s|", "n.", "NOME:", "AV1", "AV2", "MÉDIA",
                        "SITUAÇÃO"));
    }
}
