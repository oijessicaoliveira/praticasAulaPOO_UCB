package biblioteca.modelos;
// Criando a classe "Publicacao" com seus devidos atributos
public class Publicacao {
    /*
     Ao usar "protected" em vez de "private",
     as subclasses podem acessar diretamente esses atributos.
     Porém, é recomendável, na prática, manter "private" e usar getters/setters
     para encapsulamento. Aqui, deixamos "protected" para fins didáticos.
     */
    protected String titulo;
    protected String autor;
    protected String editora;
    protected String tipo; // Poderia representar o tipo de publicação ("Livro", "Revista", etc.)
    protected int numeroDePaginas;

    // Usados para calcular média de avaliações
    private double somaAvaliacoes;
    private int totalDeAvaliacoes;

    // GETTERS (métodos de acesso)
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getEditora() {
        return editora;
    }
    public String getTipo() {
        return tipo;
    }
    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }
    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    // SETTERS (métodos modificadores)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /* Aqui usamos o throw para lançar manualmente uma exceção do tipo IllegalArgumentException,
    caso o valor recebido seja inválido. */

    public void setNumeroDePaginas(int numeroDePaginas) {
        if (numeroDePaginas <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser maior que zero.");
        }
        this.numeroDePaginas = numeroDePaginas;
    }

    //Exemplo de Overload / Sobrecarga de métodos

    // Método principal que recebe notas em double
    public void avalia(double nota) {
        somaAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    // Método sobrecarregado: recebe notas inteiras (int)
    public void avalia(int nota) {
        // Internamente, convertemos int para double e
        // chamamos a versão principal acima (avalia(double))
        avalia((double) nota);
    }

    // Método sobrecarregado: recebe um array de doubles
    public void avalia(double[] notas) {
        for (double nota : notas) {
            avalia(nota);  // chama avalia(double) para cada valor
        }
    }

    // Exemplo de uso do throws
    public void avaliaComValidacao(double nota) throws Exception {
        if (nota < 0 || nota > 10) {
            throw new Exception("Nota fora do intervalo permitido (0 a 10).");
        }
        avalia(nota);
    }

    // Retorna a média das avaliações realizada
    public double retornaMedia() {
        // Se não houver avaliações, retornamos 0 (evita divisão por zero)
        if (totalDeAvaliacoes == 0) {
            return 0;
        }
        return somaAvaliacoes / totalDeAvaliacoes;
    }

    // Exibe a média de avaliações. Exemplo simples de método adicional.
    public void exibeMedia() {
        System.out.println("Avaliações: " + retornaMedia());
    }

    /*
     Método para exibir a ficha literária da publicação.
     Será sobrescrito (override) nas subclasses para incluir detalhes específicos.
     */
    public void exibeFichaLiteraria() {
        System.out.println("\n--- Ficha Literária (Classe Publicacao) ---");
        System.out.println("Título: " + titulo);
        System.out.println("Nome do autor(a): " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("Número de páginas: " + numeroDePaginas);
    }
}