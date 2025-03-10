import biblioteca.modelos.Publicacao;

public class Principal {
    public static void main(String[] args) throws Exception {
        // System.out.println("Olá, humano!");

// Criando o primeiro objeto com base na classe "Publicacao" 
        Publicacao meuLivro = new Publicacao();
        meuLivro.setTitulo("Harry Potter e a Pedra Filosofal");
        meuLivro.setAutor("J. K. Rowlling");
        meuLivro.setEditora("Rocco");
        meuLivro.setTipo("Livro");
        meuLivro.setNumeroDePaginas(208);

        /*System.out.println(meuLivro.nome);
        System.out.println(meuLivro.autor);*/

        meuLivro.exibeFichaLiteraria();

        meuLivro.avalia(9);
        meuLivro.avalia(10);
        meuLivro.avalia(8.5);

        /*System.out.println(meuLivro.somaAvaliacoes);
        System.out.println(meuLivro.totalDeAvaliacoes);*/

        System.out.println(meuLivro.retornaMedia());

    }
}
