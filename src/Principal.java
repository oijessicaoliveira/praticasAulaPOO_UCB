public class Principal {
    public static void main(String[] args) throws Exception {
        // System.out.println("Olá, humano!");

        Livro meuLivro = new Livro();
        meuLivro.titulo = "Harry Potter e a Pedra Filosofal";
        meuLivro.autor = "J. K. Rowlling";
        meuLivro.editora = "Rocco";
        meuLivro.numeroDePaginas = 208;

        //System.out.println(meuLivro.nome);
        //System.out.println(meuLivro.autor);

        meuLivro.exibeFichaLiteraria();

    }
}
