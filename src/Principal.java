import biblioteca.modelos.Livro;
import biblioteca.modelos.Revista;
//import biblioteca.modelos.Publicacao;

public class Principal {
    public static void main(String[] args) throws Exception {
        Livro meuLivro = new Livro();
        meuLivro.setTitulo("Harry Potter e a Pedra Filosofal");
        meuLivro.setAutor("J. K. Rowlling");
        meuLivro.setEditora("Rocco");
        meuLivro.setTipo("Livro");
        meuLivro.setNumeroDePaginas(208);
        meuLivro.setNumeroDeCapitulos(17);
        meuLivro.setIsbn("9780545069670");
        meuLivro.setVolume(1);

        meuLivro.avalia(9);
        meuLivro.avalia(10);
        meuLivro.avalia(8.5);

        meuLivro.exibeFichaLiteraria();
        System.out.println("Número de capítulos: " + meuLivro.getNumeroDeCapitulos());
        System.out.println("ISBN: " + meuLivro.getIsbn());
        System.out.println("Volume: " + meuLivro.getVolume());
        System.out.println("Avaliação: " + meuLivro.retornaMedia());

        Revista minhaRevista = new Revista();
        minhaRevista.setTitulo("Superinteressante");
        minhaRevista.setAutor("Alexandre Versignassi");
        minhaRevista.setEditora("Abril");
        minhaRevista.setTipo("Revista");
        minhaRevista.setNumeroDePaginas(70);
        minhaRevista.setEdicao("473 - março/2025");
        minhaRevista.setAssunto("Cultura e Ciências");
        minhaRevista.setIssn("0104-178-9");
        minhaRevista.setNumeroDeArtigos(25);

        minhaRevista.avalia(9.5);
        minhaRevista.avalia(8);
        minhaRevista.avalia(7.7);

        minhaRevista.exibeFichaLiteraria();
        System.out.println("Assunto: " + minhaRevista.getAssunto());
        System.out.println("ISSN: " + minhaRevista.getIssn());
        System.out.println("Edição: " + minhaRevista.getEdicao());
        System.out.println("Número de artigos: " + minhaRevista.getNumeroDeArtigos());
        System.out.println("Avaliação: " + minhaRevista.retornaMedia());
    }
}
