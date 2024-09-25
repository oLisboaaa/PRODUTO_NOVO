package ProdutoNovo;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
// Classe que representa o cadastro de um produto
class CadastroProduto {
    private String nome; // Nome do produto
    private Date dataFab; // Data de fabricação do produto
    private Date dataVal; // Data de validade do produto
    private double precoVenda; // Preço de venda do produto

    // Construtor que inicializa o produto com nome, data de fabricação e preço
    public CadastroProduto(String nome, Date dataFab, double precoVenda) {
        this.nome = nome;
        this.dataFab = dataFab;
        this.precoVenda = precoVenda;
        setDataVal(); // Chama o método para definir a data de validade automaticamente
    }

    // Métodos getter e setter para manipulação dos atributos

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome; // Define o nome do produto
    }

    public Date getDataFab() {
        return dataFab;
    }

    public void setDataFab(Date dataFab) {
        dataFab = dataFab; // Atualiza a data de fabricação
        setDataVal(); // Atualiza a data de validade após mudança
    }

    public Date getDataVal() {
        return dataVal; // Retorna a data de validade
    }

    // Método privado que calcula a data de validade com base na data de fabricação
    private void setDataVal() {
        if (dataFab != null) { // Verifica se a data de fabricação não é nula
            Calendar calendar = Calendar.getInstance(); // Cria uma instância do calendário
            calendar.setTime(dataFab); // Define a data do calendário como a data de fabricação
            calendar.add(Calendar.MONTH, 1); // Adiciona um mês à data de fabricação
            dataVal = calendar.getTime(); // Atualiza a data de validade
        }
    }

    public double getPrecoVenda() {
        return precoVenda; // Retorna o preço de venda
    }

    public void setPrecoVenda(double precoVenda) {
        precoVenda = precoVenda; // Define o preço de venda
    }
}

// Classe principal que executa o programa
public class Produto {
    public static void main(String[] args) {
        // Cria uma data de fabricação para o produto
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.SEPTEMBER, 25); // Define uma data específica
        Date dataFab = calendar.getTime(); // Obtém a data a partir do calendário

        // Cria uma instância de CadastroProduto com os dados fornecidos
        CadastroProduto cadastroProd = new CadastroProduto("Pepsi", dataFab, 5.99);

        // Cria um formatador de data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Exibe os detalhes do produto
        System.out.println("Nome do produto: " + cadastroProd.getNome());
        System.out.println("Data de fabricação: " + sdf.format(cadastroProd.getDataFab()));
        System.out.println("Data de validade: " + sdf.format(cadastroProd.getDataVal()));
        System.out.println("Preço de venda: " + cadastroProd.getPrecoVenda());
    }
}
