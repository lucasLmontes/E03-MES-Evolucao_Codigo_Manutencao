public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente(
            "João Silva",
            "123.456.789-00",
            TipoCliente.VIP
        );

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(new Produto("Teclado", 150.00));
        pedido.adicionarProduto(new Produto("Mouse", 80.00));
        pedido.adicionarProduto(new Produto("Monitor", 900.00));

        pedido.mostrarResumo();
    }
}
