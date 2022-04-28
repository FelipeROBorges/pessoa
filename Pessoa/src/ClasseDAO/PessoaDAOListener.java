/*
 * ClienteDAOListener.java
 *
 * Created on 18 de Dezembro de 2008, 19:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ClasseDAO;

import ClasseDAO.PessoaDAO;
import java.util.List;


public interface PessoaDAOListener {
    /**
     * M�todo que atualiza os dados na tabela cliente
     * 
     * @param disciplina - recebe o objeto ClienteBeans
     * @throws java.lang.Exception se n�o for poss�vel atualizar
     */
    void atualizar(Pessoa pessoa) throws Exception;

    /**
     * M�todo que exclui uma linha na tabela cliente
     * 
     * @param pessoa - recebe o objeto ClienteBeans
     * @throws se n�o for poss�vel excluir o cliente
     */
    void excluir(Pessoa pessoa) throws Exception;

    /**
     * M�todo respons�vel por pesquisar um cliente
     * 
     * @param id - recebe um Inteiro como par�metro para pesquisar
     * pelo campo codigo
     * @return objeto ClienteBeans
     * @throws java.lang.Exception se n�o for poss�vel retornar o objeto cliente
     */
    //Pessoa procurarDisciplina(Integer id) throws Exception;

    void salvar(Pessoa pessoa) throws Exception;

    /**
     * M�todo que retorna todos os clientes
     * 
     * @return objeto List
     * @throws java.lang.Exception se n�o for poss�vel retornar o objeto List
     */
    List todasPessoas() throws Exception;
   
}
