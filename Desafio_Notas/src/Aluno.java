import java.util.Scanner;
public class Aluno {
    
    // Criando Atributos ---------------------------------------------
    private double notas[] = new double[3];
    private double media;
    private String status;
    Scanner sc = new Scanner(System.in);


    // método construtor
    public Aluno(){}



    // método setar Nota
    public void setNota(int Av){
        System.out.println("Digite a nota da A"+(Av+1));
        this.notas[Av] = sc.nextDouble();

        while (this.notas[Av]<0 || this.notas[Av]>10){
            System.out.println("> A nota deve estar entre 0 e 10.");
            this.notas[Av] = sc.nextDouble();
        }
    }



    // método calcular a média
    public void calcMedia(){
        this.media = notas[0]*0.3 + notas[1]*0.3 + notas[2]*0.4;
    }



    // método status (aprovado/reprovado)
    public String status(){
        if (this.media<7){
            status = "Reprovado";
        }
        else{
            status = "Aprovado";
        }
        return status;
    }



    // método pegar média
    public double getMedia(){
        return this.media;
    }


}
