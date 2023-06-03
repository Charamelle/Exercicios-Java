import java.util.Scanner;

public class main {
    


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Escolhendo a quantidade de alunos
        System.out.println("Digite a quantidade de alunos:");
        int N = sc.nextInt();

        // Criar o vetor relacionado cm a classe Aluno
        Aluno[] alunos = new Aluno[N];


        // Criação dos alunos como objetos, pegando as notas e cálculo da média
        for (int i = 0; i<N; i++){
            alunos[i] = new Aluno();                                // Cria um objeto no índice i do vetor
           
            System.out.println("\n- Notas Aluno "+(i+1)+" -");     // puramente estética

            for (int x=0; x<3; x++){                               // Pegando as 3 notas(A1, A2, A3) do aluno i
                alunos[i].setNota(x);
            }
            alunos[i].calcMedia();                  // Calcula a média do aluno i
        }


        // Display
        for (int i = 0 ; i<N; i++){
            System.out.println("----\nAluno "+(i+1)+"\nMedia: "+ alunos[i].getMedia() + "\n" + alunos[i].status()+"\n");
        }

        sc.close();
    }
}
