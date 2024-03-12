package ifmt.cba.persistencia;

import jakarta.persistence.EntityManager;

// Superclasse para as classes de persistência (DAO).
// Implementa as operações básicas de manipulação de entidades (incluir, alterar e excluir), além do controle de transações.

public class DAO<VO> {
    protected EntityManager entityManager;

    public DAO(EntityManager entityManager) throws PersistenciaException{
        this.entityManager = entityManager;
    }

    public void incluir(VO vo) throws PersistenciaException{
        try{
            this.entityManager.persist(vo); //registra o objeto(insira, persista)
        }catch(Exception ex){
            throw new PersistenciaException("Erro ao incluir " + vo.getClass() + " - " + ex.getMessage());
        }
    }

    public void alterar(VO vo) throws PersistenciaException{
        try{
            this.entityManager.merge(vo); // faz um update
        }catch(Exception ex){
            throw new PersistenciaException("Erro ao alterar " + vo.getClass() + " - " + ex.getMessage());
        }
    }

    public void excluir(VO vo) throws PersistenciaException{
        try{
            this.entityManager.remove(vo);
        }catch(Exception ex){
            throw new PersistenciaException("Erro ao excluir " + vo.getClass() + " - " + ex.getMessage());
        }
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //inicia o bloco de transacao
    public void beginTransaction(){
        this.entityManager.getTransaction().begin();
    }

    //grava o registro no banco de dados
    public void commitTransaction(){
        this.entityManager.getTransaction().commit();
    }

    // cancela tudo que foi feito
    public void rollbackTransaction(){
        this.entityManager.getTransaction().rollback();
    }
}