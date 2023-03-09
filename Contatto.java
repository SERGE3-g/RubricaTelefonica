//DESCRIZIONE: Classe che rappresenta un contatto
public class Contatto {

    private String nome;
    private String numero;

    public Contatto() {}

    public Contatto(String nome, String numero) {
        this.nome=nome;
        this.numero=numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " numero: " + this.numero;
    }
}