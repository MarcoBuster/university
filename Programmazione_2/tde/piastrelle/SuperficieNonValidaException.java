package piastrelle;

/*
 * Questa eccezione viene scatenata se viene rilevata
 * una superficie non valida che non rispetta i requisiti
 * (l'RI nell'interfaccia Superficie)
 */
public class SuperficieNonValidaException extends RuntimeException {
    
    public SuperficieNonValidaException() {
        super();
    }

    public SuperficieNonValidaException(String message) {
        super(message);
    }

}
