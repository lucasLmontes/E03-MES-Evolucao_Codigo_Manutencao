import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public double calcularTotalComDesconto() {
        double total = calcularTotal();
        return total - (total * cliente.getTipoCliente().getDesconto());
    }

    public void mostrarResumo() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + ": R$ " + produto.getPreco());
        }
        System.out.println("Total final: R$ " + calcularTotalComDesconto());
    }
}
