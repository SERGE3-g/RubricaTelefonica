//
// CREATA DA: SERGE GUEA (09/03/2023 )
//
// DESCRIZIONE: classe che rappresenta un oggetto di tipo smartphone
import java.util.ArrayList;

public class Smartphone {

    private String numeroTelefonico;
    private ArrayList<Contatto> rubrica = new ArrayList<>();

    public Smartphone() {
    }

    public Smartphone(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    //metodo ausiliario per impedire di scrivere sempre lo stesso ciclo for in modifica contatto, aggiorna numero, aggiorna nome e elimina contatto
    //si noti il private: questo metodo sarà usato solo all'interno della classe Smartphone

    private int ricerca(String nome) {
        for (int i = 0; i < rubrica.size(); i++) {
            // rubrica[i] equivalente a rubrica.get(i)
            if (rubrica.get(i).getNome().equals(nome)) {
                return i;
            }
        }

        return -1;
    }

    public boolean aggiungiContatto(Contatto c) {

        if (rubrica.isEmpty()) {
            rubrica.add(c);
            return true;
        }

        if (ricerca(c.getNome()) >= 0) {
            Contatto c2 = rubrica.get(ricerca(c.getNome()));
            System.out.println("Impossibile aggiungere contatto, " + c2.getNome() + " è già presente con il numero: "
                    + c2.getNumero());
            return false;
        } else {
            rubrica.add(c);
            return true;
        }
    }

    public void eliminaContatto(String nome) {

        int indice = ricerca(nome);

        if (indice >= 0) {
            rubrica.remove(indice);
            System.out.println(nome + " eliminato correttamente");
        } else {
            System.out.println("Non puoi elminare un contatto che non esiste");
        }

    }

    // si faccia attenzione all'uso del varargs
    public void modificaContatto(String nomeOld, String... nuoviElementi) {

        int indice = ricerca(nomeOld);

        if (indice < 0) {
            System.out.println("non esiste questo contatto, quindi non puoi aggiornarlo");
            return;
        }

        if (nuoviElementi.length == 2) {
            rubrica.get(indice).setNome(nuoviElementi[0]);
            rubrica.get(indice).setNumero(nuoviElementi[1]);

        } else if (nuoviElementi.length == 1 && Character.isDigit(nuoviElementi[0].toCharArray()[0])) {
            rubrica.get(indice).setNumero(nuoviElementi[0]);
        } else {
            rubrica.get(indice).setNome(nuoviElementi[0]);
        }

    }

    // con metodo ricerca(vedi primo metodo della classe)
    public void aggiornaNome(String vecchioNome, String nuovoNome) {// aggiorna nome

        int indice = ricerca(vecchioNome);

        if (indice >= 0) {
            rubrica.get(indice).setNome(nuovoNome);
        } else {
            System.out.println("il contatto " + vecchioNome + " non esiste e quindi non puoi modificarlo!");// se non esiste
                                                                                                            // il contatto
                                                                                                            // non puoi
                                                                                                             // modificarlo
        }

    }

    // senza metodo ricerca
    public void aggiornaNumero(String nome, String numero) {



        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).getNome().equals(nome)) {
                rubrica.get(i).setNumero(numero);
                return;
            }
        }

        System.out.println("Mi spiace ma il contatto non esiste!");

    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public ArrayList<Contatto> getRubrica() {
        return rubrica;
    }

    public void setRubrica(ArrayList<Contatto> rubrica) {
        this.rubrica = rubrica;
    }

}