import biblioteca.modelos.*;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws Exception {
        /*
         ============================
         CRIAÇÃO DE OBJETO: LIVRO
         ============================
         */

        /* Aqui, try engloba o processo de criação do objeto.
        Se uma exceção for lançada (por exemplo, com número de páginas negativo), o catch a tratará.
        O finally garante que o sistema finalize algo, mesmo em caso de erro. */

        Livro meuLivro = null;
        try {
            meuLivro = new Livro();
            meuLivro.setTitulo("Harry Potter e a Pedra Filosofal");
            meuLivro.setAutor("J. K. Rowlling");
            meuLivro.setEditora("Rocco");
            meuLivro.setGenero("Fantasia");
            meuLivro.setNumeroDePaginas(208); // valor válido
            meuLivro.setNumeroDeCapitulos(17);
            meuLivro.setIsbn("9780545069670");
            meuLivro.setVolume(1);
            meuLivro.geraVersaoDigital();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar o livro: " + e.getMessage());
        } finally {
            System.out.println("Processo de criação de livro finalizado.");
        }

        // Avaliando usando sobrecarga (overload):
        meuLivro.avalia(9); // chamará avalia(int nota)
        meuLivro.avalia(10.0); // chamará avalia(double nota)
        meuLivro.avalia(8.5); // idem avalia(double nota)

        // Avaliando usando try-catch
        try {
            meuLivro.avaliaComValidacao(12); // nota inválida
        } catch (Exception e) {
            System.out.println("Erro ao avaliar: " + e.getMessage());
        }

        double[] notasLivro = {9.2, 8.8, 10};
        meuLivro.avalia(notasLivro); // chamará avalia(double[])

        // Exibe a ficha literária (override) e a média de avaliações
        meuLivro.exibeFichaLiteraria();
        System.out.println("Avaliação: " + meuLivro.retornaMedia());

        /*
         ==============================
         CRIAÇÃO DE OBJETO: REVISTA
         ==============================
         */
        Revista minhaRevista = new Revista();
        minhaRevista.setTitulo("Superinteressante");
        minhaRevista.setAutor("Alexandre Versignassi");
        minhaRevista.setEditora("Abril");
        // minhaRevista.setTipo("Revista");
        minhaRevista.setNumeroDePaginas(70);
        minhaRevista.setEdicao("473 - março/2025");
        minhaRevista.setAssunto("Cultura e Ciências");
        minhaRevista.setIssn("0104-178-9");
        minhaRevista.setNumeroDeArtigos(25);

        // Avaliando usando a sobrecarga (overload):
        minhaRevista.avalia(9.5); // avalia(double)
        minhaRevista.avalia(8); // avalia(int)
        minhaRevista.avalia(7.7); // avalia(double)

        minhaRevista.exibeFichaLiteraria();
        System.out.println("Avaliação: " + minhaRevista.retornaMedia());

        /*
         * =====================
         * POLIMORFISMO
         * =====================
         * Demonstrando que podemos usar uma lista de "Publicacao"
         * e colocar objetos "Livro" e "Revista" juntos.
         */
        System.out.println("\n=== DEMONSTRANDO POLIMORFISMO ===");

        List<Publicacao> listaPublicacoes = new ArrayList<>();
        listaPublicacoes.add(meuLivro);      // Um Livro, mas a referência é do tipo Publicacao
        listaPublicacoes.add(minhaRevista);  // Uma Revista, mas a referência é do tipo Publicacao

        // Percorremos a lista e chamamos "exibeFichaLiteraria()"
        // Observe que cada objeto "responde" de forma diferente
        for (Publicacao pub : listaPublicacoes) {
            // Nesse momento, acontece o polimorfismo de sobreposição (runtime).
            pub.exibeFichaLiteraria();

            // Exibe média de avaliações
            System.out.println("Média de Avaliações: " + pub.retornaMedia());
            if (pub instanceof Digitalizavel) {
                ((Digitalizavel) pub).geraVersaoDigital();
            }
            System.out.println("-----------------------------------------");
        }

        /*
         * ============================
         * CRIAÇÃO DE OBJETO: E-BOOK
         * ============================
         */
        Ebook meuEbook = new Ebook();
        meuEbook.setTitulo("Clean Code: A Handbook of Agile Software Craftsmanship");
        meuEbook.setAutor("Robert C. Martin");
        meuEbook.setEditora("Prentice Hall");
        meuEbook.setNumeroDePaginas(464); // referência, como se fosse a edição impressa
        meuEbook.setTamanhoEmMB(45);
        meuEbook.setFormato("EPUB");

        // Avaliações via métodos herdados de Publicacao
        meuEbook.avalia(10);
        meuEbook.avalia(9.5);

        // Exibe a ficha literária (que vem da cadeia PublicacaoDigital -> Publicacao)
        meuEbook.exibeFichaLiteraria();

        // Chama o método abstrato implementado em Ebook
        meuEbook.baixar();

        // Mostra a média de avaliações (herdado de Publicacao)
        System.out.println("Avaliação média: " + meuEbook.retornaMedia());
    }
}