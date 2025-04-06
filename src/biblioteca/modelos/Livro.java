package biblioteca.modelos;
public class Livro extends Publicacao implements Digitalizavel {
    // Atributos específicos de Livro
    private int volume;
    private String isbn;
    private String genero;
    private int numeroDeCapitulos;

    // GETTERS
    public int getVolume() {
        return volume;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getGenero() {
        return genero;
    }
    public int getNumeroDeCapitulos() {
        return numeroDeCapitulos;
    }

    // SETTERS
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setNumeroDeCapitulos(int numeroDeCapitulos) {
        this.numeroDeCapitulos = numeroDeCapitulos;
    }

    /*
     Exemplo de sobrescrita (Override):
     Sobrescrevemos o método "exibeFichaLiteraria()" para incluir
     informações específicas de um "Livro".
     */
    @Override
    public void exibeFichaLiteraria() {
        // Chamamos primeiro o método da superclasse para mostrar atributos comuns
        super.exibeFichaLiteraria();

        // Depois exibimos atributos específicos de "Livro"
        System.out.println("Gênero: " + genero);
        System.out.println("Volume: " + volume);
        System.out.println("ISBN: " + isbn);
        System.out.println("Número de capítulos: " + numeroDeCapitulos);
        System.out.println("Tipo de publicação: Livro");
    }

    /*
     Método da interface Digitalizavel que somos obrigados a implementar,
     já que "Livro" declarou "implements Digitalizavel".
     */
    @Override
    public void geraVersaoDigital() {
        System.out.println("Há uma versão digital do livro disponível para você!");
    }
}