/*
Realizzare una gerarchia di classi che astragga il concetto di rubrica telefonica di uno smartphone.
La classe Smartphone avrà due attributi: un numero di telefono e una struttura dati che permetta di salvare, cancellare,
leggere e aggiornare i contatti presenti nella rubrica.
I contatti dovranno portare con sé due informazioni: Nome del contatto e Numero di telefono.
Realizzare un caso di test in un metodo main.


Si consideri che:

- Il metodo che aggiunge contatti dovra impedire l'aggiunta di un nuovo contatto se il nome è già presente all'interno della rubrica.

- il metodo che cancella un contatto dalla rubrica dovrà accettare come parametro solo il nome del contatto, per poi andarlo a cancellare.

- Il discorso che vale per il metodo che cancella i contatti vale anche per il metodo che li aggiorna:
prima dovrà essere cercato il contatto e poi verrà aggiornato con i dati passati in parametro.

 */
public class Main {

    public static void main(String[] args) {

        Smartphone iphone = new Smartphone("3333333333");

        Contatto c=new Contatto("Topolino", "3357894561");
        Contatto c2=new Contatto("Topo", "3347894561");
        Contatto c3=new Contatto("Poppy", "3347894561");

        iphone.aggiungiContatto(c);
        iphone.aggiungiContatto(c2);
        iphone.aggiungiContatto(c3);

        //System.out.println(iphone.getRubrica());
        iphone.getRubrica().forEach(x -> System.out.println(x)); //stampo la rubrica

        System.out.println("");

        iphone.eliminaContatto("Topolino");  //elimino un contatto

        //System.out.println(iphone.getRubrica());
        iphone.getRubrica().forEach(x -> System.out.println(x));

        System.out.println("");


        iphone.aggiungiContatto(new Contatto("Mariam", "9432801"));
        iphone.aggiungiContatto(new Contatto("Gamba", "123446767"));
        iphone.modificaContatto("Gamba", "GambaAggiornato", "888888");
        iphone.aggiornaNome("Mariam", "Mariam aggiornato");
        iphone.aggiornaNumero("Mariam aggiornato", "12121212");

        //System.out.println(iphone.getRubrica());
        iphone.getRubrica().forEach(x -> System.out.println(x));


    }

}