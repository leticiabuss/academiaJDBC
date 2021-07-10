package model.dao;
import db.DB;
import model.dao.impl.AlunoDaoJDBC;
import model.dao.impl.CidadeDaoJDBC;
import model.dao.impl.EstadoDaoJDBC;
import model.dao.impl.InstrutorDaoJDBC;
import model.dao.impl.PlanoDaoJDBC;

public class DaoAcademia {

	public static AlunoDao createAlunoDao() {
		return new AlunoDaoJDBC(DB.getConnection());
	}
	
	public static EstadoDao createEstadoDao() {
		return new EstadoDaoJDBC(DB.getConnection());
	}
	
	public static InstrutorDao createInstrutorDao() {
		return new InstrutorDaoJDBC(DB.getConnection());
	}
	
	public static PlanoDao createPlanoDao() {
		return new PlanoDaoJDBC(DB.getConnection());
	}
	
	public static CidadeDao createCidadeDao() {
		return new CidadeDaoJDBC(DB.getConnection());
	}
}
