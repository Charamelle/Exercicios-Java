import java.util.Scanner;
import java.util.Random;
public class Forca {
    
    // lista de palavras
    private String palavras[] = {"inerente", "respeito", "peculiar", "denegrir", "genocida", "deferido", "equidade", "prudente", "cultura", "estigma", "refutar", "virtude", "ansioso", "profano", "sentido", "exilado","consoante", "cognitivo", "adjacente"};
    
    // criando atributos
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    private int sort = random.nextInt(palavras.length-1);           // sortear a palavra que vai ir
    private int chances = 10;                                       // dá pra aumentar/diminuir pra alterar a dificuldade
    private int chancesT = chances;
    private int acertos;
    private char guess;

    private char[] letras = palavras[sort].toCharArray();
    private char[] certo = new char[letras.length];


    // método construtor
    public Forca(){}


    // método getPalavra --> UNICAMENTE PARA TESTES
    public String getPalavra(){
        return palavras[sort];
    }




    // método compare --> verifica se o chute está certo (também controla o nº de guesses left)
    public void compare (){
        boolean ok = false;
        for (int x = 0; x<letras.length; x++){
            if (letras[x] == guess){
                this.certo[x] = guess;
                ok = true;
            }
        }
        if(ok == false){
            this.chances = this.chances - 1;
        }
    }


    // método check --> verifica se o usuário ganhou o jogo (tbm controla o nº acertos)
    public void check (){
        this.acertos = 0;
        for (int y=0; y<letras.length;y++){
            if (letras[y] == certo[y]){
                this.acertos++;
            }
        }
        if (acertos == letras.length){
            this.chances = this.chancesT + 1;
        }
    }

    // método display set up --> só um negócinho pro display()
    public void displaySetup(){
        for (int i=0; i<certo.length ;i++){
            certo[i] = '_';
        }
    }

    // método display --> interfacezinha do jogo
    public void display(){
        System.out.println("\n\nChances: "+ chances);
        for (int z =0; z<letras.length ;z++){
            System.out.print(certo[z]+" ");
        }


        System.out.println("");
    }

    // método jogo --> método principal; usa dos anteriores pra rodar o joguinho c:
    public void jogo(){
        displaySetup();
        while((chances>0) && (chances<=chancesT)){
            display();
            guess = sc.next().charAt(0);
            compare();
            check();
        }
        if (chances>chancesT){
            System.out.println("\n>> Voce ganhou!\nA palavra era: "+palavras[sort]);
        }
        else{
            System.out.println("\nVoce perdeu!\nA palavra era: "+palavras[sort]);
        }
    }
}
