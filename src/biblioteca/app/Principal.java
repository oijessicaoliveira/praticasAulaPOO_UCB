package biblioteca.app;

import biblioteca.modelos.*;
import biblioteca.interfaces.Digitalizavel;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws Exception {
        Livro livro = new Livro();
        livro.setTitulo("Harry Potter e a Pedra Filosofal");
        livro.setAutor("J. K. Rowling");
        livro.setEditora("Rocco");
        livro.setGenero("Fantasia");
        livro.setNumeroDePaginas(208);
        livro.setNumeroDeCapitulos(17);
        livro.setIsbn("9780545069670");
        livro.setVolume(1);
        livro.geraVersaoDigital();
        livro.avalia(9);
        livro.avalia(8.5);

        Revista revista = new Revista();
        revista.setTitulo("Superinteressante");
        revista.setAutor("Alexandre Versignassi");
        revista.setEditora("Abril");
        revista.setNumeroDePaginas(70);
        revista.setAssunto("Ciência");
        revista.setEdicao("Março/2025");
        revista.setIssn("0104-178-9");
        revista.setNumeroDeArtigos(25);
        revista.avalia(9);

        Ebook ebook = new Ebook();
        ebook.setTitulo("Clean Code");
        ebook.setAutor("Robert C. Martin");
        ebook.setEditora("Prentice Hall");
        ebook.setNumeroDePaginas(464);
        ebook.setTamanhoEmMB(45);
        ebook.setFormato("EPUB");
        ebook.avalia(10);
        ebook.baixar();

        List<Publicacao> publicacoes = Arrays.asList(livro, revista, ebook);
        for (Publicacao pub : publicacoes) {
            pub.exibeFichaCompleta();
            System.out.println("Média de avaliações: " + pub.retornaMedia());
            if (pub instanceof Digitalizavel d) {
                d.geraVersaoDigital();
            }
            System.out.println("------------------------------");
        }
    }
}